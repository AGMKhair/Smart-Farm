package com.securesoftbd.smart_farm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.securesoftbd.smart_farm.Database.Quary;
import com.securesoftbd.smart_farm.Model.Link;
import com.securesoftbd.smart_farm.Model.User;

public class AddProfileActivity extends AppCompatActivity {

    private RadioGroup radioSexGroup,radioLinkGroup;
    private RadioButton radioSexButton,radioLinkButton;
    private Button submitBtn;
    private Quary quary=null;
    private int LinkID;
    private String userLastId=null;

    private EditText userName,age,gender;
    private EditText linkName1,linkName2,linkName3,linkName4,linkName5,linkName6;
    private EditText url1,url2,url3,url4,url5,url6;
    private LinearLayout layout1,layout2,layout3,layout4,layout5,layout6;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profile);
        
        init();
        onClick();
    }

    private void onClick()
    {
        radioLinkGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
          //      Toast.makeText(AddProfileActivity.this, String.valueOf(checkedId), Toast.LENGTH_SHORT).show();


                int selectedLinkId = radioLinkGroup.getCheckedRadioButtonId();

                radioLinkButton = (RadioButton) findViewById(selectedLinkId);


                if(radioLinkButton.getText().toString().equals("2"))
                {

                    layout1.setVisibility(View.VISIBLE);
                    layout2.setVisibility(View.VISIBLE);
                    layout3.setVisibility(View.GONE);
                    layout4.setVisibility(View.GONE);
                    layout5.setVisibility(View.GONE);
                    layout6.setVisibility(View.GONE);

                 /*   linkName2.setVisibility(View.VISIBLE);
                    linkName3.setVisibility(View.GONE);
                    linkName4.setVisibility(View.GONE);
                    linkName5.setVisibility(View.GONE);
                    linkName6.setVisibility(View.GONE);

                    url2.setVisibility(View.VISIBLE);
                    url3.setVisibility(View.GONE);
                    url4.setVisibility(View.GONE);
                    url5.setVisibility(View.GONE);
                    url6.setVisibility(View.GONE);*/

                }
                else if (radioLinkButton.getText().toString().equals("3") )
                {

                    layout1.setVisibility(View.VISIBLE);
                    layout2.setVisibility(View.VISIBLE);
                    layout3.setVisibility(View.VISIBLE);
                    layout4.setVisibility(View.GONE);
                    layout5.setVisibility(View.GONE);
                    layout6.setVisibility(View.GONE);

                    /*            linkName2.setVisibility(View.VISIBLE);
                    linkName3.setVisibility(View.VISIBLE);
                    linkName4.setVisibility(View.GONE);
                    linkName5.setVisibility(View.GONE);
                    linkName6.setVisibility(View.GONE);

                    url2.setVisibility(View.VISIBLE);
                    url3.setVisibility(View.VISIBLE);
                    url4.setVisibility(View.GONE);
                    url5.setVisibility(View.GONE);
                    url6.setVisibility(View.GONE);*/
                }
                else if (radioLinkButton.getText().toString().equals("4"))
                {
                    layout1.setVisibility(View.VISIBLE);
                    layout2.setVisibility(View.VISIBLE);
                    layout3.setVisibility(View.VISIBLE);
                    layout4.setVisibility(View.VISIBLE);
                    layout5.setVisibility(View.GONE);
                    layout6.setVisibility(View.GONE);
                  /*  linkName2.setVisibility(View.VISIBLE);
                    linkName3.setVisibility(View.VISIBLE);
                    linkName4.setVisibility(View.VISIBLE);
                    linkName5.setVisibility(View.GONE);
                    linkName6.setVisibility(View.GONE);

                    url2.setVisibility(View.VISIBLE);
                    url3.setVisibility(View.VISIBLE);
                    url4.setVisibility(View.VISIBLE);
                    url5.setVisibility(View.GONE);
                    url6.setVisibility(View.GONE);*/
                }
                else if (radioLinkButton.getText().toString().equals("5"))
                {

                    layout1.setVisibility(View.VISIBLE);
                    layout2.setVisibility(View.VISIBLE);
                    layout3.setVisibility(View.VISIBLE);
                    layout4.setVisibility(View.VISIBLE);
                    layout5.setVisibility(View.VISIBLE);
                    layout6.setVisibility(View.GONE);

            /*        linkName2.setVisibility(View.VISIBLE);
                    linkName3.setVisibility(View.VISIBLE);
                    linkName4.setVisibility(View.VISIBLE);
                    linkName5.setVisibility(View.VISIBLE);
                    linkName6.setVisibility(View.GONE);

                    url2.setVisibility(View.VISIBLE);
                    url3.setVisibility(View.VISIBLE);
                    url4.setVisibility(View.VISIBLE);
                    url5.setVisibility(View.VISIBLE);
                    url6.setVisibility(View.GONE);*/
                }
                else if (radioLinkButton.getText().toString().equals("6"))
                {


                    layout1.setVisibility(View.VISIBLE);
                    layout2.setVisibility(View.VISIBLE);
                    layout3.setVisibility(View.VISIBLE);
                    layout4.setVisibility(View.VISIBLE);
                    layout5.setVisibility(View.VISIBLE);
                    layout6.setVisibility(View.VISIBLE);
                    /*             linkName2.setVisibility(View.VISIBLE);
                    linkName3.setVisibility(View.VISIBLE);
                    linkName4.setVisibility(View.VISIBLE);
                    linkName5.setVisibility(View.VISIBLE);
                    linkName6.setVisibility(View.VISIBLE);

                    url2.setVisibility(View.VISIBLE);
                    url3.setVisibility(View.VISIBLE);
                    url4.setVisibility(View.VISIBLE);
                    url5.setVisibility(View.VISIBLE);
                    url6.setVisibility(View.VISIBLE);*/
                }
                else
                {
                    Toast.makeText(AddProfileActivity.this, "Else", Toast.LENGTH_SHORT).show();
/*                    linkName2.setVisibility(View.GONE);
                    linkName3.setVisibility(View.GONE);
                    linkName4.setVisibility(View.GONE);
                    linkName5.setVisibility(View.GONE);
                    linkName6.setVisibility(View.GONE);

                    url2.setVisibility(View.GONE);
                    url3.setVisibility(View.GONE);
                    url4.setVisibility(View.GONE);
                    url5.setVisibility(View.GONE);
                    url6.setVisibility(View.GONE);*/
                    layout2.setVisibility(View.GONE);
                    layout3.setVisibility(View.GONE);
                    layout4.setVisibility(View.GONE);
                    layout5.setVisibility(View.GONE);
                    layout6.setVisibility(View.GONE);

                }
            }
        });


        submitBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                int selectedLinkId = radioLinkGroup.getCheckedRadioButtonId();
                int selectedGenderId = radioSexGroup.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                radioSexButton = (RadioButton) findViewById(selectedGenderId);
                radioLinkButton = (RadioButton) findViewById(selectedLinkId);
              /*  Toast.makeText(AddProfileActivity.this,
                        radioSexButton.getText()+" link : "+radioLinkButton.getText(), Toast.LENGTH_SHORT).show();*/

                String username, userAge;
                username = userName.getText().toString();
                userAge = age.getText().toString();


                if (username.isEmpty()) {
                    userName.setError("Fill Up");
                } else if (userAge.isEmpty()) {
                    age.setError("Fill up");
                } else {


                    String name1 = linkName1.getText().toString();
                    String name2 = linkName2.getText().toString();
                    String name3 = linkName3.getText().toString();
                    String name4 = linkName4.getText().toString();
                    String name5 = linkName5.getText().toString();
                    String name6 = linkName6.getText().toString();

                    String urllink1 = url1.getText().toString();
                    String urllink2 = url2.getText().toString();
                    String urllink3 = url3.getText().toString();
                    String urllink4 = url4.getText().toString();
                    String urllink5 = url5.getText().toString();
                    String urllink6 = url6.getText().toString();


                    if (radioLinkButton.getText().toString().equals("1")) {
                        if (name1.isEmpty() || urllink1.isEmpty()) {


                            Toast.makeText(AddProfileActivity.this, "Please fill up the empty filed ", Toast.LENGTH_SHORT).show();
                        } else {

                            userDataInsert(username,userAge,"image",radioSexButton.getText().toString());
                            Link link = new Link(userLastId, name1, urllink1);
                            String s = quary.InsertLinkData(link);

                            Toast.makeText(AddProfileActivity.this, "Save data ", Toast.LENGTH_SHORT).show();

                        }

                    } else if (radioLinkButton.getText().toString().equals("2")) {
                        if (name1.isEmpty() || name2.isEmpty() || urllink1.isEmpty() || urllink2.isEmpty()) {
                            Toast.makeText(AddProfileActivity.this, "Please fill up the empty filed ", Toast.LENGTH_SHORT).show();

                        } else {


                            userDataInsert(username,userAge,"image",radioSexButton.getText().toString());
                            Link link = new Link(userLastId, name1, urllink1);
                            quary.InsertLinkData(link);
                            Link link2 = new Link(userLastId, name2, urllink2);
                            quary.InsertLinkData(link2);

                            Toast.makeText(AddProfileActivity.this, "Save data ", Toast.LENGTH_SHORT).show();
                        }

                    } else if (radioLinkButton.getText().toString().equals("3")) {
                        if (name1.isEmpty() || name2.isEmpty() || name3.isEmpty() || urllink1.isEmpty() || urllink2.isEmpty() || urllink3.isEmpty()) {

                            Toast.makeText(AddProfileActivity.this, "Please fill up the empty filed ", Toast.LENGTH_SHORT).show();

                        } else {

                            userDataInsert(username,userAge,"image",radioSexButton.getText().toString());
                            Link link = new Link(userLastId, name1, urllink1);
                            quary.InsertLinkData(link);
                            Link link2 = new Link(userLastId, name2, urllink2);
                            quary.InsertLinkData(link2);
                            Link link3 = new Link(userLastId, name3, urllink3);
                            quary.InsertLinkData(link3);

                            Toast.makeText(AddProfileActivity.this, "Save data ", Toast.LENGTH_SHORT).show();
                        }
                    } else if (radioLinkButton.getText().toString().equals("4")) {
                        if (name1.isEmpty() || name2.isEmpty() || name3.isEmpty() || name4.isEmpty() || urllink1.isEmpty() || urllink2.isEmpty() || urllink3.isEmpty() || urllink4.isEmpty()) {


                            Toast.makeText(AddProfileActivity.this, "Please fill up the empty filed ", Toast.LENGTH_SHORT).show();

                        } else {


                            userDataInsert(username,userAge,"image",radioSexButton.getText().toString());
                            Link link = new Link(userLastId, name1, urllink1);
                            quary.InsertLinkData(link);
                            Link link2 = new Link(userLastId, name2, urllink2);
                            quary.InsertLinkData(link2);
                            Link link3 = new Link(userLastId, name3, urllink3);
                            quary.InsertLinkData(link3);
                            Link link4 = new Link(userLastId, name4, urllink4);
                            quary.InsertLinkData(link4);

                            Toast.makeText(AddProfileActivity.this, "Save data ", Toast.LENGTH_SHORT).show();
                        }
                    } else if (radioLinkButton.getText().toString().equals("5")) {
                        if (name1.isEmpty() || name2.isEmpty() || name3.isEmpty() || name4.isEmpty() || name5.isEmpty() || urllink1.isEmpty() || urllink2.isEmpty() || urllink3.isEmpty() || urllink4.isEmpty() || urllink5.isEmpty()) {
                            Toast.makeText(AddProfileActivity.this, "Please fill up the empty filed ", Toast.LENGTH_SHORT).show();

                        } else {


                            userDataInsert(username,userAge,"image",radioSexButton.getText().toString());
                            Link link = new Link(userLastId, name1, urllink1);
                            quary.InsertLinkData(link);
                            Link link2 = new Link(userLastId, name2, urllink2);
                            quary.InsertLinkData(link2);
                            Link link3 = new Link(userLastId, name3, urllink3);
                            quary.InsertLinkData(link3);
                            Link link4 = new Link(userLastId, name4, urllink4);
                            quary.InsertLinkData(link4);
                            Link link5 = new Link(userLastId, name5, urllink5);
                            quary.InsertLinkData(link5);

                            Toast.makeText(AddProfileActivity.this, "Save data ", Toast.LENGTH_SHORT).show();
                        }
                    } else if (radioLinkButton.getText().toString().equals("6")) {
                        if (name1.isEmpty() || name2.isEmpty() || name3.isEmpty() || name4.isEmpty() || name5.isEmpty() || name6.isEmpty() || urllink1.isEmpty() || urllink2.isEmpty() || urllink3.isEmpty() || urllink4.isEmpty() || urllink5.isEmpty() || urllink6.isEmpty()) {
                            Toast.makeText(AddProfileActivity.this, "Please fill up the empty filed ", Toast.LENGTH_SHORT).show();

                        } else {
                            userDataInsert(username,userAge,"image",radioSexButton.getText().toString());
                            Link link = new Link(userLastId, name1, urllink1);
                            quary.InsertLinkData(link);
                            Link link2 = new Link(userLastId, name2, urllink2);
                            quary.InsertLinkData(link2);
                            Link link3 = new Link(userLastId, name3, urllink3);
                            quary.InsertLinkData(link3);
                            Link link4 = new Link(userLastId, name4, urllink4);
                            quary.InsertLinkData(link4);
                            Link link5 = new Link(userLastId, name5, urllink5);
                            quary.InsertLinkData(link5);
                            Link link6 = new Link(userLastId, name6, urllink6);
                            quary.InsertLinkData(link6);

                            Toast.makeText(AddProfileActivity.this, "Save data ", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
            }
        });

    }

  private void userDataInsert(String name,String  age,String image,String gender)
  {
      User user = new User(name,age,image,gender);
      quary.InsertData(user);
      userLastId  =  quary.getUserLastId();
  }


    private void init() {

        radioSexGroup = (RadioGroup) findViewById(R.id.radioSexId);
        submitBtn = (Button) findViewById(R.id.submitBtnId);
        radioLinkGroup = findViewById(R.id.radiolinkSizeId);
        quary = new Quary(this);

        userName = findViewById(R.id.addUserNameId);
        age = findViewById(R.id.addUserAgeId);


        layout1 = findViewById(R.id.add_linearLayout01);
        layout2 = findViewById(R.id.add_linearLayout02);
        layout3 = findViewById(R.id.add_linearLayout03);
        layout4 = findViewById(R.id.add_linearLayout04);
        layout5 = findViewById(R.id.add_linearLayout05);
        layout6 = findViewById(R.id.add_linearLayout06);

        linkName1 = findViewById(R.id.dataName1Id);
        linkName2 = findViewById(R.id.dataName2Id);
        linkName3 = findViewById(R.id.dataName3Id);
        linkName4 = findViewById(R.id.dataName4Id);
        linkName5 = findViewById(R.id.dataName5Id);
        linkName6 = findViewById(R.id.dataName6Id);

        url1 = findViewById(R.id.datalink1Id);
        url2 = findViewById(R.id.datalink2Id);
        url3 = findViewById(R.id.datalink3Id);
        url4 = findViewById(R.id.datalink4Id);
        url5 = findViewById(R.id.datalink5Id);
        url6 = findViewById(R.id.datalink6Id);

    }
}
