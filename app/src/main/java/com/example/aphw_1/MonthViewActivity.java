package com.example.aphw_1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class MonthViewActivity extends AppCompatActivity {

    int year;
    int month;



    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();  // 인텐트를 받아 사용


        year = intent.getIntExtra("year", -1);   // 값을 읽음, 해당 되는 이름의 벨류가 없을 때 -1 리턴
        month = intent.getIntExtra("month", -1);  // 값을 읽음, 해당 되는 이름의 벨류가 없을 때 -1 리턴

        if(year == -1||month == -1) {  // year나 month가 -1이면
            month = Calendar.getInstance().get(Calendar.MONTH);  // 현재 달을 가져옴
            year = Calendar.getInstance().get(Calendar.YEAR);    // 현재 년도를 가져옴

        }


        TextView yearMonth = findViewById(R.id.year_month);  // 아이디에 해당하는 텍스트 개체를 찾음
        yearMonth.setText(year+"년 "+ (month+1) +"월"); // 텍스트를 입력



        // 다음 버튼을 눌렀을 때

        Button nextBtn = findViewById(R.id.next);  // ID로부터 대응되는 객체를 찾음
        nextBtn.setOnClickListener(new View.OnClickListener() {  // 이 함수를 통해 이벤트 리스너 등록

            @Override
            public void onClick(View v) {

                if (++month > 11) { // month를 1 증가시킨 값이 범위를 벗어나는지 확인
                    month = 0; // month 를 1월로 설정
                    year++; // year를 1 증가
                }

                Intent intent = new Intent(getApplicationContext(), MonthViewActivity.class);
                intent.putExtra("year", year);       //extra에 year 값 저장
                intent.putExtra("month", month);  // extra에 month 값 저장
                startActivity(intent); //새 액티비티의 인스턴스를 시작
                finish(); // 종료

            }
        });


        // 이전 버튼을 눌렀을 때

        Button backBtn = findViewById(R.id.back); // ID로부터 대응되는 객체를 찾음
        backBtn.setOnClickListener(new View.OnClickListener() {  // 이 함수를 통해 이벤트 리스너 등록

            @Override
            public void onClick(View v) {

                if (--month < 0) { // month를 1 감소시킨 값이 범위를 벗어나는지 확인
                    month = 11; // month 를 12월로 설정
                    year--; // year를 1 감소
                }

                Intent intent = new Intent(getApplicationContext(), MonthViewActivity.class);
                intent.putExtra("year", year);        // extra에 year 값 저장
                intent.putExtra("month", month);   // extra에 month 값 저장
                startActivity(intent); // 새 액티비티의 인스턴스를 시작
                finish(); // 종료

            }
        });
    }

    private void getLeafYear(Integer year){

    }
}