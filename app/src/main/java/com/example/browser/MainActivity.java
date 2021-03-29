package com.example.browser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    TextInputEditText input;
    String url = "";
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.web);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/index.html");
        input = (TextInputEditText) findViewById(R.id.input);
        // From https://stackoverflow.com/questions/1489852/android-handle-enter-in-an-edittext
        input.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    System.out.println("Enter");
                    onEnter(v);
                    return true;
                }
                return false;
            }
        });
    }

    public void onEnter(View v){
        url = input.getText().toString();
        System.out.println(url);
        url = "http://" + url;
        webView.loadUrl(url);
    }

    public void reLoad(View v) {
        webView.loadUrl(url);
    }

    public void previousPage(View v) {
        if (webView.canGoBack()==true) {
            webView.goBack();
        }
    }

    public void nextPage(View v) {
        if (webView.canGoForward()==true){
         webView.goForward();
        }
    }

    public void executeJavascript(View v) {
            webView.evaluateJavascript("javascript:shoutOut()", null);
    }
    public void executeJavascript2(View v) {
        webView.evaluateJavascript("javascript:initialize()", null);
    }
}