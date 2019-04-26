package sg.edu.rp.c346.reservation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_end extends AppCompatActivity {

    Button btnEnd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        btnEnd = findViewById(R.id.buttonHome);

            Intent intentReceived = getIntent();

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), activity_main.class);
                startActivity(intent);
            }
        });
    }
}
