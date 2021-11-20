package com.example.todamoon_1;

import android.content.Context;
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
        viewHolder.image.setImageResource(cardDatum.image);
        viewHolder.restaurant.setText(cardDatum.restaurant);
        viewHolder.category.setText(cardDatum.category);
        viewHolder.location.setText(cardDatum.location);
        viewHolder.image_icon.setImageResource(cardDatum.image_icon);
        viewHolder.description = cardDatum.longDescription;
    }

    @Override
    public int getItemCount() {
        return cardData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView restaurant;
        private TextView location;
        private ImageView image;
        private ImageView image_icon;
        private Chip category;

        private String description;

        public ViewHolder(View view) {
            super(view);
            this.title = view.findViewById(R.id.title);
            this.image = view.findViewById(R.id.image);
            this.image_icon = view.findViewById(R.id.company_icon);
            this.location = view.findViewById(R.id.location);
            this.restaurant = view.findViewById(R.id.company);
            this.category = view.findViewById(R.id.category);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity) context).findViewById(R.id.main).setVisibility(View.GONE);
                    View volunteer = ((MainActivity) context).findViewById(R.id.volunteer);
                    volunteer.setVisibility(View.VISIBLE);
                    ((ImageView) volunteer.findViewById(R.id.banner)).setImageDrawable(ViewHolder.this.image.getDrawable());
                    ((ImageView) volunteer.findViewById(R.id.logo)).setImageDrawable(ViewHolder.this.image_icon.getDrawable());
                    ((TextView) volunteer.findViewById(R.id.shortDescription)).setText(ViewHolder.this.title.getText());
                    ((TextView) volunteer.findViewById(R.id.longDescription)).setText(ViewHolder.this.description);
                    ((TextView) volunteer.findViewById(R.id.location)).setText(ViewHolder.this.location.getText());
                    ((Chip) volunteer.findViewById(R.id.category)).setText(ViewHolder.this.category.getText());

                }
            });
        }
    }
}
