package com.example.studyapplication.layout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.studyapplication.R;
import com.google.android.material.navigation.NavigationView;

/**
 * NavigationView  和DrawerLayout实现漂亮的侧滑菜单
 */
public class DrawerLayoutActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);
        drawerLayout = findViewById(R.id.drawlayout);
        NavigationView navigationView = findViewById(R.id.nav);
        //设置关闭
        navigationView.setCheckedItem(R.id.a);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.close();
                return true;
            }
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(R.id.back == item.getItemId()){
            Toast.makeText(this,"back",Toast.LENGTH_SHORT).show();
        }else if(R.id.run == item.getItemId()){
            drawerLayout.openDrawer(GravityCompat.START);
            Toast.makeText(this,"run",Toast.LENGTH_SHORT).show();
        } else if (R.id.caidan == item.getItemId()) {
            Toast.makeText(this,"caidan",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}