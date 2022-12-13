package it.mirea.restorante.repository.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table")
public class Table {
    @PrimaryKey(autoGenerate = true)
    int table_numb;

    @ColumnInfo
    int tab_type;

    boolean table_status;

    public int getTable_numb() {
        return table_numb;
    }

    public void setTable_numb(int table_numb) {
        this.table_numb = table_numb;
    }

    public int getTab_type() {
        return tab_type;
    }

    public void setTab_type(int tab_type) {
        this.tab_type = tab_type;
    }

    public boolean isTable_status() {
        return table_status;
    }

    public void setTable_status(boolean table_status) {
        this.table_status = table_status;
    }
}
