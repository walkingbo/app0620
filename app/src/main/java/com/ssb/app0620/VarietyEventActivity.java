package com.ssb.app0620;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class VarietyEventActivity extends AppCompatActivity {
    private EditText edit;
    private Button hidebtn;
    private LinearLayout linear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variety_event);

        edit = (EditText)findViewById(R.id.edit);
        hidebtn =(Button)findViewById(R.id.hidebtn);
        linear =(LinearLayout)findViewById(R.id.linear);

        //키보드 관리 객체 생성
        final InputMethodManager imm =(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        //버튼을 눌렀을 때의 이벤트 처리
        hidebtn.setOnClickListener((view)->{
            imm.hideSoftInputFromWindow(edit.getWindowToken(),0);
        });

        //메인 뷰 영역을 터치했을 때의 이벤트 처리
        linear.setOnTouchListener(((view, event) -> {
            imm.hideSoftInputFromWindow(edit.getWindowToken(),0);

            return true;
        }));

    }
}
