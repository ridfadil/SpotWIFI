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
import id.wifispotri.com.wifispot.R;
import id.wifispotri.com.wifispot.adapter.FavoriteAdapter;
import id.wifispotri.com.wifispot.adapter.SpotAdapter;
import id.wifispotri.com.wifispot.database.DBHelper;
import id.wifispotri.com.wifispot.model.Spot;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteSpotFragment extends Fragment {
    View spotView;
    DBHelper dbHelper;
    @BindView(R.id.rv_list_spot)
    RecyclerView rvListSpot;

    private List<Spot> listSpot = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private FavoriteAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        spotView = inflater.inflate(R.layout.fragment_favorite_spot, container, false);
        dbHelper = new DBHelper(getContext());
        listSpot = dbHelper.tampilData();

        mRecyclerView = spotView.findViewById(R.id.rv_list_spot);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new FavoriteAdapter(getActivity(), listSpot, dbHelper);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        return spotView;
    }

}
