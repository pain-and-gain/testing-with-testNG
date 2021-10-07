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
public class PaymentDetailDTO {

    private int paymentID;
    private String paymentTitle;
    private ArrayList<ItemDTO> itemList;

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getPaymentTitle() {
        return paymentTitle;
    }

    public void setPaymentTitle(String paymentTitle) {
        this.paymentTitle = paymentTitle;
    }

    public ArrayList<ItemDTO> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<ItemDTO> itemList) {
        this.itemList = itemList;
    }

    public PaymentDetailDTO(int paymentID, String paymentTitle, ArrayList<ItemDTO> itemList) {
        this.paymentID = paymentID;
        this.paymentTitle = paymentTitle;
        this.itemList = itemList;
    }

    public PaymentDetailDTO() {
        this.itemList = new ArrayList<>();
    }

}
