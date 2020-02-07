/**
 * @author Michael Zhou
 * @version 13/11/2017
 * @since 7/11/2017
 */

 /**
 * This SmartComputer class is an extension of the Player class specifically for adjusting behaviour of the Smart Computer.
 */
public class SmartComputer extends Player{
  protected String n;
  protected Game game;

  public SmartComputer(Game g,String name){
    super(g,name);
    initialiseDeck();
  }

  /**
   * This method forces the player to make their turn.
   * @return the attribute chosen.
   */
  protected int turn(){
	   System.out.println("New round has started!");
    System.out.println("It is now " + Name + "'s turn.");
    for(int i = 0;i<4;i++){
      System.out.println("-"+i+"- " + viewCard().grabAttribute(i).name + ": "+ viewCard().grabAttribute(i).getValue());
    }
    /**
    * Conditional statements implemented to compare all the attribute values against each other to find out
    * which attribute gives the highest value for the smart computer to select.
    */
    int one = viewCard().grabAttribute(0).getValue();
    int two = viewCard().grabAttribute(1).getValue();;
    int three = viewCard().grabAttribute(2).getValue();
    int four = viewCard().grabAttribute(3).getValue();

    if(one>=two && one >= three && one>=four) return 0;
    else if (two>=one && two >= three && two>=four){
      return 1;
    }
    else if(three>=one && three >= two && three>=four){
      return 2;
    }
    else if(four>=one && four >= two && one>=three){
      return 3;
    }
    else return 0;
  }
}
