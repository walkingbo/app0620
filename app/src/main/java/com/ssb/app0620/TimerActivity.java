package com.ssb.app0620;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {

    private TextView display;
    private Button startbtn, stopbtn;
    //인덱스 변수
    private int idx;
    //타이머 변수
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        display =(TextView)findViewById(R.id.display);
        startbtn =(Button)findViewById(R.id.startbtn);
        stopbtn =(Button)findViewById(R.id.stopbtn);

        /*
        startbtn.setOnClickListener((view)->{
            timer = new CountDownTimer(10000,1000) {
                @Override
                public void onTick(long l) {
                    idx = idx +1 ;
                    display.setText(idx+"");
                }

                @Override
                public void onFinish() {

                }
            };
            timer.start();
        });

        stopbtn.setOnClickListener((view )->{
            if(timer != null){
                timer.cancel();
                timer = null;
            }
        } );
        */
        View.OnClickListener router = (view) ->{
           if(view == startbtn) {
               timer = new CountDownTimer(10000,1000) {
                   @Override
                   public void onTick(long l) {
                       idx = idx +1 ;
                       display.setText(idx+"");
                   }

                   @Override
                   public void onFinish() {

                   }
               };
               timer.start();
           }else {
               if(timer != null){
                   timer.cancel();
                   timer = null;
               }
           }
        } ;

        startbtn.setOnClickListener(router);
        stopbtn.setOnClickListener(router);

        //구문으로 볼 때는 1부터 10까지 1초마다 텍스트 뷰에 출력해야 하지만
        //실제로는 출력하는 부분은 모두 모아서 한꺼번에 처리
        //idx는 1초 마다 1씩 증가하지만 출력은 10초 후에 한꺼번에 10을 수행
        //화면상에서는 10초 후에 10을 출력하는 것으로 보임
        /*
        try{
            for (int i =0;i<10;i=i+1) {
                idx = idx + 1;
                Log.e("idx",idx+"");
                display.setText(idx+"");
                Thread.sleep(1000);
            }
        }catch (Exception e){

        }
        */

        /*
        //타이머를 이용
        //일정한 주기 마다 메인 스레드에게 onTick메소드의 수행을 요청
        timer = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long l) {
                idx = idx+1;
                display.setText(idx+"");
            }

            @Override
            public void onFinish() {

            }
        };
        timer.start();
        */

    }
}
