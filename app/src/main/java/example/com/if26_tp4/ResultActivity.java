package example.com.if26_tp4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        TextView tw = (TextView) findViewById(R.id.ar_result);

        String nom = extras.getString("nom");
        String prenom = extras.getString("prenom");

        tw.setText("Vous etes "+ nom + " " + prenom);
    }
}
