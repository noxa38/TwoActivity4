package fr.esgi.twoactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "fr.esgi.twoactivity.extra.REPLY";
    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Trouver la référence de l'EditText
        mReply = findViewById(R.id.editText_second);

        // Récupérer l'Intent qui a lancé cette activité
        Intent intent = getIntent();

        // Extraire la chaîne du message de l'Intent
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Trouver la référence du TextView
        TextView textView = findViewById(R.id.text_message);

        // Définir le texte du TextView avec la chaîne extra de l'Intent
        textView.setText(message);
    }

    // Méthode pour renvoyer la réponse à l'activité principale
    public void returnReply(View view) {
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}
