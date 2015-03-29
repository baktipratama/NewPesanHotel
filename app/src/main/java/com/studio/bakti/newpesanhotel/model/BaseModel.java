package com.studio.bakti.newpesanhotel.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by bakti on 3/28/15.
 */
public class BaseModel implements Serializable {
    @SerializedName("diagnostic")
    Diagnostic diagnostic;
    @SerializedName("output_type")
    String output_type;
    @SerializedName("login_status")
    boolean login_status;

    public Diagnostic getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(Diagnostic diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getOutput_type() {
        return output_type;
    }

    public void setOutput_type(String output_type) {
        this.output_type = output_type;
    }

    public boolean isLogin_status() {
        return login_status;
    }

    public void setLogin_status(boolean login_status) {
        this.login_status = login_status;
    }
}
