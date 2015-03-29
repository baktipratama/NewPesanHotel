package com.studio.bakti.newpesanhotel.controller;

import android.content.Context;

import com.studio.bakti.newpesanhotel.task.IResponse;
import com.studio.bakti.newpesanhotel.task.ITaskFactory;
import com.studio.bakti.newpesanhotel.task.TaskFactory;
import com.studio.bakti.newpesanhotel.util.ConstantaUtil;

/**
 * Created by bakti on 3/28/15.
 */
public class DataController {

    private static DataController instance;
    private ITaskFactory taskFactory;
    private Context context;
    public DataController(Context context){
        this.context = context;
        taskFactory = new TaskFactory();
    }

    public static DataController getInstance(Context context){
        if(instance==null)
            instance = new DataController(context);
        return instance;
    }

    public void getAllToken(IResponse response){
        taskFactory.getTokenTask(response,context, ConstantaUtil.appID).execute();
    }

    public void getAllSearch(IResponse response, String key, String sDate, int night, String eDate, int room, int adult){
        taskFactory.getListHotelTask(response,context,key,sDate,night,eDate,room,adult).execute();
    }

}
