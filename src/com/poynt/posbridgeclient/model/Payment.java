package com.poynt.posbridgeclient.model;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import co.poynt.api.model.Order;
import co.poynt.api.model.Transaction;
import co.poynt.api.model.TransactionReference;

import java.util.List;

public class Payment {
    private static final String TAG = "Payment";
    private long amount;
    private long cashbackAmount;
    private long tipAmount;
    private String currency;
    private String referenceId;
    private PaymentStatus status;
    private List<Transaction> transactions;
    private String transactionNumber;
    private boolean multiTender;
    private boolean authzOnly;
    private String orderId;
    private Order order;
    private boolean nonReferencedCredit;
    /** @deprecated */
    @Deprecated
    private boolean disableDebitCards;
    private boolean disableCash;
    private boolean disableTip;
    private List<TransactionReference> references;
    private String notes;
    private boolean cashOnly;
    private boolean debit;
    private String STAN;
    private boolean skipReceiptScreen;


    public Payment() {
    }

    public long getAmount() {
        return this.amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getTipAmount() {
        return this.tipAmount;
    }

    public void setTipAmount(long tipAmount) {
        this.tipAmount = tipAmount;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getReferenceId() {
        return this.referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public PaymentStatus getStatus() {
        return this.status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getTransactionNumber() {
        return this.transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public boolean isMultiTender() {
        return this.multiTender;
    }

    public void setMultiTender(boolean multiTender) {
        this.multiTender = multiTender;
    }

    public boolean isAuthzOnly() {
        return this.authzOnly;
    }

    public void setAuthzOnly(boolean authzOnly) {
        this.authzOnly = authzOnly;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public boolean isNonReferencedCredit() {
        return this.nonReferencedCredit;
    }

    public void setNonReferencedCredit(boolean nonReferencedCredit) {
        this.nonReferencedCredit = nonReferencedCredit;
    }

    /** @deprecated */
    @Deprecated
    public boolean isDisableDebitCards() {
        return this.disableDebitCards;
    }

    /** @deprecated */
    @Deprecated
    public void setDisableDebitCards(boolean disableDebitCards) {
        this.disableDebitCards = disableDebitCards;
    }

    public boolean isDisableCash() {
        return this.disableCash;
    }

    public void setDisableCash(boolean disableCash) {
        this.disableCash = disableCash;
    }

    public List<TransactionReference> getReferences() {
        return this.references;
    }

    public void setReferences(List<TransactionReference> references) {
        this.references = references;
    }

    public boolean isDisableTip() {
        return this.disableTip;
    }

    public void setDisableTip(boolean disableTip) {
        this.disableTip = disableTip;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public long getCashbackAmount() {
        return this.cashbackAmount;
    }

    public void setCashbackAmount(long cashbackAmount) {
        this.cashbackAmount = cashbackAmount;
    }

    public boolean isCashOnly() {
        return this.cashOnly;
    }

    public void setCashOnly(boolean cashOnly) {
        this.cashOnly = cashOnly;
    }

    public boolean isDebit() {
        return this.debit;
    }

    public void setDebit(boolean debit) {
        this.debit = debit;
    }

    public boolean isSkipReceiptScreen() {
        return this.skipReceiptScreen;
    }

    public void setSkipReceiptScreen(boolean skipReceiptScreen) {
        this.skipReceiptScreen = skipReceiptScreen;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "Payment{amount=" + this.amount + ", tipAmount=" + this.tipAmount + ", currency=\'" + this.currency + '\'' + ", referenceId=\'" + this.referenceId + '\'' + ", orderId=\'" + this.orderId + '\'' + ", status=" + this.status + ", transactionNumber=" + this.transactionNumber + ", transactions=" + this.transactions + ", authzOnly=" + this.authzOnly + ", nonReferencedCredit=" + this.nonReferencedCredit + ", multiTender=" + this.multiTender + ", disableDebitCards=" + this.disableDebitCards + ", disableCash=" + this.disableCash + ", references=" + this.references + ", disableTip=" + this.disableTip + ", notes=" + this.notes + ", STAN=" + this.STAN + ", cashOnly=" + this.cashOnly + ", debit=" + this.debit + ", skipReceiptScreen=" + this.skipReceiptScreen + ", order=" + (this.order != null?this.order.toString():"n/a") + '}';
    }

    public String getSTAN() {
        return this.STAN;
    }

    public void setSTAN(String STAN) {
        this.STAN = STAN;
    }
}
