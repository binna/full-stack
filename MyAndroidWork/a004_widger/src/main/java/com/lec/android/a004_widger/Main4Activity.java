package com.lec.android.a004_widger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    RadioGroup rg;
    Button btnResult;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        // 체크박스와는 달리
        // RadioButton 은 각각 선언하는 것이 아니라
        // RadioGroup 으로 선언하여 사용

        // 여기서 shift + F6을 이용하여 이름 변경하면
        // 모든 이름이 변경됨. 레이아웃, java 파일 전부..!!
        rg = findViewById(R.id.rg);
        btnResult = findViewById(R.id.btnResult);
        tvResult = findViewById(R.id.tvResult);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 선택된 라디오 버튼의 id 값 가져오기
                int id = rg.getCheckedRadioButtonId();

                // 위 id 값을 통해 RadioButton 객체 가져오기
                RadioButton rb = findViewById(id);

                tvResult.setText("결과: " + rb.getText());
            }
        });

        // 라디오 버튼을 선택했을 때도 위와 같은 동작하게 하기
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            // checkedId : 선택된 라디오버튼의 id
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                tvResult.setText("결과: " + rb.getText());

            }
        });
    }
}
