package com.example.todamoon_1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;

import java.util.ArrayList;

public class CardRecyclerView extends RecyclerView.Adapter<CardRecyclerView.ViewHolder> {
    private ArrayList<CardData> cardData;
    private Context context;

    public CardRecyclerView(Context context, ArrayList<CardData> cardData) {
        this.cardData = cardData;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        CardData cardDatum = cardData.get(position);
        viewHolder.title.setText(cardDatum.shortDescription);
        viewHolder.bg.setImageResource(cardDatum.image);
        viewHolder.restaurant.setText(cardDatum.restaurant);
        viewHolder.category.setText(cardDatum.category);
    }

    @Override
    public int getItemCount() {
        return cardData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView restaurant;
        private ImageView bg;
        private Chip category;

        public ViewHolder(View view) {
            super(view);
            this.title = view.findViewById(R.id.title);
            this.bg = view.findViewById(R.id.entryBg);
            this.restaurant = view.findViewById(R.id.restaurant);
            this.category = view.findViewById(R.id.category);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity) context).findViewById(R.id.main).setVisibility(View.GONE);
                    ((MainActivity) context).findViewById(R.id.volunteer).setVisibility(View.VISIBLE);
                }
            });
        }
    }
}
