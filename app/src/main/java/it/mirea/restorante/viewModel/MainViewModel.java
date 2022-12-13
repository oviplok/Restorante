package it.mirea.restorante.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import it.mirea.restorante.di.ServiceLocator;
import it.mirea.restorante.repository.RepoTasks;
import it.mirea.restorante.repository.model.Client;
import it.mirea.restorante.repository.model.Table;

public class MainViewModel extends AndroidViewModel {
    //PlaceOps placeOps =new PlaceOps();
    RepoTasks repository;

    Client client;
    Table table;
   // Place place;

    public LiveData<Client> ClientLiveData;
    public LiveData<Table> TableLiveData;

    public MainViewModel(@NonNull Application application) {
        super(application);
        ServiceLocator.getInstance().initBase(application);
        this.repository = ServiceLocator.getInstance().getRepository();
       // mapFireBaseRepository = new MapFireBaseRepository();
    }


}
