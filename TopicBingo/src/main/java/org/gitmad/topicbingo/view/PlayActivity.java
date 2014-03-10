package org.gitmad.topicbingo.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import org.gitmad.topicbingo.R;
import org.gitmad.topicbingo.TopicBingoApplication;
import org.gitmad.topicbingo.model.DataModel;
import org.gitmad.topicbingo.model.GameState;
import org.gitmad.topicbingo.util.ClickListenerGenerator;

public class PlayActivity extends Activity implements ClickListenerGenerator {

	private ListView mTopicsList;
    private DataModel model;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);

        Intent currIntent = getIntent();

        if (currIntent.getBooleanExtra("reset", false)) {
            ((TopicBingoApplication)getApplication()).resetModel();
        }

        model = ((TopicBingoApplication)getApplication()).getModel();

		mTopicsList = (ListView) findViewById(R.id.topics_list);
		mTopicsList.setAdapter(new TopicArrayAdapter(this,
      	        model.getCurrentTopics(), this));

    }

    public View.OnClickListener generateClickListner(final Integer position) {
        return (new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (v.getClass() == TextView.class) {
                    TextView tv = (TextView)v;
                    tv.setTextColor(Color.GREEN);
                    GameState currState = model.clearTopic(position);
                    checkWinState(currState);
                }
            }
        });
    }

    public void checkWinState(GameState currState) {
       if (currState.getWonState()) {
           Intent winScreenIntent= new Intent(this, GameEndActivity.class);
           winScreenIntent.putExtra("message", "Congratulation! You won!");
           winScreenIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
           startActivity(winScreenIntent);

       }
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play, menu);
		return true;
	}

}
