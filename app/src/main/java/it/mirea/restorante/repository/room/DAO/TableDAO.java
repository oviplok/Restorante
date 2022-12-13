package it.mirea.restorante.repository.room.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import it.mirea.restorante.repository.model.OrderList;
import it.mirea.restorante.repository.model.Table;

@Dao
public interface TableDAO {
    @Insert
    void addTable(Table table);

    @Update
    void changeTable(Table table);

    @Delete
    void deleteOrderLine(Table order_list);

    @Query("SELECT * FROM `table` where table_numb like :table_numb")
    LiveData<Table> getTable(int table_numb);

    @Query("SELECT * FROM `table` where table_status = 1 and tab_type >= :people")
    LiveData<List<Table>> getFreeTables(int people);

}
