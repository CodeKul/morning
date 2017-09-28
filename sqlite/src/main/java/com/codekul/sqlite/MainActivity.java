package com.codekul.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private DbHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new DbHelper(
                this,
                "codekul.db",
                null,
                1
        );
    }

    public void onInsert(View view) {

        String table = "codekul";
        String nullColumnHack = null;

        ContentValues values = new ContentValues();
        values.put("nm", getNm());
        values.put("mob", getMob());
        values.put("city", getCity());

        SQLiteDatabase sqDb = helper.getWritableDatabase();
        sqDb.insert(table, nullColumnHack, values);
        sqDb.close();
    }

    public void onUpdate(View view) {

        String table = "codekul";
        String where = "city = ?";
        String[] whereArgs = {getCity()};
        ContentValues values = new ContentValues();
        values.put("nm", getNm());
        values.put("mob", getMob());

        SQLiteDatabase sqDb = helper.getWritableDatabase();
        sqDb.update(table, values, where, whereArgs);
        sqDb.close();
    }

    public void onDelete(View view) {
        String table = "codekul";
        String where = "city = ?";
        String[] whereArgs = {getCity()};

        SQLiteDatabase sqDb = helper.getWritableDatabase();
        sqDb.delete(table, where, whereArgs);
        sqDb.close();
    }

    public void onQuery(View view) {
        selectFew();
    }

    private void selectAll() {
        String table = "codekul";
        String[] columns = null;
        String selection = null;
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;

        SQLiteDatabase sqDb = helper.getReadableDatabase();
        Cursor cursor = sqDb.query(
                table,
                columns,
                selection,
                selectionArgs,
                groupBy,
                having,
                orderBy
        );

        while (cursor.moveToNext()) {
            String nm = cursor.getString(0);
            String mob = cursor.getString(1);
            int city = cursor.getInt(cursor.getColumnIndex("city"));
            Log.i("@codekul", "Name - " + nm + " Mob - " + mob + " City - " + city);
        }
        cursor.close();
        sqDb.close();
    }

    private void selectFew() {
        String table = "codekul";
        String[] columns = {"nm", "mob"};
        String selection = "city = ?";
        String[] selectionArgs = {getCity()};
        String groupBy = null;
        String having = null;
        String orderBy = null;

        SQLiteDatabase sqDb = helper.getReadableDatabase();
        Cursor cursor = sqDb.query(
                table,
                columns,
                selection,
                selectionArgs,
                groupBy,
                having,
                orderBy
        );

        while (cursor.moveToNext()) {
            String nm = cursor.getString(0);
            String mob = cursor.getString(1);
            //int city = cursor.getInt(cursor.getColumnIndex("city"));
            Log.i("@codekul", "Name - " + nm + " Mob - " + mob);
        }
        cursor.close();
        sqDb.close();
    }

    public void onRawQuery(View view) {
        SQLiteDatabase sqDb = helper.getWritableDatabase();
        sqDb.execSQL("insert into codekul values('mouse', '9762548833', 2)");
    }

    private String getNm() {
        return ((EditText) findViewById(R.id.etNm)).getText().toString();
    }

    private String getMob() {
        return ((EditText) findViewById(R.id.etMob)).getText().toString();
    }

    private String getCity() {
        return ((EditText) findViewById(R.id.etCity)).getText().toString();
    }
}
