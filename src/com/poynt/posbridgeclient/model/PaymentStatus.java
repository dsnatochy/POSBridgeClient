package com.poynt.posbridgeclient.model;

/**
 * Created by dennis on 3/7/17.
 */
public enum PaymentStatus {
    COMPLETED,
    AUTHORIZED,
    VOIDED,
    REFUNDED,
    CANCELED,
    FAILED,
    HOLD,
    DECLINED;

    private PaymentStatus() {
    }
}