package com.example.learnandroid3.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.example.learnandroid3.R;
import com.example.learnandroid3.adapter.ContactAdapter;
import com.example.learnandroid3.utils.ContactManager;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_CONTACTS, Manifest.permission.READ_CONTACTS}, 122);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(android.os.Build.VERSION.SDK_INT > 22) {
            if (!(requestCode == 123 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                return;
            }
            if (!(requestCode == 111 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                return;
            }
            if (!(requestCode == 122 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                return;
            }
        }

        if(requestCode == 122){
            RecyclerView recyclerView = findViewById(R.id.recyclerViewContact);
            ContactManager contactManager = new ContactManager(this);
            ContactAdapter adapter = new ContactAdapter(contactManager.getData(), this);

            recyclerView.setHasFixedSize(true);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }

        if(requestCode == 123){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+getIntent().getStringExtra("phone")));
                startActivity(intent);
            }
        if (requestCode == 111){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("sms:"+getIntent().getStringExtra("phone")));
                startActivity(intent);
            }
        }
}