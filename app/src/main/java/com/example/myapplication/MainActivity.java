package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText write_code;
    Button run_btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        write_code = findViewById(R.id.write_code);
        run_btn = findViewById(R.id.run_btn);
        String str = write_code.getText().toString();
        run_btn.setOnClickListener(v -> {
            Intent intent = new Intent(this, OutputActivity.class);
            intent.putExtra("code", str);
            startActivity(intent);
        });

    }
}