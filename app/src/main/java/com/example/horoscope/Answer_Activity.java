 package com.example.horoscope;

import static java.lang.Character.toUpperCase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

 public class Answer_Activity extends AppCompatActivity {

    TextView textView,textView1;
     private String string;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_answer);

        textView = findViewById(R.id.answerTextView);
         textView1 = findViewById(R.id.textView1);
        String sunsinename = getIntent().getStringExtra("sunsinename");

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "https://horoscopefree.herokuapp.com/daily/";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonObject = new JSONObject(response.toLowerCase());
                    String data = jsonObject.get(sunsinename.toLowerCase()).toString();
                    char [] charArray = data.toCharArray();
                    for(int i = 0; i < charArray.length-1; i++) {
                        if(charArray[i]=='.')
                        {
                            charArray[i+1] = Character.toUpperCase(charArray[i+1]);
                        }

                    }
                    data = String.valueOf(charArray);
                    String ans=data.replaceAll("\\. ", ".\n\n");
                    
                    Log.i("SNT:",ans);
                    textView.setText(ans);
                    textView1.setText(sunsinename.toUpperCase());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }


 }