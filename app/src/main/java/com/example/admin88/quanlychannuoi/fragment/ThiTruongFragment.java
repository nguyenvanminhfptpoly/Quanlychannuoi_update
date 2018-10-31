package com.example.admin88.quanlychannuoi.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.admin88.quanlychannuoi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThiTruongFragment extends Fragment {
private WebView webView;

    public ThiTruongFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_thi_truong, container, false);
        webView = v.findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://anvietfood.com.vn/");

    return  v;
    }


}
