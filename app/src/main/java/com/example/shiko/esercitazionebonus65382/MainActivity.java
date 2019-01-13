package com.example.shiko.esercitazionebonus65382;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login;
    User user = new User();
    TextView error;
    public static final String USER_EXTRA="com.example.shiko.esercitazionebonus65382.User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);
        error = (TextView)findViewById(R.id.error);

        error.setVisibility(View.GONE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkInput()) {
                    updateUser();

                    Intent showResults = new Intent(MainActivity.this, ShowResults.class);
                    showResults.putExtra(USER_EXTRA, user);
                    startActivity(showResults);
                }
            }
        });
    }

    private void updateUser() {
        user.setUsername(""+username.getText());
        user.setPassword(""+password.getText());
    }

    private boolean checkInput()
    {
        int errors = 0;

        if(username.getText()==null || username.getText().length()==0) {
            username.setError("E' richiesto lo username");
            errors++;
        }
        else
            username.setError(null);

        if(password.getText()==null || password.getText().length()==0) {
            password.setError("E' richiesta la password");
            errors++;
        }
        else
            password.setError(null);


        switch (errors){
            case 0:
                error.setVisibility(View.GONE);
                error.setText("");
                break;
            case 1:
                error.setVisibility(View.VISIBLE);
                error.setText("Si è verificato un Errore!");
                break;
            case 2:
                error.setVisibility(View.VISIBLE);
                error.setText("Si sono verificati 2 errori!" );
                break;
        }
        return errors==0;
    }
}
