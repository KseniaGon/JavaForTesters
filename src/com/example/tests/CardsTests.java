package com.example.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.example.framework.Card;
import com.example.framework.Contact;
import com.example.utils.SortedListOf;

public class CardsTests extends TestBase {
	@Test
	public void verifyCards() throws IOException {
		SortedListOf<Contact> contacts = applicationManager.getContactHelper().getContacts();
		
		SortedListOf<Card> cards = applicationManager.getCardsHelper().getAllCards();
		
		assertThat(cards, equalTo(applicationManager.getContactHelper().convertToCards(contacts)));
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		applicationManager.setUp();
	}
}
