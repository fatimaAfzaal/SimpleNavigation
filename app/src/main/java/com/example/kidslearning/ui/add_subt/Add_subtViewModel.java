package com.example.kidslearning.ui.add_subt;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Add_subtViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public Add_subtViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}