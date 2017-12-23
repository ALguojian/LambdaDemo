package com.alguojian.lambda;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected Button button;
    protected Button button2;
    protected Button button3;
    protected Button button4;
    protected Button button5;
    protected Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
        init();
    }


    @TargetApi(Build.VERSION_CODES.N)
    private void init() {

        button.setOnClickListener(view -> System.out.println("asd"));

        List<String> strings = new ArrayList<>();

        strings.add("asd");
        strings.add("asd");
        strings.add("asd");
        strings.add("asd");
        strings.add("asd");
        strings.add("asd");
        strings.add("asd");

        button2.setOnClickListener(v -> strings.forEach(n -> System.out.println(n)));



    }

    private void initView() {
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
    }
}
