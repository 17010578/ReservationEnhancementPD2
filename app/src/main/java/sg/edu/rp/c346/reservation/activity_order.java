package sg.edu.rp.c346.reservation;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class activity_order extends AppCompatActivity {

    Button btnView;
    Button btnNext;
    Button btnReserve;
    EditText etMain;
    EditText etSides;
    EditText etDrinks;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        btnView = findViewById(R.id.buttonView);
        btnNext = findViewById(R.id.buttonReset);
        etDrinks = findViewById(R.id.editTextHintDrinks);
        etMain = findViewById(R.id.editTextMain);
        etSides = findViewById(R.id.editTextSides);


        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getMain =etMain.getText().toString().trim();
                String getSides = etSides.getText().toString().trim();
                String getDrinks = etDrinks.getText().toString().trim();

                Log.i("getMain", getMain.length()+"");
                Log.i("getSides", getSides.length()+"");
                Log.i("getDrinks", getDrinks.length()+"");



                String output = String.format("Current Order\n\nMain: %s\nSides: %s\nDrinks: %s"
                        ,getMain, getSides, getDrinks );
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(activity_order.this);
                myBuilder.setTitle("Confirm Your Order");
                myBuilder.setMessage(output);
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Confirm",null);
                myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();


            }
        });

        Intent intentReceived = getIntent();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), activity_payment.class);
                startActivity(intent);
            }
        });
    }
}
