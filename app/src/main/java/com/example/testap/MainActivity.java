package com.example.testap;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.testap.Adapter.ListViewInventoryAdapter;
import com.example.testap.Object.DTO.InventoryListItem;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.googlecode.tesseract.android.TessBaseAPI;

import org.w3c.dom.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static FirebaseFirestore db = FirebaseFirestore.getInstance();
    ListViewInventoryAdapter adapter = new ListViewInventoryAdapter();
    ListView lvInventory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        DocumentReference docRef = db.collection("testdb").document("test");

        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()){
                        Map<String, Object> temp = (Map<String, Object>) document.getData();
                        ArrayList<Map<String, Object>> temp2 = (ArrayList<Map<String, Object>>) temp.get("Refrigerator");
                        Log.d(TAG, String.valueOf(temp2));
                        if (temp2 != null) {
                            for (Map<String, Object> item : temp2) {
                                Log.d(TAG, String.valueOf(item.get("name")));
                                adapter.addItem(new InventoryListItem((String) item.get("name"), (String)item.get("day"), (String)item.get("date"), (String)item.get("imagePath")));
                            }
                            adapter.notifyDataSetChanged();
                        }
                    } else {
                        Log.d(TAG, "no document");
                    }
                } else {
                    Log.d(TAG, "Fail Task");
                }
            }
        });

        lvInventory = (ListView) findViewById(R.id.lvInventory);
        lvInventory.setAdapter(adapter);

        //inventory 추가하기
        Button button = (Button) findViewById(R.id.inventory_add_activity);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InventoryAddActivity.class);
                startActivity(intent);
            }
        });
    }
}