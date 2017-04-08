package pl.arnonedev.fuelanalyst.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;
import pl.arnonedev.fuelanalyst.R;

public class CarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void selectCar(View view) {
        Toast toast = Toast.makeText(this, "Wybrano samochód", Toast.LENGTH_LONG);
        toast.show();
    }

    public void addNewCar(View view) {
        Intent intent = new Intent(this, AddVechicleActivity.class);
        startActivity(intent);
    }

}
