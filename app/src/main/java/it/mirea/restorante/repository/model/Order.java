package it.mirea.restorante.repository.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "order",foreignKeys = {
        @ForeignKey(entity=Client.class,
                parentColumns = "table_numb",
                childColumns = "table_numb"),
        @ForeignKey(entity=Client.class,
                parentColumns = "client_id",
                childColumns = "client_id")
})
public class Order {

    @PrimaryKey(autoGenerate = true)
    String order_id;

    @ColumnInfo
    String id_tab;


}
