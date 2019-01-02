package id.wifispotri.com.wifispot.api;

import java.util.List;

import id.wifispotri.com.wifispot.model.ResponseData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by fadil on 4/30/18.
 */

public interface BaseApiService {

    @GET("daftar/get")
    Call<ResponseData> getSpotWifi();

    @GET("daftar/cari/{lokasi}")
    Call<ResponseData> searchSpot(@Path("lokasi") String lokasi);

    //https://installin.000webhostapp.com/public/index.php/daftar/cari/taman Diskamtam

    /*@GET("daftar/get")
    Call<List<ResponseData>> getSpotWifi();*/
}
