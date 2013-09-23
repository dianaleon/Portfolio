package com.portfolio.model;

import android.content.Context;
import android.os.Message;

import com.portfolio.asyncTask.GetPortfolioAsyncTask;
import com.portfolio.handler.AsyncTaskHandler;
import com.portfolio.listener.IPortfolioListener;
import com.portfolio.model.entities.Portfolio;
import com.portfolio.model.interfaces.IPage;

public class PortfolioModel {

	private static PortfolioModel instance = null;
	
	private Portfolio portfolio;
	private Context context;
	private IPortfolioListener callback;
	
	private PortfolioModel(Context context) {
		this.context = context;
	}
	
	public static PortfolioModel getInstance(Context context) {
		if (instance == null) {
			instance = new PortfolioModel(context);
		}
		return instance;
	}
	
	public void getPortfolio(final IPortfolioListener callback) {
		this.callback = callback;
		GetPortfolioAsyncTask task = new GetPortfolioAsyncTask(context, new AsyncTaskHandler(context) {

			@Override
			public void acceptRequest(Message msg) {
				Portfolio portfolio = (Portfolio) msg.obj;
				PortfolioModel.instance.portfolio = portfolio;
				callback.onPortfolioReady();
			}
		});
		task.exec();
	}
	
	public int getNumberPages() {
		return portfolio.getNumberPages();
	}
	
	public IPage getPageInfo(int numberPage) {
		return portfolio.getPage(numberPage);
	}
}
