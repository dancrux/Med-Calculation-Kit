package com.wordpress.cruxonlinedotblog.cruxbmicalc.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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


import java.util.Objects;


public class SecondFragment extends Fragment  {
    private Context myContext = null;

    private EditText length_quantity;
    private TextView length_result;
    private Spinner sp_convert_from;
    private Spinner sp_convert_to;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);

        length_quantity = rootView.findViewById(R.id.length_quantity);
        length_result=rootView.findViewById(R.id.length_result);
        sp_convert_from = rootView.findViewById(R.id.sp_convert_from);
        sp_convert_to = rootView.findViewById(R.id.sp_convert_to);

        ArrayAdapter<CharSequence>  spinnerAdapter =  ArrayAdapter.createFromResource(getActivity().getBaseContext(),
                R.array.length_units, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_convert_from.setAdapter(spinnerAdapter);
        sp_convert_to.setAdapter(spinnerAdapter);

        Button button_length= rootView.findViewById(R.id.button_length);
        button_length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getResult =length_quantity.getText().toString();
                if (TextUtils.isEmpty(getResult)) {
                    Toast.makeText(getActivity(), "Enter A Value", Toast.LENGTH_SHORT).show();


                }else{
                    int index1 = sp_convert_from.getSelectedItemPosition();
                    int index2 = sp_convert_to.getSelectedItemPosition();
                    float value = Float.parseFloat(length_quantity.getText().toString());


                    float  ratio[] = {1.0f, 100f, 0.001f, 39.37f, 3.281f, 1000f, 1.093613f, 0.0006214f};
                    float  result = value / ratio[index1] * ratio[index2];






                    length_result.setText(result + "");

                }

            }
        });
        return rootView;


    }



}