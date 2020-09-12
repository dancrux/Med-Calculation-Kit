package com.wordpress.cruxonlinedotblog.cruxbmicalc.Fragments;


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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.wordpress.cruxonlinedotblog.cruxbmicalc.R;

import java.text.DecimalFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstCardiovascularFragment extends Fragment {
private TextView mapPulseResult,cardiacOutputResult,bloodPressureResult,peripheralResResult;
private EditText systolicText,diastolicText, heartRateText,strokeVolText,cardiacOutputText,
        peripheralResistance,cardiacOutputText2 ,mapText;
private Button cardiacOutputBtn, bloodPressureBtn,peripheralResBtn;
private RadioButton mapButton, pulseButton;
private RadioGroup radioGroup;
    public FirstCardiovascularFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_first_cardiovascular, container, false);
        systolicText = rootView.findViewById(R.id.systolicText);
        diastolicText = rootView.findViewById(R.id.diastolicText);
        mapPulseResult = rootView.findViewById(R.id.mapPulseResult);

        mapButton =rootView.findViewById(R.id.mapButton);


        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String systolicString =systolicText.getText().toString();
                String diastolicString =diastolicText.getText().toString();
                if (!systolicText.getText().toString().equals("")&& !diastolicText.getText().toString().equals("")){
                    double systolicValue =Double.parseDouble(systolicString);
                    double diastolicValue =Double.parseDouble(diastolicString);
                    double map = 0.333*((systolicValue-diastolicValue)+diastolicValue);
                    displayMap(map);
                }else if (TextUtils.isEmpty(systolicString)&&TextUtils.isEmpty(diastolicString)){
                    Toast.makeText(getActivity(),"Enter Systolic and Diastolic Pressure",Toast.LENGTH_SHORT).show();

                }else if( TextUtils.isEmpty(systolicString)){
                    Toast.makeText(getActivity(), "Enter Systolic Pressure  ", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getActivity(), "Enter Diastolic Pressure ", Toast.LENGTH_SHORT).show();

                }
            }
            private void displayMap(double map){
                String mapResult;
                DecimalFormat df = new DecimalFormat(".##");

                String formattedValue = df.format(map);

                mapResult = formattedValue +"mmHg";
                mapPulseResult.setText(mapResult);

            }
        });

        pulseButton =rootView.findViewById(R.id.pulseButton);
        pulseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String systolicString = systolicText.getText().toString();
                String diastolicString = diastolicText.getText().toString();
                if (!systolicText.getText().toString().equals("")&& !diastolicText.getText().toString().equals("")){
                    float systolicValue = Float.parseFloat(systolicString);
                    float diastolicValue = Float.parseFloat(diastolicString);
                    float pulse = systolicValue-diastolicValue;
                    displayPulse(pulse);
                }else if (TextUtils.isEmpty(systolicString)&&TextUtils.isEmpty(diastolicString)){
                    Toast.makeText(getActivity(),"Enter Systolic and Diastolic Pressure",Toast.LENGTH_SHORT).show();

                }else if( TextUtils.isEmpty(systolicString)){
                    Toast.makeText(getActivity(), "Enter Systolic Pressure  ", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getActivity(), "Enter Diastolic Pressure ", Toast.LENGTH_SHORT).show();

                }
            }
            private void displayPulse(float pulse) {
                String pulseResult;
                pulseResult = pulse + "mmHg";
                mapPulseResult.setText(pulseResult);
            }
        });

        heartRateText =rootView.findViewById(R.id.heartRateText);
        strokeVolText = rootView.findViewById(R.id.strokevolText);
        cardiacOutputResult =rootView.findViewById(R.id.cardiacOutputResult);

        cardiacOutputBtn = rootView.findViewById(R.id.cardiacOutputBtn);
        cardiacOutputBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String heartRateString=heartRateText.getText().toString();
                String strokeVolString =strokeVolText.getText().toString();
                if (!heartRateText.getText().toString().equals("")&& !strokeVolText.getText().toString().equals("")){
                    double heartRateValue =Double.parseDouble(heartRateString);
                    double strokeVolValue =Double.parseDouble(strokeVolString);
                    double cardiacOutput = heartRateValue - strokeVolValue;
                    displayCardiacOutput(cardiacOutput);
                }else if (TextUtils.isEmpty(heartRateString)&&TextUtils.isEmpty(strokeVolString)){
                    Toast.makeText(getActivity(),"Enter Heart Rate and Stroke Volume",Toast.LENGTH_SHORT).show();

                }else if( TextUtils.isEmpty(heartRateString)){
                    Toast.makeText(getActivity(), "Enter Heart Rate", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getActivity(), "Enter Stroke Volume", Toast.LENGTH_SHORT).show();

                }

            }

            private void displayCardiacOutput(double cardiacOutput) {
                String CoResult;
                CoResult = cardiacOutput + "ml/Min";
                cardiacOutputResult.setText(CoResult);

            }
        });

        cardiacOutputText =rootView.findViewById(R.id.cardiacOutputText);
        peripheralResistance = rootView.findViewById(R.id. peripheralResistance);
        bloodPressureResult =rootView.findViewById(R.id. bloodPressureResult);

        bloodPressureBtn = rootView.findViewById(R.id. bloodPressureBtn );
        bloodPressureBtn .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cardiacOutputString=cardiacOutputText.getText().toString();
                String peripheralString = peripheralResistance.getText().toString();
                if (!cardiacOutputText.getText().toString().equals("")&& ! peripheralResistance.getText().toString().equals("")){
                    double cardiacOutputValue =Double.parseDouble(cardiacOutputString);
                    double peripheralValue =Double.parseDouble(peripheralString);
                    double bloodPressure = cardiacOutputValue - peripheralValue;
                    displayBloodPressure(bloodPressure);
                }else if (TextUtils.isEmpty(cardiacOutputString)&&TextUtils.isEmpty(peripheralString)){
                    Toast.makeText(getActivity(),"Enter Cardiac Output and Peripheral Resistance",Toast.LENGTH_SHORT).show();

                }else if( TextUtils.isEmpty(cardiacOutputString)){
                    Toast.makeText(getActivity(), "Enter Cardiac Output", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getActivity(), "Enter Peripheral Resistance", Toast.LENGTH_SHORT).show();

                }

            }

            private void displayBloodPressure(double bloodPressure) {
                String bloodPrResult;
                bloodPrResult = bloodPressure + "mmHg";
                bloodPressureResult.setText(bloodPrResult);

            }
        });

        mapText =rootView.findViewById(R.id. mapText);
        cardiacOutputText2= rootView.findViewById(R.id.cardiacOutputText2);
        peripheralResResult =rootView.findViewById(R.id. peripheralResResult);

        peripheralResBtn = rootView.findViewById(R.id.peripheralResBtn );
        peripheralResBtn .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mapString= mapText.getText().toString();
                String coString = cardiacOutputText2.getText().toString();
                if (!cardiacOutputText2.getText().toString().equals("")&& ! mapText.getText().toString().equals("")){
                    double mapValue =Double.parseDouble(mapString);
                    double coValue =Double.parseDouble(coString);
                    double peripheralPressure =  mapValue/coValue;
                    displayPeripheralPressure(peripheralPressure);
                }else if (TextUtils.isEmpty(mapString)&&TextUtils.isEmpty(coString)){
                    Toast.makeText(getActivity(),"Enter Mean Arterial Pressure and Cardiac Output",Toast.LENGTH_SHORT).show();

                }else if( TextUtils.isEmpty(mapString)){
                    Toast.makeText(getActivity(), "Enter Mean Arterial Pressure", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getActivity(), "Enter Cardiac Output", Toast.LENGTH_SHORT).show();

                }

            }

            private void displayPeripheralPressure(double peripheralPressure) {
                String peripheralPreResult;
                DecimalFormat df = new DecimalFormat(".##");

                String formattedValue = df.format(peripheralPressure);
                peripheralPreResult = formattedValue + "mmHg";
                peripheralResResult.setText( peripheralPreResult);

            }
        });


        return rootView;
    }
