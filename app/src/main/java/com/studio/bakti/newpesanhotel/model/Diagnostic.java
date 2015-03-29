package com.studio.bakti.newpesanhotel.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by bakti on 3/28/15.
 */
public class Diagnostic implements Serializable {

    @SerializedName("status")
    int status;
    @SerializedName("lang")
    String lang;
    @SerializedName("currency")
    String currency;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
