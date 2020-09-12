package  com.wordpress.cruxonlinedotblog.cruxbmicalc.Fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.wordpress.cruxonlinedotblog.cruxbmicalc.R;

import java.text.DecimalFormat;


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

                    double heightValue = Double.parseDouble(height.getText().toString());
                    double weightValue = Double.parseDouble(weight.getText().toString());
                    double bmi = weightValue / (heightValue * heightValue);
                    displayBMI(bmi);

                } else if (TextUtils.isEmpty(weightStr)&&TextUtils.isEmpty(heightStr)) {
                    Toast.makeText(getActivity(), "Enter Your Height and Weight ", Toast.LENGTH_SHORT).show();

                }else if( TextUtils.isEmpty(weightStr)){
                    Toast.makeText(getActivity(), "Enter Your Weight  ", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getActivity(), "Enter Your Height ", Toast.LENGTH_SHORT).show();

                }

            }




            private void displayBMI ( double bmi) {
                String bmiLabel , formattedValue;
                if (Double.compare(bmi, 15d) <= 0) {
                    bmiLabel = getString(R.string.you_severely_underweight);
                } else if (Double.compare(bmi, 15d) > 0 && Double.compare(bmi, 16d) <= 0) {
                    bmiLabel = getString(R.string.you_very_underweight);
                } else if (Double.compare(bmi, 16d) > 0 && Double.compare(bmi, 18.5d) <= 0) {
                    bmiLabel = getString(R.string.you_underweight);
                } else if (Double.compare(bmi, 18.5d) > 0 && Double.compare(bmi, 25d) <= 0) {
                    bmiLabel = getString(R.string.you_normal_weight);
                } else if (Double.compare(bmi, 25d) > 0 && Double.compare(bmi, 30d) <= 0) {
                    bmiLabel = getString(R.string.you_over_weight);
                } else if (Double.compare(bmi, 30d) > 0 && Double.compare(bmi, 35d) <= 0) {
                    bmiLabel = getString(R.string.you_first_class_obese);
                } else if (Double.compare(bmi, 35d) > 0 && Double.compare(bmi, 40d) <= 0) {
                    bmiLabel = getString(R.string.you_second_class_obese);
                } else {
                    bmiLabel = getString(R.string.you_third_class_obese);
                }
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                formattedValue = decimalFormat.format(bmi);

                bmiLabel = formattedValue + "\n" + bmiLabel;
                result.setText(bmiLabel);
            }
        });
        return rootView;

    }
}






