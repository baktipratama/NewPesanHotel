package com.studio.bakti.newpesanhotel.task;

import android.content.Context;

import com.studio.bakti.newpesanhotel.model.SearchResult;
import com.studio.bakti.newpesanhotel.model.Token;
import com.studio.bakti.newpesanhotel.service.SingleService;
import com.studio.bakti.newpesanhotel.util.ConstantaUtil;

/**
 * Created by bakti on 3/28/15.
 */
public class GetListHotelTask extends AsynchronousTask<SearchResult> {
    private String key;
    private String sDate;
    private int night;
    private String eDate;
    private int room;
    private int adult;


    public GetListHotelTask(IResponse callback, Context context,
                            String key,String sDate, int night,String eDate,int room,
                            int adult) {
        super(callback, context);
        this.key = key;
        this.sDate = sDate;
        this.night = night;
        this.eDate = eDate;
        this.room = room;
        this.adult = adult;
    }
    @Override
    public SearchResult process() throws Exception {
        SingleService service = SingleService.getInstance(getContext());
        Token token = service.getService().getToken("getToken", ConstantaUtil.appID,"json");
        SearchResult result = service.getService().getSearchResult(key,sDate,night,eDate,room,adult,token.getToken(),"json",0);
        return result;
    }
}
