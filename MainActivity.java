package com.example.homework;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homework.R;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    EditText etVal1,etVal2;
    Button calculateBtn;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tvResult);
        etVal1 = findViewById(R.id.value1);
        etVal2 = findViewById(R.id.value2);
        radioGroup = findViewById(R.id.radioGroup);

        calculateBtn = findViewById(R.id.calculateButton);
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int val1,val2;
                double result = 0;
                val1 = Integer.parseInt(etVal1.getText().toString());
                val2 = Integer.parseInt(etVal2.getText().toString());
                int selectedOperationId = radioGroup.getCheckedRadioButtonId();
                if (selectedOperationId == R.id.radiosum){
                    result = val1 + val2;
                }
                else if (selectedOperationId == R.id.radiosub){
                    result = val1 - val2;
                }
                else if (selectedOperationId == R.id.radiomul){
                    result = val1 * val2;
                }
                else if (selectedOperationId == R.id.radiodiv){
                    result = val1 / val2;
                }
                tvResult.setText(removeZero("Result: " + result));
            }
        });
    }

    // paramater number string is array
    String removeZero(String number) {
        // declare n array = number count....
        String n[] = number.split("\\.");
        // length > 1 mean after .
        if (n.length > 1) {
            if (n[1].equals("0")){
                number = n[0];
            }
        }
        return number;
    }


}