package pl.arnonedev.fuelanalyst.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.*;
import pl.arnonedev.fuelanalyst.R;
import pl.arnonedev.fuelanalyst.helper.DatabaseModelHelper;
import pl.arnonedev.fuelanalyst.helper.FuelTypeHelper;
import pl.arnonedev.fuelanalyst.helper.FuelingHelper;
import pl.arnonedev.fuelanalyst.model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddFuelingActivity extends AppCompatActivity {
    public static final String CLIMA = "CLIMA";
    public static final String TRAILER = "TRAILER";

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year;
    private int month;
    private int day;
    private Fueling fueling;
    private SimpleDateFormat dateFormat;
    private Vehicle vehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fueling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        vehicle = (Vehicle) getIntent().getSerializableExtra(VehicleDetailsActivity.VEHICLE);
        if ((fueling = (Fueling) getIntent().getSerializableExtra(FuelingActivity.FUELING)) != null) {
            if (vehicle == null) {
                vehicle = fueling.getVehicle();
            }
            setViews();
        } else {
            dateView = (TextView) findViewById(R.id.add_fueling_date);
            calendar = Calendar.getInstance();

            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH);
            day = calendar.get(Calendar.DAY_OF_MONTH);
            showDate(year, month + 1, day);
        }
    }

    private void setViews() {
        ((TextView) findViewById(R.id.add_fueling_date)).setText(dateFormat.format(fueling.getDate()));
        ((EditText) findViewById(R.id.add_fueling_odometer)).setText(Integer.toString(fueling.getOdometer()));
        ((EditText) findViewById(R.id.add_fueling_trip)).setText(Double.toString(fueling.getTrip()));
        ((EditText) findViewById(R.id.add_fueling_quantity)).setText(Double.toString(fueling.getQuantity()));
        ((CheckBox) findViewById(R.id.add_fueling_full_fueling)).setChecked(fueling.isFullFueling());
        ((EditText) findViewById(R.id.add_fueling_cost)).setText(Double.toString(fueling.getCost()));
        ((TextView) findViewById(R.id.add_fueling_average_consumption)).setText(Double.toString(fueling.getAverageConsumption()));
        ((TextView) findViewById(R.id.add_fueling_fuel_unit_cost)).setText(Double.toString(fueling.getFuelUnitCost()));
        setExtras();
        setDrivingStyle();
        setRoutesType();
        setTiresType();
        ((Spinner) findViewById(R.id.add_fueling_fuel_type_input)).setSelection(fueling.getFuelType().getArrayIndex());
    }

    private void setTiresType() {
        TireType tireType = fueling.getTireType();
        if (tireType.equals(TireType.MULTI_SEASON)) {
            ((ToggleButton) findViewById(R.id.add_fueling_multi_season)).setChecked(true);
        } else if (tireType.equals(TireType.SUMMER)) {
            ((ToggleButton) findViewById(R.id.add_fueling_summer_tire)).setChecked(true);
        } else  {
            ((ToggleButton) findViewById(R.id.add_fueling_winter_tire)).setChecked(true);
        }
    }

    private void setExtras() {
        ((ToggleButton) findViewById(R.id.add_fueling_extras_clima)).setChecked(fueling.getExtras().contains(CLIMA));
        ((ToggleButton) findViewById(R.id.add_fueling_extras_trailer)).setChecked(fueling.getExtras().contains(TRAILER));
    }

    private void setRoutesType() {
        RoutesType routesType = fueling.getRoutesType();
        if (routesType.equals(RoutesType.CITY)) {
            ((ToggleButton) findViewById(R.id.add_fueling_city)).setChecked(true);
        } else if (routesType.equals(RoutesType.HIGHWAY)) {
            ((ToggleButton) findViewById(R.id.add_fueling_highway)).setChecked(true);
        } else {
            ((ToggleButton)findViewById(R.id.add_fueling_mixed)).setChecked(true);
        }
    }

    private void setDrivingStyle() {
        DrivingStyle drivingStyle = fueling.getDrivingStyle();
        if (drivingStyle.equals(DrivingStyle.DYNAMIC)) {
            ((ToggleButton) findViewById(R.id.add_fueling_dynamic_driving)).setChecked(true);
        } else if (drivingStyle.equals(DrivingStyle.ECO)) {
            ((ToggleButton) findViewById(R.id.add_fueling_eco_driving)).setChecked(true);
        } else {
            ((ToggleButton) findViewById(R.id.add_fueling_normal_driving)).setChecked(true);
        }
    }

    public void setDate(View view) {
        showDialog(0);
    }


    @Override
    protected Dialog onCreateDialog(int id) {
        return new DatePickerDialog(this, myDateListener, year, month, day);
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            showDate(year, month+1, dayOfMonth);
        }
    };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder()
                .append(day)
                .append("-")
                .append(month)
                .append("-")
                .append(year));
    }

    public void saveFueling(View view) throws ParseException {
        double trip = Double.parseDouble(((EditText) findViewById(R.id.add_fueling_trip)).getText().toString()) * 1.0;
        double quantity = Double.parseDouble(((EditText) findViewById(R.id.add_fueling_quantity)).getText().toString()) * 1.0;
        double cost = Double.parseDouble(((EditText) findViewById(R.id.add_fueling_cost)).getText().toString()) * 1.0;
        Fueling fueling = new Fueling();
        fueling.setDate(dateFormat.parse(((TextView)findViewById(R.id.add_fueling_date)).getText().toString()));
        fueling.setOdometer(Integer.parseInt(((EditText) findViewById(R.id.add_fueling_odometer)).getText().toString()));
        fueling.setTrip(trip);
        fueling.setQuantity(quantity);
        fueling.setFullFueling(((CheckBox) findViewById(R.id.add_fueling_full_fueling)).isChecked());
        fueling.setCost(cost);
        fueling.setAverageConsumption((quantity/trip)*100);
        fueling.setFuelUnitCost(cost / quantity);
        fueling.setExtras(getExtras());
        fueling.setDrivingStyle(getDrivingStyle());
        fueling.setRoutesType(getRoutesType());
        fueling.setTireType(getTiresType());
        fueling.setFuelType(FuelTypeHelper.getFuelTypeByIndex(((Spinner) findViewById(R.id.add_fueling_fuel_type_input)).getSelectedItemPosition()));
        fueling.setVehicle(vehicle);
        DatabaseModelHelper<Fueling> fuelingHelper = new FuelingHelper(this);
        if (this.fueling == null) {
            fuelingHelper.save(fueling);
            backToFuelingActivity();
        } else {
            fueling.setId(this.fueling.getId());
            fuelingHelper.modify(fueling);
            backToFuelingDetailsActivity();
        }
    }

    private TireType getTiresType() {
        if (((ToggleButton) findViewById(R.id.add_fueling_summer_tire)).isChecked()) {
            return TireType.SUMMER;
        } else if (((ToggleButton) findViewById(R.id.add_fueling_winter_tire)).isChecked()) {
            return TireType.WINTER;
        } else {
            return TireType.MULTI_SEASON;
        }
    }

    private RoutesType getRoutesType() {
        if (((ToggleButton) findViewById(R.id.add_fueling_city)).isChecked()) {
            return RoutesType.CITY;
        } else if (((ToggleButton) findViewById(R.id.add_fueling_highway)).isChecked()) {
            return RoutesType.HIGHWAY;
        } else {
            return RoutesType.MIXED;
        }
    }

    private DrivingStyle getDrivingStyle() {
        if (((ToggleButton) findViewById(R.id.add_fueling_eco_driving)).isChecked()) {
            return DrivingStyle.ECO;
        } else if (((ToggleButton) findViewById(R.id.add_fueling_dynamic_driving)).isChecked()) {
            return DrivingStyle.DYNAMIC;
        } else {
            return DrivingStyle.NORMAL;
        }
    }

    private String getExtras() {
        String result = "";
        if(((ToggleButton)findViewById(R.id.add_fueling_extras_clima)).isChecked()) {
            result += CLIMA + "|";
        }
        if (((ToggleButton) findViewById(R.id.add_fueling_extras_trailer)).isChecked()) {
            result += TRAILER;
        }
        return result;
    }

    private void backToFuelingActivity() {
        Intent intent = new Intent(this, FuelingActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(VehicleDetailsActivity.VEHICLE, vehicle);
        startActivity(intent);
        finish();
    }

    private void backToFuelingDetailsActivity() {
        Intent intent = new Intent(this, FuelingDetailsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(FuelingDetailsActivity.FUELING_ID, fueling.getId());
        startActivity(intent);
        finish();
    }

    public void rejectFueling(View view) {
        if (this.fueling == null) {
            backToFuelingActivity();
        } else {
            backToFuelingDetailsActivity();
        }
    }
}
