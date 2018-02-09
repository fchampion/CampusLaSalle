package com.flavienclara.campuslasalle.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.flavienclara.campuslasalle.R;
import com.flavienclara.campuslasalle.classes.Groupe;

import java.util.ArrayList;

/**
 * Created by Clara on 09/02/2018.
 */

public class LoginActivity extends AppCompatActivity {
    private static Context context;
    public ArrayList<Groupe> lesGroupes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this.getApplicationContext();


        final EditText code = (EditText) findViewById(R.id.input_code);
        final Button btnConnexion = (Button) findViewById(R.id.btn_conn);
        final TextView error = (TextView) findViewById(R.id.error_auth);

        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                error.setText("");
                //si le champ code est vide
                if (code.getText().toString().equals("")) {
                    error.setText("Veuillez remplir tous les champs.");
                } else {
                    //parcours les groupes
                    for (Groupe g : lesGroupes) {
                        //si le code du groupe = code entré
                        if (String.valueOf(g.getCode()).equals(code.getText())) {
                            //setCode(g);
                            //on ouvre l'intent  (Remplacer Activity par L'activité de la liste d'acceuil)
                               Intent i = new Intent(LoginActivity.this, ListActivity.class);
                               startActivity(i);
                            //sinon on affiche code incorrect
                        } else {
                            error.setText("Code incorrect.");
                        }
                    }

                }
            }
        });



    }
}

