package com.example.deliveryshop.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderList {

    @SerializedName("Data")
    @Expose
    private List<Order> data = null;
    @SerializedName("Success")
    @Expose
    private Boolean success;
    @SerializedName("ErrorCode")
    @Expose
    private Object errorCode;
    @SerializedName("ErrorDescription")
    @Expose
    private Object errorDescription;

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

    public Object getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Object errorCode) {
        this.errorCode = errorCode;
    }

    public Object getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(Object errorDescription) {
        this.errorDescription = errorDescription;
    }

}