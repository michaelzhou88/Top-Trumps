import java.util.*;

/**
 * @author Michael Zhou
 * @version 13/11/2017
 * @since 7/11/2017
 */

 /**
 * This is the player class which holds the player's deck.
 * It will also contain methods that can perform operations on the player's deck.
 */
public class Player{
  Random r = new Random();
  protected Queue<Card> queueCards;
  public String[] names = {"Simon Mignolet","Loris Karius","Adam Bogdan","Nathaniel Clyne","Virgil Van Dijk","Dejan Lovren","Ragnar Klavan","Alberto Moreno","Andrew Robertson","Joel Matip","Trent Alexander-Arnold","Georginio Wijnaldum",
      "James Milner","Jordan Henderson","Adam Lallana","Alex Oxlade-Chamberlain","Emre Can","Phillipe Coutinho","Roberto Firmino","Mohamed Salah","Sadio Mane","Danny Ings","Dominic Solanke","Ben Woodburn","Ryan Kent",
      "Danny Ward","Ovie Ejaria","Lucas Leiva","Kevin Stewart","Mamadou Sakho","Andre Wisdom"};
  public String[] attributeNames = {"Offence", "Defence", "Strength","Mobility"};

  protected Game g;
  protected String Name;

  public Player(Game game,String name){
    g = game; // access variables in the game class
    Name = name; // name of the attributes
    queueCards = new LinkedList<Card>();
    initialiseDeck();
  }

  // This will generate a card with a random name to pick.
  protected String pickCardName(){
    return names[r.nextInt(names.length)];
  }

  // This will add cards to the queue.
  protected void addCard(Card card){
    queueCards.add(card);
  }

  // This will distribute the cards and assign attributes to each card
  protected void initialiseDeck()
	{
		for( int i = 0; i < 5; i++)
		{
			Card cardObject = new Card(pickCardName());
			for(int j = 0; j < 4; j++){

				cardObject.addAttribute(new Attribute(attributeNames[j] , r.nextInt(10)));
			}
      addCard(cardObject);
		}
	}

  /**
  * When called will make the player take their turn.
  * @return the index of the attribute chosen.
  */
	protected int turn(){
	  return 0;
	}

	// Allows revealing of certain attributes and other properties of a player's card.
	protected Card viewCard(){
	  return queueCards.peek();
	}

  // Method removes card from deck
	protected void removeCard(Card card){
	  queueCards.remove(card);
	}

  /**
  * @return the value of the attribute depending on index value.
  * @param index - determines the position by its value of the attribute retrieved by player.
  */
	protected Attribute retrieveA(int index){
	  return queueCards.peek().grabAttribute(index);
	}
}
