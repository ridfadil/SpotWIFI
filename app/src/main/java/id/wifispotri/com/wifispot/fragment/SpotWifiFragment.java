package id.wifispotri.com.wifispot.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import id.wifispotri.com.wifispot.R;
import id.wifispotri.com.wifispot.adapter.SpotAdapter;
import id.wifispotri.com.wifispot.api.UtilsApi;
import id.wifispotri.com.wifispot.database.DBHelper;
import id.wifispotri.com.wifispot.model.Data;
import id.wifispotri.com.wifispot.model.ResponseData;
import id.wifispotri.com.wifispot.model.Spot;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpotWifiFragment extends Fragment {
    View spotView;
    DBHelper dbHelper;
    @BindView(R.id.rv_list_spot)
    RecyclerView rvListSpot;

    private List<Spot> listSpot = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private SpotAdapter mAdapter;
    String dbId = "", apiId = "", spotName = "", jumlahSpot = "", locationSpot = "", longitideSpot = "", latitudeSpot = "";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        spotView = inflater.inflate(R.layout.fragment_spot_wifi, container, false);
        dbHelper = new DBHelper(getContext());

        /*listSpot.add(new Spot("1", "Tsel WIFI", "3", "Ujung Berung", "23456789", "098765432"));
        listSpot.add(new Spot("2", "Hexagon WIFI", "1", "Cicadas", "23456789", "098765432"));
        listSpot.add(new Spot("3", "Lunax WIFI", "2", "Maranatha", "23456789", "098765432"));
        listSpot.add(new Spot("4", "Oxygen WIFI", "4", "Cibiru", "23456789", "098765432"));
        listSpot.add(new Spot("5", "Speedy WIFI", "6", "Buah Batu", "23456789", "098765432"));
        listSpot.add(new Spot("6", "YouthFi WIFI", "5", "Cicalengka", "23456789", "098765432"));*/

        Call<ResponseData> call = UtilsApi.getAPIService().getSpotWifi();
        call.enqueue(new Callback<ResponseData>() {
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
                        mAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Toast.makeText(getActivity(), "Aktifkan koneksi internet Anda", Toast.LENGTH_LONG).show();
            }
        });

        mRecyclerView = spotView.findViewById(R.id.rv_list_spot);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new SpotAdapter(getActivity(), listSpot, dbHelper);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        return spotView;
    }
}
