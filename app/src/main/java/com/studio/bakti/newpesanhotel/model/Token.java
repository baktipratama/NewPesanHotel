package com.studio.bakti.newpesanhotel.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by bakti on 3/28/15.
 */
public class Token extends BaseModel {
    @SerializedName("token")
    String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
