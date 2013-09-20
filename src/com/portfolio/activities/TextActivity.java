package com.portfolio.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.portfolio.R;

public class TextActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text);
        Bundle bundle = this.getIntent().getExtras();

        String text = bundle.getString("text");
        //TODO text to show

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
