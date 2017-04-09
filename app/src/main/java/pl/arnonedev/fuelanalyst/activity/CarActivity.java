package pl.arnonedev.fuelanalyst.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import pl.arnonedev.fuelanalyst.R;
import pl.arnonedev.fuelanalyst.helper.DatabaseModelHelper;
import pl.arnonedev.fuelanalyst.helper.VehicleHelper;
import pl.arnonedev.fuelanalyst.model.Vehicle;

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
        TextView savedCars = (TextView) findViewById(R.id.readed_vehicles_tmp);
        DatabaseModelHelper<Vehicle> vehicleHelper = new VehicleHelper(this);
        List<Vehicle> vehicles = vehicleHelper.findAll();
        for (Vehicle vehicle : vehicles) {
            savedCars.setText(savedCars.getText().toString() + Long.toString(vehicle.getId()) + " " + vehicle.getMake() + " " + vehicle.getModel() + ", ");
        }
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
