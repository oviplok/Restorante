package it.mirea.restorante.repository.room.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import it.mirea.restorante.repository.model.Client;
import it.mirea.restorante.repository.model.OrderList;

@Dao
public interface ClientDAO {

    @Insert
    void addClient(Client client);

    @Update
    void changeClient(Client client);

    @Delete
    void deleteClient(Client client);

    @Query("Delete FROM client WHERE table_numb LIKE :id")
    LiveData<Client> DeleteClientByTable(int id);

    @Query("SELECT * FROM OrderList")
    LiveData<List<Client>> getClients();

//    @Query("SELECT * FROM OrderList WHERE order_id LIKE :id")
//    LiveData<List<Client>> getClientByOrder(int id);
}
