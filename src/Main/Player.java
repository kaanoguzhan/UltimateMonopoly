package Main;

import java.util.Scanner;

public class Player {

	private String Name = "";
	private int Money = 0;
	private int Location = 0;

	public Player() {
		Money = Properties.StartGold;

		Scanner scan = new Scanner(System.in);
		String s = scan.next();

		System.out.print("Player " + s + " with " + Money + " added.");
	}

	public void move(int roll) {
		Location += roll;
		if (Location > Properties.TotalSquares) {
			addMoney(Properties.PASSING_MONEY);
			Location = Location % Properties.TotalSquares;
		}
	}

	public void addMoney(int amount) {
		Money += amount;
	}

	public void reduceMoney(int amount){
		if(Money>=amount)
			Money -= amount;
		else{
			Location = Properties.Heaven;
			System.out.println(Name + " is bankrupt.");
		}

	public String toString() {
		return "Player " + Name + " has " + Money + "\n" + "Square: " + Location;

	}
}
