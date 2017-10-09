package com.example.maurits.universo.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.maurits.universo.fragment.GalaxyFragment;
import com.example.maurits.universo.fragment.PlanetFragment;
import com.example.maurits.universo.fragment.StarFragment;

/**
 * Created by Maurits on 3-10-2017.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        mContext = context;
    }

    /**
     * get the fragment to show
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new PlanetFragment();
        } else if (position == 1) {
            return new StarFragment();
        } else {
            return new GalaxyFragment();
        }
    }

    /**
     * get the fragment title
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Planets";
        } else if (position == 1) {
            return "Stars";
        } else {
            return "Galaxies";
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
