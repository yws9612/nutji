package org.techtown.dontlate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class addressSearch extends AppCompatActivity {
    private WebView daum_webView;
    private TextView daum_result;
    String DORO;

    private Handler handler;

    private TextView address;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addresssearch);

        daum_result = (TextView) findViewById(R.id.daum_result);
        address = (TextView) findViewById(R.id.Address);

        // WebView 초기화
        init_webView();

        // 핸들러를 통한 JavaScript 이벤트 반응
        handler = new Handler();

    }


    public void init_webView() {

        // WebView 설정
        daum_webView = (WebView) findViewById(R.id.daum_webview);

        // JavaScript 허용
        daum_webView.getSettings().setJavaScriptEnabled(true);

        // JavaScript의 window.open 허용
        daum_webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        // JavaScript이벤트에 대응할 함수를 정의 한 클래스를 붙여줌
        daum_webView.addJavascriptInterface(new AndroidBridge(), "TestApp");

        // web client 를 chrome 으로 설정
        daum_webView.setWebChromeClient(new WebChromeClient());

        // webview url load. php 파일 주소
        daum_webView.loadUrl("http://10.0.2.2:8000/2B/1906050/doro.php");

    }


    private class AndroidBridge {

        @JavascriptInterface
        public void setAddress(final String arg1, final String arg2, final String arg3) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    DORO = String.format("%s %s", arg2, arg3);
                    daum_result.setText(DORO);

                    Intent result = new Intent();
                    result.putExtra("data", DORO);
                    setResult(RESULT_OK, result);

                    // WebView를 초기화 하지않으면 재사용할 수 없음
                    init_webView();
                    finish();
                }

            });
        }
    }
}
