package pl.arnonedev.fuelanalyst.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import pl.arnonedev.fuelanalyst.R;

import java.util.Calendar;

public class AddFuelingActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fueling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dateView = (TextView) findViewById(R.id.add_fueling_date);
        calendar = Calendar.getInstance();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);
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
                .append("/")
                .append(month)
                .append("/")
                .append(year));
    }
}
