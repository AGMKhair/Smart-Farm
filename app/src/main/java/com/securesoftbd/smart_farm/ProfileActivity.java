package com.securesoftbd.smart_farm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.securesoftbd.smart_farm.Adapter.UserAdapter;
import com.securesoftbd.smart_farm.Database.Quary;
import com.securesoftbd.smart_farm.Model.User;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    private Quary quary;
    private RecyclerView recyclerView;
    private TextView user;
    private UserAdapter userAdapter;
    private List<User> userList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        init();
    }

    private void DataShow()
    {
        try {

        this.userList = this.quary.getAllUser();

        }catch (Exception e)
        {

        }

        this.userAdapter = new UserAdapter(this,userList);
        this.recyclerView.setAdapter(this.userAdapter);


    }

    private void init()
    {
        this.recyclerView = findViewById(R.id.allUserShowRecyclerViewId);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.userList = new ArrayList<>();
        this.quary = new Quary(this);

        //this
    }

    @Override
    protected void onStart() {
        super.onStart();
        DataShow();
    }
}
