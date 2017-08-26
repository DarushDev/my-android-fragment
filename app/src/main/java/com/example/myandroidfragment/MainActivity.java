package com.example.myandroidfragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RageComicListFragment.OnRageComicSelected {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.root_layout, RageComicListFragment.newInstance(), "rageComicList")
                    .commit();
        }
    }

    @Override
    public void onRageComicSelected(int imageResId, String name, String description, String url) {
        final RageComicDetailsFragment detailsFragment = RageComicDetailsFragment.newInstance(imageResId, name, description, url);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root_layout, detailsFragment, "rageComicDetails")
                .addToBackStack(null)
                .commit();
    }

}
