package com.hashcodes.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.hashcodes.bottomnavigation.SpaceNavigation.SpaceItem;
import com.hashcodes.bottomnavigation.SpaceNavigation.SpaceNavigationView;
import com.hashcodes.bottomnavigation.SpaceNavigation.SpaceOnClickListener;
import com.hashcodes.test.Fragments.Cart;
import com.hashcodes.test.Fragments.HelpDesk;
import com.hashcodes.test.Fragments.Home;
import com.hashcodes.test.Fragments.Profile;
import com.hashcodes.test.Fragments.Search;

/**
 * Code written by Sudheer on 06.12.2019
 */


public class MainActivity extends AppCompatActivity {
    private SpaceNavigationView spaceNavigationView;
    private FragmentTransaction fragmentTransaction;
    private FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //call first fragment as default
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,new Home());
        fragmentTransaction.commit();

        spaceNavigationView =  findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.addSpaceItem(new SpaceItem(R.id.navigation_first,"HOME", R.drawable.home));
        spaceNavigationView.addSpaceItem(new SpaceItem(R.id.navigation_second, "TRENDING", R.drawable.help_desk));
        spaceNavigationView.addSpaceItem(new SpaceItem(R.id.navigation_third, "HOME", R.drawable.shoping_cart));
        spaceNavigationView.addSpaceItem(new SpaceItem(R.id.navigation_forth, "SEARCH", R.drawable.user));
        spaceNavigationView.shouldShowFullBadgeText(false);

        spaceNavigationView.setCentreButtonId(R.id.navigation_centre);
        spaceNavigationView.setCentreButtonIconColorFilterEnabled(false);

        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,new Search());
                fragmentTransaction.commit();
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {

                if (itemIndex==0){
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container,new Home());
                    fragmentTransaction.commit();

                }else if (itemIndex==1){
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container,new HelpDesk());
                    fragmentTransaction.commit();

                }else if (itemIndex==2){
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container,new Cart());
                    fragmentTransaction.commit();

                }else if (itemIndex==3){
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container,new Profile());
                    fragmentTransaction.commit();

                }else{
                    Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onItemReselected(int itemIndex, String itemName) {}
        });

        spaceNavigationView.showIconOnly();

    }

}
