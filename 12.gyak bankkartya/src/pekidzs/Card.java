package pekidzs;

import java.time.LocalDate;

public class Card implements Chargeable {
	private String name;
	private LocalDate valid;
	private Bank bank;
	private int balance;
	private int fee;
	
	public Card(String name, LocalDate valid, Bank bank, int balance) {
		this.name = name;
		this.valid = valid;
		this.bank = bank;
		this.balance = balance;
		switch(bank) {
			case OTP:
				this.fee = 100;
				break;
			case KH:
				this.fee = 156;
				break;
			case ERSTE:
				this.fee = 200;
				break;
			case CIB:
				this.fee = 188;
				break;
			default:
				fee = 0;
		}
	}
	
//getter setter
	public String getName() {
		return name;
	}
	
	public LocalDate getValid() {
		return valid;
	}
	
	public Bank getBank() {
		return bank;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int getBalance() {
		return balance;
	}
//--------------------------------
	
	@Override
	public String toString() {
		return "Owner=" + name + ", Valid=" + valid + ", Bank=" + bank + ", Balance=" + balance;
	}
	
	public boolean withdrawal(int sum) {
		boolean success = true;
		
		try {
			if (sum > balance || valid.isBefore(LocalDate.now())) {
				success = false;
				throw new YouAreBrokeException();
			}
		}catch (YouAreBrokeException e) {
			System.out.println(e.getMessage());
		}
		
		return success;
	}
	
//4.
	public int getFee() {
		return fee;
	}
	
	public boolean takeFee(int fee) {
		boolean success = true;
		
		try {
			if (fee > balance) {
				success = false;
				throw new YouAreBrokeException();
			}
			else {
				balance -= fee;
			}
		}catch (YouAreBrokeException e) {
			System.out.println(e.getMessage());
		}
		
		return success;
	}
	
}
































