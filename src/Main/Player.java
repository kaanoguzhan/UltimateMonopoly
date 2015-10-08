package Main;

import GameSquares.GameSquare;

public class Player {

	private String name;
	private int money, location;
	private GameSquare[] gameSquares;

	public Player(String name, GameSquare[] gameSquares) {
		this.location = 0;
		this.money = Properties.StartGold;
		this.name = name;
		this.gameSquares = gameSquares;
		System.out.println("Player " + name + " with " + money + " added.");
	}

	public void moveBy(int roll) {
		location += roll;
		if (location > Properties.TotalSquares) {
			addMoney(Properties.PASSING_MONEY);
			location = location % Properties.TotalSquares;
		}
		gameSquares[location].onArrive(this);
		System.out.println(name + " is at " + gameSquares[location].toString());
	}

	public void moveTo(int id) {
		location = id;
		gameSquares[location].onArrive(this);
		System.out.println(name + " is at " + gameSquares[location].toString());
	}

	public void addMoney(int amount) {
		money += amount;
	}

	public void reduceMoney(int amount) {
		if (money >= amount)
			money -= amount;
		else {
			location = Properties.Heaven;
			System.out.println(name + " is bankrupt.");
		}
	}

	public String toString() {
		return "Player " + name + " has " + money + "\n" + "Square: " + location;

	}
}
