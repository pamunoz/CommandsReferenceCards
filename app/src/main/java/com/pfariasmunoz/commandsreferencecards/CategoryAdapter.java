package com.pfariasmunoz.commandsreferencecards;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Pablo Farias on 28-09-16.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;
    private String[] tabTitles;
    private int TAB_COUNT;

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param context is the context of the app
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        tabTitles = context.getResources().getStringArray(R.array.tab_titles);
        TAB_COUNT = tabTitles.length;
    }

    @Override
    public Fragment getItem(int position) {
        return new EmacsFragment();
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
