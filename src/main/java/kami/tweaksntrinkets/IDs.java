package kami.tweaksntrinkets;

public class IDs {
	private static int currentID = 2000;

	public static int newID() {
		return currentID++;
	}
}
