package it.mirea.restorante.repository.room.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import it.mirea.restorante.repository.model.Order;
import it.mirea.restorante.repository.model.OrderList;

@Dao
public interface OrderDAO {

    @Insert
    void addOrder(Order order);

    @Update
    void changeOrder(Order order);

    @Delete
    void deleteOrder(Order order);


    @Query("Delete FROM `order` WHERE table_numb LIKE :id")
    LiveData<Order> deleteOrderByTab(int id);

    @Query("SELECT * FROM `order`")
    LiveData<List<Order>> getOrder();

    @Query("SELECT * FROM `order` WHERE order_id LIKE :id")
    LiveData<Order> getOrderById(int id);
}
