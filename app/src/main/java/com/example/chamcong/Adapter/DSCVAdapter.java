package com.example.chamcong.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.chamcong.Object.Chucvu;
import com.example.chamcong.R;

import java.util.List;


public class DSCVAdapter extends RecyclerView.Adapter<DSCVAdapter.ViewHolder> {

    Context context;
    List<Chucvu> chucvuList;

    public DSCVAdapter(List<Chucvu> chucvuList, Context context) {
        this.context = context;
        this.chucvuList = chucvuList;
    }

//    public DSCVAdapter(List<Chucvu> chucvuList) {
//        this.chucvuList = chucvuList;
//    }
    public int getItemCount() {
    return chucvuList.size();
}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dscv, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Chucvu chucvu = chucvuList.get(position);

        holder.cv_ten.setText(chucvu.cv_ten);
//        holder.cv_id.setText(String.valueOf(chucvu.cv_id));

    }



    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView cv_ten, cv_id;
//        public ImageView ivAvatar;

        public ViewHolder(View itemView) {
            super(itemView);

            cv_ten = (TextView) itemView.findViewById(R.id.cv_ten);
//            cv_id = (TextView) itemView.findViewById(R.id.cv_id);
//            ivAvatar = (ImageView) itemView.findViewById(R.id.cv_avatar);

        }
    }
}
