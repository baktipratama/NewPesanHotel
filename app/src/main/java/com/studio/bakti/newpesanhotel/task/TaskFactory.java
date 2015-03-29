package com.studio.bakti.newpesanhotel.task;

import android.content.Context;

/**
 * Created by heriman on 3/11/15.
 */
public class TaskFactory implements ITaskFactory {


    @Override
    public AsynchronousTask getTokenTask(IResponse callback, Context context, String secretKey) {
        return new GetTokenTask(callback,context,secretKey);
    }

    @Override
    public AsynchronousTask getListHotelTask(IResponse callback, Context context, String key, String sDate, int night, String eDate, int room, int adult) {
        return new GetListHotelTask(callback,context,key,sDate,night,eDate,room,adult);
    }
}
