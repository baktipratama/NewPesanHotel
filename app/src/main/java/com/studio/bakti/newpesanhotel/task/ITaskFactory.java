package com.studio.bakti.newpesanhotel.task;


import android.content.Context;

/**
 * Created by heriman on 3/11/15.
 */
public interface ITaskFactory {
    AsynchronousTask getTokenTask(IResponse callback, Context context,String secretKey);
    AsynchronousTask getListHotelTask(IResponse callback, Context context,
                                      String key,String sDate, int night,String eDate,int room,
                                      int adult);
}
