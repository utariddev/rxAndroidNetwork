package org.utarid.rxandroid.network;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.utarid.rxandroid.network.databinding.ActivityMainBinding;
import org.utarid.rxandroid.network.network.ApiClient;
import org.utarid.rxandroid.network.network.ApiService;
import org.utarid.rxandroid.network.network.model.User;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private ApiService apiService;
    private UsersAdapter mAdapter;
    private List<User> globalPostsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        apiService = ApiClient.getClient(getApplicationContext()).create(ApiService.class);

        RecyclerView recyclerView = binding.recyclerView;

        mAdapter = new UsersAdapter(this, globalPostsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        binding.buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User userRequest = new User();
                userRequest.setId("12");
                userRequest.setName("foo");
                userRequest.setUsername("bar");

                apiService.postUsersObservable(userRequest)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<User>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {
                                Log.d("rxAndroidNetwork", "onSubscribe");
                            }

                            @Override
                            public void onNext(@NonNull User posts) {
                                Log.d("rxAndroidNetwork", "onNext");
                                globalPostsList.add(posts);
                                mAdapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                Log.d("rxAndroidNetwork", "onError");
                            }

                            @Override
                            public void onComplete() {
                                Log.d("rxAndroidNetwork", "onComplete");
                            }
                        });
            }
        });

        binding.buttonGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiService.getUsersObservable()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<List<User>>() {

                            @Override
                            public void onSubscribe(@NonNull Disposable d) {
                                Log.d("rxAndroidNetwork", "onSubscribe");
                            }

                            @Override
                            public void onNext(@NonNull List<User> users) {
                                Log.d("rxAndroidNetwork", "onNext");
                                globalPostsList.addAll(users);
                                mAdapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                Log.d("rxAndroidNetwork", "onError");
                            }

                            @Override
                            public void onComplete() {
                                Log.d("rxAndroidNetwork", "onComplete");
                            }
                        });
            }
        });
    }
}