package pl.arnonedev.fuelanalyst.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import pl.arnonedev.fuelanalyst.R;
import pl.arnonedev.fuelanalyst.helper.*;
import pl.arnonedev.fuelanalyst.model.Vehicle;

public class AddVechicleActivity extends AppCompatActivity {
    Vehicle vehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vechicle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if ((vehicle = (Vehicle) getIntent().getSerializableExtra(VehicleDetailsActivity.VEHICLE)) != null) {
            setViews();
        }
    }

    private void setViews() {
        ((EditText) findViewById(R.id.vehicle_make_input)).setText(vehicle.getMake());
        ((EditText) findViewById(R.id.vehicle_model_input)).setText(vehicle.getModel());
        ((EditText) findViewById(R.id.year_of_manufacture_input)).setText(Integer.toString(vehicle.getYearOfManufacture()));
        ((EditText) findViewById(R.id.weight_input)).setText(Integer.toString(vehicle.getWeight()));
        ((Spinner) findViewById(R.id.fuel_type_input)).setSelection(vehicle.getFuelType().getArrayIndex());
        ((EditText) findViewById(R.id.licence_number_input)).setText(vehicle.getLicenseNumber());
        ((EditText) findViewById(R.id.power_input)).setText(Integer.toString(vehicle.getPower()));
        ((EditText) findViewById(R.id.engine_capacity_input)).setText(Integer.toString(vehicle.getEngineCapacity()));
        ((EditText) findViewById(R.id.odometer_add_vehicle_input)).setText(Integer.toString(vehicle.getOdometer()));
        ((Spinner) findViewById(R.id.transmission_input)).setSelection(vehicle.getTransmissionType().getArrayIndex());
        ((Spinner) findViewById(R.id.odometer_unit_input)).setSelection(vehicle.getOdometerUnit().getArrayIndex());
        ((Spinner) findViewById(R.id.body_type_input)).setSelection(vehicle.getBodyType().getArrayIndex());
    }

    public void accept(View view) {
        Vehicle vehicle = new Vehicle();
        vehicle.setMake(((EditText) findViewById(R.id.vehicle_make_input)).getText().toString());
        vehicle.setModel(((EditText) findViewById(R.id.vehicle_model_input)).getText().toString());
        vehicle.setYearOfManufacture(Integer.parseInt(((EditText) findViewById(R.id.year_of_manufacture_input)).getText().toString()));
        vehicle.setWeight(Integer.parseInt(((EditText) findViewById(R.id.weight_input)).getText().toString()));
        vehicle.setFuelType(FuelTypeHelper.getFuelTypeByIndex(((Spinner) findViewById(R.id.fuel_type_input)).getSelectedItemPosition()));
        vehicle.setLicenseNumber(((EditText) findViewById(R.id.licence_number_input)).getText().toString());
        vehicle.setPower(Integer.parseInt(((EditText) findViewById(R.id.power_input)).getText().toString()));
        vehicle.setEngineCapacity(Integer.parseInt(((EditText) findViewById(R.id.engine_capacity_input)).getText().toString()));
        vehicle.setOdometer(Integer.parseInt(((EditText) findViewById(R.id.odometer_add_vehicle_input)).getText().toString()));
        vehicle.setTransmissionType(TransmissionTypeHelper.getTransmissionTypeByIndex(((Spinner) findViewById(R.id.transmission_input)).getSelectedItemPosition()));
        vehicle.setOdometerUnit(OdometerUnitHelper.getOdometerUnitByIndex(((Spinner) findViewById(R.id.odometer_unit_input)).getSelectedItemPosition()));
        vehicle.setBodyType(BodyTypeHelper.getBodyTypeByIndex(((Spinner) findViewById(R.id.body_type_input)).getSelectedItemPosition()));
        DatabaseModelHelper<Vehicle> vehicleHelper = new VehicleHelper(this);
        if (this.vehicle != null) {
            vehicle.setId(this.vehicle.getId());
            vehicleHelper.modify(vehicle);
            backToVehicleDetailsActivity();
        } else {
            vehicleHelper.save(vehicle);
            backToMainActivity();
        }
    }

    public void reject(View view) {
        if(this.vehicle == null) {
            backToMainActivity();
        } else {
            backToVehicleDetailsActivity();
        }
    }

    private void backToMainActivity() {
        Intent intent = new Intent(this, CarActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    private void backToVehicleDetailsActivity() {
        Intent intent = new Intent(this, VehicleDetailsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(VehicleDetailsActivity.VEHICLE_ID, vehicle.getId());
        startActivity(intent);
        finish();
    }
}
