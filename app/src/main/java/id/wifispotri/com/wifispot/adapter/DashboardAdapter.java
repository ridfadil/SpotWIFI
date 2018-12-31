package id.wifispotri.com.wifispot.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import id.wifispotri.com.wifispot.fragment.AboutFragment;
import id.wifispotri.com.wifispot.fragment.FavoriteSpotFragment;
import id.wifispotri.com.wifispot.fragment.SpotWifiFragment;

/**
 * Created by fadil on 2/4/18.
 */


public class DashboardAdapter extends FragmentStatePagerAdapter {

    private int number_tabs;

    public DashboardAdapter(FragmentManager fm, int number_tabs) {
        super(fm);
        this.number_tabs = number_tabs;
    }

    //Mengembalikan Fragment yang terkait dengan posisi tertentu
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SpotWifiFragment();
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