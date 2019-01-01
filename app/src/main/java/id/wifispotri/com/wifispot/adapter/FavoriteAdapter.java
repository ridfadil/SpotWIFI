package id.wifispotri.com.wifispot.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import id.wifispotri.com.wifispot.R;
import id.wifispotri.com.wifispot.database.DBHelper;
import id.wifispotri.com.wifispot.model.Spot;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ListSpotViewHolder> {
    private List<Spot> listSpot;
    private Context context;
    private DBHelper dbHelper;
    int hit = 1;
    String dbId = "", apiId = "", spotName = "", jumlahSpot = "", locationSpot = "", longitideSpot = "", latitudeSpot = "";

    public FavoriteAdapter(Context context, List<Spot> listSpot, DBHelper dbHelper) {
        this.context = context;
        this.listSpot = listSpot;
        this.dbHelper = dbHelper;
    }

    @Override
    public ListSpotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_spot, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mItemView.setLayoutParams(layoutParams);

        return new ListSpotViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(final ListSpotViewHolder holder, final int position) {
        final String status;
        final Spot mCurrent = listSpot.get(position);

        holder.namaWifi.setText(mCurrent.getNamaSpot());
        holder.lokasiWifi.setText(mCurrent.getLokasiSpot());
        holder.jumlahWifi.setText(mCurrent.getJumlahSpot());
        holder.layoutExpand.setVisibility(View.GONE);
        holder.imgExpand.setImageResource(R.drawable.up);
        holder.favorite.setImageResource(R.drawable.like);
        holder.expander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hit % 2 == 0) {
                    holder.layoutExpand.setVisibility(View.GONE);
                    holder.imgExpand.setImageResource(R.drawable.up);
                    hit++;
                } else {
                    holder.layoutExpand.setVisibility(View.VISIBLE);
                    holder.imgExpand.setImageResource(R.drawable.down);
                    hit++;
                }
            }
        });

        holder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.DeleteData(mCurrent.getIdDb());
                Toast.makeText(context, "dihilangkan dari Favorite", Toast.LENGTH_SHORT).show();
                listSpot.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    public void getData(int position, ListSpotViewHolder holder) {
        final Spot mCurrent = listSpot.get(position);
        dbId = mCurrent.getIdDb();
        apiId = mCurrent.getIdApi();
        jumlahSpot = mCurrent.getJumlahSpot();
        spotName = holder.namaWifi.getText().toString();
        locationSpot = holder.lokasiWifi.getText().toString();
        latitudeSpot = mCurrent.getLatitude();
        longitideSpot = mCurrent.getLongitude();
    }

    @Override
    public int getItemCount() {
        return listSpot.size();
    }

    public class ListSpotViewHolder extends RecyclerView.ViewHolder {
        final FavoriteAdapter mAdapter;
        private TextView namaWifi;
        private TextView lokasiWifi;
        private TextView jumlahWifi;
        private ImageView imgExpand;
        private ImageView favorite;
        private LinearLayout layoutExpand;
        private LinearLayout expander;

        public ListSpotViewHolder(View itemView, FavoriteAdapter adapter) {
            super(itemView);
            context = itemView.getContext();
            imgExpand = itemView.findViewById(R.id.img_expand);
            layoutExpand = itemView.findViewById(R.id.layout_expand);
            expander = itemView.findViewById(R.id.expander);
            favorite = itemView.findViewById(R.id.favorite);
            namaWifi = itemView.findViewById(R.id.et_nama_wifi);
            jumlahWifi = itemView.findViewById(R.id.et_jumlah_wifi);
            lokasiWifi = itemView.findViewById(R.id.et_lokasi);
            this.mAdapter = adapter;
        }
    }
}

