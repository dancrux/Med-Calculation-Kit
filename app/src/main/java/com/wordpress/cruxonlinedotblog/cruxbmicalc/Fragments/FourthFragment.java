package com.wordpress.cruxonlinedotblog.cruxbmicalc.Fragments;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.wordpress.cruxonlinedotblog.cruxbmicalc.R;

public class FourthFragment extends Fragment {


    public FourthFragment (){

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fourth, container, false);
        TableLayout table= rootView.findViewById(R.id.table_chart);
        return rootView;
    }


}
