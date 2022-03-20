package com.example.kidslearning.ui.learning;

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

import com.example.kidslearning.MainActivity3;
import com.example.kidslearning.R;
import com.example.kidslearning.databinding.FragmentLearningBinding;

public class LearningFragment extends Fragment {

    private FragmentLearningBinding binding;
    Activity table;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LearningViewModel homeViewModel =
                new ViewModelProvider(this).get(LearningViewModel.class);

        binding = FragmentLearningBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        table=getActivity();

        return root;
    }

    public void onStart() {
        super.onStart();
        ImageView i = (ImageView) table.findViewById(R.id.imageView99);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(table, MainActivity3.class);
                startActivity(intent);
            }
        });
    }
}