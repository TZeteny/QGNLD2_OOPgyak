package pekidzs;

public class YouAreBrokeException extends Exception {
	
	public YouAreBrokeException() {
		super("You don't have enough money.");
	}
	
	public YouAreBrokeException(String message) {
		super(message);
	}
	
}
