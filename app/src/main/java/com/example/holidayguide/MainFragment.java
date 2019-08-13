package com.example.holidayguide;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

@SuppressLint("ValidFragment")
class MainFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "CardListActivity";
    private CardArrayAdapter cardArrayAdapter;
    private ListView listView;
    private View view;
    private Button btnLogin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        initView();
        return view;
    }


    private void initView() {
        btnLogin = view.findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        listView = (ListView) view.findViewById(R.id.card_listView);

        listView.addHeaderView(new View(getContext()));
        listView.addFooterView(new View(getContext()));

        cardArrayAdapter = new CardArrayAdapter(getActivity().getApplicationContext(), R.layout.item_view_main_page);

        for (int i = 0; i < 10; i++) {
            Card card = new Card("Card " + (i + 1) + " Line 1", "Card " + (i + 1) + " Line 2");
            cardArrayAdapter.add(card);
        }
        listView.setAdapter(cardArrayAdapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

          case R.id.btn_login:
                LoginPage loginPage = new LoginPage();
                FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                fragmentTransaction1.replace(R.id.flMainActivity, loginPage, "timeForReservation");
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
                break;


        }

    }
}