# CustomBottomNavigation
![alt text](https://github.com/sudheer76/CustomBottomNavigation/blob/master/screenshot.jpg)


add this dependency into build.gradle(Module:app)



    
  *  implementation 'com.github.sudheer76:BottomNavigation:1.1.1'
}

add this code into build.gradle(Project:yourProjectName)
     
   *  allprojects {
     
    repositories {
    
        google()
        
        jcenter()
        
        // add jitpack
        
        maven { url 'https://jitpack.io' }
      
    }
}
    
    
    
     <com.hashcodes.bottomnavigation.SpaceNavigation.SpaceNavigationView
        android:id="@+id/space"
        android:layout_width="match_parent"
        android:layout_height="60dp"
        android:layout_alignParentBottom="true"
        android:layout_gravity="bottom"
        app:centre_part_linear="false"
        app:inactive_item_color="@color/colorAccent"
        app:space_background_color="@color/white"
        app:active_item_color="@color/darkyellow"
        app:centre_button_icon="@drawable/search"
        app:layout_behavior="com.hashcodes.bottomnavigation.SpaceNavigation.SpaceNavigationViewBehavior"
        tools:ignore="MissingConstraints" />
        
        
        
        
    

          // put these lines in styles.xml section to change navigation buttons color into white   
          
       * <item name="android:navigationBarColor" tools:ignore="NewApi">@android:color/white</item>
       * <item name="android:windowLightNavigationBar" tools:ignore="NewApi">true</item>
        
        
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





*  Color.xml


 <color name="colorPrimary">#008577</color>
    <color name="colorPrimaryDark">#FFD740</color>
    <color name="colorAccent">#868686</color>
    <color name="yellow">#FFD740</color>
    <color name="darkyellow">#FFC505</color>
    <color name="lightyellow">#FFE58B</color>
    <color name="LightGray">#F1F1F1</color>
    <color name="transprent">#00FFFFFF</color>
    <color name="Grey">#b8b8b8</color>
    <color name="white">#ffffff</color>
