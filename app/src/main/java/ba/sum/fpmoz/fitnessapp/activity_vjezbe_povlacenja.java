package ba.sum.fpmoz.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_vjezbe_povlacenja extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vjezbe_povlacenja);

        Button button14 = findViewById(R.id.button_14);
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTrainingActivity();
            }
        });
    }

    private void openTrainingActivity() {
        Intent intent = new Intent(activity_vjezbe_povlacenja.this, activity_trening.class);
        startActivity(intent);
    }
}