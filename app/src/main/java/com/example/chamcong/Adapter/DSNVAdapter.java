package com.example.chamcong.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.chamcong.MyUtil;
import com.example.chamcong.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DSNVAdapter extends BaseAdapter {

    private Context context;
    private JSONArray jsonArrayUser;

    public DSNVAdapter(Context context, JSONArray jsonArrayUser) {
        this.context = context;
        this.jsonArrayUser = MyUtil.jsonArrayUser;
    }

    @Override
    public int getCount() {
        return jsonArrayUser.length();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.dsnv, parent, false);
        }
        TextView nv_hoten = (TextView) convertView.findViewById(R.id.hoten);
//        TextView nv_sdt = (TextView) convertView.findViewById(R.id.sdt);
//        TextView nv_gioitinh = (TextView) convertView.findViewById(R.id.gioitinh);
//        TextView nv_email = (TextView) convertView.findViewById(R.id.email);
//        TextView nv_diachi = (TextView) convertView.findViewById(R.id.diachi);
//        TextView nv_chucvu = (TextView) convertView.findViewById(R.id.chucvu);
//        TextView nv_phongban = (TextView) convertView.findViewById(R.id.phongban);

        try {
            JSONObject jsonObject = jsonArrayUser.getJSONObject(position);

            nv_hoten.setText(jsonObject.getString("User_hoten"));
//            nv_sdt.setText(jsonObject.getString("User_sdt"));
//            nv_gioitinh.setText(jsonObject.getString("User_gioitinh"));
//            nv_email.setText(jsonObject.getString("User_email"));
//            nv_diachi.setText(jsonObject.getString("User_diachi"));
//            nv_chucvu.setText(jsonObject.getString("Chucvu"));
//            nv_phongban.setText(jsonObject.getString("Phongban"));


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return convertView;
    }
}
//    Context context;
//    List<User> userList;
//
//    public DSNVAdapter(List<User> userList, Context context) {
//        this.context = context;
//        this.userList = userList;
//    }
//
//    //    public DSCVAdapter(List<Chucvu> chucvuList) {
////        this.chucvuList = chucvuList;
////    }
//    public int getItemCount() {
//        return userList.size();
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.dsnv, parent, false);
//        return new ViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        User user = userList.get(position);
////        Picasso.get()
////                .load(user.avatar_url)
////                .into(holder.nvAvatar);
//
//        holder.user_hoten.setText(user.getUser_hoten());
////        holder.cv_id.setText(String.valueOf(chucvu.cv_id));
//
//    }
//
//
//
//    public static class ViewHolder extends RecyclerView.ViewHolder{
//
//        public TextView user_hoten, cv_id;
////        public ImageView nvAvatar;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//
//            user_hoten = (TextView) itemView.findViewById(R.id.nv_ten);
////            nvAvatar = (ImageView) itemView.findViewById(R.id.nv_avatar);
//
//        }
//    }
//}
