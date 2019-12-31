package com.wordpress.cruxonlinedotblog.cruxbmicalc.Fragments;


import android.os.Bundle;
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

import java.text.DecimalFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstRenalFragment extends Fragment {


    public FirstRenalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =inflater.inflate(R.layout.fragment_first_renal, container, false);
        final TextView clearanceResult = rootView.findViewById(R.id.clearanceResult);
        final TextView rbfResult = rootView.findViewById(R.id.rbfResult);

        final EditText uxText = rootView.findViewById(R.id.uxText);
        final EditText pxText = rootView.findViewById(R.id.pxText);
        final EditText volText = rootView.findViewById(R.id.volText);

        final EditText rpfText = rootView.findViewById(R.id.rpfText);
        final EditText hctText = rootView.findViewById(R.id.hctText);

        Button clearanceBtn = rootView.findViewById(R.id.clearanceBtn);
        clearanceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uxString = uxText.getText().toString();
               String pxString =  pxText.getText().toString();
               String volString = volText.getText().toString();
                if (!uxText.getText().toString().equals("") && !pxText.getText().toString().equals("")&& !volText.getText().toString().equals("")) {
                    double uxValue = Double.parseDouble(uxString);
                    double pxValue = Double.parseDouble(pxString);
                    double volValue = Double.parseDouble(volString);
                    double clearance = ((uxValue* volValue)/pxValue) ;
                    showClearance(clearance);

                } else if (TextUtils.isEmpty(uxString) && TextUtils.isEmpty(pxString)&&TextUtils.isEmpty(volString)) {
                    Toast.makeText(getActivity(), "Enter volume, Px and Ux", Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(uxString)&& TextUtils.isEmpty(pxString)) {
                    Toast.makeText(getActivity(), "Enter Ux and Px", Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(pxString)&& TextUtils.isEmpty(volString)) {
                    Toast.makeText(getActivity(), "Enter Px and volume", Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(uxString)) {
                    Toast.makeText(getActivity(), "Enter Ux", Toast.LENGTH_SHORT).show();

                }else if (TextUtils.isEmpty(pxString)) {
                    Toast.makeText(getActivity(), "Enter Px", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getActivity(), "Enter Volume", Toast.LENGTH_SHORT).show();

                }

            }

            private void showClearance(double clearance) {
                String showClearance;
                DecimalFormat df = new DecimalFormat(".#");
                String formattedValue = df.format(clearance);
                showClearance = formattedValue + "ml/min";
                clearanceResult.setText(showClearance);

            }
        });
        Button rbfBtn = rootView.findViewById(R.id.rbfBtn);
        rbfBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String rpfString = rpfText.getText().toString();
                String hctString = hctText.getText().toString();
                if (!rpfText.getText().toString().equals("") && !hctText.getText().toString().equals("")) {
                    double rpfValue = Double.parseDouble(rpfString);
                    double hctValue = Double.parseDouble(hctString);

                    double rbf = (((rpfValue* 100)/90)*(1/(1-hctValue/100)))/1000;
                    showRbf(rbf);

                } else if (TextUtils.isEmpty(rpfString) && TextUtils.isEmpty(hctString)) {
                    Toast.makeText(getActivity(), "Enter Rpf and Hematocrit", Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(rpfString) ) {
                    Toast.makeText(getActivity(), "Enter Rpf", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(getActivity(), "Enter Hematocrit", Toast.LENGTH_SHORT).show();

                }
            }

            private void showRbf(double rbf) {
                String displayRbf , formattedValue;
                DecimalFormat df = new DecimalFormat(".#");
                formattedValue = df.format(rbf);
                displayRbf = formattedValue + "L/min";
                rbfResult.setText(displayRbf);
            }
        });

        return rootView;
    }

}
