package pl.arnonedev.fuelanalyst.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import pl.arnonedev.fuelanalyst.R;
import pl.arnonedev.fuelanalyst.helper.DatabaseModelHelper;
import pl.arnonedev.fuelanalyst.helper.VehicleHelper;
import pl.arnonedev.fuelanalyst.model.Vehicle;
import pl.arnonedev.fuelanalyst.uiElements.CarButton;

import java.util.List;

public class CarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        readSavedVehicles();
    }

    private void readSavedVehicles() {
        DatabaseModelHelper<Vehicle> vehicleHelper = new VehicleHelper(this);
        List<Vehicle> vehicles = vehicleHelper.findAll();
        for(Vehicle vehicle : vehicles) {
            CarButton button = new CarButton();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            button.setVehicle(vehicle);
            ft.add(R.id.vehicles_buttons, (Fragment)button);
            ft.commit();
        }
    }

    public void addNewCar(View view) {
        Intent intent = new Intent(this, AddVechicleActivity.class);
        startActivity(intent);
    }

}
