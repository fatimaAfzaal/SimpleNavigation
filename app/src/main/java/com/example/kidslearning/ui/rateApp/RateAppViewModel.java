package com.example.kidslearning.ui.rateApp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RateAppViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RateAppViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}