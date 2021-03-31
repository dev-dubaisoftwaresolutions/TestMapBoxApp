package com.example.testmapboxapp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MainViewModel  extends ViewModel {


    public MutableLiveData<List<User>> getUserDetails()
    {
        return UserRepository.getInstance().getMutableLiveData();
    }
}
