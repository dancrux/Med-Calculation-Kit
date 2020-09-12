package com.wordpress.cruxonlinedotblog.cruxbmicalc.Fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.wordpress.cruxonlinedotblog.cruxbmicalc.R;

import java.text.DecimalFormat;

public class ThirdFragment extends Fragment {

    private EditText weight_quantity;
    private TextView weight_result;
    private Spinner sp_weight_convert_from;
    private Spinner sp_weight_convert_to;
    public ThirdFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_third, container, false);

        weight_quantity = rootView.findViewById(R.id.weight_quantity);
        weight_result=rootView.findViewById(R.id.weight_result);
        sp_weight_convert_from = rootView.findViewById(R.id.sp_weight_convert_from);
        sp_weight_convert_to = rootView.findViewById(R.id.sp_weight_convert_to);

        ArrayAdapter<CharSequence> spinnerAdapter =  ArrayAdapter.createFromResource(getActivity().getBaseContext(),
                R.array.weight_units, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_weight_convert_from.setAdapter(spinnerAdapter);
        sp_weight_convert_to .setAdapter(spinnerAdapter);

        Button button_weight = rootView.findViewById(R.id.button_weight);
        button_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getResult = weight_quantity.getText().toString();
                if (TextUtils.isEmpty(getResult)) {
                    Toast.makeText(getActivity(), "Enter A Value", Toast.LENGTH_SHORT).show();


                }else{
                    int index1 = sp_weight_convert_from.getSelectedItemPosition();
                    int index2 = sp_weight_convert_to.getSelectedItemPosition();
                    double value = Double.parseDouble( weight_quantity.getText().toString());


                    double ratio[] = {1.0d,0.001d, 1000d,0.453592d};
                    double result = value / ratio[index1] * ratio[index2];
                    showResult(result);
//                    weight_result.setText(result + "");




                }
            }

            private void showResult(double result) {

                String displayResult, formattedValue;
                DecimalFormat df = new DecimalFormat("#.####");
                formattedValue = df.format(result);
                displayResult = formattedValue;
                weight_result.setText(displayResult);
            }
        });
        return rootView;
    }

}
