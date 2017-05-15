package pl.arnonedev.fuelanalyst.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.ToggleButton;
import pl.arnonedev.fuelanalyst.R;
import pl.arnonedev.fuelanalyst.helper.DatabaseModelHelper;
import pl.arnonedev.fuelanalyst.helper.FuelingHelper;
import pl.arnonedev.fuelanalyst.model.*;

import java.text.SimpleDateFormat;

public class FuelingDetailsActivity extends AppCompatActivity {
    public static final String FUELING_ID = "FUELING_ID";
    private Fueling fueling;
    private SimpleDateFormat dateFormat;
    private DatabaseModelHelper<Fueling> fuelingHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fueling_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        fuelingHelper = new FuelingHelper(this);
        fueling = fuelingHelper.find((int)getIntent().getLongExtra(FUELING_ID, 0));
        if (fueling != null) {
            setViews();
        }
    }

    private void setViews() {
        ((TextView) findViewById(R.id.add_fueling_date_output)).setText(dateFormat.format(fueling.getDate()));
        ((TextView) findViewById(R.id.add_fueling_odometer_output)).setText(Integer.toString(fueling.getOdometer()));
        ((TextView) findViewById(R.id.add_fueling_trip_output)).setText(Double.toString(fueling.getTrip()));
        ((TextView) findViewById(R.id.add_fueling_quantity_output)).setText(Double.toString(fueling.getQuantity()));
        ((CheckBox) findViewById(R.id.add_fueling_full_fueling_output)).setChecked(fueling.isFullFueling());
        ((TextView) findViewById(R.id.add_fueling_cost_output)).setText(Double.toString(fueling.getCost()));
        ((TextView) findViewById(R.id.add_fueling_average_consumption_output)).setText(Double.toString(fueling.getAverageConsumption()));
        ((TextView) findViewById(R.id.add_fueling_fuel_unit_cost_output)).setText(Double.toString(fueling.getFuelUnitCost()));
        setExtras();
        setDrivingStyle();
        setRoutesType();
        setTiresType();
        ((TextView) findViewById(R.id.add_fueling_fuel_type_input_output)).setText(fueling.getFuelType().getTitle());
    }

    private void setTiresType() {
        TireType tireType = fueling.getTireType();
        if (tireType.equals(TireType.MULTI_SEASON)) {
            ((ToggleButton) findViewById(R.id.add_fueling_multi_season_output)).setChecked(true);
        } else if (tireType.equals(TireType.SUMMER)) {
            ((ToggleButton) findViewById(R.id.add_fueling_summer_tire_output)).setChecked(true);
        } else  {
            ((ToggleButton) findViewById(R.id.add_fueling_winter_tire_output)).setChecked(true);
        }
    }

    private void setExtras() {
        ((ToggleButton) findViewById(R.id.add_fueling_extras_clima_output)).setChecked(fueling.getExtras().contains(AddFuelingActivity.CLIMA));
        ((ToggleButton) findViewById(R.id.add_fueling_extras_trailer_output)).setChecked(fueling.getExtras().contains(AddFuelingActivity.TRAILER));
    }

    private void setRoutesType() {
        RoutesType routesType = fueling.getRoutesType();
        if (routesType.equals(RoutesType.CITY)) {
            ((ToggleButton) findViewById(R.id.add_fueling_city_output)).setChecked(true);
        } else if (routesType.equals(RoutesType.HIGHWAY)) {
            ((ToggleButton) findViewById(R.id.add_fueling_highway_output)).setChecked(true);
        } else {
            ((ToggleButton)findViewById(R.id.add_fueling_mixed_output)).setChecked(true);
        }
    }

    private void setDrivingStyle() {
        DrivingStyle drivingStyle = fueling.getDrivingStyle();
        if (drivingStyle.equals(DrivingStyle.DYNAMIC)) {
            ((ToggleButton) findViewById(R.id.add_fueling_dynamic_driving_output)).setChecked(true);
        } else if (drivingStyle.equals(DrivingStyle.ECO)) {
            ((ToggleButton) findViewById(R.id.add_fueling_eco_driving_output)).setChecked(true);
        } else {
            ((ToggleButton) findViewById(R.id.add_fueling_normal_driving_output)).setChecked(true);
        }
    }

    public void editFueling(View view) {
        Intent intent = new Intent(this, AddFuelingActivity.class);
        intent.putExtra(FuelingActivity.FUELING, fueling);
        startActivity(intent);
    }

    public void deleteFueling(View view) {
        Vehicle vehicle = fueling.getVehicle();
        fuelingHelper.delete(fueling);
        Intent intent = new Intent(this, FuelingActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(VehicleDetailsActivity.VEHICLE, vehicle);
        startActivity(intent);
        finish();
    }
}
