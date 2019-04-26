package sg.edu.rp.c346.reservation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class activity_payment extends AppCompatActivity {

    RadioButton rdbCash;
    RadioButton rdbCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        rdbCard = findViewById(R.id.radioButtonCard);
        rdbCash = findViewById(R.id.radioButtonCash);

        Intent intentReceived = getIntent();

        rdbCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), activity_cash.class);
                startActivity(intent);
            }
        });


        rdbCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), activity_card.class);
                startActivity(intent);
            }
        });

    }
}
