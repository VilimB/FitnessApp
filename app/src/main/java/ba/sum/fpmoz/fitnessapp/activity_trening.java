package ba.sum.fpmoz.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.firebase.auth.FirebaseAuth;

public class activity_trening extends AppCompatActivity {

    Button Another_section;
    Button Goal;
    Button Goal_ek1;
    Button logoutButton; // Dodan gumb za odjavu

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trening);

        Another_section = findViewById(R.id.another_section);
        Goal = findViewById(R.id.goal);
        Goal_ek1 = findViewById(R.id.goal_ek1);
        logoutButton = findViewById(R.id.button_top_right); // Pronađen gumb za odjavu

        // Postavljanje onClickListener-a za gumb za odjavu
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Odjava korisnika
                FirebaseAuth.getInstance().signOut();
                // Redirekcija na početni zaslon (activity_login1)
                Intent intent = new Intent(activity_trening.this, activity_login1.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        Another_section.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_trening.this, activity_vjezbe_guranja.class);
                startActivity(intent);
            }
        });

        Goal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_trening.this, activity_vjezbe_noge.class);
                startActivity(intent);
            }
        });

        Goal_ek1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_trening.this, activity_vjezbe_povlacenja.class);
                startActivity(intent);
            }
        });
    }
}

