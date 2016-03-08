package com.example.deepa.loginhistory;

import android.provider.BaseColumns;

/**
 * Created by Deepa on 3/4/2016.
 */
public class TableData {

    public TableData() {

    }
    //Inner class declaring db,table & column names
    public static abstract class TableInfo implements BaseColumns {

        public static final String DATABASE_NAME = "userInfo.db";
        public static final String TABLE_NAME = "regInfo";
        public static final String COLUMN_USERNAME = "userName";
        public static final String COLUMN_PASSWORD = "pwd";
    }
}
