package com.example.giaodien_lt5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
TextView tvkq,tvAlert;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvkq = findViewById(R.id.tv);
        tvAlert = findViewById(R.id.tv1);
        btn= findViewById(R.id.btn);
    }

    public void openDatePicker(View view) {
        DatePickerDialog datePickerDialog;
       Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+7:00"));
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
       final int day = cal.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                tvkq.setText(year + "/" +(month+1)+"/"+dayOfMonth);
            }
        },year,month,day);
        datePickerDialog.show();
    }

    public void openTimePicker(View view) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+7:00"));
        final  int hour = cal.get(Calendar.HOUR_OF_DAY);
        final  int minute = cal.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog= new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                tvkq.setText(hourOfDay + ":" + minute);
            }
        } ,hour ,minute , false);
        timePickerDialog.show();
    }

    public void openProgressDialog(View view) {
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading.....");
        progressDialog.show();
    }


    public void openToast(View view) {
    }

    @SuppressLint("NewApi")
    public void openCustomAlert(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setView(R.layout.my_alert);
        AlertDialog alertDialog = builder.show();
        final TextView tvQ = alertDialog.findViewById(R.id.tv1);
        Button btn = alertDialog.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvQ.setText("Successfully");
            }
        });

    }

    public void openAlertSingle(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Alert !!!!");
        builder.setMessage("Yeu minh k :)) " );
        builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("Dong Y", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    public void openAlertList(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Alert !!!!");
        String[] family = new String[]{"Bo","Me", "Me" ,"Linh"};
        builder.setItems(family, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    public void openAlertMulti(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Alert !!!!");
        String[] family = new String[]{"Bo","Me", "Me" ,"Linh"};
        builder.setMultiChoiceItems(family, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
}
