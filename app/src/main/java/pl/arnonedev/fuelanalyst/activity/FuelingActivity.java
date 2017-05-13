package pl.arnonedev.fuelanalyst.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import pl.arnonedev.fuelanalyst.R;
import pl.arnonedev.fuelanalyst.adapter.FuelingAdapter;
import pl.arnonedev.fuelanalyst.helper.DatabaseModelHelper;
import pl.arnonedev.fuelanalyst.helper.FuelingHelper;
import pl.arnonedev.fuelanalyst.model.Fueling;
import pl.arnonedev.fuelanalyst.model.Vehicle;

import java.util.List;

public class FuelingActivity extends AppCompatActivity {
    public static final String FUELING = "FUELING";

    private Vehicle vehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fueling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        vehicle = (Vehicle) getIntent().getSerializableExtra(VehicleDetailsActivity.VEHICLE);
        List<Fueling> fuelings = getFuelings();
        createCards(fuelings);
    }

    private void createCards(List<Fueling> fuelings) {
        RecyclerView fuelingsRecycler = (RecyclerView) findViewById(R.id.fueling_recycler);
        FuelingAdapter fuelingAdapter = new FuelingAdapter(fuelings);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        fuelingsRecycler.setAdapter(fuelingAdapter);
        fuelingsRecycler.setLayoutManager(layoutManager);
    }

    private List<Fueling> getFuelings() {
        DatabaseModelHelper<Fueling> fuelingHelper = new FuelingHelper(this);
        return fuelingHelper.findAllByVehicleId((int) vehicle.getId());
    }

    public void addFueling(View view) {
        Intent intent = new Intent(this, AddFuelingActivity.class);
        intent.putExtra(VehicleDetailsActivity.VEHICLE, vehicle);
        startActivity(intent);
    }
}
