package csc131.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GiftCardTest {

	@Test
	public void getIssuingStore()
	{
		double		balance;
		GiftCard	card;
		int			issuingStore;
		
		issuingStore	= 1337;
		balance 		= 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getIssuingStore()", issuingStore, card.getIssuingStore());
	}
	@Test
	public void getBalance()
	{
		double		balance;
		GiftCard	card;
		int			issuingStore;
		
		issuingStore	= 1337;
		balance 		= 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getBalance()", balance, card.getBalance(), 0.001);
	}
	@Test
	public void deduct_RemainingBalance()
	{
		double		balance;
		GiftCard	card;
		int			issuingStore;
		
		issuingStore	= 1337;
		balance 		= 100.00;
		card = new GiftCard(issuingStore, balance);
		
		balance = balance - 20;

		String bal = "Remaining Balance: " + String.format("%6.2f",
                Math.abs(balance));
		
		assertEquals("deduct()", bal, card.deduct(20.00));
	}
	
	@Test
	public void deduct_RemainingBalanceRevese()
	{
		double		balance;
		GiftCard	card;
		int			issuingStore;
		
		issuingStore	= 1337;
		balance 		= 100.00;
		card = new GiftCard(issuingStore, balance);
		
		balance = balance - -1;
		/*
		String bal = "Remaining Balance: " + String.format("%6.2f",
                Math.abs(balance));
                */
		
		String bal = "Invalid Transaction";
		
		assertEquals("deduct()", bal, card.deduct(-1));
	}
	@Test
	public void deduct_RemainingBalanceDept()
	{
		double		balance;
		GiftCard	card;
		int			issuingStore;
		
		issuingStore	= 1337;
		balance 		= 0;
		card = new GiftCard(issuingStore, balance);
		
		balance = balance - 20;
		
		String bal = "Amount Due: " + String.format("%6.2f",
                Math.abs(balance));
		
		assertEquals("deduct()", bal, card.deduct(20.00));
	}
	@Test
	public void constructor_IncorrectBalance()
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);});
	}
	@Test
	public void constructor_IncorrectID_Low()
	{
		double		balance;
		GiftCard	card;
		int			issuingStore;
		
		issuingStore	= -1;
		balance 		= 0;
		card = new GiftCard(issuingStore, balance);
	}
	@Test
	public void constructor_IncorrectID_High()
	{
		double		balance;
		GiftCard	card;
		int			issuingStore;
		
		issuingStore	= 10000;
		balance 		= 0;
		card = new GiftCard(issuingStore, balance);
	}
	
	


}
