package org.utarid.rxandroid.network.network;

import org.utarid.rxandroid.network.network.model.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("users")
    Observable<List<User>> getUsersObservable();

    @POST("users")
    Observable<User> postUsersObservable(@Body User user);
}
