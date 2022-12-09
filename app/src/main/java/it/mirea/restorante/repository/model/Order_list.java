package it.mirea.restorante.repository.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity=Order.class,
        parentColumns = "order_id",
        childColumns = "order_id"))
public class Order_list {
    @PrimaryKey(autoGenerate = true)
    int string_id;

    @ColumnInfo
    int order_id;

    @ColumnInfo
    String dish;

}
