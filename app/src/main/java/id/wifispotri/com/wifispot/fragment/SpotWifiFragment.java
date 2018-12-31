package id.wifispotri.com.wifispot.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import id.wifispotri.com.wifispot.R;
import id.wifispotri.com.wifispot.adapter.SpotAdapter;
import id.wifispotri.com.wifispot.model.Spot;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpotWifiFragment extends Fragment {
    View spotView;
    @BindView(R.id.rv_list_spot)
    RecyclerView rvListSpot;

    private List<Spot> listSpot = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private SpotAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        spotView = inflater.inflate(R.layout.fragment_spot_wifi, container, false);

        listSpot.add(new Spot("Tsel WIFI", "5", "Ujung Berung"));
        listSpot.add(new Spot("Tsel WIFI", "5", "Ujung Berung"));
        listSpot.add(new Spot("Tsel WIFI", "5", "Ujung Berung"));
        listSpot.add(new Spot("Tsel WIFI", "5", "Ujung Berung"));
        listSpot.add(new Spot("Tsel WIFI", "5", "Ujung Berung"));
        mRecyclerView = spotView.findViewById(R.id.rv_list_spot);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new SpotAdapter(getActivity(), listSpot);
        mRecyclerView.setAdapter(mAdapter);

        return spotView;
    }
}
