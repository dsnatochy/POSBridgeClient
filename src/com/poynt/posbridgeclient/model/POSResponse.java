package com.poynt.posbridgeclient.model;

import java.util.List;



/**
 * Created by dennis on 6/27/16.
 */
public class POSResponse {
    private CATResponse catResponse;
    private Error error;
    // keeping for backwards compatibility with existing iOS SDK.
    private Payment payment;

    private String poyntRequestId;

    public SettlementResponse getSettlementResponse() {
        return settlementResponse;
    }

    public void setSettlementResponse(SettlementResponse settlementResponse) {
        this.settlementResponse = settlementResponse;
    }

    private SettlementResponse settlementResponse;

    public String getPoyntRequestId() {
        return poyntRequestId;
    }
    public void setPoyntRequestId(String poyntRequestId) {
        this.poyntRequestId = poyntRequestId;
    }
    public Error getError() {
        return error;
    }
    public void setError(Error error) {
        this.error = error;
    }
    public Payment getPayment() {
        return payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    public CATResponse getCatResponse() {
        return catResponse;
    }
    public void setCatResponse(CATResponse catResponse) {
        this.catResponse = catResponse;
    }

    public class CATResponse{
        //region getters and setters

        public int getSequenceNumber(){
            return sequenceNumber;
        }

        public void setSequenceNumber(int sequenceNumber){
            this.sequenceNumber = sequenceNumber;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public String getApprovalCode() {
            return approvalCode;
        }

        public void setApprovalCode(String approvalCode) {
            this.approvalCode = approvalCode;
        }

        public String getCardCompanyID() {
            return cardCompanyID;
        }

        public void setCardCompanyID(String cardCompanyID) {
            this.cardCompanyID = cardCompanyID;
        }

        public String getCardHolderFirstName() {
            return cardHolderFirstName;
        }

        public void setCardHolderFirstName(String cardHolderFirstName) {
            this.cardHolderFirstName = cardHolderFirstName;
        }

        public String getCardHolderLastName() {
            return cardHolderLastName;
        }

        public void setCardHolderLastName(String cardHolderLastName) {
            this.cardHolderLastName = cardHolderLastName;
        }

        public String getCenterResultCode() {
            return centerResultCode;
        }

        public void setCenterResultCode(String centerResultCode) {
            this.centerResultCode = centerResultCode;
        }

        public int getPaymentCondition() {
            return paymentCondition;
        }

        public void setPaymentCondition(int paymentCondition) {
            this.paymentCondition = paymentCondition;
        }

        public String getTransactionNumber() {
            return transactionNumber;
        }

        public void setTransactionNumber(String transactionNumber) {
            this.transactionNumber = transactionNumber;
        }

        public int getTransactionType() {
            return transactionType;
        }

        public void setTransactionType(int transactionType) {
            this.transactionType = transactionType;
        }
        //endregion

        String accountNumber;
        String cardHolderFirstName;
        String cardHolderLastName;
        String cardCompanyID;
        String approvalCode;
        int transactionType;
        int paymentCondition;
        String transactionNumber;
        String centerResultCode;
        int sequenceNumber;
    }

    public static class SettlementResponse{
        public List<String> getAcceptedAuthorizations() {
            return acceptedAuthorizations;
        }

        public void setAcceptedAuthorizations(List<String> acceptedAuthorizations) {
            this.acceptedAuthorizations = acceptedAuthorizations;
        }

        List<String> acceptedAuthorizations;
    }

    public String toString(){
        return "CATResponse" + catResponse +
                ": {'approvalCode':'" + catResponse.approvalCode + "'}";
    }
}

