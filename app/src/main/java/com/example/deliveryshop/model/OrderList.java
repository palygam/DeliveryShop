package com.example.deliveryshop.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderList {

    @SerializedName("Data")
    @Expose
    private List<Order> data;
    @SerializedName("Success")
    @Expose
    private Boolean success;
    @SerializedName("ErrorCode")
    @Expose
    private String errorCode;
    @SerializedName("ErrorDescription")
    @Expose
    private String errorDescription;

    public OrderList(List<Order> data, Boolean success, String errorCode, String errorDescription) {
        this.data = data;
        this.success = success;
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    public List<Order> getData() {
        return data;
    }

    public void setData(List<Order> data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

}