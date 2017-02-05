package jp.techacademy.masatoshi.tashiro.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);

        mTextView = (TextView)findViewById(R.id.text1);
    }

    @Override
    public void onClick (View v) {
        showTimePickerDialog();
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        showaisatu(hourOfDay);
                    }
                }, 0, 0, true);
        timePickerDialog.show();
    }

    private void showaisatu(int hour){
        if ( hour >= 2 && hour < 10 ) {
            mTextView.setText("おはよう");
        } else if ( hour >= 10 && hour < 18 ) {
            mTextView.setText("こんにちは");
        } else if (hour >= 18 && hour <= 23 || hour >= 0 && hour < 2) {
            mTextView.setText("こんばんは");
        }
    }
}