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
    private Context context;
    private List<Phongban> phongbanList;

    public DSPBAdapter(Context context, List phongbanList) {
        this.context = context;
        this.phongbanList = phongbanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dspb, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(phongbanList.get(position));

        Phongban phongban = phongbanList.get(position);

//        holder.cv_ten.setText(pu.getPersonFirstName()+" "+pu.getPersonLastName());
        holder.pb_ten.setText(phongban.getPb_ten());
    }

    public int getItemCount() {
        return phongbanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView pb_ten;


        public ViewHolder(View itemView) {
            super(itemView);

            pb_ten = (TextView) itemView.findViewById(R.id.pb_ten);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Phongban phongban = (Phongban) view.getTag();

                    Toast.makeText(view.getContext(), phongban.getPb_ten()
                            , Toast.LENGTH_SHORT).show();

                }
            });

        }
    }
}

