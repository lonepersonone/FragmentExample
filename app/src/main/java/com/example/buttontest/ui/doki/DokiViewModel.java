package com.example.buttontest.ui.doki;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DokiViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> mText;

    public DokiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("DOKI");
    }

    public LiveData<String> getText() {
        return mText;
    }
}