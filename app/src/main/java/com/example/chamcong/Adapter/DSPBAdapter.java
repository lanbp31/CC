package com.example.chamcong.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.chamcong.Object.Chucvu;
import com.example.chamcong.Object.Phongban;
import com.example.chamcong.R;

import java.util.List;

public class DSPBAdapter extends RecyclerView.Adapter<DSPBAdapter.ViewHolder> {
    Context context;
    List<Phongban> phongbanList;

    public DSPBAdapter(Context context, List<Phongban> phongbanList) {
        this.context = context;
        this.phongbanList = phongbanList;
    }
//    public DSPBAdapter(List<Phongban> phongbanList) {
//        this.phongbanList = phongbanList;
//    }

    public int getItemCount() {
        return phongbanList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dspb, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Phongban phongban = phongbanList.get(position);

        holder.pb_ten.setText(phongban.pb_ten);
//        holder.cv_id.setText(String.valueOf(chucvu.cv_id));

    }



    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView pb_ten, cv_id;
//        public ImageView ivAvatar;

        public ViewHolder(View itemView) {
            super(itemView);

            pb_ten = (TextView) itemView.findViewById(R.id.pb_ten);
//            cv_id = (TextView) itemView.findViewById(R.id.cv_id);
//            ivAvatar = (ImageView) itemView.findViewById(R.id.cv_avatar);

        }
    }
}