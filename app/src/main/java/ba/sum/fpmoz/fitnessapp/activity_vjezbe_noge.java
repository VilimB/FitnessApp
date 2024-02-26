package ba.sum.fpmoz.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_vjezbe_noge extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vjezbe_noge);

        Button button13 = findViewById(R.id.button_13);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTrainingActivity();
            }
        });
    }

    private void openTrainingActivity() {
        Intent intent = new Intent(activity_vjezbe_noge.this, activity_trening.class);
        startActivity(intent);
    }
}