package maine;

import pekidzs.Card;
import pekidzs.CreditCard;
import pekidzs.Bank;

import java.util.Scanner;
import java.time.LocalDate;

public class CardTest {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		//readInt(1,10)
		Card[] cards = new Card[4];
		
		cards[0] = new CreditCard("Kiss Tamás", LocalDate.parse("2020-04-30"), Bank.OTP, 150000, 100000);
		cards[1] = new Card("Nagy Levente", LocalDate.parse("2022-05-31"), Bank.ERSTE, 100000);
		cards[2] = new CreditCard("Szabó László", LocalDate.parse("2019-03-31"), Bank.OTP, 200000, 100000);
		cards[3] = new Card("Kovács Edit", LocalDate.parse("2021-01-31"), Bank.CIB, 250000);
		
		for (int i = 0; i < cards.length; i++) {
			System.out.print( (i + 1) + ". withdrawal: " + 280000);
			if (cards[i].withdrawal(280000) == true) {
				System.out.print(" Successful ");
			}
			else {
				System.out.print(" Unsuccessful ");
			}
			
			System.out.print("The new balance: " + cards[i].getBalance());
			
			if (cards[i] instanceof CreditCard) {
				System.out.println(" Credit: " + /*cards[i].getCredit()*/ "credit");
			}
			
			System.out.print("\n");
			
		}
		
		System.out.println("CIBs:" + countCib(cards));
		
		System.out.println("Order array:");
		orderArray(cards);
		printArray(cards);
		
	//4.
		for (int i = 0; i < cards.length; i++) {
			cards[i].takeFee(cards[i].getFee());
		}
		
		System.out.println("After taking the fee");
		printArray(cards);
		
	}
	
	public static int readInt(int min, int max) {
		int number = 0;
		
		do {
			System.out.println("Between " + min + " and " + max + ":");
			while(!input.hasNextInt()) {
				System.out.println("Between " + min + " and " + max + "!");
				input.next();
			}
			number = input.nextInt();
		}while(number < min || number > max);
		
		return number;
	}
	
	public static int countCib(Card[] cards) {
		int count = 0;
		
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].getBank() == Bank.CIB) {
				count++;
			}
		}
		
		return count;
	}
	
	public static Card[] orderArray(Card[] cards) {
		Card temp;
		
		for (int i = 0; i < cards.length; i++) {
			
			for (int j = i + 1; j < cards.length; j++) {
				
				if (cards[i].getValid().isAfter(cards[j].getValid())) {
					temp = cards[i];
					cards[i] = cards[j];
					cards[j] = temp;
				}
				
			}
			
		}
		
		return cards;
	}
	
	public static void printArray(Card[] cards) { 
		for (int i = 0; i < cards.length; i++) {
			System.out.println(cards[i]);
		}
	}
	
}







































