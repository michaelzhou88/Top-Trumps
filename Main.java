/**
 * @author Michael Zhou
 * @version 13/11/2017
 * @since 7/11/2017
 */
/**
* This is the main class which is used to establish the Game constructor and run the game
*/
public class Main {

	public static void main(String[] args) {

		/*
		* Generate a game object
		*/
		
		Game gameObject = new Game();

		/**
		 * Running the three methods from the Game class to start the card game
		 */
		gameObject.welcomeMessage();
		gameObject.setup();
		gameObject.startGame();
	}
}
