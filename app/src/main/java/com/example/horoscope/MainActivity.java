package com.example.horoscope;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {


    private List<Horoscope> horoscopeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        prepareView();

    }

    void prepareView()
    {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        ImageView imageView = findViewById(R.id.imageView);

        Adapter adapter = new Adapter(horoscopeList,this);
        RecyclerView.LayoutManager manager = new GridLayoutManager(getApplicationContext(),1);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        String ssarray[] = {"taurus","gemini","cancer","leo","virgo","libra","scorpio","sagittarius","capricorn","aquarius","pisces"};

        Horoscope horoscope = new Horoscope("ARIES","aries",imageView);
        horoscopeList.add(horoscope);

        for(String ss:ssarray)
        {
            horoscope = new Horoscope(ss.toUpperCase(),ss.toLowerCase(),imageView);
            horoscopeList.add(horoscope);
        }

    }
}
