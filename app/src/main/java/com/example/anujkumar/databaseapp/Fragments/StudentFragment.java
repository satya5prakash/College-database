package com.example.anujkumar.databaseapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anujkumar.databaseapp.Database.MyDatabase;
import com.example.anujkumar.databaseapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class StudentFragment extends Fragment {

    TextView details;
    View view;

    public StudentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_student, container, false);
        MyDatabase myDatabase=new MyDatabase(view.getContext());
        details= view.findViewById(R.id.textViewDetailsStudent);
        myDatabase.search(details,1);
        return view;
    }

}
