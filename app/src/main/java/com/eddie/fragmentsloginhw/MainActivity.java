package com.eddie.fragmentsloginhw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, EmailFragment.Callback, PasswordFragment.Callback {

    private TextView emailTxt, passwordTxt;
    private Button loginBtn, emailBtn, passwordBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailTxt = findViewById(R.id.email_txt);
        passwordTxt = findViewById(R.id.password_txt);

//        loginBtn = findViewById(R.id.login_btn);
//        loginBtn.setOnClickListener(this);

        emailBtn = findViewById(R.id.email_btn);
        emailBtn.setOnClickListener(this);

        passwordBtn = findViewById(R.id.password_btn);
        passwordBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.email_btn) {

            EmailFragment fragment = new EmailFragment();
            Bundle bundle = new Bundle();
            fragment.setArguments(bundle);
            fragment.setCallback(this);


            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.my_container, fragment)
                    .addToBackStack(null)
                    .commit();

        } else if (v.getId() == R.id.password_btn) {

            PasswordFragment fragment = new PasswordFragment();
            Bundle bundle = new Bundle();
            fragment.setArguments(bundle);
            fragment.setCallback(this);


            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.my_container, fragment)
                    .addToBackStack(null)
                    .commit();
        }

    }

    @Override
    public void inputEmail(String email) {

        emailTxt.setText(email);
    }

    @Override
    public void inputPassword(String password) {

        passwordTxt.setText(password);
    }
}
