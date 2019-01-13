package com.example.shiko.esercitazionebonus65382;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class ShowResults extends AppCompatActivity {

    User user;
    TextView messaggio;
    Button indietro;
    ImageView smile, sad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_results);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(MainActivity.USER_EXTRA);

        user = (obj instanceof User) ? (User)obj : new User();

        messaggio = (TextView) findViewById(R.id.messaggio);
        indietro = (Button) findViewById(R.id.indietro);
        smile = (ImageView) findViewById(R.id.smile);
        sad = (ImageView) findViewById(R.id.sad);

        if(UserFactory.getInstance().checkUser(user.getUsername(),user.getPassword())){
            messaggio.setText("Benvenuto, "+user.getUsername()+"!");
            sad.setVisibility(View.GONE);
        }
        else{
            messaggio.setText("Accesso negato!");
            smile.setVisibility(View.GONE);
        }


        indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();// termina la prima activity
                // oppure
                Intent showResults = new Intent(ShowResults.this,
                        MainActivity.class);
                startActivity(showResults);
            }
        });
    }
}
