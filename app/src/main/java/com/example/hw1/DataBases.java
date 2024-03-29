package com.example.hw1;

import android.provider.BaseColumns;

public final class DataBases {
    public static final class CreateDB implements BaseColumns {
        public static final String USERID = "userid";
        public static final String PASS = "pass";
        public static final String NAME = "name";
        public static final String PHONE = "phone";
        public static final String ADDRESS = "address";

        public static final String _TABLENAME0 = "usertable";

        public static final String _CREATE0 = "create table if not exists "+_TABLENAME0+"("
                +_ID+" integer primary key autoincrement, "
                +USERID+" text not null UNIQUE, "
                +PASS+" text not null , "
                +NAME+" text not null , "
                +PHONE+" text not null , "
                +ADDRESS+" text not null );";
    }


}
