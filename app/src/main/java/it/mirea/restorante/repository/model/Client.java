package it.mirea.restorante.repository.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "client")
public class Client {

    @PrimaryKey
    String client_id;

    @ColumnInfo
    String FIO;

    @ColumnInfo
    String table_numb;

}
