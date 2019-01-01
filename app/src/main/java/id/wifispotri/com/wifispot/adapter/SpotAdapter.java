package id.wifispotri.com.wifispot.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import id.wifispotri.com.wifispot.R;
import id.wifispotri.com.wifispot.model.Spot;

public class SpotAdapter extends RecyclerView.Adapter<SpotAdapter.ListSpotViewHolder> {
    private List<Spot> listSpot;
    private Context context;
    int hit = 1;
    int hitFav = 1;

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
    public void onBindViewHolder(final ListSpotViewHolder holder, int position) {
        final String status;
        final Spot mCurrent = listSpot.get(position);

        holder.namaWifi.setText(mCurrent.getNamaSpot());
        holder.lokasiWifi.setText(mCurrent.getLokasiSpot());
        holder.jumlahWifi.setText(mCurrent.getJumlahSpot());
        holder.layoutExpand.setVisibility(View.GONE);
        holder.imgExpand.setImageResource(R.drawable.up);
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
                if (hitFav % 2 == 0) {
                    holder.favorite.setImageResource(R.drawable.likewhite);
                    hitFav++;
                } else {
                    holder.favorite.setImageResource(R.drawable.like);
                    hitFav++;
                }
            }
        });
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
        private ImageView imgExpand;
        private ImageView favorite;
        private LinearLayout layoutExpand;
        private LinearLayout expander;

        public ListSpotViewHolder(View itemView, SpotAdapter adapter) {
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
