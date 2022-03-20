package com.example.kidslearning;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;

import com.example.kidslearning.R;

public class Fragment1 extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment1_layout,container,false);
    }
}
