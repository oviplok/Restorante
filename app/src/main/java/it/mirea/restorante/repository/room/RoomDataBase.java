package it.mirea.restorante.repository.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import it.mirea.restorante.repository.model.Client;
import it.mirea.restorante.repository.model.Employee;
import it.mirea.restorante.repository.model.Order;
import it.mirea.restorante.repository.model.OrderList;
import it.mirea.restorante.repository.model.Table;
import it.mirea.restorante.repository.room.DAO.ClientDAO;
import it.mirea.restorante.repository.room.DAO.EmployeeDAO;
import it.mirea.restorante.repository.room.DAO.OrderDAO;
import it.mirea.restorante.repository.room.DAO.OrderListDAO;
import it.mirea.restorante.repository.room.DAO.TableDAO;

@Database(entities = {Table.class, Client.class, Order.class, OrderList.class, Employee.class}, version = 1)
public abstract class RoomDataBase extends RoomDatabase {
    public abstract EmployeeDAO employeeDAO();

    public abstract TableDAO tableDAO();

    public abstract ClientDAO clientDAO();

    public abstract OrderDAO orderDAO();

    public abstract OrderListDAO orderListDAO();

    private static volatile RoomDataBase instance;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static RoomDataBase getInstance(Context context) {
        if (instance == null) {
            synchronized (RoomDataBase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDataBase.class, "restr_database")
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);

                                    databaseWriteExecutor.execute(() -> {
                                                Table table1 = new Table();
                                                table1.setTab_type(4);
                                                table1.setTable_status(true);

                                                getInstance(context).tableDAO().addTable(table1);

                                                Table table2 = new Table();
                                                table2.setTab_type(2);
                                                table2.setTable_status(true);

                                                getInstance(context).tableDAO().addTable(table2);

                                                Table table3 = new Table();
                                                table3.setTab_type(8);
                                                table3.setTable_status(true);

                                                getInstance(context).tableDAO().addTable(table3);

                                                Table table4 = new Table();
                                                table4.setTab_type(4);
                                                table4.setTable_status(true);

                                                getInstance(context).tableDAO().addTable(table4);
                                            }
                                    );
                                }
                            })
                            //.fallbackToDestructiveMigration()
                            //.allowMainThreadQueries()
                            .build();
                }
            }
        }
        return instance;
    }
}
