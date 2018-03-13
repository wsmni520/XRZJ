package com.xrzj.decoration.widget;

/**
 * @author: zhoufu
 * @date: On 2018/3/13
 */

import android.content.Context;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Map;

public class ScrollWebView extends WebView {
    private boolean mTouchByUser;
    private ScrollWebView.OnScrollWebListener onScrollWebListener;

    public ScrollWebView(Context context) {
        super(context);
    }

    public ScrollWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ScrollWebView.OnScrollWebListener getOnScrollWebListener() {
        return this.onScrollWebListener;
    }

    public void setScrollWebListener(ScrollWebView.OnScrollWebListener onScrollWebListener) {
        this.onScrollWebListener = onScrollWebListener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(this.onScrollWebListener != null) {
            this.onScrollWebListener.onScroll(l - oldl, t - oldt);
        }

    }

    @Override
    public final void loadUrl(String url, Map<String, String> additionalHttpHeaders) {
        super.loadUrl(url, additionalHttpHeaders);
        this.resetAllStateInternal(url);
    }

    @Override
    public void loadUrl(String url) {
        super.loadUrl(url);
        this.resetAllStateInternal(url);
    }

    @Override
    public final void postUrl(String url, byte[] postData) {
        super.postUrl(url, postData);
        this.resetAllStateInternal(url);
    }

    @Override
    public final void loadData(String data, String mimeType, String encoding) {
        super.loadData(data, mimeType, encoding);
        this.resetAllStateInternal(this.getUrl());
    }

    @Override
    public final void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        super.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
        this.resetAllStateInternal(this.getUrl());
    }

    @Override
    public void reload() {
        super.reload();
        this.resetAllStateInternal(this.getUrl());
    }

    public boolean isTouchByUser() {
        return this.mTouchByUser;
    }

    private void resetAllStateInternal(String url) {
        if(TextUtils.isEmpty(url) || !url.startsWith("javascript:")) {
            this.resetAllState();
        }
    }

    protected void resetAllState() {
        this.mTouchByUser = false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()) {
            case 0:
                this.mTouchByUser = true;
            default:
                return super.onTouchEvent(event);
        }
    }

    @Override
    public void setWebViewClient(final WebViewClient client) {
        super.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                boolean handleByChild = null != client && client.shouldOverrideUrlLoading(view, url);
                if(handleByChild) {
                    return true;
                } else if(!ScrollWebView.this.isTouchByUser()) {
                    return super.shouldOverrideUrlLoading(view, url);
                } else {
                    ScrollWebView.this.loadUrl(url);
                    return true;
                }
            }

            @RequiresApi(
                    api = 24
            )
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                boolean handleByChild = null != client && client.shouldOverrideUrlLoading(view, request);
                if(handleByChild) {
                    return true;
                } else if(!ScrollWebView.this.isTouchByUser()) {
                    return super.shouldOverrideUrlLoading(view, request);
                } else {
                    ScrollWebView.this.loadUrl(request.getUrl().toString());
                    return true;
                }
            }
        });
    }

    public interface OnScrollWebListener {
        void onScroll(int var1, int var2);
    }
}