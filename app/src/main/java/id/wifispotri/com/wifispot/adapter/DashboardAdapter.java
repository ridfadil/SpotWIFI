package id.wifispotri.com.wifispot.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import id.wifispotri.com.wifispot.fragment.AboutFragment;
import id.wifispotri.com.wifispot.fragment.FavoriteSpotFragment;
import id.wifispotri.com.wifispot.fragment.SpotWifiFragment;
import id.wifispotri.com.wifispot.model.Spot;

/**
 * Created by fadil on 2/4/18.
 */


public class DashboardAdapter extends FragmentStatePagerAdapter {

    private int number_tabs;
    List<Spot> listSpot = new ArrayList<>();

    public DashboardAdapter(FragmentManager fm, int number_tabs, List<Spot> listSpot) {
        super(fm);
        this.number_tabs = number_tabs;
        this.listSpot = listSpot;
    }

    //Mengembalikan Fragment yang terkait dengan posisi tertentu
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SpotWifiFragment(listSpot);
            case 1:
                return new FavoriteSpotFragment();
            case 2:
                return new AboutFragment();
            default:
                return null;
        }
    }

    //Mengembalikan jumlah tampilan yang tersedia.
    @Override
    public int getCount() {
        return number_tabs;
    }
}