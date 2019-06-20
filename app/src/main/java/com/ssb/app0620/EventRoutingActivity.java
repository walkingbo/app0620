package com.ssb.app0620;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EventRoutingActivity extends AppCompatActivity {

    private TextView display;
    private Button btn1,btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_routing);

        display = (TextView)findViewById(R.id.routedisplay);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);

        /*
        btn1.setOnClickListener((view) ->{
            display.setText("kotlin");
        } );

        btn2.setOnClickListener((view )->{
            display.setText("java");
        } );
        */

        //이벤트 처리 객체
        View.OnClickListener router =
        //이벤트가 발생한 뷰를 구분해서 분기문 작성
                (view) -> {if(view == btn1){
                    display.setText("kotlin");
                }else {
                    display.setText("java");
                }
                };
        //2개의 뷰에 발생한 이벤트를 하나의 객체를 가지고 처리
        btn1.setOnClickListener(router);
        btn2.setOnClickListener(router);



    }
}