//    public void onRadioButtonSelected(View v) {
//        boolean checked = ((RadioButton) v).isChecked();
//        switch (v.getId()) {
//            case R.id.mapButton:
//                if (checked) {
//                    String systolicString = systolicText.getText().toString();
//                    String diastolicString = diastolicText.getText().toString();
//                    if (!systolicText.getText().toString().equals("") && !diastolicText.getText().toString().equals("")) {
//                        double systolicValue = Double.parseDouble(systolicString);
//                        double diastolicValue = Double.parseDouble(diastolicString);
//                        double map = 0.333 * ((systolicValue - diastolicValue) + diastolicValue);
//                        displayMap(map);
//                    } else if (TextUtils.isEmpty(systolicString) && TextUtils.isEmpty(diastolicString)) {
//                        Toast.makeText(getActivity(), "Enter Systolic and Diastolic Pressure", Toast.LENGTH_SHORT).show();
//
//                    } else if (TextUtils.isEmpty(systolicString)) {
//                        Toast.makeText(getActivity(), "Enter Systolic Pressure  ", Toast.LENGTH_SHORT).show();
//
//                    } else {
//                        Toast.makeText(getActivity(), "Enter Diastolic Pressure ", Toast.LENGTH_SHORT).show();
//
//                    }
//                }
//                public void displayMap ( double map){
//                String mapResult;
//                DecimalFormat df = new DecimalFormat(".##");
//
//                String formattedValue = df.format(map);
//
//                mapResult = formattedValue + "mmHg";
//                mapPulseResult.setText(mapResult);
//            }
//
//            break;
//            case R.id.pulseButton:
//                if (checked) {
//
//                }
//                break;
//
//
//        }
//
//    }
}
