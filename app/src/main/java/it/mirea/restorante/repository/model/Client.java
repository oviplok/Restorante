package it.mirea.restorante.repository.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "client")
public class Client {
    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    @PrimaryKey(autoGenerate = true)
    int client_id;

    @ColumnInfo
    int people;

    @ColumnInfo
    String FIO;

    @ColumnInfo
    int table_numb;

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public int getTable_numb() {
        return table_numb;
    }

    public void setTable_numb(int table_numb) {
        this.table_numb = table_numb;
    }
}
