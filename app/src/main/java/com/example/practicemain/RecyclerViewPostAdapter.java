package com.example.practicemain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewPostAdapter extends RecyclerView.Adapter<RecyclerViewPostAdapter.MyViewHolder> {

   List<Post>list;
   Context context;

    public RecyclerViewPostAdapter(List<Post> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewPostAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_post,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewPostAdapter.MyViewHolder holder, int position) {
        holder.userID.setText(list.get(position).getUserId()+"");
        holder.id.setText(list.get(position).getId()+"");
        holder.title.setText(list.get(position).getTitle());
        holder.body.setText(list.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView userID, id, title, body;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            userID = itemView.findViewById(R.id.userId);
            id = itemView.findViewById(R.id.id);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
        }
    }
}
