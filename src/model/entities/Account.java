package model.entities;

import model.exceptions.DomainException;

public class Account {

	Integer number;
	String holder;
	Double balance;
	Double withdraw_limit;

	public Account() {

	}

	public Account(Integer number, String holder, Double balance, Double withdraw_limit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdraw_limit = withdraw_limit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdraw_limit() {
		return withdraw_limit;
	}

	public void setWithdraw_limit(Double withdraw_limit) {
		this.withdraw_limit = withdraw_limit;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) {
		if (amount > withdraw_limit) {
			throw new DomainException("The amount exceeds withdraw limit");
		}
		if (amount > balance) {
			throw new DomainException("Not enough balance");
		}
		balance -= amount;
	}

	@Override
	public String toString() {
		return "New balance: $ " + String.format("%.2f", balance);
	}

}
