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

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ArrayList<Foods> arrayFoods;
    private ActionBarDrawerToggle toggle;
    private Fragment fragment;
    private ActionBar toolbar;
 //   private NavigationView navigationView;

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
        binding.main.navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.account: {
                        toolbar.setTitle("Account");
                        fragment = AccountFragment.getInstance();
                        loadFragment(fragment);
                        binding.navMenuView.setCheckedItem(R.id.nav_menu_account);
                        return true;
                    }
                    case R.id.navi_home: {
                        toolbar.setTitle("Home");
                        fragment = HomeFragment.getInstance();
                        loadFragment(fragment);
                        binding.navMenuView.setCheckedItem(R.id.nav_menu_home);
                        return true;
                    }
                    case R.id.search: {
                        toolbar.setTitle("Search");
                        fragment = SearchFragment.getInstance();
                        loadFragment(fragment);
                        binding.navMenuView.setCheckedItem(R.id.nav_menu_search);
                        return true;
                    }
                    case R.id.cooking: {
                        toolbar.setTitle("Cooking");
                        fragment = CookingFragment.getInstance();
                        loadFragment(fragment);
                        binding.navMenuView.setCheckedItem(R.id.nav_menu_cooking);
                        return true;
                    }
                    default:
                        return false;
                }
            }
        });
        loadFragment(HomeFragment.getInstance());
    }

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
                        binding.main.navigation.setSelectedItemId(R.id.navi_home);
                        fragment = HomeFragment.getInstance();
                        loadFragment(fragment);
                        break;
                    case R.id.nav_menu_cooking:
                        toolbar.setTitle("Cooking");
                        binding.main.navigation.setSelectedItemId(R.id.cooking);
                        fragment = CookingFragment.getInstance();
                        loadFragment(fragment);
                        break;
                    case R.id.nav_menu_search:
                        toolbar.setTitle("Search");
                        binding.main.navigation.setSelectedItemId(R.id.search);
                        fragment = SearchFragment.getInstance();
                        loadFragment(fragment);
                        break;
                    case R.id.nav_menu_account:
                        toolbar.setTitle("Account");
                        binding.main.navigation.setSelectedItemId(R.id.account);
                        fragment = AccountFragment.getInstance();
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
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_contaibner, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
