package it.mirea.restorante.repository.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
//        foreignKeys = @ForeignKey(entity=Order.class,
//        parentColumns = "order_id",
//        childColumns = "order_id")
)
public class OrderList {
    @PrimaryKey(autoGenerate = true)
    int string_id;


    @ColumnInfo
    int order_id;

    @ColumnInfo
    String dish;

    @ColumnInfo
    int dish_num;

    public int getString_id() {
        return string_id;
    }

    public void setString_id(int string_id) {
        this.string_id = string_id;
    }


    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public int getDish_num() {
        return dish_num;
    }

    public void setDish_num(int dish_num) {
        this.dish_num = dish_num;
    }
}
