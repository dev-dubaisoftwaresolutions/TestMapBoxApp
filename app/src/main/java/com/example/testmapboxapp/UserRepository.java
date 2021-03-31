package com.example.testmapboxapp;

import android.app.Application;
import android.content.DialogInterface;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.MutableLiveData;

import com.mapbox.geojson.Feature;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private ArrayList<User> users = new ArrayList<>();
    private MutableLiveData<List<User>> mutableLiveData = new MutableLiveData<>();
    private static UserRepository userRepository;

    public UserRepository() {

    }

    public synchronized static UserRepository getInstance() {
        if (userRepository == null) {
            return new UserRepository();
        }
        return userRepository;
    }


    public MutableLiveData<List<User>> getMutableLiveData() {
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<UserWrapper> call = apiService.getUserList();
        call.enqueue(new Callback<UserWrapper>() {
            @Override
            public void onResponse(Call<UserWrapper> call, Response<UserWrapper> response) {

                UserWrapper userWrapper = response.body();
                if (userWrapper != null && userWrapper.getUser() != null) {
                    users = (ArrayList<User>) userWrapper.getUser();
                    mutableLiveData.setValue(users);
                }
            }
            @Override
            public void onFailure(Call<UserWrapper> call, Throwable t) {

                Log.d("ListSize"," - > Error    "+ t.getMessage());

                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.context).create();
                alertDialog.setTitle("Error");
                alertDialog.setMessage(t.getMessage());
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                alertDialog.show();
            }
        });
        return mutableLiveData;
    }
}