package id.wifispotri.com.wifispot.activity;

import android.app.ActivityOptions;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.wifispotri.com.wifispot.R;
import id.wifispotri.com.wifispot.adapter.DashboardAdapter;
import id.wifispotri.com.wifispot.adapter.SearchAdapter;
import id.wifispotri.com.wifispot.adapter.SpotAdapter;
import id.wifispotri.com.wifispot.api.UtilsApi;
import id.wifispotri.com.wifispot.database.DBHelper;
import id.wifispotri.com.wifispot.model.Data;
import id.wifispotri.com.wifispot.model.ResponseData;
import id.wifispotri.com.wifispot.model.Spot;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchSpotctivity extends AppCompatActivity {

    @BindView(R.id.rv_search_list)
    RecyclerView rvSearchList;
    @BindView(R.id.search)
    EditText search;
    @BindView(R.id.btn_search)
    Button btnSearch;

    private List<Spot> listSpot = new ArrayList<>();
    private RecyclerView mRecyclerView;
    DBHelper dbHelper;
    EditText etSpot;
    private SearchAdapter mAdapter;
    String dbId = "", apiId = "", spotName = "", jumlahSpot = "", locationSpot = "", longitideSpot = "", latitudeSpot = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_spotctivity);
        etSpot = (EditText) findViewById(R.id.search);
        ButterKnife.bind(this);
        dbHelper = new DBHelper(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Cari Spot");

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listSpot.clear();
                String spot = etSpot.getText().toString();
                Call<ResponseData> call = UtilsApi.getAPIService().searchSpot(spot);
                call.enqueue(new Callback<ResponseData>() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                        if (response.isSuccessful()) {
                            ResponseData responseSpot = response.body();
                            List<Data> data = responseSpot.getData();
                            for (int i = 0; i < data.size(); i++) {
                                apiId = data.get(i).getId();
                                jumlahSpot = data.get(i).getJumlah();
                                locationSpot = data.get(i).getLokasi();
                                spotName = data.get(i).getLokasi();
                                latitudeSpot = data.get(i).getLatitude();
                                longitideSpot = data.get(i).getLongitude();
                                listSpot.add(new Spot(apiId, locationSpot, jumlahSpot, locationSpot, longitideSpot, latitudeSpot));
                            }
                        }
                        if (listSpot.size() < 1) {
                            Toast.makeText(SearchSpotctivity.this, "Maaf Spot Tidak di Temukan", Toast.LENGTH_SHORT).show();
                        }
                        mRecyclerView = findViewById(R.id.rv_search_list);
                        mRecyclerView.setLayoutManager(new LinearLayoutManager(SearchSpotctivity.this));
                        mAdapter = new SearchAdapter(SearchSpotctivity.this, listSpot, dbHelper);
                        mRecyclerView.setAdapter(mAdapter);
                        mAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<ResponseData> call, Throwable t) {
                        Toast.makeText(SearchSpotctivity.this, "Aktifkan koneksi internet Anda", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home : {
                finish();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
