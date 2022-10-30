package com.latte22.sw_2022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbarMain;
    private TextView textMain;
    private TextView textDate;
    private ProgressBar testProgress;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarMain = findViewById(R.id.toolbar_main);
        textMain = findViewById(R.id.textView);
        textDate = findViewById(R.id.textDate);
        testProgress = findViewById(R.id.testprogressBar);

        textDate.setText(getDate());

//        int i = 0;
//        while(true){
//            double testLoading = ((getRemainingDays() /  getYear())*100);
//            textMain.setText("Loading... " + testLoading + "%");
//            i++;
//            if(i>1000000) break;
//        }


        // 현재 날짜 일 수 / 365 (년도 총 일 수) * 100
        double testLoading = ((getRemainingDays() /  getYear())*100);
        String strNumber = String.format("%.6f", testLoading);
        textMain.setText("Loading... " + strNumber + "%");

        //Part 1 : toolbar, FloatingActionButton (+Snackbar)
        setSupportActionBar(toolbarMain); //툴바를 사용하면 여러 레이아웃을 사용할 수 있기 때문
        getSupportActionBar().setTitle("Loading.."); //툴바 메인 이름 바뀜

        int value = (int) testLoading;
        testProgress.setProgress(value);

    }

    //뒤로가기 버튼 실행 어떻게 받아야 하는지
    //툴바에서 클릭되면 이게 실행됨
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
//            case R.id.action_test_01:
//                Toast.makeText(this, "text 01", Toast.LENGTH_SHORT).show();
//                break;
//
//            case R.id.action_test_02:
//                Toast.makeText(this, "text 02", Toast.LENGTH_SHORT).show();
//                break;
//
//            case R.id.action_test_03:
//                Toast.makeText(this, "text 03", Toast.LENGTH_SHORT).show();
//                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private String getDate() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
        String getDate = dateFormat.format(date);

        return getDate;
    }

    private long getYear(){
        Calendar calendar;
        calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);

        if (year % 400 == 0) {  //연도가 400의 배수이면 윤년
            return 366;
        } else if (year % 4 == 0 && year % 100 != 0) {  //연도가 4의 배수고 100의 배수가 아니면 윤년
            return 366;
        } else {  //나머지는 다 윤년이 아니다
            return 365;
        }
    }

    private double getRemainingDays(){

//        try {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            Date date = dateFormat.parse(getDate());
//
//            long d1 = getYear() - date.getTime();
//            long remain = d1/(1000*60*60*24);
//            if(remain < 0) remain += 1;
//
//
//
//            return remain;
//
//        } catch (ParseException e) {
//            return -2;
//        }
        int  d1 = -2;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            OffsetDateTime offset = OffsetDateTime.now();
            //textView.setText(String.valueOf(offset.getDayOfWeek() + " : " + offset.getDayOfMonth() + " : " + offset.getDayOfYear()));
            d1 = offset.getDayOfYear();
        }

        return d1;
    }
}
