package com.example.testap.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.testap.Object.DTO.InventoryListItem;
import com.example.testap.R;

import java.util.ArrayList;

public class ListViewInventoryAdapter extends BaseAdapter {
    Context context;
    ArrayList<InventoryListItem> inventory_items = new ArrayList<InventoryListItem>();

    public ListViewInventoryAdapter(){

    }

    @Override
    public int getCount() {
        return inventory_items.size();
    }

    @Override
    public Object getItem(int i) {
        return inventory_items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        context = viewGroup.getContext();
        InventoryListItem inventory_itemd = inventory_items.get(i);

        if(view == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.inventory_item, viewGroup, false);
        }

        TextView item_name = view.findViewById(R.id.item_name);
        TextView day = view.findViewById(R.id.item_dday);

        item_name.setText(inventory_itemd.getName());
        day.setText(inventory_itemd.getDay() + "-Day");

        return view;
    }

    public void addItem( InventoryListItem item ){ inventory_items.add(item); }
}
