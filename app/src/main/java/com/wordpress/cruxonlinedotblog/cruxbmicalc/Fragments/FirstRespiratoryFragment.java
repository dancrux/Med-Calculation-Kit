package com.wordpress.cruxonlinedotblog.cruxbmicalc.Fragments;


import android.os.Bundle;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstRespiratoryFragment extends Fragment {
private TextView vcResult, frcResult,icResult, rvResult;
private EditText tvText, irvText, ervText,rvText,ervText2,irvText2,tvText2,frcText,ervText3;
private Button vcBtn, frcBtn, icBtn,rvBtn;



    public FirstRespiratoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_first_respiratory, container, false);
        vcBtn= rootView.findViewById(R.id.vcBtn);

        vcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvText = rootView.findViewById(R.id.tvText);
                ervText = rootView.findViewById(R.id.ervText);
                irvText = rootView.findViewById(R.id.irvText);
                vcResult = rootView.findViewById(R.id.vcResult);

                String tvString = tvText.getText().toString();
                String ervString =  ervText.getText().toString();
                String irvString = irvText.getText().toString();
                if (!tvText.getText().toString().equals("") && !ervText.getText().toString().equals("")&& !irvText.getText().toString().equals("")) {
                    double tvValue = Double.parseDouble(tvString);
                    double ervValue = Double.parseDouble(ervString);
                    double irvValue = Double.parseDouble(irvString);
                    double vitalCapacity = (tvValue + ervValue + irvValue);
                    showVitalCapacity(vitalCapacity);

                } else if (TextUtils.isEmpty(tvString) && TextUtils.isEmpty(ervString)&&TextUtils.isEmpty(irvString)) {
                    Toast.makeText(getActivity(), "Enter tv, erv and irv", Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(tvString)&& TextUtils.isEmpty(ervString)) {
                    Toast.makeText(getActivity(), "Enter Tv and Erv", Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(ervString)&& TextUtils.isEmpty(irvString)) {
                    Toast.makeText(getActivity(), "Enter Erv and Irv", Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(ervString)) {
                    Toast.makeText(getActivity(), "Enter Erv", Toast.LENGTH_SHORT).show();

                }else if (TextUtils.isEmpty(irvString)) {
                    Toast.makeText(getActivity(), "Enter Irv", Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(tvString)&& TextUtils.isEmpty(irvString)) {
                    Toast.makeText(getActivity(), "Enter Tv and Irv", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(getActivity(), "Enter Tv", Toast.LENGTH_SHORT).show();

                }

            }

            private void showVitalCapacity(double vitalCapacity) {
                String showVc;
                showVc =vitalCapacity + "ml";
                vcResult.setText(showVc);

            }
        });

        frcBtn = rootView.findViewById(R.id.frcBtn);
        frcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ervText2 = rootView.findViewById(R.id.ervText2);
                rvText = rootView.findViewById(R.id.rvText);
                frcResult = rootView.findViewById(R.id.frcResult);
                String ervString = ervText2.getText().toString();
                String rvString =  rvText.getText().toString();

                if (!rvText.getText().toString().equals("") && !ervText2.getText().toString().equals("")) {
                    double ervValue = Double.parseDouble(ervString);
                    double rvValue = Double.parseDouble(rvString);

                    double frc = (ervValue + rvValue);
                    showFrc(frc);

                }  else if (TextUtils.isEmpty(ervString)&& TextUtils.isEmpty(rvString)) {
                    Toast.makeText(getActivity(), "Enter Erv and RV", Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(ervString)) {
                    Toast.makeText(getActivity(), "Enter Erv", Toast.LENGTH_SHORT).show();

                }  else {
                    Toast.makeText(getActivity(), "Enter Rv", Toast.LENGTH_SHORT).show();

                }


            }

            private void showFrc(double frc) {
                String displayFrc;
                displayFrc = frc + "ml";
                frcResult.setText(displayFrc);
            }
        });

        icBtn = rootView.findViewById(R.id.icBtn);
        icBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irvText2 = rootView.findViewById(R.id.irvText2);
                tvText2 = rootView.findViewById(R.id.tvText2);
                icResult = rootView.findViewById(R.id.icResult);
                String irvString = irvText2.getText().toString();
                String tvString =  tvText2.getText().toString();

                if (!irvText2.getText().toString().equals("") && !tvText2.getText().toString().equals("")) {
                    double irvValue = Double.parseDouble(irvString);
                    double tvValue = Double.parseDouble(tvString);

                    double ic = (irvValue + tvValue);
                    showIc(ic);

                } else if (TextUtils.isEmpty(irvString) && TextUtils.isEmpty(tvString)) {
                    Toast.makeText(getActivity(), "Enter Irv and Tv ", Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(tvString)) {
                    Toast.makeText(getActivity(), "Enter Tv", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getActivity(), "Enter Irv", Toast.LENGTH_SHORT).show();

                }


            }

            private void showIc(double ic) {
                String displayIc;
                displayIc = ic +"ml";
                icResult.setText(displayIc);
            }
        });

        rvBtn = rootView.findViewById(R.id.rvBtn);
        rvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ervText3 = rootView.findViewById(R.id.ervText3);
                frcText = rootView.findViewById(R.id.frcText);
                rvResult = rootView.findViewById(R.id.rvResult);
                String ervString = ervText3.getText().toString();
                String frcString =  frcText.getText().toString();

                if (!ervText3.getText().toString().equals("") && !frcText.getText().toString().equals("")) {
                    double ervValue = Double.parseDouble(ervString);
                    double frcValue = Double.parseDouble(frcString);

                    double rv = (ervValue + frcValue);
                    showRv(rv);

                } else if (TextUtils.isEmpty(ervString) && TextUtils.isEmpty(frcString)) {
                    Toast.makeText(getActivity(), "Enter Erv and Frc", Toast.LENGTH_SHORT).show();


                } else if (TextUtils.isEmpty(ervString)) {
                    Toast.makeText(getActivity(), "Enter Erv", Toast.LENGTH_SHORT).show();
                }   else {
                    Toast.makeText(getActivity(), "Enter Frc", Toast.LENGTH_SHORT).show();

                }


            }

            private void showRv(double rv) {
                String displayRv;
                displayRv = rv +"ml";
                rvResult.setText(displayRv);
            }
        });
        return rootView;
    }

}
