package com.securesoftbd.smart_farm.Database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "IOT";
    private static final int VERSION = 01;

    public final String TABLE_NAME = "USER";

    public final String ID = "ID";
    public final String AGE = "AGE";
    public final String NAME = "NAME";
    public final String GENDER ="GENDER";
    public final String PROFILE_IMAGE ="PROFILE";


    public final String TABLE_NAME_LINK = "IOTLINK";
    public final String ID_LINK = "ID";
    public final String NAME_LINK ="NAME";
    public final String LINK ="LINK";


    private final String SQL = "CREATE TABLE "+TABLE_NAME+" ("+ID+" INTEGER primary key , "+NAME + " TEXT, "+AGE +" INTEGER ,"
            +PROFILE_IMAGE+" TEXT NOT NULL,"+GENDER+" TEXT  "+");";
    private final String SQL2 = "CREATE TABLE "+TABLE_NAME_LINK+" ("+ID_LINK+" INTEGER ,"+NAME_LINK + " TEXT,  "+LINK + " TEXT "+");";



    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL);
        db.execSQL(SQL2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_LINK);
        onCreate(db);

    }


}