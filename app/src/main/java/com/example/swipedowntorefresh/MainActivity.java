package com.example.swipedowntorefresh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = findViewById(R.id.refreshLayout);
        textView = findViewById(R.id.tv1);

        //If enabled true swipeRefresh work otherwise not
        //swipeRefreshLayout.setEnabled(false);
        //swipeRefresh BackgroundColor
        //swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Color.RED);
        //swipeRefresh circle line color,also use multiple colors
        swipeRefreshLayout.setColorSchemeColors(Color.BLUE,Color.RED,Color.DKGRAY);
        //swipeRefresh circle line color,also use multiple colors
        //swipeRefreshLayout.setColorSchemeResources(R.color.pDarkGreen, R.color.blue, R.color.orange, R.color.pFullLightGreen);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                textView.setText("Now I am Refreshed");

                // To keep animation for 3 seconds
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //For stopping  swipeRefresh
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);


            }
        });


    }
}