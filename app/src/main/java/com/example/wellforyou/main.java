package com.example.wellforyou;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;

public class main extends AppCompatActivity{
    private Context mContext;

    private FloatingActionButton sub_chatBot, sub_setting, main_fab,sub_timeline;
    private Animation fab_open, fab_close;
    private boolean isFabOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        fab_open = AnimationUtils.loadAnimation(mContext, R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(mContext, R.anim.fab_close);


        main_fab = (FloatingActionButton) findViewById(R.id.main_fab);
        sub_timeline = (FloatingActionButton) findViewById(R.id.sub_timeline);
        sub_setting = (FloatingActionButton) findViewById(R.id.sub_setting);
        sub_chatBot = (FloatingActionButton) findViewById(R.id.sub_chatBot);


        main_fab.setOnClickListener((View.OnClickListener) this);
        sub_chatBot.setOnClickListener((View.OnClickListener)this);
        sub_setting.setOnClickListener((View.OnClickListener) this);
        sub_timeline.setOnClickListener((View.OnClickListener) this);
    }

    public void onClick(@NotNull View v) {
        switch (v.getId()) {
            case R.id.main_fab:
                toggleFab();
                break;
            case R.id.sub_chatBot:
                toggleFab();
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                break;

            case R.id.sub_setting:
                toggleFab();
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

            case R.id.sub_timeline:
                toggleFab();
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void toggleFab() {
        if (isFabOpen) {
            main_fab.setImageResource(R.drawable.delete_button);
            sub_chatBot.startAnimation(fab_close);
            sub_setting.startAnimation(fab_close);
            sub_timeline.startAnimation(fab_close);
            sub_chatBot.setClickable(false);
            sub_setting.setClickable(false);
            sub_timeline.setClickable(false);
            isFabOpen = false;
        } else {
            main_fab.setImageResource(R.drawable.plus);
            sub_timeline.startAnimation(fab_open);
            sub_setting.startAnimation(fab_open);
            sub_chatBot.startAnimation(fab_open);
            sub_chatBot.setClickable(true);
            sub_setting.setClickable(true);
            sub_timeline.setClickable(true);
            isFabOpen = true;
        }
    }

}
