package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DrinkDetail extends AppCompatActivity {
    ArrayList<String> favorites = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_detail);

        Intent intent = getIntent();
        int id = (int) intent.getExtras().get("drink_id");

        DrinkDet drink = DrinkDet.drinks[id];

        ImageView image = findViewById(R.id.coffee_image);
        image.setImageResource(drink.getImageID());

        TextView txtName = findViewById(R.id.txtName);
        TextView txtTime = findViewById(R.id.txtTime);
        TextView txtDesc = findViewById(R.id.txtDesc);

        txtName.setText(drink.getName());
        txtDesc.setText(drink.getDescription());
        //txtTime.setText(drink.getTime()); TextView just access String , in this case time is integer .
        Button myfavorite = findViewById(R.id.myfavorite);
        myfavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ArrayList<String> favorites = new ArrayList<String>();
                String name = txtName.getText().toString();
                String time = txtTime.getText().toString();
                String desc = txtDesc.getText().toString();
                favorites.add(name + " " + time + " " + desc);
                // you can add a toast message to confirm that the item has been added to the favorites list
                Toast.makeText(getApplicationContext(), "Item added to favorites", Toast.LENGTH_SHORT).show();
                ListView listView = (ListView) findViewById(R.id.listView);
                MyAdapter adapter = new MyAdapter(DrinkDetail.this,favorites);
                listView.setAdapter(adapter);
            }

        });
        Button newbotton = findViewById(R.id.newbotton);
        newbotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListView listView = (ListView) findViewById(R.id.listView);
                MyAdapter adapter = new MyAdapter(DrinkDetail.this,favorites);
                listView.setAdapter(adapter);
            }
        });


    }
}