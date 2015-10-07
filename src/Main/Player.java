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

	public String toString() {
		return "Player " + Name + " has " + Money + "\n" + "Square: " + Location;

	}
}
