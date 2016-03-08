package com.example.deepa.loginhistory;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.widget.ListView;

import org.w3c.dom.UserDataHandler;

public class ListUsersActivity extends AppCompatActivity {
    ListView myList;
    SQLiteDatabase mysqlitedb;
    DatabaseOperations mydop;
    Context contxt=this;
    private Cursor cur;
    ListDataAdapter myListAdater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);
        displayList();
    }

    public void displayList() {
        myList = (ListView) findViewById(R.id.listViewUsers);
        myListAdater = new ListDataAdapter(this, R.layout.row_layout);
        myList.setAdapter(myListAdater);
        mydop = new DatabaseOperations(getApplicationContext());
        mysqlitedb = mydop.getReadableDatabase();
        cur = mydop.selectOperation(mydop);
        if (cur.moveToFirst()) {
            do {
                String name, passcode;
                name = cur.getString(0);
                passcode = cur.getString(1);
                DataProvider myData = new DataProvider(name, passcode);
                myListAdater.add(myData);

            } while (cur.moveToNext());
        }
    }
}
