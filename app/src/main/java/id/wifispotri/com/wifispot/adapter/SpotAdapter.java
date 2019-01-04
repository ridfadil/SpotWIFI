package id.wifispotri.com.wifispot.adapter;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import id.wifispotri.com.wifispot.R;
import id.wifispotri.com.wifispot.activity.DashboardActivity;
import id.wifispotri.com.wifispot.database.DBHelper;
import id.wifispotri.com.wifispot.model.Spot;

public class SpotAdapter extends RecyclerView.Adapter<SpotAdapter.ListSpotViewHolder> {
    private List<Spot> listSpot;
    private Context context;
    private DBHelper dbHelper;
    int hit = 1, hitFav = 0, fav;
    String dbId = "", apiId = "", spotName = "", jumlahSpot = "", locationSpot = "", longitideSpot = "", latitudeSpot = "";

    public SpotAdapter(Context context, List<Spot> listSpot, DBHelper dbHelper) {
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
        if (dbHelper.cekData(mCurrent.getIdApi())) {
            holder.favorite.setImageResource(R.drawable.like);
        } else {
            holder.favorite.setImageResource(R.drawable.likewhite);
        }
        holder.namaWifi.setText(mCurrent.getNamaSpot());
        holder.lokasiWifi.setText(mCurrent.getLokasiSpot());
        holder.jumlahWifi.setText(mCurrent.getJumlahSpot());
        holder.layoutExpand.setVisibility(View.GONE);
        holder.imgExpand.setImageResource(R.drawable.down);
        holder.btnLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:" + mCurrent.getLatitude() + "," + mCurrent.getLongitude());
                //Uri gmmIntentUri = Uri.parse("https://www.google.com/maps/@?api=1&map_action=map&center=" + mCurrent.getLatitude() + "," + mCurrent.getLongitude() + "&zoom=15&basemap=satellite&layer=transit");
                //Uri gmmIntentUri = Uri.parse("https://www.google.com/maps/@?api=1&map_action=pano&pano=tu510ie_z4ptBZYo2BGEJg&viewpoint=" + mCurrent.getLatitude() + "," + mCurrent.getLongitude() + "&heading=-45&pitch=38&fov=80");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                context.startActivity(mapIntent);

            }
        });

        holder.btnLokasiView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("https://www.google.com/maps/@?api=1&map_action=pano&pano=tu510ie_z4ptBZYo2BGEJg&viewpoint=" + mCurrent.getLatitude() + "," + mCurrent.getLongitude() + "&heading=-45&pitch=38&fov=80");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                context.startActivity(mapIntent);
            }
        });

        holder.expander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hit % 2 == 0) {
                    holder.layoutExpand.setVisibility(View.GONE);
                    holder.imgExpand.setImageResource(R.drawable.down);
                    hit++;
                } else {
                    holder.layoutExpand.setVisibility(View.VISIBLE);
                    holder.imgExpand.setImageResource(R.drawable.up);
                    hit++;
                }
            }
        });
        holder.favorite.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                if (hitFav % 2 == 0) {
                    holder.favorite.setImageResource(R.drawable.likewhite);
                    fav = 0;
                    hitFav++;
                } else {
                    holder.favorite.setImageResource(R.drawable.like);
                    fav = 1;
                    hitFav++;
                }

                if (fav == 1) {
                    if (dbHelper.cekData(mCurrent.getIdApi())) {
                        Toast.makeText(context, "Data sudah ada di favorite", Toast.LENGTH_SHORT).show();
                        holder.favorite.setImageResource(R.drawable.like);
                    } else {
                        getData(position, holder);
                        if (dbHelper.MasukanData(apiId, spotName, jumlahSpot, locationSpot, longitideSpot, latitudeSpot)) {
                            Toast.makeText(context, "Data di Masukan ke daftar Favorite", Toast.LENGTH_SHORT).show();
                            notifyDataSetChanged();

                            Intent i = new Intent(context, DashboardActivity.class);
                            i.setFlags(i.FLAG_ACTIVITY_CLEAR_TOP);

                            ActivityOptions options =
                                    ActivityOptions.makeCustomAnimation(context, R.anim.fade_in, R.anim.fade_out);
                            context.startActivity(i, options.toBundle());
                        } else {
                            Toast.makeText(context, "Gagal Di Masukan ke daftar Favorite", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                if (fav == 0) {
                    String id = dbHelper.getIdDb(mCurrent.getIdApi());
                    if (!id.equals("")) {
                        dbHelper.DeleteData(id);
                        Toast.makeText(context, "dihilangkan dari Favorite", Toast.LENGTH_SHORT).show();
                        notifyDataSetChanged();

                        Intent i = new Intent(context, DashboardActivity.class);
                        i.setFlags(i.FLAG_ACTIVITY_CLEAR_TOP);
                        ActivityOptions options =
                                ActivityOptions.makeCustomAnimation(context, R.anim.fade_in, R.anim.fade_out);
                        context.startActivity(i, options.toBundle());
                    }
                }
            }
        });
    }

    public void getData(int position, ListSpotViewHolder holder) {
        final Spot mCurrent = listSpot.get(position);
        dbId = mCurrent.getIdDb();
        apiId = mCurrent.getIdApi();
        spotName = mCurrent.getNamaSpot();
        jumlahSpot = mCurrent.getJumlahSpot();
        locationSpot = mCurrent.getLokasiSpot();
        latitudeSpot = mCurrent.getLatitude();
        longitideSpot = mCurrent.getLongitude();
    }

    @Override
    public int getItemCount() {
        return listSpot.size();
    }

    public class ListSpotViewHolder extends RecyclerView.ViewHolder {
        final SpotAdapter mAdapter;
        private TextView namaWifi;
        private Button btnLokasi;
        private Button btnLokasiView;
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
            btnLokasi = itemView.findViewById(R.id.btn_lokasi);
            btnLokasiView = itemView.findViewById(R.id.btn_lokasi_view);
            this.mAdapter = adapter;
        }
    }
}
