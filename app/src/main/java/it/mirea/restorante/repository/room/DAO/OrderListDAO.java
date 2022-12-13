package it.mirea.restorante.repository.room.DAO;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import it.mirea.restorante.repository.model.OrderList;

@Dao
public interface OrderListDAO {

    @Insert
    void addOrderLine(OrderList order_list);

    @Update
    void changeOrderLine(OrderList order_list);

    @Delete
    void deleteOrderLine(OrderList order_list);

    @Query("Delete FROM OrderList WHERE order_id LIKE :id")
    LiveData<OrderList> DeleteOrderList(int id);

    @Query("SELECT * FROM OrderList")
    LiveData<List<OrderList>> getOrderLists();

    @Query("SELECT * FROM OrderList WHERE order_id LIKE :id")
    LiveData<List<OrderList>> getOrderList(int id);

}
