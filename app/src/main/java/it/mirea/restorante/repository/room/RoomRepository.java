package it.mirea.restorante.repository.room;

import android.app.Application;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

import it.mirea.restorante.repository.RepoTasks;
import it.mirea.restorante.repository.model.Client;
import it.mirea.restorante.repository.model.Order;
import it.mirea.restorante.repository.model.OrderList;
import it.mirea.restorante.repository.model.Table;
import it.mirea.restorante.repository.room.DAO.ClientDAO;
import it.mirea.restorante.repository.room.DAO.EmployeeDAO;
import it.mirea.restorante.repository.room.DAO.OrderDAO;
import it.mirea.restorante.repository.room.DAO.OrderListDAO;
import it.mirea.restorante.repository.room.DAO.TableDAO;

public class RoomRepository implements RepoTasks {
    private ClientDAO clientDAO;
    private EmployeeDAO employeeDAO;
    private OrderDAO orderDAO;
    private OrderListDAO orderListDAO;
    private TableDAO tableDAO;
    private LiveData<Order> order;
    private LiveData<List<OrderList>> order_list;
    private LiveData<List<Table>> tableList;



    public RoomRepository(Application application){
        RoomDataBase db = RoomDataBase.getInstance(application);
        clientDAO= db.clientDAO();
        employeeDAO = db.employeeDAO();
        orderDAO = db.orderDAO();
        orderListDAO = db.orderListDAO();
        tableDAO = db.tableDAO();
       // order_list=orderListDAO.getOrderLists();
       // allPlaces = placeDAO.getAllPlaces();
       // allUsers = userDAO.getAllUsers();
    }

    public void deleteClientByTable(int table_numb){
        RoomDataBase.databaseWriteExecutor.execute(()->{
            clientDAO.DeleteClientByTable(table_numb);
        });
    }

    public LiveData<Table> getTable(int table_num){
        LiveData<Table> tables = new MutableLiveData<>();
        tables = tableDAO.getTable(table_num);
        return tables;
    }

    public void deleteClient(Client client){
//        LiveData<Table> tables = new MutableLiveData<>();
//        tables = tableDAO.getTable(client.getTable_numb());
//        changeTableStatusTrue(tables);
        RoomDataBase.databaseWriteExecutor.execute(()->{
            clientDAO.deleteClient(client);
        });
    }
//MAIN CLIENT
    public void addClient(Client client){
//

        LiveData<List<Table>> tables = new MutableLiveData<>();
//        tables = getFreeTables(client.getPeople());
//
//        client.setTable_numb(tables.getValue().get(0).getTable_numb());
//
//        changeTableStatusFalse(tables);
//        addOrder(client.getClient_id(),client.getTable_numb());
        RoomDataBase.databaseWriteExecutor.execute(()->{
            clientDAO.addClient(client);
        });
    }
//LiveData<List<Table>>
    public void changeTableStatusFalse(Table newTable){
//        Table table = new Table();
//        table.setTable_status(false);
//        table.setTable_numb(newTable.getValue().get(0).getTable_numb());
//        table.setTab_type(newTable.getValue().get(0).getTab_type());

        RoomDataBase.databaseWriteExecutor.execute(()->{
            tableDAO.changeTable(newTable);
        });

    }

    public void changeTableStatusTrue(Table newTable){
//        Table table=new Table();
//        table.setTable_status(true);
//        table.setTable_numb(newTable.getValue().getTable_numb());
//        table.setTab_type(newTable.getValue().getTab_type());


        RoomDataBase.databaseWriteExecutor.execute(()->{
            tableDAO.changeTable(newTable);
        });
    }

    public LiveData<List<Table>> getFreeTables(int people){
        tableList=tableDAO.getFreeTables(people);
        return tableList;
    }

    public void addOrder(int client_id,int tab_numb){
        Order order1 = new Order();
        order1.setClient_id(client_id);
        order1.setTable_numb(tab_numb);
        RoomDataBase.databaseWriteExecutor.execute(()->{
            orderDAO.addOrder(order1);
        });
    }

    public LiveData<Order> getOrderById(int id){
        LiveData<Order> ordich;

        ordich= orderDAO.getOrderById(id);
        return ordich;
    }

//MAIN ORDER
    public  void deleteOrderByTab(int tab){
        //deleteOrderLines(id_order);

      //  LiveData<Order> ordich=getOrderById(tab);
      // deleteClientByTable(ordich.getValue().getTable_numb());

        RoomDataBase.databaseWriteExecutor.execute(()->{
            orderDAO.deleteOrderByTab(tab);
        });
    }





    public void addOrderLine(OrderList order_list){
        RoomDataBase.databaseWriteExecutor.execute(()->{
            orderListDAO.addOrderLine(order_list);
        });
    }

    public  void deleteOrderLines(int id_order){
        //PlaceDTO placeDTO = PlaceDTO.convertFromPlace(place);
        RoomDataBase.databaseWriteExecutor.execute(()->{
            orderListDAO.DeleteOrderList(id_order);
            //placeDAO.deletePlace(placeDTO);
        });
    }


    public LiveData<List<OrderList>> getOrderList(int id, LifecycleOwner owner){
        order_list=orderListDAO.getOrderList(id);
        return order_list;
    }



//    public LiveData<PlaceDTO> findPlace(String place_name, LifecycleOwner owner) {
//        searchPlace = placeDAO.getPlace(place_name);
//        return searchPlace;
//    }

}
