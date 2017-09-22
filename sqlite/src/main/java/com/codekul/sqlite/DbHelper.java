package com.codekul.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by aniruddha on 22/9/17.
 */

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(
            Context context,
            String name,
            SQLiteDatabase.CursorFactory factory,
            int version
    ) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqDb) {
        sqDb.execSQL("create table codekul(nm text, mob text, city number)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVer, int newVer) {

    }
}
