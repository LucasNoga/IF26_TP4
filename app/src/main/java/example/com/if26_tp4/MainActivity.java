package example.com.if26_tp4;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText et_nom, et_prenom = null;
    private Button b1, b2 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nom = (EditText) findViewById(R.id.et_nom);
        et_prenom = (EditText) findViewById(R.id.et_prenom);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);

        //fond des boutons en rouge
        b1.setBackgroundColor(Color.RED);
        b2.setBackgroundColor(Color.RED);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

        //ajout des long click
        b1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                sendIntent1();
                return false;
            }
        });

        //ajout du long click
        b2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                sendIntent2();
                return false;
            }
        });
    }

    /**Methode qui lance l'intent sur ResultActivity*/
    private void sendIntent1() {
        Log.i("hello", "hellp");
        String nom = et_nom.getText().toString();
        String prenom = et_prenom.getText().toString();
        if (nom.isEmpty() || prenom.isEmpty())
            return;

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("nom", nom);
        intent.putExtra("prenom", prenom);
        startActivity(intent);
    }

    /**Methode qui lance l'intent sur GrisActivity*/
    private void sendIntent2() {
        Intent intent = new Intent(this, GridActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                toogle(view);
                break;

            case R.id.button2:
                toogle(view);
                break;
        }
    }

    /**Methode pour modifier la couleur des boutons*/
    public void toogle(View view) {
        switch (view.getId()) {
            case R.id.button1:
                if (b1.isSelected()) {
                    b1.setSelected(false);
                    b1.setBackgroundColor(Color.RED);
                } else {
                    b1.setSelected(true);
                    b1.setBackgroundColor(Color.GREEN);
                }
                break;

            case R.id.button2:
                if (b2.isSelected()) {
                    b2.setSelected(false);
                    b2.setBackgroundColor(Color.RED);
                } else {
                    b2.setSelected(true);
                    b2.setBackgroundColor(Color.GREEN);
                }
                break;

        }
    }
}
