package pekidzs;

import java.time.LocalDate;

public class CreditCard extends Card {
	private int credit;
	
	public CreditCard(String name, LocalDate valid, Bank bank, int balance) {
		super(name, valid, bank, balance);
		credit = 100000;
	}
	
	public CreditCard(String name, LocalDate valid, Bank bank, int balance, int credit) {
		super(name, valid, bank, balance);
		this.credit = credit;
	}
	
	public int getCredit() {
		return credit;
	}
	
	@Override
	public String toString() {
		return "Owner=" + getName() + ", Valid=" + getValid() + ", Bank=" + getBank() + ", Balance=" + getBalance() + "Credit=" + credit;
	}
	
	@Override
	public boolean withdrawal(int sum) {
		boolean success = true;
		
		if ( getValid().isBefore(LocalDate.now()) ) {
			success = false;
		}
		
		try {
			if ( sum > getBalance() || ( getBalance() - sum ) <= credit ) {
				credit -= ( getBalance() - sum );
			}
			else {
				success = false;
				throw new YouAreBrokeException();
			}
		}catch (YouAreBrokeException e) {
			System.out.println(e.getMessage());
		}
		
		return success;
	}
	
	@Override
	public boolean takeFee(int fee) {
		boolean success = true;
		fee += 100;
		
		try {
			if (this.getFee() > this.getBalance()) {
				success = false;
				throw new YouAreBrokeException();
			}
			else {
				this.setBalance(this.getBalance() - fee);
			}
		}catch (YouAreBrokeException e) {
			System.out.println(e.getMessage());
		}
		
		return success;
	}
	
	
	
}
