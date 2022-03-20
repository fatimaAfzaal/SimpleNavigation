package com.example.kidslearning.ui.tables;

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
import com.example.kidslearning.databinding.FragmentTablesBinding;

public class TablesFragment extends Fragment {

    Activity h;
    int index=0,correct=0,icorrect=0;
    boolean flag=true;
    private FragmentTablesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TablesViewModel homeViewModel =
                new ViewModelProvider(this).get(TablesViewModel.class);

        binding = FragmentTablesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        h=getActivity();

        return root;
    }

    public void onStart() {
        super.onStart();
        Button bn = (Button) h.findViewById(R.id.button3);
        RadioButton r1=(RadioButton) h.findViewById(R.id.radioButton4);
        RadioButton r2=(RadioButton) h.findViewById(R.id.radioButton3);
        RadioButton r3=(RadioButton) h.findViewById(R.id.radioButton);
        RadioButton r4=(RadioButton) h.findViewById(R.id.radioButton2);
        RadioGroup rg=(RadioGroup) h.findViewById(R.id.radioGroup2) ;
        TextView tmq=(TextView) h.findViewById(R.id.textView9);
        TextView tmx=(TextView) h.findViewById(R.id.textView7);
        TextView tmy=(TextView) h.findViewById(R.id.textView8);

        String[] mcq_q=getResources().getStringArray(R.array.mcq_question);
        String[] mcq_a1=getResources().getStringArray(R.array.mcq_Answer1);
        String[] mcq_a2=getResources().getStringArray(R.array.mcq_Answer2);
        String[] mcq_a3=getResources().getStringArray(R.array.mcq_Answer3);
        String[] mcq_a4=getResources().getStringArray(R.array.mcq_Answer4);
        String[] mcq_ac=getResources().getStringArray(R.array.mcq_Answerc);

        tmq.setText(mcq_q[index]);
        tmx.setText(String.valueOf(index+1));
        tmy.setText("/"+String.valueOf(mcq_q.length));
        r1.setText(String.valueOf(mcq_a1[index]));
        r2.setText(String.valueOf(mcq_a2[index]));
        r3.setText(String.valueOf(mcq_a3[index]));
        r4.setText(String.valueOf(mcq_a4[index]));

        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.button3:

                        if(index<9) {
                            if(r1.isChecked()||r2.isChecked()||r3.isChecked()||r4.isChecked()==true) {
                                if ((r1.isChecked() && (mcq_ac[index].equals(r1.getText()))) || (r2.isChecked() && (mcq_ac[index].equals(r2.getText()))) || (r3.isChecked() && (mcq_ac[index].equals(r3.getText()))) || (r4.isChecked() && (mcq_ac[index].equals(r4.getText())))) {
                                    correct++;
                                } else {
                                    icorrect++;
                                }
                            }

                            if(r1.isChecked()||r2.isChecked()||r3.isChecked()||r4.isChecked()==true) {
                                rg.clearCheck();
                                index++;
                                tmq.setText(mcq_q[index]);
                                tmx.setText(String.valueOf(index + 1));
                                r1.setText(String.valueOf(mcq_a1[index]));
                                r2.setText(String.valueOf(mcq_a2[index]));
                                r3.setText(String.valueOf(mcq_a3[index]));
                                r4.setText(String.valueOf(mcq_a4[index]));
                            }
                            else {
                                Toast.makeText(h.getApplication(),"Select option",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else if(index==9&&flag==true) {
                            if(r1.isChecked()||r2.isChecked()||r3.isChecked()||r4.isChecked()==true) {
                                if ((r1.isChecked() && (mcq_ac[index].equals(r1.getText()))) || (r2.isChecked() && (mcq_ac[index].equals(r2.getText()))) || (r3.isChecked() && (mcq_ac[index].equals(r3.getText()))) || (r4.isChecked() && (mcq_ac[index].equals(r4.getText())))) {
                                    correct++;
                                } else {
                                    icorrect++;
                                }
                            }
                            flag=false;
                            Toast.makeText(h.getApplication(),"Quiz end",Toast.LENGTH_SHORT).show();
                            bn.setText("Show Result");
                        }
                        else if(index==9 && flag==false) {
                            rg.setVisibility(view.INVISIBLE);
                            tmq.setVisibility(view.INVISIBLE);
                            tmx.setText("Score: " + correct);
                            bn.setText("RETRY!!");
                            index++;
                        }
                        else if(index>9&&flag==false) {
                            Intent intent=new Intent(h, MainActivity5.class);
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