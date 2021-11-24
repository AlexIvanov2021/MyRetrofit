package retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
        @GET("weather?q=london&appid=92756c24107bc39dd0a7541f66ba55c5&units=metric")
        Call<OpenWeather> getOpenWeather();


    }

