package com.example.chamcong.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.chamcong.R;
import com.example.chamcong.Object.User;

import java.util.List;

public class DSNVAdapter extends ArrayAdapter<User> {
    //the hero list that will be displayed
    private List<User> Userlist;

    //the context object
    private Context mCtx;

    public DSNVAdapter(List<User> heroList, Context mCtx) {
        super(mCtx, R.layout.dsnv, heroList);
        this.Userlist = heroList;
        this.mCtx = mCtx;
    }

    //this method will return the list item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //getting the layoutinflater
        LayoutInflater inflater = LayoutInflater.from(mCtx);

        //creating a view with our xml layout
        View listViewItem = inflater.inflate(R.layout.dsnv, null, true);

        //getting text views
        TextView hoten = listViewItem.findViewById(R.id.hoten);
        TextView email = listViewItem.findViewById(R.id.email);

        //Getting the hero for the specified position
        User user = Userlist.get(position);

        //setting hero values to textviews
        hoten.setText(user.getUser_hoten());
        email.setText(user.getUser_email());

        //returning the listitem
        return listViewItem;
    }
}
