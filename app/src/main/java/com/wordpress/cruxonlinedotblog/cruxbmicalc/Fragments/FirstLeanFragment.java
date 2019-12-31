package com.wordpress.cruxonlinedotblog.cruxbmicalc.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.wordpress.cruxonlinedotblog.cruxbmicalc.R;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstLeanFragment extends Fragment {


    public FirstLeanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_first_lean, container, false);
        final TextView ibmResult = rootView.findViewById(R.id.ibmResult);
        final TextView bodyfatTextView = rootView.findViewById(R.id.bodyfatTextView);
        final TextView lbmPercentageText = rootView.findViewById(R.id.lbmPercentageText);

        Button ibmButton =   rootView.findViewById(R.id.ibmButton);
        ibmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioButton maleRadioBtn = rootView.findViewById(R.id.maleRadioBtn);
                RadioButton femaleRadioBtn = rootView.findViewById(R.id.femaleRadioBtn);
                RadioButton yesRadioBtn = rootView.findViewById(R.id.yesRadioBtn);
                RadioButton noRadioBtn = rootView.findViewById(R.id.noRadioBtn);

                EditText heightText = rootView.findViewById(R.id.heightText);
                EditText weightText = rootView.findViewById(R.id.weightText);


                String heightString = heightText.getText().toString();
                String weightString = weightText.getText().toString();
                if (maleRadioBtn.isChecked() && noRadioBtn.isChecked()) {
                    if (!heightText.getText().toString().equals("") && !weightText.getText().toString().equals("")) {
                        double heightValue = Double.parseDouble(heightString);
                        double weightValue = Double.parseDouble(weightString);
                        double mLeanMass = ((weightValue * 0.32810) + (heightValue* 0.33929)-29.5336) ;
                        showMaleLeanMass(mLeanMass);
                        double lbmPercentage = (mLeanMass*100)/weightValue;
                        showLbmPercentage(lbmPercentage);
                        double fatPercentage = 100 - lbmPercentage;
                        showFatPercentage(fatPercentage);
                    } else if (TextUtils.isEmpty(heightString) && TextUtils.isEmpty(weightString)) {
                        Toast.makeText(getActivity(), "Enter Your Height and Weight", Toast.LENGTH_SHORT).show();

                    } else if (TextUtils.isEmpty(heightString)) {
                        Toast.makeText(getActivity(), "Enter Your Height", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getActivity(), "Enter Your Weight", Toast.LENGTH_SHORT).show();

                    }

                } else if (femaleRadioBtn.isChecked() && noRadioBtn.isChecked()) {

                    if (!heightText.getText().toString().equals("") && !weightText.getText().toString().equals("")) {
                        double heightValue = Double.parseDouble(heightString);
                        double weightValue = Double.parseDouble(weightString);
                        double fLeanMass = ((weightValue * 0.29569) +(heightValue* 0.41813)-43.2933);
                        showFemaleLeanMass(fLeanMass);
                        double lbmPercentage = (fLeanMass*100)/weightValue;
                        showLbmPercentage(lbmPercentage);
                        double fatPercentage = 100 - lbmPercentage;
                        showFatPercentage(fatPercentage);
                    }else if (TextUtils.isEmpty(heightString)&&TextUtils.isEmpty(weightString)){
                        Toast.makeText(getActivity(),"Enter Your Height and Weight",Toast.LENGTH_SHORT).show();

                    }else if( TextUtils.isEmpty(heightString)){
                        Toast.makeText(getActivity(), "Enter Your Height", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getActivity(), "Enter Your Weight", Toast.LENGTH_SHORT).show();

                    }
                } else if (maleRadioBtn.isChecked() && yesRadioBtn.isChecked()) {

                    if (!heightText.getText().toString().equals("") && !weightText.getText().toString().equals("")) {
                        double heightValue = Double.parseDouble(heightString);
                        double weightValue = Double.parseDouble(weightString);
                        double mChildLeanMass = (3.8*(0.0215* Math.pow(weightValue , 0.6469))*Math.pow(heightValue, 0.7236));
                        showMChildLeanMass(mChildLeanMass);
                        double lbmPercentage = (mChildLeanMass*100)/weightValue;
                        showLbmPercentage(lbmPercentage);
                        double fatPercentage = 100 - lbmPercentage;
                        showFatPercentage(fatPercentage);
                    }else if (TextUtils.isEmpty(heightString)&&TextUtils.isEmpty(weightString)){
                        Toast.makeText(getActivity(),"Enter Your Height and Weight",Toast.LENGTH_SHORT).show();

                    }else if( TextUtils.isEmpty(heightString)){
                        Toast.makeText(getActivity(), "Enter Your Height", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getActivity(), "Enter Your Weight", Toast.LENGTH_SHORT).show();

                    }
                }else if (femaleRadioBtn.isChecked()&& yesRadioBtn.isChecked()){
                    if (!heightText.getText().toString().equals("") && !weightText.getText().toString().equals("")) {
                        double heightValue = Double.parseDouble(heightString);
                        double weightValue = Double.parseDouble(weightString);
                        double mChildLeanMass = (3.8*(0.0215* Math.pow(weightValue , 0.6469))*Math.pow(heightValue, 0.7236));
                        showMChildLeanMass(mChildLeanMass);
                        double lbmPercentage = (mChildLeanMass*100)/weightValue;
                        showLbmPercentage(lbmPercentage);
                        double fatPercentage = 100 - lbmPercentage;
                        showFatPercentage(fatPercentage);
                    }else if (TextUtils.isEmpty(heightString)&&TextUtils.isEmpty(weightString)){
                        Toast.makeText(getActivity(),"Enter Your Height and Weight",Toast.LENGTH_SHORT).show();

                    }else if( TextUtils.isEmpty(heightString)){
                        Toast.makeText(getActivity(), "Enter Your Height", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getActivity(), "Enter Your Weight", Toast.LENGTH_SHORT).show();

                    }

                }else if (!maleRadioBtn.isChecked()&& !femaleRadioBtn.isChecked()
                        &&!yesRadioBtn.isChecked()&&!noRadioBtn.isChecked()) {
                    Toast.makeText(getActivity(),"Select Your Gender and Age Range",Toast.LENGTH_SHORT).show();
                }else if (!maleRadioBtn.isChecked()&& !femaleRadioBtn.isChecked()) {
                    Toast.makeText(getActivity(),"Select Your Age Range",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(),"Select Your Age Range",Toast.LENGTH_SHORT).show();


                }


            }

            private void showMChildLeanMass(double mChildLeanMass) {
                String maleChildLeanMass;
                DecimalFormat df = new DecimalFormat(".#");
                String formattedValue = df.format(mChildLeanMass);
                maleChildLeanMass = "Your Lean Body Mass is "+formattedValue+"Kg";
                ibmResult.setText(maleChildLeanMass);
            }

            private void showFatPercentage(double fatPercentage) {
                String bodyFatPercentage;
                DecimalFormat df = new DecimalFormat("##");
                String formattedValue = df.format(fatPercentage);
                bodyFatPercentage = "Your Body Fat is "+formattedValue +"% of Your Body Weight";
                bodyfatTextView.setText(bodyFatPercentage);
            }

            private void showLbmPercentage(double lbmPercentage) {
                String leanMassPercentage;
                DecimalFormat df = new DecimalFormat("##");
                String formattedValue = df.format(lbmPercentage);
                leanMassPercentage ="Your Lean Mass Is "+formattedValue+"% of Your Body Weight";
                lbmPercentageText.setText(leanMassPercentage);
            }

            private void showMaleLeanMass(double mLeanMass) {
                String maleLeanMass ;
                DecimalFormat df = new DecimalFormat(".#");

                String formattedValue = df.format(mLeanMass);
                maleLeanMass = "Your Lean Body Mass is "+formattedValue+"Kg";
                ibmResult.setText(maleLeanMass);

            }

                private void showFemaleLeanMass(double fLeanMass){
                String femaleLeanMass;
                DecimalFormat df = new DecimalFormat(".#");
                String formattedValue = df.format(fLeanMass);
                femaleLeanMass ="Your Lean Body Mass is "+formattedValue+"Kg";
                    ibmResult.setText(femaleLeanMass);

                }




 });
        return rootView;
    }

}
