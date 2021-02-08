package com.example.learnandroid3.utils;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    private Context context;

    public ContactManager(Context context){
        this.context = context;
    };

    public ArrayList<Contact> getData(){
        ArrayList<Contact> list = new ArrayList<>();

        String[] fields = new String[]{
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone.PHOTO_URI
        };

        Cursor cursor =  context.getContentResolver()
                .query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        fields, null, null, null);

        int nameIndex = cursor.getColumnIndex(fields[0]);
        int numberIndex = cursor.getColumnIndex(fields[1]);
        int imgIndex = cursor.getColumnIndex(fields[2]);

        cursor.moveToFirst();
        while(cursor.moveToNext()){
            String name = cursor.getString(nameIndex);
            String number = cursor.getString(numberIndex);
            String photoUri = cursor.getString(imgIndex);
            Bitmap photo;
            if(photoUri != null){
                try {
                    photo = MediaStore.Images.Media.getBitmap(context.getContentResolver(), Uri.parse(photoUri));
                } catch (IOException e) {
                    e.printStackTrace();
                    photo = null;
                }
            }else photo = null;
            list.add(new Contact(name, number, photo));
        }

        return list;
    }
}
