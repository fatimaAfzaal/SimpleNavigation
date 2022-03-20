package com.example.kidslearning.ui.rateApp;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.kidslearning.R;
import com.example.kidslearning.databinding.FragmentRateappBinding;

public class RateAppFragment extends Fragment {

    private FragmentRateappBinding binding;
    RatingBar r;
    Activity rateUs;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RateAppViewModel slideshowViewModel =
                new ViewModelProvider(this).get(RateAppViewModel.class);

        binding = FragmentRateappBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        rateUs=getActivity();

        return root;
    }
    public void onStart() {
        super.onStart();
        Button btn = (Button) rateUs.findViewById(R.id.button);
        RatingBar r = (RatingBar) rateUs.findViewById(R.id.ratingBar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float rvalue = r.getRating();
                Toast.makeText(rateUs.getApplicationContext(), "Rating : " + rvalue, Toast.LENGTH_SHORT).show();
            }
        });
    }
}