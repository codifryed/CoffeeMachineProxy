package wbs.pattern.proxy;

import java.util.Stack;

interface Coffee {
	void drink();
}

class Becher implements Coffee {

	private static CoffeeMachine coffeeMachine;

	@Override
	public void drink() {
		if (coffeeMachine == null) {
			coffeeMachine = new CoffeeMachine();
		}
		coffeeMachine.drink();
	}

	public static Coffee fill() {
		return new Becher();
	}

}

class CoffeeMachine implements Coffee {
	private Stack<Coffee> coffeePot = new Stack<>();
	private final int MAX_CUPS = 8;

	@Override
	public void drink() {

		if (coffeePot.isEmpty()) {
			makeCoffee();
			System.out.println("Making new coffee pot...");
		}
		coffeePot.pop();
		System.out.println("Cups left in pot: " + coffeePot.size());

	}

	private void makeCoffee() {
		for (int i = 0; i < MAX_CUPS; i++) {
			coffeePot.push(new Becher());
		}

	}

}

public class CoffeeProxyDemo {

	public static void main(String[] args) {

		Coffee coffeeBecher = Becher.fill();
		System.out.println("Drinking...");
		coffeeBecher.drink();
		coffeeBecher.drink();
		coffeeBecher.drink();
		coffeeBecher.drink();
		coffeeBecher.drink();
		coffeeBecher.drink();
		coffeeBecher.drink();
		coffeeBecher.drink();
		coffeeBecher.drink();
		coffeeBecher.drink();
		System.out.println("Krank...");

	}

}
