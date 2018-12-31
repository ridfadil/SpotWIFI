package id.wifispotri.com.wifispot.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.wifispotri.com.wifispot.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteSpotFragment extends Fragment {
    View spotView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        spotView = inflater.inflate(R.layout.fragment_favorite_spot, container, false);

        return spotView;
    }

}
