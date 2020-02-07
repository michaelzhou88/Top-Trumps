import java.util.*;
/**
 * @author Michael Zhou
 * @version 13/11/2017
 * @since 7/11/2017
 */

public class Game {
	int size = -1;
	int humanSize = 0;
	int computerSize = 0;
	int computerSkill;
	protected int computerNum = 3;
	Scanner input = new Scanner(System.in);
	protected ArrayList<Player> playerObject;
	private Player turnPlayer,roundWinner;
	protected int order = 0;
	protected int winValue = 0;

	//Constructor
	public Game() {
		playerObject = new ArrayList<Player>();
	}

	/**
	 * Method which returns a simple message to introduce the game to the user
	 */
	public void welcomeMessage()
	{
		System.out.println("Welcome to LFC top trumps!");
	}

	/**
	 * Method which set ups how many human and computer players will be involved. User input validation has also been
	 * implemented to ensure that the user enters in values that are in a suitable and preferred range.
	 */
	public void setup()
	{
		while( humanSize < 1 ) {
			System.out.println("How many human players will this game have? (1-6)");
			String playerCount = input.nextLine();
		try {
			humanSize = Integer.parseInt(playerCount);
		}catch( NumberFormatException e ) {
			System.out.println("Invalid input, please try again");
			}
		}

		System.out.println("How many computer Players? (0-5)");
		computerSize = input.nextInt();


		for (int j=0; j<humanSize; j++)
		{
			System.out.println("Input a name for human player " + (j+1));
			playerObject.add(new Human(this, input.next()));
		}

		for (int j=0; j<computerSize; j++)
		{
			System.out.println("Input a name for computer player " + (j+1));
			playerObject.add(new SmartComputer(this, input.next()));
		}

		computerType();
		turnPlayer = playerObject.get(order);
		round();
	}

	/**
	 * Method to enable user to select the type of computer they want to play against
	 */
	public void computerType() {
		while(true){
			System.out.println("Do you want the computer player be predicatable(1), smart(2) or random(3)?");
			String computerBehaviour = input.next();
			try{
				computerSkill = Integer.parseInt(computerBehaviour);
				if ((computerSkill>0) && (computerSkill <4)) break;
			}catch(NumberFormatException e ){
				System.out.println("Invalid input, please try again." );
			}
		}
	}

	/**
	 * Method which offers the user the choice to select the behaviour of the AI they would like to play against
	 */
	public void startGame(){
		String computerType = " ";
		switch (computerSkill){
			// predictable computer
			case 1:
				for (int j=0;j<computerNum;j++){
					playerObject.add(new Player(this, "Computer " + (j+1)));
				}
				computerType = "Predictable";
				// smart computer
			case 2:
				for (int j=0;j<computerNum;j++){
					playerObject.add(new SmartComputer(this, "Computer " + (j+1)));
				}
				computerType = "Smart";
				// random computer
			case 3:
				for (int j=0;j<computerNum;j++){
					playerObject.add(new RandomComputer(this, "Computer " + (j+1)));
			}
				computerType = "Random";
		}
		turnPlayer = playerObject.get(order);
	}


	public void round(){
		int myname = turnPlayer.turn();
		findWinner(myname);
		giveWinnerCards();
		nextPlayer();

	}

	/**
	 * Method determines the winner of each round and prints out the player name.
	 * In addition to this, it will ensure all cards are given to the winning player.
	 * @param index - value determines postion of attribute
	 */
	protected void findWinner(int index){
		roundWinner = turnPlayer;
		winValue = turnPlayer.viewCard().grabAttribute(index).getValue();
		//System.out.println(playerObject.size());
		for(Player player : playerObject){
			System.out.println("************"+player.Name+"*************");
			System.out.println(player.viewCard().grabAttribute(index).printAttribute());
			int attributeValue = player.viewCard().grabAttribute(index).getValue();
			if(attributeValue>winValue){
				roundWinner = player;
				winValue = attributeValue;
			}

		}
		System.out.println("**********************");
		System.out.println("The winner of the round is " + roundWinner.Name + " who has scored " + winValue + " points.");
		System.out.println("Cards have been given to " + roundWinner.Name);
		System.out.println("**********************");
	}

	/**
	 * Method to make players who have lost to give their cards to the winner of current round.
	 * Also keeps track of player card count.
	 */
	private void giveWinnerCards(){

		for(Player player : playerObject){
			System.out.println(player.Name + " has " + player.queueCards.size() + " cards.");
			Card card = player.viewCard();
			player.removeCard(card);
			roundWinner.addCard(card);
		}
	}

	/**
	 * Method enables the game to continue an unlimited number of rounds until one player,
	 * the winner has cards left in their deck
	 */
	protected void nextPlayer(){
		for(Player player : playerObject){
			while(player.queueCards.size()<1){
				playerObject.remove(player);
				System.out.println(player.Name + " has been removed from the game");
				break;
			}
		}
		order++;
		if(order + 1>playerObject.size()) order = 0;
		turnPlayer = playerObject.get(order);
		round();
	}
}
