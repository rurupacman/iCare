package com.example.subss.icare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SubSs on 1/15/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "userDatabase.db";
    private static final String TABLE_NAME = "profileTable";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_CPASSWORD = "cpassword";

    private static final String TABLE_CREATE = "CREATE TABLE"+ TABLE_NAME+ "( "+COLUMN_ID +" INTEGER PRIMARY KEY , "
            + COLUMN_USERNAME +" TEXT,"+ COLUMN_NAME+" TEXT,"+COLUMN_EMAIL+" TEXT,"+COLUMN_PASSWORD+" TEXT,"+COLUMN_CPASSWORD+" TEXT )";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.db = db;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }
    public void  insertContact(ContactClass contactClass){
        db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        String query = "select * from"+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);

        int count = cursor.getCount();

        contentValues.put(COLUMN_ID,count);
        contentValues.put(COLUMN_USERNAME,contactClass.getUsername());
        contentValues.put(COLUMN_NAME,contactClass.getName());
        contentValues.put(COLUMN_EMAIL,contactClass.getEmail());
        contentValues.put(COLUMN_PASSWORD, contactClass.getPassword());

        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public String searchPassword(String username){

        String userName,password;
        password = "Not found";
        db = this.getReadableDatabase();
        String query = "select username, password from"+ TABLE_NAME ;
        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                userName = cursor.getString(0);

                if(userName.equals(username)){
                    password = cursor.getString(1);
                    break;
                }

            }while (cursor.moveToNext());

        }
        return password;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST"+ TABLE_NAME);
        onCreate(db);



    }
}
