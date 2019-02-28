package com.example.thanhson.cookingrecipet3h;

import android.Manifest;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.view.Gravity;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.thanhson.cookingrecipet3h.adapter.MyAdapter;
import com.example.thanhson.cookingrecipet3h.databinding.ActivityMainBinding;
import com.example.thanhson.cookingrecipet3h.fragment.AccountFragment;
import com.example.thanhson.cookingrecipet3h.fragment.CookingFragment;
import com.example.thanhson.cookingrecipet3h.fragment.HomeFragment;
import com.example.thanhson.cookingrecipet3h.fragment.SearchFragment;
import com.example.thanhson.cookingrecipet3h.model.Foods;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private ActivityMainBinding binding;
    private ArrayList<Foods> arrayFoods;
    private ActionBarDrawerToggle toggle;
    private Fragment fragment;
    private ActionBar toolbar;
    private ViewPager viewPager;
    //   private NavigationView navigationView;
    private int[] tabIcons = {
            R.drawable.home,
            R.drawable.cooking,
            R.drawable.search,
            R.drawable.avatar
    };
    private String[] LIST_PERMISSION = {
            Manifest.permission.INTERNET
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //binding.main.nav.
        setUpActionBar();
        toolbar = getSupportActionBar();
        initSliding();
        if (checkPermisson()) {
            initView();
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(4);
        viewPager.addOnPageChangeListener(this);
    }

    private boolean checkPermisson() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (String p : LIST_PERMISSION) {
                if (checkSelfPermission(p) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(LIST_PERMISSION, 0);
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (checkPermisson()) {
            initView();
        } else {
            finish();
        }
    }

    private void initView() {
        // viewPager = (ViewPager) findViewById(R.id.)
        setupViewPager(binding.viewpager);
        binding.tabs.setupWithViewPager(binding.viewpager);
        setupTabIcons();
        binding.viewpager.setPagingEnabled(false);
    }

    private void setupTabIcons() {
        binding.tabs.getTabAt(0).setIcon(tabIcons[0]);
        binding.tabs.getTabAt(1).setIcon(tabIcons[1]);
        binding.tabs.getTabAt(2).setIcon(tabIcons[2]);
        binding.tabs.getTabAt(3).setIcon(tabIcons[3]);

        //  binding.tabs.on
    }
//    private void initView() {
//        binding.main.navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                switch (menuItem.getItemId()) {
//                    case R.id.account: {
//                        toolbar.setTitle("Account");
//                        fragment = AccountFragment.getInstance();
//                        loadFragment(fragment);
//                        binding.navMenuView.setCheckedItem(R.id.nav_menu_account);
//                        return true;
//                    }
//                    case R.id.navi_home: {
//                        toolbar.setTitle("Home");
//                        fragment = HomeFragment.getInstance();
//                        loadFragment(fragment);
//                        binding.navMenuView.setCheckedItem(R.id.nav_menu_home);
//                        return true;
//                    }
//                    case R.id.search: {
//                        toolbar.setTitle("Search");
//                        fragment = SearchFragment.getInstance();
//                        loadFragment(fragment);
//                        binding.navMenuView.setCheckedItem(R.id.nav_menu_search);
//                        return true;
//                    }
//                    case R.id.cooking: {
//                        toolbar.setTitle("Cooking");
//                        fragment = CookingFragment.getInstance();
//                        loadFragment(fragment);
//                        binding.navMenuView.setCheckedItem(R.id.nav_menu_cooking);
//                        return true;
//                    }
//                    default:
//                        return false;
//                }
//            }
//        });
//        loadFragment(HomeFragment.getInstance());
//    }

    private void initSliding() {
        toggle = new ActionBarDrawerToggle(this, binding.drawlayout, R.string.app_name, R.string.app_name);
        binding.drawlayout.addDrawerListener(toggle);
        toggle.syncState();

        // thanh code
        binding.navMenuView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_menu_home:
                        toolbar.setTitle("Home");
                        fragment = HomeFragment.getInstance();
                        binding.viewpager.setCurrentItem(0);
                        loadFragment(fragment);
                        break;
                    case R.id.nav_menu_cooking:
                        toolbar.setTitle("Cooking");
                        fragment = CookingFragment.getInstance();
                        binding.viewpager.setCurrentItem(1);
                        loadFragment(fragment);
                        break;
                    case R.id.nav_menu_search:
                        toolbar.setTitle("Search");
                        fragment = SearchFragment.getInstance();
                        binding.viewpager.setCurrentItem(2);
                        loadFragment(fragment);
                        break;
                    case R.id.nav_menu_account:
                        toolbar.setTitle("Account");
                        fragment = AccountFragment.getInstance();
                        binding.viewpager.setCurrentItem(3);
                        loadFragment(fragment);
                        break;
                }
                binding.drawlayout.closeDrawer(Gravity.START);
                return true;
            }
        });
    }

    private void setUpActionBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//hien thi icon
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.frame_contaibner, fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
    }


    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        int size = binding.navMenuView.getMenu().size();
        for (int j = 0; j < size; j++) {
            binding.navMenuView.getMenu().getItem(j).setChecked(false);
        }
        if (i == 0)
            binding.navMenuView.setCheckedItem(R.id.nav_menu_home);
        else if (i == 1) {
            binding.navMenuView.setCheckedItem(R.id.nav_menu_cooking);
        } else if (i == 2) {
            binding.navMenuView.setCheckedItem(R.id.nav_menu_search);
        } else if (i == 3) {
            binding.navMenuView.setCheckedItem(R.id.nav_menu_account);
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
