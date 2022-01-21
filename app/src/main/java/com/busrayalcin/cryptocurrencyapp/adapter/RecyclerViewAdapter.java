package com.busrayalcin.cryptocurrencyapp.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.busrayalcin.cryptocurrencyapp.R;
import com.busrayalcin.cryptocurrencyapp.model.CryptoModel;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RowHolder> {

    private ArrayList<CryptoModel> cryptoList;
    private String[] colors = {"#d97c70","#d2936c","#cd8289","#fbbbbd","#db575e","#e06c72","#ee7676","#f9aa95","#f36374","#aa8080"};

    public RecyclerViewAdapter(ArrayList<CryptoModel> cryptoList) {
        this.cryptoList = cryptoList;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_row,parent,false);
        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
        holder.bind(cryptoList.get(position), colors, position);
    }

    @Override
    public int getItemCount() {
        return cryptoList.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder {
        TextView nameText;
        TextView priceText;

        public RowHolder(@NonNull View itemView) {
            super(itemView);

        }

        public void bind(CryptoModel cryptoModel, String[] colors, Integer position){
            itemView.setBackgroundColor(Color.parseColor(colors[position % 10]));
            nameText = itemView.findViewById(R.id.nameText);
            priceText = itemView.findViewById(R.id.priceText);
            nameText.setText(cryptoModel.currency);
            priceText.setText(cryptoModel.price);
        }
    }
}
