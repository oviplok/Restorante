package it.mirea.restorante.di;

import android.app.Application;

import it.mirea.restorante.repository.RepoTasks;
import it.mirea.restorante.repository.room.RoomRepository;

public class ServiceLocator {

    private static ServiceLocator instance = null;

    private ServiceLocator() {};

    public static ServiceLocator getInstance() {
        if (instance == null) {
            instance = new ServiceLocator();
        }
        return instance;
    }
    private RepoTasks repoTasks;

    public void initBase(Application app) {
        if (repoTasks == null) {
            repoTasks = new RoomRepository(app);
        }
    }

    public RepoTasks getRepository() {
       // if (repoTasks == null) {
       //    initBase(getA);
       // }
        return repoTasks;
    }
}
