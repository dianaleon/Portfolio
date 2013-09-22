package com.portfolio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;

import com.portfolio.activities.TextActivity;
import com.portfolio.model.PortfolioModel;
import com.portfolio.model.interfaces.IPage;
import com.portfolio.model.interfaces.ITextPage;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
               
		setContentView(R.layout.activity_main);
		
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.window_title);

		PortfolioModel portfolioModel = PortfolioModel.getInstance();
		int pagesCount = portfolioModel.getNumberPages();
//		IPage pageNum1 = portfolioModel.getPageInfo(1);
//		switch (pageNum1.getType()) {
//			case IPage.type_text:
//				ITextPage textPage = (ITextPage) pageNum1;
//				Intent intent = new Intent(MainActivity.this, TextActivity.class);
//				intent.putExtra("text", textPage.getText());
//				startActivity(intent);
//				break;
//	
//			default:
//				break;
//			}
//		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
