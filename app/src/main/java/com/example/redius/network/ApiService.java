package com.example.redius.network;


import com.example.redius.model.DataResponse;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {

    @GET
    Observable<Response<DataResponse>> getFacilities(@Url String url);

}
