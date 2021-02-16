package com.cookandroid.myapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// 메인쓰레드 => onCreate() => UI 쓰레드
//                         => 이벤트 쓰레드[      ] 확인
//                         => 이벤트 리스너(OS)[ A버튼 ]
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    
    private TextView tvTitle;
    private LinearLayout linearLayout;
    
    //매니페스트에서 설정된 자바 파일이 실행될 때 가장 먼저 실행되는 함수 onCreate()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main); // 그림 그리는 함수

        // A버튼 리스너 등록 코드 작성 => 안녕이라고 출력
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
        SharedPreferences sp = getSharedPreferences("movie", MODE_PRIVATE);
        String title = sp.getString("title", "없음");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");

        SharedPreferences sp = getSharedPreferences("movie", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("title", "바람과 함께 사라지다.");
        editor.commit();
    }
}
