package com.example.testap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testap.Object.DTO.InventoryListItem;

public class InventoryAddActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory_add_activity);


        Button imageCaptureBtn = (Button) findViewById(R.id.inventory_add_image_btn);
        Button dateCaptureBtn = (Button) findViewById(R.id.inventory_add_date_btn);

        imageCaptureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InventoryAddActivity.this, PhotoActivity.class);
                startActivity(intent);
            }
        });

        dateCaptureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InventoryAddActivity.this, PhotoOCRActivity.class);
                startActivity(intent);
            }
        });
    }
}
