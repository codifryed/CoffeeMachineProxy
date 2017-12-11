import java.util.ArrayDeque;
import java.util.Deque;

// Proxy Interface
interface Coffee {
	void drink();
}

// Proxy
class Becher implements Coffee {

	private static final CoffeeMachine coffeeMachine = CoffeeMachine.getCoffeeMachine();

	private Becher() {
	}

	@Override
	public void drink() {
		coffeeMachine.drink();
	}

	public static Coffee fill() {
		return new Becher();
	}

}

// Singleton
class CoffeeMachine implements Coffee {
	private static final Deque<Coffee> coffeePot = new ArrayDeque<>();
	private static final int MAX_CUPS = 8;

	private CoffeeMachine() {
	}

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
			coffeePot.push(Becher.fill());
		}

	}

	public static CoffeeMachine getCoffeeMachine() {
		return CoffeeMachineHolder.coffeeMachine;
	}

	private static class CoffeeMachineHolder {
		static final CoffeeMachine coffeeMachine = new CoffeeMachine();
	}

}

// Demo
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
		coffeeBecher.drink();
		coffeeBecher.drink();
		coffeeBecher.drink();
		coffeeBecher.drink();
		System.out.println("Krank...");

	}

}
