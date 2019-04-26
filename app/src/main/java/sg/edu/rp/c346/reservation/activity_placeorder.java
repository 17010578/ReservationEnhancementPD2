package sg.edu.rp.c346.reservation;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class activity_placeorder extends AppCompatActivity {
    Button btnReset;
    Button btnReserve;
    EditText etName;
    EditText etMobile;
    EditText etPax;
    CheckBox cbSmoke;
    CheckBox cbSeat;
    TextView tvshow1;
    TextView tvshow2;
    EditText etDay;
    EditText etTime;


    String name = "";
    String date = "";
    String time = "";
    String pax = "";
    String phone = "";
    int Year = 0;
    int Day = 0;
    int Month = 0;
    int Hour = 0;
    int Minute = 0;
    Calendar calander = Calendar.getInstance();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReserve = findViewById(R.id.buttonConfirm);
        btnReset = findViewById(R.id.buttonReset);
        etName = findViewById(R.id.editTextHint1);
        etMobile = findViewById(R.id.editTextHint2);
        etPax = findViewById(R.id.editTextHint3);
        cbSmoke = findViewById(R.id.checkBoxSmoking);
        cbSeat = findViewById(R.id.checkBoxSeat);
        tvshow1 = findViewById(R.id.textViewDay);
        tvshow2 = findViewById(R.id.textViewTime);
        etDay = findViewById(R.id.editTextDay);
        etTime = findViewById(R.id.editTextTime);

        Day = calander.get(Calendar.DAY_OF_MONTH);
        Month = calander.get(Calendar.MONTH);
        Year = calander.get(Calendar.YEAR);
        Hour = calander.get(Calendar.HOUR);
        Minute = calander.get(Calendar.MINUTE);

        Intent intentReceived = getIntent();


        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String getName =etName.getText().toString().trim();
                String getMobile = etMobile.getText().toString().trim();
                String getPax = etPax.getText().toString().trim();
                String getDate = etDay.getText().toString().trim();
                String getTime = etTime.getText().toString().trim();

                Log.i("getName", getName.length()+"");
                Log.i("getMobile", getMobile.length()+"");
                Log.i("getPax", getPax.length()+"");



                String isSmoke = "";
                if (cbSmoke.isChecked() ){
                    isSmoke = "Smoking";
                }else{
                    isSmoke = "Non-Smoking";
                }

                String isSeat = "";
                if (cbSeat.isChecked() ){
                    isSeat = "Window Seat";
                }else{
                    isSeat = "Non-Window Seat";
                }

                Intent intentReceived = getIntent();
                Intent intent = new Intent(getBaseContext(), activity_order.class);
                startActivity(intent);
            }

        });

        etDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        etDay.setText("Date: " + dayOfMonth +"/"+(month+1)+"/"+year);
                        Year = year;
                        Month = month;
                        Day = dayOfMonth;
                    }
                };

                DatePickerDialog myDateDialog = new DatePickerDialog(activity_placeorder.this, myDateListener, Year, Month, Day);
                myDateDialog.show();
            }
        });

        etTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String currMin = "";
                        if (minute < 10){
                            currMin += "0"+minute;
                        } else {
                            currMin += minute+"";
                        }
                        etTime.setText("Time: "+ hourOfDay+ ":" + currMin);
                        Hour = hourOfDay;
                        Minute = minute;
                    }
                };
                TimePickerDialog myTimeDialog = new TimePickerDialog(activity_placeorder.this, myTimeListener, 23, 30,true);
                myTimeDialog.show();
            }
        });



        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                etName.setText(null);
//                etPax.setText(null);
//                etMobile.setText(null);
//                cbSmoke.setChecked(false);
//                Day = calander.get(Calendar.DAY_OF_MONTH);
//                Month = calander.get(Calendar.MONTH);
//                Year = calander.get(Calendar.YEAR);
//                Hour = calander.get(Calendar.HOUR);
//                Minute = calander.get(Calendar.MINUTE);
                String getName =etName.getText().toString().trim();
                String getMobile = etMobile.getText().toString().trim();
                String getPax = etPax.getText().toString().trim();
                String getDate = etDay.getText().toString().trim();
                String getTime = etTime.getText().toString().trim();

                Log.i("getName", getName.length()+"");
                Log.i("getMobile", getMobile.length()+"");
                Log.i("getPax", getPax.length()+"");



                String isSmoke = "";
                if (cbSmoke.isChecked() ){
                    isSmoke = "Smoking";
                }else{
                    isSmoke = "Non-Smoking";
                }
                String isSeat = "";
                if (cbSeat.isChecked() ){
                    isSeat = "Window Seat";
                }else{
                    isSeat = "Non-Window Seat";
                }
                String output = String.format("New Registration\n\nName: %s\nSmoking: %s\nSize: %s\nDate: %s\nTime: %s\nSeat: %s"
                        ,getName, isSmoke, getPax , getDate, getTime, isSeat);
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(activity_placeorder.this);
                myBuilder.setTitle("Confirm Your Order");
                myBuilder.setMessage(output);
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Confirm",null);
                myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();


            }
        });

    }
}
