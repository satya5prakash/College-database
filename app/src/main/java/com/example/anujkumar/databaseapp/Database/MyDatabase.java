package com.example.anujkumar.databaseapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;

import com.example.anujkumar.databaseapp.Helper.MyHelper;

public class MyDatabase {

    public static final String MY_DB="schoolDB";

    Context myCon;
    SQLiteDatabase sdb;
    MyHelper myHelper;

    public MyDatabase(Context myContext) {
        myCon = myContext;
        myHelper = new MyHelper(myCon,MY_DB,null,1);
    }
    //method to insert the values
    public void insert(String ename,int sal,int ch){
        //query to inset the value into the DB
        sdb=myHelper.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put("name",ename);
        cv.put("salary",sal);
        cv.put("categoryDecider",ch);
        sdb.insert("details",null,cv);
    }

    public void search(TextView tv, int ch){
        sdb=myHelper.getWritableDatabase();
        tv.setText("");
        Cursor cs=sdb.rawQuery("select * from details where categoryDecider='"+ch+"'",null);
        while(cs.moveToNext()){
            tv.append(cs.getString(0)+" "+cs.getString(1)+" " +cs.getString(2)+"\n");
        }
    }
}
