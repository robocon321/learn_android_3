package com.example.learnandroid3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.learnandroid3.R;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpReadURLActivity extends AppCompatActivity {
    EditText editUrl;
    Button btnGet;
    TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http_read_u_r_l);
        addControls();
        setEvents();
    }

    public void addControls() {
        editUrl = findViewById(R.id.editUrl);
        btnGet = findViewById(R.id.btnGetData);
        txtShow = findViewById(R.id.txtShowData);
    }

    public void setEvents() {
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetData().execute(editUrl.getText().toString());
            }
        });
    }

    private class GetData extends AsyncTask<String, Void, String>{
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .writeTimeout(5000, TimeUnit.MILLISECONDS)
                .build();

        @Override
        protected String doInBackground(String... strings) {
            Request request = new Request.Builder().url(strings[0]).build();
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
            txtShow.setText(s);
            super.onPostExecute(s);
        }
    }
}