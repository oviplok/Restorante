package it.mirea.restorante.repository.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "order"
//        ,foreignKeys = {
//        @ForeignKey(entity=Client.class,
//                parentColumns = "table_numb",
//                childColumns = "table_numb"),
//        @ForeignKey(entity=Client.class,
//                parentColumns = "client_id",
//                childColumns = "client_id")
//}
)
public class Order {

    @PrimaryKey(autoGenerate = true)
    int order_id;

    @ColumnInfo
    int table_numb;

    @ColumnInfo
    int client_id;


    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getTable_numb() {
        return table_numb;
    }

    public void setTable_numb(int table_numb) {
        this.table_numb = table_numb;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }
}
