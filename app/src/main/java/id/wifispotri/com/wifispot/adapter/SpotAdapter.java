package id.wifispotri.com.wifispot.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import id.wifispotri.com.wifispot.R;
import id.wifispotri.com.wifispot.model.Spot;

public class SpotAdapter extends RecyclerView.Adapter<SpotAdapter.ListSpotViewHolder> {
    private List<Spot> listSpot;
    private Context context;

    public SpotAdapter(Context context, List<Spot> listSpot) {
        this.context = context;
        this.listSpot = listSpot;
    }

    @Override
    public ListSpotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_spot, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mItemView.setLayoutParams(layoutParams);

        return new ListSpotViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(ListSpotViewHolder holder, int position) {
        final String status;
        final Spot mCurrent = listSpot.get(position);

        holder.namaWifi.setText(mCurrent.getNamaSpot());
        holder.lokasiWifi.setText(mCurrent.getLokasSpot());
        holder.jumlahWifi.setText(mCurrent.getJumlahSpot());
    }

    @Override
    public int getItemCount() {
        return listSpot.size();
    }

    public class ListSpotViewHolder extends RecyclerView.ViewHolder {
        final SpotAdapter mAdapter;
        private TextView namaWifi;
        private TextView lokasiWifi;
        private TextView jumlahWifi;
        private ImageView gambar;

        public ListSpotViewHolder(View itemView, SpotAdapter adapter) {
            super(itemView);
            context = itemView.getContext();
            namaWifi = itemView.findViewById(R.id.et_nama_wifi);
            jumlahWifi = itemView.findViewById(R.id.et_jumlah_wifi);
            lokasiWifi = itemView.findViewById(R.id.et_lokasi);
            this.mAdapter = adapter;
        }
    }
}
