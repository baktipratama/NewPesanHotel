package com.studio.bakti.newpesanhotel.task;

/**
 * Created by heriman on 3/11/15.
 */
public interface IResponse {
    public void onSuccess(Object o);
    public void onError(Object o);
    public void onStart();
}
