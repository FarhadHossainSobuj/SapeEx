package com.tushar.sapeex;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "expence")
public class ExpencessModel {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "type")
    private String cost_type;

    @ColumnInfo(name = "ammount")
    private float ammoutn;

    @ColumnInfo(name = "date")
    private String date;

    public ExpencessModel(String cost_type, float ammoutn, String date) {
        this.cost_type = cost_type;
        this.ammoutn = ammoutn;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCost_type() {
        return cost_type;
    }

    public void setCost_type(String cost_type) {
        this.cost_type = cost_type;
    }

    public float getAmmoutn() {
        return ammoutn;
    }

    public void setAmmoutn(float ammoutn) {
        this.ammoutn = ammoutn;
    }
}
