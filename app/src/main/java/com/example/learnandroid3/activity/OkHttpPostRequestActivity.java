package com.example.learnandroid3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.learnandroid3.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpPostRequestActivity extends AppCompatActivity {
    Button btnLogin;
    EditText editUname, editPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http_post_request);
        btnLogin = findViewById(R.id.btnLogin);
        editUname = findViewById(R.id.editUname);
        editPwd = findViewById(R.id.editPwd);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostRequest().execute("hhhh");
            }
        });
    }

    private class PostRequest extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

            String uname = editUname.getText().toString();
            String pwd = editPwd.getText().toString();

            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("uname", uname);
                jsonObject.put("pwd",pwd);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            MediaType JSON = MediaType.get("application/json; charset=utf-8");

            RequestBody body = RequestBody.create(JSON, jsonObject.toString());

            Request request = new Request.Builder().url("https://6xkhq.sse.codesandbox.io/").post(body).build();
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
            Toast.makeText(OkHttpPostRequestActivity.this, s+"", Toast.LENGTH_SHORT).show();
            super.onPostExecute(s);
        }
    }
}