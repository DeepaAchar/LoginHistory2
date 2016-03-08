package com.example.deepa.loginhistory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Deepa on 3/4/2016.
 */
public class DatabaseOperations extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;

    public SQLiteDatabase mydb;
    public String stmt="CREATE TABLE "+ TableData.TableInfo.TABLE_NAME+
            " ("+TableData.TableInfo.COLUMN_USERNAME+" TEXT,"+
            TableData.TableInfo.COLUMN_PASSWORD+" TEXT);";

    //Constfructor
    public DatabaseOperations(Context context) {
        super(context, TableData.TableInfo.DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("db:", "db is created!");
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {

        sdb.execSQL(stmt);
        Log.d("Table:","Table is created!");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sdb, int oldVersion, int newVersion) {

    }


    public void insertOperation(DatabaseOperations dop,String name,String passwd){

        mydb=dop.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(TableData.TableInfo.COLUMN_USERNAME,name);
        cv.put(TableData.TableInfo.COLUMN_PASSWORD,passwd);
        mydb.insert(TableData.TableInfo.TABLE_NAME, null, cv);
        Log.d("Row:","A row is inserted!");

    }

    public Cursor selectOperation(DatabaseOperations dop){
        mydb=dop.getReadableDatabase();
        String[] col={TableData.TableInfo.COLUMN_USERNAME, TableData.TableInfo.COLUMN_PASSWORD};
        Cursor cur=mydb.query(TableData.TableInfo.TABLE_NAME,col,null,null,null,null, TableData.TableInfo.COLUMN_USERNAME);
        return cur;
    }
}
