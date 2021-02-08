package com.example.learnandroid3.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnandroid3.R;
import com.example.learnandroid3.utils.Contact;

import java.security.Permission;
import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    ArrayList<Contact> contacts;
    Context context;

    public ContactAdapter(ArrayList<Contact> contacts, Context context){
        this.contacts = contacts;
        this.context = context;
    }

    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater infater = LayoutInflater.from(context);
        View view = infater.inflate(R.layout.layout_contact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        if(contact.getImage() != null) holder.imgContact.setImageBitmap(contact.getImage());
        holder.txtName.setText(contact.getName());
        holder.txtPhoneNumber.setText(contact.getNumber());

        holder.imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = (Activity) context;

                Intent intent = new Intent();
                intent.putExtra("phone", contact.getNumber());
                activity.setIntent(intent);

                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE}, 123);
            }
        });

        holder.imgMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = (Activity) context;

                Intent intent = new Intent();
                intent.putExtra("phone", contact.getNumber());
                activity.setIntent(intent);

                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.SEND_SMS}, 111);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgContact, imgCall, imgMessage;
        TextView txtName, txtPhoneNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgContact = itemView.findViewById(R.id.imgContact);
            imgCall = itemView.findViewById(R.id.imgPhoneContact);
            imgMessage = itemView.findViewById(R.id.imgMessageContact);
            txtName = itemView.findViewById(R.id.txtNameContact);
            txtPhoneNumber = itemView.findViewById(R.id.txtNumberContact);
        }
    }
}
