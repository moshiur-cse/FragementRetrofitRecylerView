package com.moshiurcse.fragementretrofit.emp_monthly_time;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface EmpMonthlyTimeServiceApi {
   /* @GET("feeds/flowers.json")
    Call<List<EmpMonthlyTime>> getAllTime();*/

   /* @GET()
    Call<ForecastWeatherResponseBody> getForecastWeatherData(@Url String endUrl);*/

/*    @GET()
    Call<List<EmpMonthlyTime>> getAllTime();*/

    @GET()
    Call<List<EmpMonthlyTime>> getAllTime(@Url String endUrl);



}

    /*String endUrl = String.format("forecast/daily?lat=%f&lon=%f&cnt=16&units=%s&appid=%s",
            location.getLatitude(), location.getLongitude(), units, apiKey);
    WeatherServiceApi serviceApi = RetrofitClientModel.getRetrofitClient()
            .create(WeatherServiceApi.class);
*/