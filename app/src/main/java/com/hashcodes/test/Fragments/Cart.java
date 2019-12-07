package com.hashcodes.test.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.hashcodes.test.R;


/**
 * Code written by Sudheer on 06.12.2019
 */
public class Cart extends Fragment {


    public Cart() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        //your code

        return view;
    }

}
