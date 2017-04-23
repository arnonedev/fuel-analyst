package pl.arnonedev.fuelanalyst.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import pl.arnonedev.fuelanalyst.R;
import pl.arnonedev.fuelanalyst.helper.VehicleHelper;
import pl.arnonedev.fuelanalyst.model.Vehicle;

public class VehicleDetailsActivity extends AppCompatActivity {
    public static final String VEHICLE_ID = "VEHICLE_ID";
    private Vehicle vehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_details);
        long id = getIntent().getLongExtra(VEHICLE_ID, 0);
        getVehicleAndShowDetails(id);
    }

    private void getVehicleAndShowDetails(long id) {
        if (id > 0) {
            VehicleHelper vehicleHelper = new VehicleHelper(this);
            vehicle = vehicleHelper.find((int) id);
            if(vehicle != null) {
                setViews(vehicle);
            }
        }
    }

    private void setViews(Vehicle vehicle) {
        ((TextView) findViewById(R.id.vehicle_make_output)).setText(vehicle.getMake());
        ((TextView) findViewById(R.id.vehicle_model_output)).setText(vehicle.getModel());
        ((TextView) findViewById(R.id.year_of_manufacture_output)).setText(Integer.toString(vehicle.getYearOfManufacture()));
        ((TextView) findViewById(R.id.weight_output)).setText(vehicle.getWeight() + " kg");
        ((TextView) findViewById(R.id.fuel_type_output)).setText(vehicle.getFuelType().getTitle());
        ((TextView) findViewById(R.id.licence_number_output)).setText(vehicle.getLicenseNumber());
        ((TextView) findViewById(R.id.power_output)).setText(vehicle.getPower() + " KM");
        ((TextView) findViewById(R.id.engine_capacity_output)).setText(vehicle.getEngineCapacity() + " cm3");
        ((TextView) findViewById(R.id.odometer_add_vehicle_output)).setText(vehicle.getOdometer() + " " + vehicle.getOdometerUnit().getTitle());
        ((TextView) findViewById(R.id.transmission_output)).setText(vehicle.getTransmissionType().getTitle());
        ((TextView) findViewById(R.id.odometer_unit_output)).setText(vehicle.getOdometerUnit().getTitle());
        ((TextView) findViewById(R.id.body_type_output)).setText(vehicle.getBodyType().getTitle());
    }

    public void editVehicle(View view) {

    }
}
