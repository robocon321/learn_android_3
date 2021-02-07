package com.example.learnandroid3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnandroid3.R;
import com.example.learnandroid3.utils.Item;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    ArrayList<Item> list;
    Context context;

    public ItemAdapter(ArrayList<Item> list, Context context){
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
        Item item = list.get(position);

        holder.imgView.setImageResource(item.getImage());
        holder.txtView.setText(item.getDesciption());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void remove(int postion){
        list.remove(postion);
        this.notifyItemRemoved(postion);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgView;
        TextView txtView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.imgRecyclerView);
            txtView = itemView.findViewById(R.id.txtRecylerView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    remove(getAdapterPosition());
                }
            });
        }
    }
}
