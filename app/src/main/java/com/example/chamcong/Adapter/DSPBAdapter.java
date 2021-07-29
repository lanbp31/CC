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

public class DSPBAdapter extends BaseAdapter {

    private Context context;
    private JSONArray jsonArrayPhongban;

    public DSPBAdapter(Context context, JSONArray jsonArrayPhongban) {
        this.context = context;
        this.jsonArrayPhongban = MyUtil.jsonArrayPhongban;
    }

    @Override
    public int getCount() {
        return jsonArrayPhongban.length();
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
//            convertView = LayoutInflater.from(context).inflate(R.layout.dscv, parent, false);
            convertView = LayoutInflater.from(context).inflate(R.layout.dspb, parent, false);
        }
        TextView pb_ten = (TextView) convertView.findViewById(R.id.pb_ten);

        try {
            JSONObject jsonObject = jsonArrayPhongban.getJSONObject(position);

            pb_ten.setText(jsonObject.getString("Pb_ten"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return convertView;
    }
}
//    Context context;
//    List<Phongban> phongbanList;
//
//    public DSPBAdapter(Context context, List<Phongban> phongbanList) {
//        this.context = context;
//        this.phongbanList = phongbanList;
//    }
////    public DSPBAdapter(List<Phongban> phongbanList) {
////        this.phongbanList = phongbanList;
////    }
//
//    public int getItemCount() {
//        return phongbanList.size();
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.dspb, parent, false);
//        return new ViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        Phongban phongban = phongbanList.get(position);
//
//        holder.pb_ten.setText(phongban.pb_ten);
////        holder.cv_id.setText(String.valueOf(chucvu.cv_id));
//
//    }
//
//
//
//    public static class ViewHolder extends RecyclerView.ViewHolder{
//
//        public TextView pb_ten, cv_id;
////        public ImageView ivAvatar;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//
//            pb_ten = (TextView) itemView.findViewById(R.id.pb_ten);
////            cv_id = (TextView) itemView.findViewById(R.id.cv_id);
////            ivAvatar = (ImageView) itemView.findViewById(R.id.cv_avatar);
//
//        }
//    }
//}