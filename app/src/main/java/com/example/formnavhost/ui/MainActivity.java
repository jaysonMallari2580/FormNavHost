package com.example.formnavhost.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;

import android.os.Bundle;

import com.example.formnavhost.R;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Navigation.findNavController(this, R.id.form_nav_host_fragment)
                .setGraph(R.navigation.form_nav_graph);
    }
}