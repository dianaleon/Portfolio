package com.portfolio.model;

import com.portfolio.model.entities.TextPage;
import com.portfolio.model.interfaces.IPage;

public class PortfolioModel {

	private static PortfolioModel instance = null;
	
	public static PortfolioModel getInstance() {
		if (instance == null) {
			instance = new PortfolioModel();
		}
		return instance;
	}
	
	public int getNumberPages() {
		return 5;
	}
	
	public IPage getPageInfo(int numberPage) {
		return new TextPage("TEXTO DE LA PAGINA");
	}
}
