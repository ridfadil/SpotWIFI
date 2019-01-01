package id.wifispotri.com.wifispot.api;

import java.util.List;

import id.wifispotri.com.wifispot.model.ResponseData;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by fadil on 4/30/18.
 */

public interface BaseApiService {

    @GET("daftar/get")
    Call<ResponseData> getSpotWifi();

    /*@GET("daftar/get")
    Call<List<ResponseData>> getSpotWifi();*/
}
