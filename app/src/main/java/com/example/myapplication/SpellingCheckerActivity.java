package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.textservice.SentenceSuggestionsInfo;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;
import android.view.textservice.TextServicesManager;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.textservice.SentenceSuggestionsInfo;
import android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener;
public class SpellingCheckerActivity extends AppCompatActivity implements SpellCheckerSessionListener {



    EditText editText;
    Button suggestionsButton;
   // SpellCheckerSession spellChecker;
    TextView textSuggestions;
    private SpellCheckerSession mScs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spelling_checker);



        editText=(EditText)findViewById(R.id.edit_text);
        suggestionsButton=findViewById(R.id.suggestions_button);
        textSuggestions=findViewById(R.id.text_suggestions);
        suggestionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), editText.getText().toString(), Toast.LENGTH_SHORT).show();
              //  spellChecker.getSuggestions( new TextInfo(editText.getText().toString()), Integer.parseInt("3"));
           mScs.getSentenceSuggestions(new TextInfo[] {new TextInfo(editText.getText().toString())}, 3);
//mScs.getSpellChecker();
            }
        });

    }
    public void onResume() {
        super.onResume();
        final TextServicesManager tsm = (TextServicesManager)
                getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);
        mScs = tsm.newSpellCheckerSession(null, null, this, true);
    }

    public void onPause() {
        super.onPause();
        if (mScs != null) {
            mScs.close();
        }
    }


    public void onGetSuggestions(final SuggestionsInfo[] arg0) {
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arg0.length; ++i) {
            // Returned suggestions are contained in SuggestionsInfo
            final int len = arg0[i].getSuggestionsCount();
            sb.append('\n');

            for (int j = 0; j < len; ++j) {
                sb.append("," + arg0[i].getSuggestionAt(j));
            }

            sb.append(" (" + len + ")");
        }

        runOnUiThread(new Runnable() {
            public void run() {
                textSuggestions.append(sb.toString());
            }
        });
    }

    @Override
    public void onGetSentenceSuggestions(SentenceSuggestionsInfo[] arg0) {
        // TODO Auto-generated method stub
    }
}