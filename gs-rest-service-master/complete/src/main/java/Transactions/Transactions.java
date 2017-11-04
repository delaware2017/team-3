package Transactions;

import TableObject.Person;

public class Transactions {

	public static void decrement(Person person, double sub) {
		person.setBalance(person.getBalance()-sub);
	}

	public static void increment(Person person, double add) {
		person.setBalance(person.getBalance()+add);
	}
}
