package com.securesoftbd.smart_farm.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.securesoftbd.smart_farm.Model.Link;
import com.securesoftbd.smart_farm.R;
import java.util.List;

public class UserLinkAdapter extends RecyclerView.Adapter<UserLinkAdapter.MyViewHolder> {

    private List<Link> linkList;
    private Context context;


    public UserLinkAdapter(List<Link> linkList, Context context)
    {
        this.linkList = linkList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.model_show_data,null,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i)
    {
        Link link = linkList.get(i);
        myViewHolder.name.setText(link.getName());
        myViewHolder.view.setWebViewClient(new MyBrowser());
        myViewHolder.view.getSettings().setLoadsImagesAutomatically(true);
        myViewHolder.view.getSettings().setJavaScriptEnabled(true);
        myViewHolder.view.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        myViewHolder.view.loadUrl(link.getLink());

     /*   wv1.getSettings().setLoadsImagesAutomatically(true);
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv1.loadUrl(url);
        */


    }


    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public int getItemCount() {
        try {

            return linkList.size();
        }catch (Exception e)
        {
            return 0;
        }
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        WebView view;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.show_data_name_TVId);
            view = itemView.findViewById(R.id.show_data_webviewId);

        }
    }
}
