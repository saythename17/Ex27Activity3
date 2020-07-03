package com.icandothisallday2020.ex27activity3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        et=findViewById(R.id.et);
    }

    public void click(View view) {
        //MainActivity 에 돌려줄 데이터를 EditText 에서 얻기
        String s=et.getText().toString();
        //MainActivity 로 부터 온 Intent 객체 참조
        Intent intent=getIntent();
        //되돌려줄 데이터 intent 에 추가
        intent.putExtra("Name",s);
        intent.putExtra("Age",25);
        //intent 에게 이 RESULT-OK 설정
        this.setResult(RESULT_OK,intent);
        //Request Code 와 별개로 제대로 된 값을 입력했다는
        // ok sign 을 주고 받음
        //뒤로가기를 눌렀을 때는 RESULT_CANCEL
        finish();//Activity 종료
    }
}
