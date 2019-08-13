package com.example.holidayguide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class LoginPage extends Fragment implements View.OnClickListener {
    private View view;
    private Button btnCreateMan;
    private Button btnCreateWoman;
    private Button btnGetInfoAboutUs;
    private String userId;
    private String categoryId;
    private String categoryType = "weew";
    private String batchId = "weew";
    private TextView textView;
    private TextView textView1;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.login_page, container, false);
        initView();
        initBL();
        return view;
    }

    private void initBL() {

    }

    private void initView() {
        btnCreateMan = view.findViewById(R.id.btn_man_login_page);
        btnCreateWoman = view.findViewById(R.id.btn_woman_login_page);
        btnGetInfoAboutUs = view.findViewById(R.id.btn_get_info_login_page);
        btnCreateMan.setOnClickListener(this);
        btnCreateWoman.setOnClickListener(this);
        btnGetInfoAboutUs.setOnClickListener(this);
        textView = view.findViewById(R.id.tv_login_page);
        textView1 = view.findViewById(R.id.tv_login1_page);
    }

    private void createUser() {
        SessionManager session = new SessionManager(getActivity().getApplicationContext());
        session.createLoginSession(userId, categoryId, categoryType, batchId);
    }

    private void getInfoAboutUser() {
        SessionManager session = new SessionManager(getActivity().getApplicationContext());
        HashMap<String, String> user = session.getUserDetails();
        String userIdInfo = user.get("userId").toString();
        String categoryIdInfo = user.get("catId").toString();
        String categoryTypeInfo = user.get("catType").toString();
        String batchIdInfo = user.get("batchId").toString();

        textView.setText("userId - " + userIdInfo + " catId - " + categoryIdInfo + " catType - "
                + categoryTypeInfo + " batchId - " + batchIdInfo);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_man_login_page:
                userId = "man";
                categoryId = "man_cat";
                textView1.setText("man");
                createUser();
                break;
            case R.id.btn_woman_login_page:
                userId = "woman";
                categoryId = "woman_cat";
                textView1.setText("woman");
                createUser();
                break;
            case R.id.btn_get_info_login_page:
                getInfoAboutUser();
                break;
        }
    }
}
