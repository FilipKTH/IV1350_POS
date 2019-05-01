package se.kth.iv1350.model;

/**
 * Used to control money actions of a purchase
 * @author Filip
 */
public class CashRegister {

	private double balance;

	/***
	 * Creates instance of CashRegister
	 * @param balance Sets amount of money contained in
	 *                the CashRegister.
	 */
	public CashRegister(double balance) {
		this.balance = balance;
	}

	/***
	 * Adds money to the balance of the cash register.
	 * @param amountToAdd Money to add to the balance
	 */
	public void addMoney(double amountToAdd) throws Exception{
		if(amountToAdd < 1)
			throw new Exception(amountToAdd + " is an invalid amount");
		balance += amountToAdd;
	}

	/***
	 * Calculate amount of change based on money payed and cost.
	 * @param amount Amount of money being payed
	 * @param runningTotal Cost of what is being purchased
	 * @return Returns the change
	 */
	public double getChange(double amount, double runningTotal) throws Exception{
		if(amount < runningTotal){
			throw new Exception("Tried to pay less than cost.");
		}
		else if((amount - runningTotal) > balance){
			throw new Exception("Not enough money in register to give change.");
		}

		double change = amount - runningTotal;
		balance -= change;

		return change;
	}

	/***
	 *
	 * @return Returns the balance
	 */
	public double getBalance(){
		return this.balance;
	}

}
