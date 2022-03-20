package com.example.kidslearning.ui.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.kidslearning.MainActivity;
import com.example.kidslearning.MainActivity5;
import com.example.kidslearning.R;
import com.example.kidslearning.databinding.FragmentTestBinding;

public class TestFragment extends Fragment {

    private FragmentTestBinding binding;
    Activity t;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TestViewModel galleryViewModel =
                new ViewModelProvider(this).get(TestViewModel.class);

        binding = FragmentTestBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        t=getActivity();


        return root;
    }

    public void onStart() {
        super.onStart();
        ImageView i = (ImageView) t.findViewById(R.id.imageView4);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(t, MainActivity5.class);
                startActivity(in);
            }
        });
    }
}