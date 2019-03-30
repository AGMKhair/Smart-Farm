package com.securesoftbd.smart_farm.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.securesoftbd.smart_farm.Database.Quary;
import com.securesoftbd.smart_farm.Model.User;
import com.securesoftbd.smart_farm.R;
import com.securesoftbd.smart_farm.ViewProfileActivity;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder>
{

    private Context context;
    private List<User> userList;


    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        return new MyViewHolder(LayoutInflater.from(this.context).inflate(R.layout.model_design,null,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {

        final User user = this.userList.get(i);
        final Quary quary = new Quary(context);
        myViewHolder.name.setText(user.getName());
        myViewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(UserAdapter.this.context, ViewProfileActivity.class).putExtra("ID",user.getId()));
            }
        });

        myViewHolder.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v)
            {
                final PopupMenu popupmenu;

                popupmenu = new PopupMenu(context, myViewHolder.menu);

                popupmenu.getMenuInflater().inflate(R.menu.pop_up_menu, popupmenu.getMenu());

                popupmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {


                        switch (item.getItemId())
                        {

                            case R.id.DeleteId:

                                quary.deleteData(String.valueOf(user.getId()));
                                userList.remove(i);// = quary.getAllUser();
                                notifyDataSetChanged();
                                    break;


                            case R.id.UpdateId:

                                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                View view = LayoutInflater.from(context).inflate(R.layout.update_design_activity,null,false);
                                builder.setView(view);

                                final EditText name,age;
                                Button cancel,submit;
                                name = view.findViewById(R.id.update_name_id);
                                age = view.findViewById(R.id.update_age_id);
                                submit = view.findViewById(R.id.update_confirm_id);
                                cancel = view.findViewById(R.id.update_cancel_id);


                                name.setText(userList.get(i).getName());
                                age.setText(userList.get(i).getAge());

                                final AlertDialog alertDialog = builder.create();
                                alertDialog.show();
                                alertDialog.setCancelable(false);

                                cancel.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        alertDialog.dismiss();
                                    }
                                });

                                submit.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        String na = name.getText().toString();
                                        String ag = age.getText().toString();
                                        if(!na.isEmpty() && ! ag.isEmpty())
                                        {
                                            quary.UpdateData(new User(userList.get(i).getId(),na,ag));
                                            UserAdapter.this.notifyDataSetChanged();
                                            alertDialog.dismiss();
                                        }
                                    }
                                });


                                    break;

                        }
                        /*
                    if(item.getTitle().equals("Update"))
                    {

                    }
                    else
                    {

                    }*/

                        return true;
                    }
                });
                popupmenu.show();

            }
        });

    }


private void deleteMethod()
{

}


    @Override
    public int getItemCount() {
        try
        {

            return userList.size();
        }catch (Exception e)
        {
            return 0;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        Button view;
        ImageView menu;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            menu = itemView.findViewById(R.id.menu_ID);
            name = itemView.findViewById(R.id.model_name_show_id);
            view = itemView.findViewById(R.id.model_button_id);

        }
    }
}
