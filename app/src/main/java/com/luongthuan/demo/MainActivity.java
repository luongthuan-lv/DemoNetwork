package com.luongthuan.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Thread thread=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i=0;i<1000;i++){
//                    Log.e("count",i+"");
//                }
//            }
//        });
//        thread.start();

//        AsyncTask asyncTask=new AsyncTask() {
//            @Override
//            protected Object doInBackground(Object[] objects) {
//                for (int i=0;i<100000;i++){
//                    Log.e("count",i+"");
//                }
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(Object o) {
//                super.onPostExecute(o);
//                Toast.makeText(MainActivity.this,"Counted",Toast.LENGTH_SHORT).show();
//            }
//        };
//        asyncTask.execute();
        progressBar = findViewById(R.id.progressBar);
        button=findViewById(R.id.button);
        progressBar.setMax(21);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Loader loader = new Loader(progressBar);
                loader.execute("https://vnexpress.net");
            }
        });


    }
}