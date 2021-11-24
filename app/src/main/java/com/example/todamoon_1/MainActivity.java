package com.example.todamoon_1;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.Arrays;

class ShiftDay {
    String day = "MONDAY";

    public ShiftDay(String day) {
        this.day = day;
    }
}

class ShiftTime {
    String title = "Shift 1: Morning";
    String time = "8:30 AM - 11:30 AM";

    public ShiftTime(String title, String time) {
        this.title = title;
        this.time = time;
    }
}

public class MainActivity extends AppCompatActivity {

    final ArrayList<Integer> ids = new ArrayList<>(Arrays.asList(R.id.main, R.id.volunteer, R.id.shift, R.id.application));

    public View showView(@IdRes int id) {
        for (int i = 0; i < ids.size(); ++i) {
            findViewById(ids.get(i)).setVisibility(View.GONE);
        }
        View view = findViewById(id);
        view.setVisibility(View.VISIBLE);
        return view;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<CardData> cardData = new ArrayList<>();
        cardData.add(new CardData(
                "ABC Food Bank",

                "ABC Food Bank provides free meals anyone in need in the community",
                "ABC Food Bank provides free meals anyone in need in the community. We rely heavily on volunteers to help us achieve this. If you have any non-perishable food items, please consider donating to ABC Food Bank. Your generosity is greatly appreciated, especially during this time of need.",
                "Marpole, South Vancouver",
                "Community",
                R.drawable.org1,
                R.drawable.logo1));
        cardData.add(new CardData(
                "DEF Run for Health",

                "DEF Run for Health raises money for medical research",
                "DEF Run for Health raises money for medical research.\n" +
                        "\n" +
                        "Join our 10k run and support this meaningful cause.\n" +
                        "\n" +
                        "If you're not able to run 10k, then you can walk the entire distance. Or a combination of walking and running would work as well. The important thing is to help raise funds for medical research.\n" +
                        "\n" +
                        "If you and a group of friends would like to do the run together, that will work as well.",
                "Suncrest, Burnaby",
                "Food",
                R.drawable.org2,
                R.drawable.logo2));
        cardData.add(new CardData(
                "GHI Homes",

                "GHI Homes helps build homes for families in poverty-stricken locations worldwide",
                "GHI Homes helps build homes for families in poverty-stricken locations worldwide.\n" +
                        "\n" +
                        "Join us for a summer or support us with your donations.",
                "West Avenue, Seattle",
                "Shelter",
                R.drawable.org3,
                R.drawable.logo3));
        CardRecyclerView cards = new CardRecyclerView(this, cardData);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView entries = findViewById(R.id.entries);
        entries.setLayoutManager(linearLayoutManager);
        entries.setAdapter(cards);

        findViewById(R.id.volunteer).findViewById(R.id.back).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                showView(R.id.main);
            }
        });

        findViewById(R.id.volunteer).findViewById(R.id.select_shift).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showView(R.id.shift);
            }
        });

        findViewById(R.id.shift).findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showView(R.id.volunteer);
            }
        });

        LayoutInflater inflater = (LayoutInflater) getApplicationContext().
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ArrayList<ShiftDay> shift_days = new ArrayList<>();
        shift_days.add(new ShiftDay("Monday"));
        shift_days.add(new ShiftDay("Wednesday"));
        shift_days.add(new ShiftDay("Friday"));
        ArrayList<ShiftTime> shift_time = new ArrayList<>();
        shift_time.add(new ShiftTime("Shift 1: Morning", "8:30 AM - 11:30 AM"));
        shift_time.add(new ShiftTime("Shift 2: Afternoon", "2:30 PM - 5:30 PM"));
        shift_time.add(new ShiftTime("Shift 3: Evening", "8:30 PM - 11:30 PM"));
        LinearLayout shift_day_list = findViewById(R.id.shift).findViewById(R.id.shift_day_list);
        for (int i = 0; i < shift_days.size(); ++i) {
            View shift_day_view = inflater.inflate(R.layout.shift_day_list, shift_day_list, false);
            TextView title = shift_day_view.findViewById(R.id.title);
            title.setText(shift_days.get(i).day);
            shift_day_list.addView(shift_day_view);
            LinearLayout shift_time_list = shift_day_view.findViewById(R.id.shift_time_list);
            for (int j = 0; j < shift_time.size(); ++j) {
                View shift_time_view = inflater.inflate(R.layout.shift_time_list, shift_time_list, false);
                TextView time_title = shift_time_view.findViewById(R.id.title);
                time_title.setText(shift_time.get(j).title);
                TextView time_time = shift_time_view.findViewById(R.id.time);
                time_time.setText(shift_time.get(j).time);
                Chip apply_chip = shift_time_view.findViewById(R.id.apply);
                apply_chip.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        findViewById(R.id.shift).setVisibility(View.GONE);
                        findViewById(R.id.application).setVisibility(View.VISIBLE);
                        TextView application_shift_title = findViewById(R.id.application).findViewById(R.id.shift_title);
                        application_shift_title.setText(time_title.getText());
                        TextView application_shift_time = findViewById(R.id.application).findViewById(R.id.shift_time);
                        application_shift_time.setText(time_time.getText());
                    }
                });
                shift_time_list.addView(shift_time_view);
            }
        }

        findViewById(R.id.application).findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showView(R.id.shift);
            }
        });

        findViewById(R.id.application).findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThanksDialog dialog = new ThanksDialog(MainActivity.this);
                dialog.show();
            }
        });
    }
}