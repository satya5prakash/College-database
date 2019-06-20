package com.example.anujkumar.databaseapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.anujkumar.databaseapp.Database.MyDatabase;
import com.example.anujkumar.databaseapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    View view ;
    TextView name,sal,marks;
    Button submit,reset;

    public MainFragment() {
        // Required empty public constructor
    }

    private String [] spinnerList={"None","Student","Teacher","Employee"};

    Spinner spinner;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_main, container, false);

       final MyDatabase myDatabase=new MyDatabase(view.getContext());
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_dropdown_item,spinnerList);
        spinner=view.findViewById(R.id.spinner);
         spinner.setAdapter(adapter);
        submit=view.findViewById(R.id.buttonSubmit);
        reset=view.findViewById(R.id.buttonReset);
        name=view.findViewById(R.id.editTextName);
        sal=view.findViewById(R.id.editTextSalary);
        marks=view.findViewById(R.id.editTextMarks);
        marks.setVisibility(view.VISIBLE);
        sal.setVisibility(view.INVISIBLE);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(spinner.getSelectedItem().toString().equals("Student")){
                    sal.setText("");
                    marks.setVisibility(view.VISIBLE);
                    sal.setVisibility(view.INVISIBLE);
                }
                else
                {
                    marks.setText("");
                    marks.setVisibility(view.INVISIBLE);
                    sal.setVisibility(view.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                sal.setText("");
                marks.setText("");
                spinner.setSelection(0);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ch=spinner.getSelectedItem().toString();
                if(ch.equals("Student")){
                    myDatabase.insert(name.getText().toString(),(Integer.parseInt(marks.getText().toString())),1);
                    Toast.makeText(view.getContext(),"Record Added",Toast.LENGTH_SHORT).show();
                    StudentFragment studentFragment=new StudentFragment();
                    FragmentManager fragmentManager= getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.mainActi,studentFragment).addToBackStack("MainFragment").commit();


                }
                else if(ch.equals("Employee")){
                    myDatabase.insert(name.getText().toString(),(Integer.parseInt(sal.getText().toString())),2);
                    Toast.makeText(view.getContext(),"Record Added",Toast.LENGTH_SHORT).show();
                    EmployeeFragment employeeFragment=new EmployeeFragment();
                    FragmentManager fragmentManager= getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.mainActi,employeeFragment).addToBackStack("MainFragment").commit();

                }
                else if(ch.equals("Teacher")){
                    myDatabase.insert(name.getText().toString(),(Integer.parseInt(sal.getText().toString())),3);
                    Toast.makeText(view.getContext(),"Record Added",Toast.LENGTH_SHORT).show();
                    TeacherFragment teacherFragment=new TeacherFragment();
                    FragmentManager fragmentManager= getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.mainActi,teacherFragment).addToBackStack("MainFragment").commit();
                }
            }
        });
        return view;

    }

}
