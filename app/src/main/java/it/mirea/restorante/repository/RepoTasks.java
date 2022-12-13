package it.mirea.restorante.repository;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

import java.util.List;

import it.mirea.restorante.repository.model.Client;
import it.mirea.restorante.repository.model.Order;
import it.mirea.restorante.repository.model.OrderList;
import it.mirea.restorante.repository.model.Table;

public interface RepoTasks {
    void deleteClientByTable(int table_numb);
    <T extends Table> LiveData<Table> getTable(int table_num) ;
    void addClient(Client client);
    void deleteClient(Client client);
    void changeTableStatusFalse(Table newTable);
    void changeTableStatusTrue(Table newTable);
    <T extends Table> LiveData<List<Table>> getFreeTables(int people);
    void addOrder(int client_id,int tab_numb);
    <T extends Order> LiveData<Order> getOrderById(int id);
    void deleteOrderByTab(int tab);
    void addOrderLine(OrderList order_list);
    void deleteOrderLines(int id_order);
    <T extends Order> LiveData<List<OrderList>> getOrderList(int id, LifecycleOwner owner);

    //<T extends PlaceDTO> LiveData<PlaceDTO> findPlace(String place_name, LifecycleOwner owner);



}
