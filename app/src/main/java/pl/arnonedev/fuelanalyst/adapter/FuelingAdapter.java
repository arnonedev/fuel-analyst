package pl.arnonedev.fuelanalyst.adapter;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import pl.arnonedev.fuelanalyst.R;
import pl.arnonedev.fuelanalyst.activity.FuelingDetailsActivity;
import pl.arnonedev.fuelanalyst.model.Fueling;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Arek on 2017-05-09.
 */

public class FuelingAdapter extends RecyclerView.Adapter<FuelingAdapter.ViewHolder> {
    private final SimpleDateFormat dateFormat;
    private List<Fueling> fuelings;
    private ViewGroup parent;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public ViewHolder(CardView itemView) {
            super(itemView);
            cardView = itemView;
        }
    }

    public FuelingAdapter(List<Fueling> fuelings) {
        this.fuelings = fuelings;
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fueling_card, parent, false);
        this.parent = parent;
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Fueling fueling = fuelings.get(position);
        CardView cardView = holder.cardView;
        TextView fuelingDate = (TextView) cardView.findViewById(R.id.fueling_date);
        TextView fuelingOdometer = (TextView) cardView.findViewById(R.id.fueling_odometer);
        TextView fuelingTrip = (TextView) cardView.findViewById(R.id.fueling_trip);
        TextView fuelingQuantity = (TextView) cardView.findViewById(R.id.fueling_quantity);
        TextView fuelingAverage = (TextView) cardView.findViewById(R.id.fueling_average);
        fuelingDate.setText(dateFormat.format(fueling.getDate()));
        fuelingOdometer.setText(Integer.toString(fueling.getOdometer()));
        fuelingTrip.setText(Double.toString(fueling.getTrip()));
        fuelingQuantity.setText(Double.toString(fueling.getQuantity()));
        fuelingAverage.setText(String.format("%.2f", fueling.getAverageConsumption()));
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parent.getContext(), FuelingDetailsActivity.class);
                intent.putExtra(FuelingDetailsActivity.FUELING_ID, fueling.getId());
                parent.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return fuelings.size();
    }
}
