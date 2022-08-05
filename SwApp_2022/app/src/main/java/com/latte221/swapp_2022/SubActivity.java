package com.latte221.swapp_2022;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SubActivity extends AppCompatActivity {
    private Toolbar toolbarSub;
    private TextView textSub;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        toolbarSub = findViewById(R.id.toolbar_sub);
        textSub = findViewById(R.id.text_sub);
        intent = getIntent();

        String clicktext = intent.getStringExtra("text");
        textSub.setText(clicktext);

        setSupportActionBar(toolbarSub);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //뒤로가기 버튼이 생긴다(툴바에
    }

    //뒤로가기 버튼 실행 어떻게 받아야 하는지
    //툴바에서 클릭되면 이게 실행됨
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

}

