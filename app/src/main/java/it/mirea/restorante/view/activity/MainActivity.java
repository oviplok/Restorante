package it.mirea.restorante.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import it.mirea.restorante.R;
import it.mirea.restorante.di.ServiceLocator;
import it.mirea.restorante.viewModel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    Button emp;
    Button client;

    private MainViewModel mainViewModel;

    //public ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emp=findViewById(R.id.emp_button);
        client=findViewById(R.id.client_button);
        ServiceLocator.getInstance().initBase(getApplication());
        initMainViewModel();

      // mBinding = ActivityMainBinding.inflate(getLayoutInflater());


        emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EmpActivity.class);
//                intent.putExtra("email", email);
//                intent.putExtra("lvl", role);
//                intent.putExtra("income_place",income_place);
                startActivity(intent);
            }
        });

        client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               // Intent intent = new Intent(MainActivity.this, OrderingAcitivity.class);
                //intent.putExtra("client", email);
                //intent.putExtra("table", role);
               // intent.putExtra("income_place",income_place);
               // startActivity(intent);
            }
        });

    }

    private void initMainViewModel() {
        mainViewModel = new ViewModelProvider(this)
                .get(MainViewModel.class);
    }
}