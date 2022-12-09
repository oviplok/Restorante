package it.mirea.restorante.repository.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table")
public class Table {
    @PrimaryKey(autoGenerate = true)
    String table_id;
    @ColumnInfo
    int tab_type;

}
