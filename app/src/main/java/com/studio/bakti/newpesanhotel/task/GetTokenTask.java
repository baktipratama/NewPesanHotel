package com.studio.bakti.newpesanhotel.task;

import android.content.Context;

import com.studio.bakti.newpesanhotel.model.Token;
import com.studio.bakti.newpesanhotel.service.SingleService;

/**
 * Created by bakti on 3/28/15.
 */
public class GetTokenTask extends AsynchronousTask<Token> {
    private String secretKey;
    public GetTokenTask(IResponse callback, Context context, String secretKey) {
        super(callback, context);
        this.secretKey = secretKey;
    }
    @Override
    public Token process() throws Exception {
        return SingleService.getInstance(getContext()).getService().getToken("getToken",secretKey,"json");
    }
}
