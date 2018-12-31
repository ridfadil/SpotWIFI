package id.wifispotri.com.wifispot.api;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by fadil on 4/30/18.
 */

public interface BaseApiService {

    /*@POST("api/auth/login")
    Call<ResponseLogin> addLogin(@Body LoginForm login);

    @GET("api/users/Profile")
    Call<ResponseProfile>getProfile(@Header("Authorization") String Authorization);

    @POST("api/cuti/ajukanCuti")
    Call<ResponseAjukanCuti> addCuti(@Header("Authorization") String Authorization, @Body RequestCutiForm cuti);

    @GET("api/cuti/getOneCuti/{email}")
    Call<List<ResponseRiwayatCuti>> getOneCuti(@Header("Authorization") String Authorization, @Path("email") String email);

    @GET("api/slipGaji/getOneSlipGaji/{email}")
    Call<List<ResponseRiwayatGaji>> getAllGaji(@Header("Authorization") String Authorization, @Path("email") String email);

    @POST("api/slipGaji/ajukanSlipGaji")
    Call<ResponseAjukanSlipGaji> addGaji(@Header("Authorization") String Authorization, @Body RequestGajiForm gaji);

    @POST("api/present/addPresent")
    Call<ResponsePresent> addPresent(@Header("Authorization") String Authorization, @Body RequestPresentForm present);

    @GET("api/company/companyprofil")
    Call<List<ResponseCompanyProfile>>getCompanyProfile(@Header("Authorization") String Authorization);

    @PATCH("api/users/{id}")
    Call<ResponseUpdateProfil> updateProfil(@Header("Authorization") String Authorization, @Path("id") String id, @Body ProfileUpdateForm profil);

    @POST("api/auth/login")
    Call<ResponseLogin> cekLogin(@Body CekLoginForm login);

    @PATCH("api/users/{id}")
    Call<ResponseUpdateProfil> updatePass(@Header("Authorization") String Authorization, @Path("id") String id, @Body ChangePasswordForm profil);

    @Multipart
    @PUT("api/users/avatar/{id}")
    Call<ResponseUploadAvatar> postImage(@Header("Authorization") String Authorization, @Path("id") String id, @Part MultipartBody.Part image);

    @DELETE("api/cuti/deleteCuti/{id}")
    Call<ResponseBody> deleteCuti(@Header("Authorization") String Authorization, @Path("id") String id);

    @DELETE("api/slipGaji/deleteSlipGaji/{id}")
    Call<ResponseBody> deleteGaji(@Header("Authorization") String Authorization, @Path("id") String id);*/



}
