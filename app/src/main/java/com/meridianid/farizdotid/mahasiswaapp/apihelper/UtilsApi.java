package com.meridianid.farizdotid.mahasiswaapp.apihelper;

/**
 * Created by fariz ramadhan.
 * website : www.farizdotid.com
 * github : https://github.com/farizdotid
 */
public class UtilsApi {
    public static final String BASE_URL_API = "http://10.0.2.2/mahasiswa/";

    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
