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
        webView = findViewById(R.id.web);

        String html = "<!DOCTYPE html> <html lang=\"en\"> <head> <meta charset=\"UTF-8\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> <title>Document</title> </head> <body> <h1>Hello World!</h1> </body> </html>";

//        webView.loadUrl(html);

        webView.loadData("<html><body><h1><img src=\"https://images.unsplash.com/photo-1575936123452-b67c3203c357?auto=format&fit=crop&q=80&w=1000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8aW1hZ2V8ZW58MHx8MHx8fDA%3D\" width=\"100%\" height=\"50%\"/></h1></body></html>", "text/html", "UTF-8");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());

    }
}