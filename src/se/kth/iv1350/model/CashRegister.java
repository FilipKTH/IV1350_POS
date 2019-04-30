package se.kth.iv1350.model;

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
	public void addMoney(double amountToAdd) {
		balance += amountToAdd;
	}

	/***
	 * Calculate amount of change based on money payed and cost.
	 * @param amount Amount of money being payed
	 * @param runningTotal Cost of what is being purchased
	 * @return Returns the change
	 */
	public double getChange(double amount, double runningTotal) {
		return amount - runningTotal;
	}

}
