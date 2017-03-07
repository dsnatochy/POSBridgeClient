package com.poynt.posbridgeclient.model;

import java.util.List;

import co.poynt.api.model.OrderItem;

/**
 * Created by dennis on 6/29/16.
 */
public class POSRequest {

    private String poyntRequestId;
    /**
     * for refund, void, capture
     */
    private String transactionId;

    /**
     * client timeout in ms. Used only if the client does not pass CatRequest and uses
     * Payment object.
     */
    private int timeout;

    /**
     * will be used by iOS SDK
     */
    private Payment payment;
    /**
     * will be used by Windows POS
     */
    private CATRequest catRequest;


    /**
     * printing request options
     */
    private PrintingRequest printingRequest;

    /**
     * second screen request options
     */
    private SecondScreenRequest secondScreenRequest;

    /**
     * settlement request options
     */
    private SettlementRequest settlementRequest;

    //region POSRequest accessors

    public PrintingRequest getPrintingRequest() { return printingRequest; }
    public void setPrintingRequest(PrintingRequest printingRequest) {
        this.printingRequest = printingRequest;
    }

    public SecondScreenRequest getSecondScreenRequest() { return secondScreenRequest; }
    public void setPrintingRequest(SecondScreenRequest printingRequest) {
        this.secondScreenRequest = secondScreenRequest;
    }

    public SettlementRequest getSettlementRequest() {
        return settlementRequest;
    }

    public void setSettlementRequest(SettlementRequest settlementRequest) {
        this.settlementRequest = settlementRequest;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPoyntRequestId() {
        return poyntRequestId;
    }

    public void setPoyntRequestId(String poyntRequestId) {
        this.poyntRequestId = poyntRequestId;
    }

    public CATRequest getCatRequest() {
        return catRequest;
    }

    public void setCatRequest(CATRequest catRequest) {
        this.catRequest = catRequest;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    //endregion

    public class CATRequest{
        int sequenceNumber;
        int amount;
        int taxOthers;
        int timeout;
        // for accessDailyLog
        int type;
        //region CATRequest accessor methods
        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getSequenceNumber() {
            return sequenceNumber;
        }

        public void setSequenceNumber(int sequenceNumber) {
            this.sequenceNumber = sequenceNumber;
        }

        public int getTaxOthers() {
            return taxOthers;
        }

        public void setTaxOthers(int taxOthers) {
            this.taxOthers = taxOthers;
        }

        public int getTimeout() {
            return timeout;
        }

        public void setTimeout(int timeout) {
            this.timeout = timeout;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
        //endregion
    }

    public class PrintingRequest {
        String content;
        public String setContent() { return content; }
        public String getContent() { return content; }
    }

    public class SecondScreenRequest {
        private List<OrderItem> items;
        private long totalAmount;
        private String currency;

        public List<OrderItem> getItems() {
            return items;
        }

        public void setItems(List<OrderItem> items) {
            this.items = items;
        }

        public long getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(long totalAmount) {
            this.totalAmount = totalAmount;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }



    public class SettlementRequest{
        public Boolean getCloseBatch() {
            return closeBatch;
        }

        public void setCloseBatch(Boolean closeBatch) {
            this.closeBatch = closeBatch;
        }

        public List<String> getAuthorizationList() {
            return authorizationList;
        }

        public void setAuthorizationList(List<String> authorizationList) {
            this.authorizationList = authorizationList;
        }

        Boolean closeBatch;
        List<String> authorizationList;
    }
}

