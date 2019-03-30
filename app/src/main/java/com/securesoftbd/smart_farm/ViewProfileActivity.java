package com.securesoftbd.smart_farm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.securesoftbd.smart_farm.Adapter.UserLinkAdapter;
import com.securesoftbd.smart_farm.Database.Quary;
import com.securesoftbd.smart_farm.Model.Link;
import com.securesoftbd.smart_farm.Model.User;

import java.util.ArrayList;
import java.util.List;

public class ViewProfileActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Link> linkList=null;
    private UserLinkAdapter linkAdapter;
    private List<User> userList;

    private TextView name,age,gender;
    private Quary quary=null;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);


init();
    }

    private void DataShow() {
        try {
            this.userList = this.quary.getUser(id);
         //   Toast.makeText(this, "linkList.size() 1", Toast.LENGTH_SHORT).show();
            this.linkList = this.quary.getLink(id);
         //   Toast.makeText(this, linkList.size(), Toast.LENGTH_SHORT).show();

        }catch (Exception e)
        {
           // Toast.makeText(this, "Error" +linkList.size(), Toast.LENGTH_SHORT).show();

        }

        name.setText("Name : "+userList.get(0).getName());
        age.setText("Age : "+userList.get(0).getAge());
        gender.setText("Gender : "+userList.get(0).getGenger());

        this.linkAdapter = new UserLinkAdapter(linkList,this);
        this.recyclerView.setAdapter(linkAdapter);
    }


    private void init() {
        id = getIntent().getStringExtra("ID");
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
        this.recyclerView = findViewById(R.id.show_link_recyclerViewId);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        name = findViewById(R.id.show_user_name_id);
        age = findViewById(R.id.show_user_age_id);
        gender = findViewById(R.id.show_user_gender_id);


        this.linkList = new ArrayList<>();
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
