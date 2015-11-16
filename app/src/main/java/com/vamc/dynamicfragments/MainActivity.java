package com.vamc.dynamicfragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment();
            }
        });

        getFragmentManager().beginTransaction()
                .add(R.id.fragmentContainer, new Fragment1(), AppConstants.FRAGMENT1_TAG)
                .commit();
    }

    public void changeFragment() {
        Fragment1 myFragment = (Fragment1)getFragmentManager()
                .findFragmentByTag(AppConstants.FRAGMENT1_TAG);
        if (myFragment!=null && myFragment.isVisible()) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new Fragment2(), AppConstants.FRAGMENT2_TAG)
                    .commit();
        } else {
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new Fragment1(), AppConstants.FRAGMENT1_TAG)
                    .commit();
        }
    }
}
