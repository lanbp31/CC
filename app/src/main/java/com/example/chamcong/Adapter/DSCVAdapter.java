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


public class DSCVAdapter extends BaseAdapter {

    private Context context;
    private JSONArray jsonArrayChucvu;

    public DSCVAdapter(Context context, JSONArray jsonArrayChucvu) {
        this.context = context;
        this.jsonArrayChucvu = MyUtil.jsonArrayChucvu;
    }

    @Override
    public int getCount() {
        return jsonArrayChucvu.length();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.dscv, parent, false);
        }

        TextView cv_ten = (TextView) convertView.findViewById(R.id.cv_ten);

        try {
            JSONObject jsonObject = jsonArrayChucvu.getJSONObject(position);

            cv_ten.setText(jsonObject.getString("cv_ten"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return convertView;
    }
}


//    private List<Chucvu> chucvuList;
//    private List<Chucvu> chucvuListFiltered;
//    private Context context;
//
//    public DSCVAdapter(Context context,List<Chucvu> chucvuList) {
//        super(context, R.layout.dscv, chucvuList);
//        this.context = context;
//        this.chucvuList = chucvuList;
//        this.chucvuList = chucvuListFiltered;
//    }
//
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dscv, null, true);
//        TextView tvCountryName = view.findViewById(R.id.cv_ten);
////        ImageView imageView = view.findViewById(R.id.imageFlag);
//
//        tvCountryName.setText(chucvuListFiltered.get(position).getCv_ten());
////        Glide.with(context).load(countryModelsListFiltered.get(position).getFlag()).into(imageView);
//
//        return view;
//    }
//
//    @Override
//    public int getCount() {
//        return chucvuListFiltered.size();
//    }
//
//    @Nullable
//    @Override
//    public Chucvu getItem(int position) {
//        return chucvuListFiltered.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public Filter getFilter() {
//        Filter filter = new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//
//                FilterResults filterResults = new FilterResults();
//                if (constraint == null || constraint.length() == 0) {
//                    filterResults.count = chucvuList.size();
//                    filterResults.values = chucvuList;
//
//                } else {
//                    List<Chucvu> resultsModel = new ArrayList<>();
//                    String searchStr = constraint.toString().toLowerCase();
//
//                    for (Chucvu itemsModel : chucvuList) {
//                        if (itemsModel.getCv_ten().toLowerCase().contains(searchStr)) {
//                            resultsModel.add(itemsModel);
//
//                        }
//                        filterResults.count = resultsModel.size();
//                        filterResults.values = resultsModel;
//                    }
//
//
//                }
//
//                return filterResults;
//            }
//
//            @Override
//            protected void publishResults(CharSequence constraint, FilterResults results) {
//
//                chucvuListFiltered = (List<Chucvu>) results.values;
//                Quanlychucvu.chucvuModelList = (List<Chucvu>) results.values;
//                notifyDataSetChanged();
//
//            }
//        };
//        return filter;
//    }
//}

//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//        View view = LayoutInflater.from(viewGroup.getContext())
//                    .inflate(R.layout.dscv, viewGroup, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
//
//        final String car_name=articles.get(i).getCv_ten();
////        final String car_desc=articles.get(i).getCv_id();
//
//        viewHolder.car_name.setText(car_name);
////        viewHolder.car_desc.setText(car_desc);
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return articles.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder{
//        private TextView car_name,car_desc;
//
//
//        public ViewHolder(View view) {
//            super(view);
//            car_name = (TextView)view.findViewById(R.id.cv_ten);
////            car_desc = (TextView)view.findViewById(R.id.car_desc);
//        }
//    }
//
//
//    @Override
//    public Filter getFilter() {
//        return null;
//    }



//    Context context;
//    List<Chucvu> chucvuList;
//    List<Chucvu> chucvuOriginalList;
//
//    public DSCVAdapter(List<Chucvu> chucvuList, Context context) {
//        this.context = context;
//        this.chucvuList = chucvuList;
//    }
//
////    public DSCVAdapter(String chucvuList) {
////        this.chucvuList = chucvuList;
////        this.chucvuOriginalList = chucvuList;
////    }
//
//    public int getItemCount() {
//        if (chucvuList != null) {
//            return chucvuList.size();
//        }
//        return 0;
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.dscv, parent, false);
//        return new ViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        Chucvu chucvu = chucvuList.get(position);
//        if (chucvu == null){
//            return;
//        }
//
//        holder.cv_ten.setText(chucvu.cv_ten);
////        holder.cv_id.setText(String.valueOf(chucvu.cv_id));
//
//    }
//
//    public static class ViewHolder extends RecyclerView.ViewHolder{
//
//         TextView cv_ten, cv_id;
////        public ImageView ivAvatar;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            cv_ten = (TextView) itemView.findViewById(R.id.cv_ten);
////            cv_id = (TextView) itemView.findViewById(R.id.cv_id);
////            ivAvatar = (ImageView) itemView.findViewById(R.id.cv_avatar);
//
//        }
//    }
//
//    @Override
//    public Filter getFilter() {
//
//        return new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//                String searchStr = constraint.toString().toLowerCase().trim();
//
//                List<Chucvu> chucvus = new ArrayList<>();
//
//                if(searchStr.length() == 0 || searchStr.isEmpty()){
//                    chucvus.addAll(chucvuOriginalList);
//                }
//                else{
//                    for(Chucvu chucvu : chucvuOriginalList){
//                        if (chucvu.getCv_ten().toLowerCase().contains(searchStr)){
//                            chucvus.add(chucvu);
//                        }
//                    }
//                }
//
//                FilterResults filterResults = new FilterResults();
//                filterResults.values = chucvus;
//
//                return filterResults;
//            }
//
//            @Override
//            protected void publishResults(CharSequence constraint, FilterResults filterResults) {
//                chucvuList.clear();
////                chucvuList.addAll((List) results.values);
//                chucvuList.addAll((List<Chucvu>) filterResults.values);
//                notifyDataSetChanged();
//            }
//        };
//    }

