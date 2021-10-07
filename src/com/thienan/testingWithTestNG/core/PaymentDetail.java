/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thienan.testingWithTestNG.core;

import java.util.ArrayList;

/**
 *
 * @author thien
 */
public class PaymentDetail {

    private ArrayList<PaymentDetailDTO> paymentList;

    public ArrayList<PaymentDetailDTO> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(ArrayList<PaymentDetailDTO> paymentList) {
        this.paymentList = paymentList;
    }

    public PaymentDetail(ArrayList<PaymentDetailDTO> paymentList) {
        this.paymentList = paymentList;
    }

    public PaymentDetail() {
        this.paymentList = new ArrayList<>();
    }
    
    public void removeAllItemInPayemt(){
        this.paymentList.removeAll(paymentList);
    }

    public boolean isExisted(int paymentID) {
        /*
        if(paymentID < 0){
            throw new IllegalArgumentException("Payment ID must be greater than 0");
        }
         */
        return this.paymentList.stream().anyMatch((paymentDetail) -> (paymentDetail.getPaymentID() == paymentID));
    }

    public boolean addPaymentToList(PaymentDetailDTO payment) {
        /*
        if (payment == null) {
            throw new NullPointerException("The paramenter can not be null");
        }
        if(isExisted(payment.getPaymentID())){
            throw new IllegalArgumentException("This payment with ID is already exist");
        }
         */
        this.paymentList.add(payment);
        return true;
    }

    public PaymentDetailDTO getOnePaymentFromListByID(int paymentID) {
        PaymentDetailDTO payment = null;
        for (PaymentDetailDTO item : this.paymentList) {
            if (item.getPaymentID() == paymentID) {
                payment = item;
            }
        }
        return payment;
    }

}
