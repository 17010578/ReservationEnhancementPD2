package sg.edu.rp.c346.reservation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_cash extends AppCompatActivity {

    Button btnBack;
    Button btnCash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash);

        btnBack = findViewById(R.id.buttonBack);
        btnCash = findViewById(R.id.buttonCash);

        Intent intentReceived = getIntent();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), activity_payment.class);
                startActivity(intent);
            }
        });

        btnCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), activity_end.class);
                startActivity(intent);
            }
        });

    }
}
