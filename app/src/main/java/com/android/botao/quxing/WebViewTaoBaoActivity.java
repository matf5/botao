package com.android.botao.quxing;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.android.botao.R;

/**
 * Created by Administrator on 2016/4/25.
 */
public class WebViewTaoBaoActivity extends Activity {
    private WebView webView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taobao_webview);










        final Activity activity = this;
        webView = (WebView) findViewById(R.id.webview);
        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                // Activities and WebViews measure progress with different scales.
                // The progress meter will automatically disappear when we reach 100%
                activity.setProgress(progress * 1000);
            }
        });
        webView.setWebViewClient(new WebViewClient() {
            // 获取cookie
            @Override
            public void onPageFinished(WebView view, String url) {
                CookieManager cookieManager = CookieManager.getInstance();
                String CookieStr = cookieManager.getCookie(url);
                Log.e("HEHE", "Cookies = " + CookieStr);
                super.onPageFinished(view, url);
            }

        });
        webView.getSettings().setJavaScriptEnabled(true);
        // 设置渲染优先级，加速渲染
//        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        // 先加载页面在加载图片
        webView.getSettings().setLoadsImagesAutomatically(true);

//        // 设置cookie，但是cookie不知道从哪来的，暂时注释
//        CookieSyncManager.createInstance(WebView.this);
//        CookieManager cookieManager = CookieManager.getInstance();
//        cookieManager.setAcceptCookie(true);
//        cookieManager.setCookie(url, cookies);  //cookies是要设置的cookie字符串
//        CookieSyncManager.getInstance().sync();

        webView.loadUrl("file:///android_asset/index.html");

        //点赞设置


    }

}