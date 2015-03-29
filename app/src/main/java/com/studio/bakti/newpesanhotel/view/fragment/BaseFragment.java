package com.studio.bakti.newpesanhotel.view.fragment;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by bakti on 3/28/15.
 */
public class BaseFragment extends Fragment{

    private ProgressDialog progressDialog;
    public void showProgressDialog(String title, String contain){
        progressDialog = ProgressDialog.show(getActivity(),title,
        contain, true);
    }
    public void dismissProgressDialog(){
            progressDialog.dismiss();
        }
    public Context getApplicationContext(){
        return getActivity().getApplicationContext();
    }
    public Context getCurrentContext(){
        return getActivity();
    }
}
