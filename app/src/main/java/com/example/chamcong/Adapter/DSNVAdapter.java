package com.example.chamcong.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.chamcong.R;
import com.example.chamcong.Object.User;

import java.util.List;

public class DSNVAdapter extends RecyclerView.Adapter<DSNVAdapter.ViewHolder> {
    Context context;
    List<User> userList;

    public DSNVAdapter(List<User> userList, Context context) {
        this.context = context;
        this.userList = userList;
    }

    //    public DSCVAdapter(List<Chucvu> chucvuList) {
//        this.chucvuList = chucvuList;
//    }
    public int getItemCount() {
        return userList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dsnv, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = userList.get(position);
//        Picasso.get()
//                .load(user.avatar_url)
//                .into(holder.nvAvatar);

        holder.user_hoten.setText(user.User_hoten);
//        holder.cv_id.setText(String.valueOf(chucvu.cv_id));

    }



    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView user_hoten, cv_id;
//        public ImageView nvAvatar;

        public ViewHolder(View itemView) {
            super(itemView);

            user_hoten = (TextView) itemView.findViewById(R.id.nv_ten);
//            nvAvatar = (ImageView) itemView.findViewById(R.id.nv_avatar);

        }
    }
}
