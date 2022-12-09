package it.mirea.restorante.repository.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Employee {
    @PrimaryKey
    String employee_id;
    @ColumnInfo
    String password;
    @ColumnInfo
    String FIO;

}
