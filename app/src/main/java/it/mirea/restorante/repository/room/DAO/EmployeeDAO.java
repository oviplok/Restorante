package it.mirea.restorante.repository.room.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import it.mirea.restorante.repository.model.Employee;
import it.mirea.restorante.repository.model.Order;

@Dao
public interface EmployeeDAO {

    @Insert
    void addEmp(Employee employee);

    @Update
    void changeEmp(Employee employee);

    @Delete
    void deleteEmp(Employee employee);

    @Query("SELECT * FROM employee WHERE employee_id LIKE :id")
    LiveData<Employee> getPlace(int id);
}
