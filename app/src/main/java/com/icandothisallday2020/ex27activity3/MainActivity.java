package com.icandothisallday2020.ex27activity3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
    }
    public void click(View view) {
        //SecondActivity 실행 & 결과 받기
        Intent intent=new Intent(this, SecondActivity.class);
        startActivityForResult(intent,17);
        //parameter2:택배기사(intent) 식별번호
    }

    // startActivityForResult()로 실행된 Activity 종료 후
    //MainActivity 가 다시 화면에 보여질때 자동 실행되는 콜백메소드
    //(SecondActivity 에 갔던 Intent(택배기사)가 돌아오면 자동실행)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //내가 보낸 택배기사가 맞는지 requestCode 통해 확인
        switch (requestCode){
            case 17://SecondActivity 의 OK 결과 확인(cancel 거르기)
                if(resultCode==RESULT_OK){
                    //intent(3번째 파라미터:data) 가 가져온 data 얻기
                    String name=data.getStringExtra("Name");
                    int age=data.getIntExtra("Age",0);
                    tv.setText(name+"\t"+age);
                }
                break;
        }
    }
}
