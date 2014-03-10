package org.gitmad.topicbingo.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.gitmad.topicbingo.R;

/**
 * Created by thedekel on 3/9/14.
 */
public class GameEndActivity extends Activity{

    TextView message_text;
    Button new_game_btn;
    Button exit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_message);

        // set the message text to be the message that was given with the intent
        message_text = (TextView)findViewById(R.id.end_message_text);
        message_text.setText(getIntent().getStringExtra("message"));

        //fetch buttons and set their listeners/actions
        new_game_btn = (Button)findViewById(R.id.new_game_btn);
        exit_btn = (Button)findViewById(R.id.exit_btn);


        exit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        new_game_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newGameIntent = new Intent(thisActivity, PlayActivity.class);
                newGameIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                newGameIntent.putExtra("reset", true);
                startActivity(newGameIntent);
            }
        });

    }
}
