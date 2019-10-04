package com.wordpress.cruxonlinedotblog.cruxbmicalc.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.wordpress.cruxonlinedotblog.cruxbmicalc.R;


public class FirstFragment extends Fragment  {
    private EditText height;
    private EditText weight;
    private TextView result;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_first, container, false);

        height =rootView.findViewById(R.id.height);
        weight = rootView.findViewById(R.id.weight);
        result = rootView.findViewById(R.id.result);

        Button calc= rootView.findViewById(R.id.calc);
        calc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                calculateBMI();
            }

            private void calculateBMI () {
                String heightStr = height.getText().toString();
                String weightStr = weight.getText().toString();
                if (!height.getText().toString().equals("") && !weight.getText().toString().equals("")){

                    float heightValue = Float.parseFloat(height.getText().toString());
                    float weightValue = Float.parseFloat(weight.getText().toString());
                    float bmi = weightValue / (heightValue * heightValue);
                    displayBMI(bmi);

                } else if (TextUtils.isEmpty(weightStr)&&TextUtils.isEmpty(heightStr)) {
                    Toast.makeText(getActivity(), "Enter Your Height and Weight ", Toast.LENGTH_SHORT).show();

                }else if( TextUtils.isEmpty(weightStr)){
                    Toast.makeText(getActivity(), "Enter Your Weight  ", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getActivity(), "Enter Your Height ", Toast.LENGTH_SHORT).show();

                }

            }




            private void displayBMI ( float bmi) {

                String bmiLabel;
                if (Float.compare(bmi, 15f) <= 0) {
                    bmiLabel = getString(R.string.you_severely_underweight);
                } else if (Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <= 0) {
                    bmiLabel = getString(R.string.you_very_underweight);
                } else if (Float.compare(bmi, 16f) > 0 && Float.compare(bmi, 18.5f) <= 0) {
                    bmiLabel = getString(R.string.you_underweight);
                } else if (Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 25f) <= 0) {
                    bmiLabel = getString(R.string.you_normal_weight);
                } else if (Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <= 0) {
                    bmiLabel = getString(R.string.you_over_weight);
                } else if (Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 35f) <= 0) {
                    bmiLabel = getString(R.string.you_first_class_obese);
                } else if (Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 40f) <= 0) {
                    bmiLabel = getString(R.string.you_second_class_obese);
                } else {
                    bmiLabel = getString(R.string.you_third_class_obese);
                }

                bmiLabel = bmi + "\n" + bmiLabel;
                result.setText(bmiLabel);
            }

        });
        return rootView;

    }
}






