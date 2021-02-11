package com.example.learnandroid3.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.Toast;

import com.example.learnandroid3.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpActivity extends AppCompatActivity {
    Button btnReadURL, btnReadImage, btnPostRequest, btnUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
        addControls();
        setEvents();
    }

    public void addControls(){
        btnReadURL = findViewById(R.id.btnReadURL);
        btnReadImage = findViewById(R.id.btnReadImage);
        btnPostRequest = findViewById(R.id.btnPostRequest);
        btnUpload = findViewById(R.id.btnUpload);
    }

    public void setEvents(){
        btnReadURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OkHttpActivity.this, OkHttpReadURLActivity.class);
                startActivity(intent);
            }
        });

        btnReadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OkHttpActivity.this, OkHttpReadImageActivity.class);
                startActivity(intent);
            }
        });

        btnPostRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OkHttpActivity.this, OkHttpPostRequestActivity.class);
                startActivity(intent);
            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 123);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 123 && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();
            String realPath = getRealPathFromURI(uri);
            new Upload().execute(realPath);
        }
    }

    public String getType(String path){
        String extension = MimeTypeMap.getFileExtensionFromUrl(path);
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
    }

    public String getRealPathFromURI (Uri contentUri) {
        String path = null;
        String[] proj = { MediaStore.MediaColumns.DATA };
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            path = cursor.getString(column_index);
        }
        cursor.close();
        return path;
    }

    private class Upload extends AsyncTask<String, Void, String>{
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        @Override
        protected String doInBackground(String... strings) {
            String realPath = strings[0];
            String content_type = getType(realPath);

            RequestBody bodyContent = RequestBody.create(MediaType.parse(content_type), new File(realPath));

            RequestBody bodyTitle = new MultipartBody.Builder()
                    .addFormDataPart("title", realPath.substring(realPath.lastIndexOf("/")+1), bodyContent)
                    .setType(MultipartBody.FORM)
                    .build();

            Request request = new Request.Builder().post(bodyTitle).url("https://6xkhq.sse.codesandbox.io/upload").build();
            try {
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(OkHttpActivity.this, s+"", Toast.LENGTH_SHORT).show();
        }
    }
}