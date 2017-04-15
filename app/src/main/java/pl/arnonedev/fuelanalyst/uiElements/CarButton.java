package pl.arnonedev.fuelanalyst.uiElements;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import pl.arnonedev.fuelanalyst.R;
import pl.arnonedev.fuelanalyst.model.Vehicle;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarButton extends Fragment {
    private Vehicle vehicle;

    public CarButton() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_car_button, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            TextView make = (TextView) view.findViewById(R.id.vehicle_make_main_activity);
            TextView model = (TextView) view.findViewById(R.id.vehicle_model_main_activity);
            TextView licensesNumber = (TextView) view.findViewById(R.id.vehicle_licenses_number);
            if (vehicle != null) {
                make.setText(vehicle.getMake());
                model.setText(vehicle.getModel());
                licensesNumber.setText(vehicle.getLicenseNumber());
            }
        }
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
