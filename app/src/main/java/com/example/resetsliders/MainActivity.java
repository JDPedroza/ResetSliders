package com.example.resetsliders;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.resetsliders.controller.activity.MainActivityController;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements MainFragment.OnNumeroAleatorio{

    private AppBarConfiguration mAppBarConfiguration;
    private MainFragment mainFrag = null;
    private BurnerAssembly burnerAssembly = null;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mainFrag!=null){
                    MainActivityController.Companion.changeText(mainFrag);
                }else if(burnerAssembly!=null){
                    MainActivityController.Companion.resetFragment(burnerAssembly);
                }
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.nav_test){
                    Toast.makeText(getApplicationContext(),"OK",Toast.LENGTH_SHORT).show();
                    MainActivityController.Companion.addFragment(getSupportFragmentManager(), findViewById(R.id.contenedorFragment), mainFrag = new MainFragment());
                }else if(item.getItemId()==R.id.nav_gallery){
                    MainActivityController.Companion.addFragment(getSupportFragmentManager(), findViewById(R.id.contenedorFragment), burnerAssembly = new BurnerAssembly());
                }else if(item.getItemId()==R.id.nav_slideshow){
                }
                return false;
            }
        });

    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {



        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.getCurrentDestination();
        Toast.makeText(getApplicationContext(), "Prueba"+navController.getCurrentDestination().getLabel(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void actualizado(int numero) {

    }
}
