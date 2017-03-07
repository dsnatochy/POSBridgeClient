package com.poynt.posbridgeclient;


import co.poynt.api.model.Transaction;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.poynt.posbridgeclient.model.POSRequest;
import com.poynt.posbridgeclient.model.POSResponse;
import com.poynt.posbridgeclient.model.Payment;
import com.poynt.posbridgeclient.model.PaymentStatus;
import okhttp3.*;

import java.net.URL;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by dennis on 3/7/17.
 */
public class Main {

    public String doPost(String signature, String jsonRequest, String urlString, int timeout) throws Exception{
        URL url = new URL(urlString);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(timeout, TimeUnit.MILLISECONDS)
                .readTimeout(timeout, TimeUnit.MILLISECONDS)
                .build();

        // needs to be text/plain
        MediaType JSON = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(JSON, jsonRequest);
        String requestId = UUID.randomUUID().toString();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Poynt-Client", "Java Sample")
                .addHeader("Poynt-Request-Id", requestId)
                .addHeader("Signature", signature)
                .post(body)
                .build();

        Response response  = client.newCall(request).execute();
        String responseString = response.body().string();
        return responseString;
    }

    public static void main(String[] args) throws Exception {
        Main client = new Main();

        String host = "http://10.255.140.195:55555";
        String pairingUrl = host + "/devices/cat/pair";
        String authorizeSaleUrl = host + "/devices/cat/authorizeSales";
        String  getScanDataUrl = host + "/devices/cat/getScanData";
        int timeout = 60000; // deault timeout 60 seconds
        String pairingCode = "ZHED2L";

        /*
         * POS/Poynt pairing request
         */
        String poyntRequestId = UUID.randomUUID().toString();
        // pairing request format
        String pairingRequest = "{\"poyntRequestId\":\"" + poyntRequestId + "\"}";
        String signature = Util.generateHmacSHA256Signature(pairingRequest, pairingCode);

        String response = client.doPost(signature, pairingRequest, pairingUrl, timeout);
        System.out.println(response);


        /*
         * Sale request example
         */
        POSRequest salePosRequest = new POSRequest();
        Payment payment = new Payment();
        payment.setAmount(1000l);
        payment.setCurrency("USD");
        // to allow multiple tenders on a single transaction
        payment.setMultiTender(true);
        // set custom reference id (could be POS reference)
        payment.setReferenceId(UUID.randomUUID().toString());

        salePosRequest.setPayment(payment);
        // for idempotency, has to be UUID
        salePosRequest.setPoyntRequestId(UUID.randomUUID().toString());
        // set client timeout to 60 seconds
        salePosRequest.setTimeout(timeout);

        // for serializing and deserializing JSON
        ObjectMapper om = new ObjectMapper();
        om.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        om.setDateFormat(new ISO8601DateFormat());
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        om.configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, false);
        om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //

        String saleRequest = om.writeValueAsString(salePosRequest);

        signature = Util.generateHmacSHA256Signature(saleRequest, pairingCode);
        String saleResponse = client.doPost(signature, saleRequest, authorizeSaleUrl, timeout);

        POSResponse salePosResponse = om.readValue(saleResponse, POSResponse.class);
        if (salePosResponse.getError() != null){
            System.out.println("Error occurred: " + salePosResponse.getError().getErrorName());
        }else{
            Payment processedPayment = salePosResponse.getPayment();
            // successful payment
            if (processedPayment.getStatus() == PaymentStatus.COMPLETED) {
                for (Transaction t : processedPayment.getTransactions()) {
                    System.out.println("--------------------");
                    System.out.println("Amount: " + t.getAmounts().getTransactionAmount());
                    System.out.println("Txn Id: " + t.getId());
                    if (t.getProcessorResponse() != null) {
                        System.out.println("Approval Code: " + t.getProcessorResponse().getApprovalCode());
                    }
                    if (t.getFundingSource().getCard() != null) {
                        System.out.println("Customer: " + t.getFundingSource().getCard().getCardHolderFullName());
                        System.out.println("Card: " + t.getFundingSource().getCard().getNumberMasked());
                    }

                }
            } else if (processedPayment.getStatus() == PaymentStatus.CANCELED) {
                System.out.println("Payment was canceled");
            }else{
                // just print the response
                System.out.println("Response: " + saleResponse);
            }
        }


        /*
         * Barcode scan example
         */
        poyntRequestId = UUID.randomUUID().toString();
        // pairing request format
        String getScanDataRequest = "{\"poyntRequestId\":\"" + poyntRequestId + "\"}";
        signature = Util.generateHmacSHA256Signature(getScanDataRequest, pairingCode);

        response = client.doPost(signature, getScanDataRequest, getScanDataUrl, timeout);
        System.out.println(response);

    }
}
