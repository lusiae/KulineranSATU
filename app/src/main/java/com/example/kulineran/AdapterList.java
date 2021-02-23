package com.example.kulineran;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder>{
    Context context;
    ArrayList<HashMap<String, String>> list_data;
    public AdapterList(Info_makanan info_makanan, ArrayList<HashMap<String, String>> list_data) {
        this.context = info_makanan;
        this.list_data = list_data;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nama, deskripsi;


        public ViewHolder(View itemView) {
            super(itemView);

            nama = (TextView) itemView.findViewById(R.id. nama);
            deskripsi = (TextView) itemView.findViewById(R.id.deskripsi);
        }
    }

}
