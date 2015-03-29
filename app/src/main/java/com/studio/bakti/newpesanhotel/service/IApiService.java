package com.studio.bakti.newpesanhotel.service;


import com.studio.bakti.newpesanhotel.model.SearchResult;
import com.studio.bakti.newpesanhotel.model.Token;
import com.studio.bakti.newpesanhotel.util.ConstantaUtil;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by heriman on 3/10/15.
 */
public interface IApiService {
    @GET(ConstantaUtil.URIgetToken)
    Token getToken(@Query("method") String method,@Query("secretkey") String secretkey,@Query("output") String output);

    @GET(ConstantaUtil.URIsearchHotel)
    SearchResult getSearchResult(@Query("q") String query,@Query("startdate") String sDate,@Query("night") int night
            ,@Query("enddate") String endDate,@Query("room") int room,@Query("adult") int adult,@Query("token") String token,
                                 @Query("output") String output,@Query("child") int child);

}
