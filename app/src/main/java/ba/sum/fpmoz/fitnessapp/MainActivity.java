package ba.sum.fpmoz.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);


        /*emailEditText = findViewById(R.id.input_email);
        passwordEditText = findViewById(R.id.input_password);
        button_ek1 = findViewById(R.id.button_ek1);
        button_ek1.setOnClickListener(view -> {
            if (emailEditText.getText().toString().equals("user") && passwordEditText.getText().toString().equals("1234")) {
                Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
            }
        });*/


    }
}
