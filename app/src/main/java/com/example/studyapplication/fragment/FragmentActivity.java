package com.example.studyapplication.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.studyapplication.EmptyActivity;
import com.example.studyapplication.R;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment3);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button button = findViewById(R.id.fragbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FragmentActivity.this,""+view.getId(),Toast.LENGTH_SHORT).show();
                if(R.id.fragbutton == view.getId()){
                    replaceFragment(new Fragment2());
                }
            }
        });
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.right,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}