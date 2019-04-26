package sg.edu.rp.c346.reservation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class activity_menu extends AppCompatActivity {


    Button btnNext;
    Button btnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        btnNext = findViewById(R.id.buttonN);

        Intent intentReceived = getIntent();


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), activity_order.class);
                startActivity(intent);
            }
        });



    }
}
