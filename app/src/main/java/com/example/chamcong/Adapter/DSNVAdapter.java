package com.example.chamcong.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chamcong.Object.Chucvu;
import com.example.chamcong.R;
import com.example.chamcong.Object.User;

import java.util.List;

public class DSNVAdapter extends RecyclerView.Adapter<DSNVAdapter.ViewHolder> {
    List<User> userList;
    Context Context;

    public DSNVAdapter(List<User> userList, Context Context) {
        this.userList = userList;
        this.Context = Context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dsnv, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(userList.get(position));

        User user = userList.get(position);

//        holder.cv_ten.setText(pu.getPersonFirstName()+" "+pu.getPersonLastName());
        holder.hoten.setText(user.getUser_hoten());
        holder.email.setText(user.getUser_email());
    }

    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
//        TextView id;
        private TextView hoten, email;
//        private ImageView avatar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hoten = itemView.findViewById(R.id.hoten);
            email = itemView.findViewById(R.id.email);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    User user = (User) view.getTag();

                    Toast.makeText(view.getContext(), user.getUser_hoten()+ "\n" + user.getUser_email(),
                            Toast.LENGTH_SHORT).show();

                }
            });

        }
    }
}
