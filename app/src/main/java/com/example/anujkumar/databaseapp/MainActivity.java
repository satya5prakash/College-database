package com.example.anujkumar.databaseapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


import com.example.anujkumar.databaseapp.Adapter.ViewAdapter;
import com.example.anujkumar.databaseapp.Fragments.EmployeeFragment;
import com.example.anujkumar.databaseapp.Fragments.MainFragment;
import com.example.anujkumar.databaseapp.Fragments.StudentFragment;
import com.example.anujkumar.databaseapp.Fragments.TeacherFragment;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    private int [] tabIcons={
            R.drawable.ic_start,
            R.drawable.ic_student,
            R.drawable.ic_teacher,
            R.drawable.ic_employee
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Toolbar App");

        ActionBar actionBar=getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

        viewPager=findViewById(R.id.viewPager);
        setUpViewPager(viewPager);

        tabLayout=findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        setUpIcons();


    }
    private void setUpViewPager(ViewPager viewPager) {
        ViewAdapter adapter=new ViewAdapter(getSupportFragmentManager());
        //pass in title to display text under the picture
        adapter.addFragment(new MainFragment(),"");
        adapter.addFragment(new StudentFragment(),"");
        adapter.addFragment(new TeacherFragment(),"");
        adapter.addFragment(new EmployeeFragment(),"");
        viewPager.setAdapter(adapter);

    }

    private void setUpIcons(){
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }
}
