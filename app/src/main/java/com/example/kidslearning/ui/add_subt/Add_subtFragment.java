package com.example.kidslearning.ui.add_subt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.kidslearning.MainActivity5;
import com.example.kidslearning.R;
import com.example.kidslearning.databinding.FragmentAddSubtBinding;

public class Add_subtFragment extends Fragment {
    int index=0,c=0,i=0;
    boolean flag=true;
    Activity as;
    private FragmentAddSubtBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Add_subtViewModel dashboardViewModel =
                new ViewModelProvider(this).get(Add_subtViewModel.class);

        binding = FragmentAddSubtBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        as=getActivity();

        return root;
    }

    public void onStart() {
        super.onStart();
        Button bn = (Button) as.findViewById(R.id.button2);

        TextView tfq=(TextView) as.findViewById(R.id.textView5);
        TextView tfx=(TextView) as.findViewById(R.id.textView2);
        TextView tfy=(TextView) as.findViewById(R.id.textView4);
        RadioButton r1=(RadioButton) as.findViewById(R.id.radioButton6);
        RadioButton r2=(RadioButton) as.findViewById(R.id.radioButton5);
        RadioGroup rgg=(RadioGroup) as.findViewById(R.id.radioGroup) ;


        String[] tf_q=getResources().getStringArray(R.array.t_questions);
        String[] tf_ac=getResources().getStringArray(R.array.t_answers);

        tfq.setText(tf_q[index]);
        tfx.setText(String.valueOf(index+1));
        tfy.setText("/"+String.valueOf(tf_q.length));

         bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.button2:

                        if(index<9) {
                            if(r1.isChecked()||r2.isChecked()) {
                                if ((r1.isChecked() && (tf_ac[index].equals(r1.getText()))) || (r2.isChecked() && (tf_ac[index].equals(r2.getText())))) {
                                    c++;
                                } else {
                                    i++;
                                }
                            }

                            if(r1.isChecked()||r2.isChecked()) {
                                rgg.clearCheck();
                                index++;
                                tfq.setText(tf_q[index]);
                                tfx.setText(String.valueOf(index + 1));
                            }
                            else {
                                Toast.makeText(as.getApplication(),"Select option",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else if(index==9&&flag==true) {
                            if(r1.isChecked()||r2.isChecked()) {
                                if ((r1.isChecked() && (tf_ac[index].equals(r1.getText()))) || (r2.isChecked() && (tf_ac[index].equals(r2.getText())))) {
                                    c++;
                                } else {
                                    i++;
                                }
                            }
                            flag=false;
                            Toast.makeText(as.getApplication(),"Quiz end",Toast.LENGTH_SHORT).show();
                            bn.setText("Show Result");
                        }
                        else if(index==9 && flag==false) {
                            rgg.setVisibility(view.INVISIBLE);
                            tfq.setVisibility(view.INVISIBLE);
                            tfx.setText("Score: "+c);
                            bn.setText("RETRY!!");
                            index++;
                        }
                        else if(index>9&&flag==false) {
                            Intent intent=new Intent(as, MainActivity5.class);
                            startActivity(intent);
                        }

                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + view.getId());
                }
            }
        });
    }
}