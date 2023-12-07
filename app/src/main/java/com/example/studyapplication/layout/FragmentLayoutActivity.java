package com.example.studyapplication.layout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.studyapplication.R;

/**
 * 指定values/themes.xml的<style name="Theme.StudyApplication" parent="Theme.MaterialComponents.DayNight.DarkActionBar">
 *     为<style name="Theme.StudyApplication" parent="Theme.MaterialComponents.DayNight.NoActionBar">
 *         表示没有头可以自己加入工具栏
 */
public class FragmentLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_layout);
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
            Toast.makeText(this,"run",Toast.LENGTH_SHORT).show();
        } else if (R.id.caidan == item.getItemId()) {
            Toast.makeText(this,"caidan",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}