package com.ith8.esg.common;

import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ith8.esg.R;

public abstract class BaseActivity extends AppCompatActivity {

    private FragmentManager fm;
    private FragmentTransaction ft;
    private String fragment=null;
//    public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    startFragment(HomeFragment.newInstance("",""));
//                    return true;
//                case R.id.navigation_dashboard:
//                    startFragment(DashbordFragment.newInstance("",""));
//                    return true;
//                case R.id.navigation_notifications:
//                    startFragment(NotificationFragment.newInstance("",""));
//                    return true;
//            }
//            return false;
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fm = getSupportFragmentManager();



    }

     public  abstract FloatingActionButton getFab();
     public  abstract View.OnClickListener getHomeFabListener();


        public  void startFragment(Fragment fragment){
          this.fragment = fragment.getClass().getSimpleName();
          ft = fm.beginTransaction();
          ft.replace(R.id.frame_container, fragment, this.fragment)
                  .addToBackStack(this.fragment)
                  .commitAllowingStateLoss();

//          setListenerByFragment(this.fragment);
      }



//    private void setListenerByFragment(String fragment) {
//
//        if (getFab() != null) {
//            if (HomeFragment.class.getSimpleName().equalsIgnoreCase(fragment)) {
//                showFab();
//                getFab().setOnClickListener(getHomeFabListener());
//            }
//            if(DashbordFragment.class.getSimpleName().equalsIgnoreCase(fragment)){
//                hideFab();
//            }
////
//        }
//    }
    public void showFab() {
        if (getFab() != null)
            getFab().show();
    }

    public void hideFab() {
        if (getFab() != null) {
            getFab().hide();
        }
    }
}




