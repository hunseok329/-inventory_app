package com.example.testap.Object.DTO;

public class InventoryListItem {
    private String name;
    private String day;
    private String date;
    private String imagePath;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDay() { return day; }
    public void setDay(String day) { this.day = day; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public InventoryListItem(String name, String day, String date, String imagePath){
        this.name = name;
        this.day = day;
        this.date = date;
        this.imagePath = imagePath;
    }
}
