package com.example.learnandroid3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.learnandroid3.R;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpReadImageActivity extends AppCompatActivity {
    EditText editImage;
    Button btnImage;
    ImageView imgShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http_read_image);
        editImage = findViewById(R.id.editImage);
        btnImage = findViewById(R.id.btnGetImage);
        imgShow = findViewById(R.id.imgShow);

        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ReadImage().execute(editImage.getText().toString());
            }
        });
    }

    private class ReadImage extends AsyncTask<String, Void, byte[]> {

        @Override
        protected byte[] doInBackground(String... strings) {
            OkHttpClient builder = new OkHttpClient.Builder()
                    .build();
            Request request = new Request.Builder().url(strings[0]).build();
            Response response = null;
            try {
                response = builder.newCall(request).execute();
                return response.body().bytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(byte[] bytes) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            imgShow.setImageBitmap(bitmap);
            super.onPostExecute(bytes);
        }
    }
}