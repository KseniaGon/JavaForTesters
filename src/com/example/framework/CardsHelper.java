package com.example.framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.utils.SortedListOf;

public class CardsHelper extends HelperBase {
	private String selector = "//table[@id='view']/tbody/tr/td";
	
	public CardsHelper(DriverManager driverManager, NavigationHelper navigationHelper) {
		super(driverManager, navigationHelper);
	}

	public SortedListOf<Card> getAllCards() throws IOException{
		navigateTo().printPhonesPage();
		
		List<WebElement> elements = findElementsBy(By.xpath(selector));
		SortedListOf<Card> result = new SortedListOf<Card>();
		
		for(WebElement element: elements) {
			String text = element.getText();
			BufferedReader bufReader = new BufferedReader(new StringReader(text));

			String names = bufReader.readLine();
			if( names.equals(".") ) {
				break;
			}
			
			try {
				result.add( 
					new Card()
						.withFirstAndLastName(extractNames(names))
						.withPhone(extractPhone(bufReader.readLine())));
			}
			catch (NullPointerException ex) {
				throw new IOException("Cannot parse string: " + text);
			}
			
			bufReader.close();
		}		
		return result;
		
	}

	private String extractNames(String text) {
		String[] result = text.split(":");
		if(result.length>0) { 
			return result[0].trim();
		}
		return "";
	}

	private String extractPhone(String text) {
		return text.replaceAll("H:\\s+(.*)", "$1");
	}

}
