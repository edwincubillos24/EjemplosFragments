package com.edwinacubillos.ejemplosfragments;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements OpInterface {

    FragmentManager fm;
    FragmentTransaction ft;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        OperacionFragment fragment = new OperacionFragment();
        ft.add(R.id.frame, fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void openDataFragment(String data) {
        Bundle args = new Bundle();
        args.putString("data",data);

        ft = fm.beginTransaction();

        DataFragment fragment = new DataFragment();
        fragment.setArguments(args);

        ft.replace(R.id.frame, fragment).commit();
        ft.addToBackStack("data");
    }

    @Override
    public void openOperacionFragment() {
        ft = fm.beginTransaction();
        OperacionFragment fragment = new OperacionFragment();
        ft.replace(R.id.frame, fragment).commit();
    }
}
