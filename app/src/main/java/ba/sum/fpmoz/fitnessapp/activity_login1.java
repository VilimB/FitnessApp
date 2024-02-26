package ba.sum.fpmoz.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

import ba.sum.fpmoz.fitnessapp.activity_registracija;

public class activity_login1 extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private FirebaseAuth mAuth;
    Button button;
    Button button_ek1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Check if the user is already logged in
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            // User is already logged in, redirect to MainActivity
            redirectToMainActivity();
        } else {
            // User not logged in, show login screen
            setContentView(R.layout.activity_login1);

            // Initialize UI elements
            emailEditText = findViewById(R.id.input_email);
            passwordEditText = findViewById(R.id.input_password);
            button_ek1 = findViewById(R.id.button_ek1);
            button = findViewById(R.id.button);

            button_ek1.setOnClickListener(v -> loginUser());
            button.setOnClickListener(v -> openRegisterActivity());
        }
    }

    private void redirectToMainActivity() {
        Intent i = new Intent(activity_login1.this, activity_trening.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Clear the activity stack
        startActivity(i);
        Log.d("Redirect", "Redirecting to MainActivity");

        finish(); // Ensure LoginActivity is closed and removed from the back stack
    }

    private void loginUser() {
        String email = emailEditText.getText().toString().trim();

        // Provjera da li je passwordEditText null
        if (passwordEditText != null) {
            String password = passwordEditText.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(activity_login1.this, "Unesite vašu email adresu i lozinku", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(activity_login1.this, "Prijava uspješna", Toast.LENGTH_SHORT).show();
                    redirectToMainActivity();
                } else {
                    Toast.makeText(activity_login1.this, "Greška prilikom prijave: " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            // Ako je passwordEditText null, prikaži odgovarajuću poruku korisniku
            Toast.makeText(activity_login1.this, "Unesite vašu lozinku", Toast.LENGTH_SHORT).show();
        }
    }


    private void openRegisterActivity() {
        Intent intent = new Intent(activity_login1.this, activity_registracija.class);
        startActivity(intent);
    }
}