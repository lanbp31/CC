package com.example.chamcong.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.chamcong.Object.Chucvu;
import com.example.chamcong.R;

import java.util.List;

public class DSCVAdapter extends RecyclerView.Adapter<DSCVAdapter.ViewHolder> {

    private Context context;
    private List<Chucvu> chucvuList;

    public DSCVAdapter(Context context, List chucvuList) {
        this.context = context;
        this.chucvuList = chucvuList;
    }

    public DSCVAdapter(List<Chucvu> chucvuList) {
        this.chucvuList = chucvuList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dscv, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(chucvuList.get(position));

        Chucvu chucvu = chucvuList.get(position);

//        holder.cv_ten.setText(pu.getPersonFirstName()+" "+pu.getPersonLastName());
        holder.cv_ten.setText(chucvu.getCv_ten());
    }

    public int getItemCount() {
        return chucvuList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView cv_ten;


        public ViewHolder(View itemView) {
            super(itemView);

            cv_ten = (TextView) itemView.findViewById(R.id.cv_ten);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Chucvu chucvu = (Chucvu) view.getTag();

                    Toast.makeText(view.getContext(), chucvu.getCv_ten()
                            , Toast.LENGTH_SHORT).show();

                }
            });

        }
    }
}
