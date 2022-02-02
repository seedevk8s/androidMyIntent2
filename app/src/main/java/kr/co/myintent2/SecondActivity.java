package kr.co.myintent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("Second 액티비티");

        Intent intent = getIntent();

        String calc = intent.getStringExtra("Calc");
        int calValue = 0;
        if (calc.equals("+")) {
            calValue = intent.getIntExtra("Num1", 0) + intent.getIntExtra("Num2",0);
        } else if (calc.equals("-")) {
            calValue = intent.getIntExtra("Num1", 0) - intent.getIntExtra("Num2", 0);
        } else if (calc.equals("*")) {
            calValue = intent.getIntExtra("Num1", 0) * intent.getIntExtra("Num2", 0);
        } else {
            calValue = intent.getIntExtra("Num1", 0) / intent.getIntExtra("Num2", 0);
        }

        final int retValue = calValue;

        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("answer", retValue);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}



























