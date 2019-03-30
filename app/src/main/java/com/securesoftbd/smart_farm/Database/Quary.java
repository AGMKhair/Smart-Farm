package com.securesoftbd.smart_farm.Database;

import android.content.Context;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.securesoftbd.smart_farm.Model.Link;
import com.securesoftbd.smart_farm.Model.User;

import java.util.ArrayList;
import java.util.List;

public class Quary
        extends DBHelper
{
    private SQLiteDatabase readSqLiteDatabase = getReadableDatabase();
    private SQLiteDatabase sqLiteDatabase = getWritableDatabase();

    public Quary(Context paramContext)
    {
        super(paramContext);
    }

    public String InsertData(User paramUser)
    {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put(NAME, paramUser.getName());
        localContentValues.put(AGE, paramUser.getAge());
        localContentValues.put(GENDER, paramUser.getGenger());
        localContentValues.put(PROFILE_IMAGE, paramUser.getProfileImage());

        if (this.sqLiteDatabase.insert(TABLE_NAME, null, localContentValues) > -1) {
            return "databse insert ";
        }
        return " inseted Error ";
    }

    public String InsertLinkData(Link paramUser)
    {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put(ID_LINK, paramUser.getId());
        localContentValues.put(NAME_LINK, paramUser.getName());
        localContentValues.put(LINK, paramUser.getLink());

        if (this.sqLiteDatabase.insert(TABLE_NAME_LINK, null, localContentValues) > -1) {
            return "databse insert ";
        }
        return " inseted Error ";
    }


    public void UpdateData(User paramUser)
    {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("NAME", paramUser.getName());
        localContentValues.put("AGE", paramUser.getAge());
       // localContentValues.put("GENDER", paramUser.getGenger());

       // localContentValues.put("PROFILE", paramUser.getProfileImage());
        if (this.sqLiteDatabase.update("USER", localContentValues, "ID = ?", new String[] { paramUser.getId() }) > -1)
        {
            System.out.println("database Update ");
            return;
        }
        System.out.println(" Update Error ");
    }

    public List<User> getAllUser()
    {

        List<User> users = null;// = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;


        //SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = readSqLiteDatabase.rawQuery(selectQuery, null);

        //System.out.println(doctorList);


        // System.out.println(" cursor have data " );

        if (cursor.moveToFirst()) {
            users = new ArrayList<>();

            do {

                String userId = cursor.getString(cursor.getColumnIndex(ID));
                String userName = cursor.getString(cursor.getColumnIndex(NAME));
                String userAge = cursor.getString(cursor.getColumnIndex(AGE));
                String userProfile = cursor.getString(cursor.getColumnIndex(PROFILE_IMAGE));
                String userGender = cursor.getString(cursor.getColumnIndex(GENDER));

                //Donor donor = new Donor(donorId, donorName, donorAge, donorProfile, donorBloodGroup, donorContractNumber, donorLastDonateDate, donorAddress);
                User user = new User(userId,userName,userAge,userProfile,userGender);

                users.add(user);


                //Doctor doctor = new Doctor(doctorId, doctorName, doctorDetails, doctorAppoinmentDate, doctorPhone, doctorEmail, doctorImage);
                //doctorList.add(doctor);

            } while (cursor.moveToNext());

        }

        return users;
    }



  public String getUserLastId()
    {

        List<User> users = null;// = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;


        //SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = readSqLiteDatabase.rawQuery(selectQuery, null);

        //System.out.println(doctorList);


        // System.out.println(" cursor have data " );
        String userId=null;


        if (cursor.moveToLast()) {
             userId = cursor.getString(cursor.getColumnIndex(ID));
        }

        return userId;
    }


    public List<User> getUser(String id)
    {
        List<User> localArrayList = new ArrayList();

        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + " = '" + id + "'";


        Cursor cursor =  this.readSqLiteDatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do
            {
                //String id = cursor.getString(cursor.getColumnIndex("ID"));
                String name = cursor.getString(cursor.getColumnIndex("NAME"));
                String age = cursor.getString(cursor.getColumnIndex("AGE"));
                String profile = cursor.getString(cursor.getColumnIndex("PROFILE"));
                String gender = cursor.getString(cursor.getColumnIndex("GENDER"));
                localArrayList.add(new User(name, age,  profile, gender));
            } while (cursor.moveToNext());
        }
        return localArrayList;
    }




    public List<Link> getLink(String id)
    {
        List<Link> localArrayList = new ArrayList();

        String selectQuery = "SELECT * FROM " + TABLE_NAME_LINK + " WHERE " + ID + " = '" + id + "'";


        Log.d("TAG", "getLink: 0");
        Cursor cursor =  this.readSqLiteDatabase.rawQuery(selectQuery, null);
        Log.d("TAG", "getLink: 0:1");

        if (cursor.moveToFirst()) {
            Log.d("TAG", "getLink: 1");
            do
            {
                String name = cursor.getString(cursor.getColumnIndex("NAME"));
                String link = cursor.getString(cursor.getColumnIndex("LINK"));
 /*               String profile = cursor.getString(cursor.getColumnIndex("PROFILE"));
                String gender = cursor.getString(cursor.getColumnIndex("AGE"));*/
                Log.d("TAG", "getLink: "+name+"  link :" +link);
                localArrayList.add(new Link(name,link));
            } while (cursor.moveToNext());
        }
        Log.d("TAG", "getLink: 3");
        return localArrayList;
    }

    public Integer deleteData(String  id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "ID = ?",new String[] {id});
        return db.delete(TABLE_NAME_LINK, "ID = ?",new String[] {id});
    }

}