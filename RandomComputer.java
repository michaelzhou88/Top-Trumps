import java.util.*;

/**
 * @author Michael Zhou
 * @version 13/11/2017
 * @since 7/11/2017
 */

/**
* This RandomComputer class is an extension of the Player class specifically for adjusting behaviour of the Random Computer.
*/
public class RandomComputer extends Player{
  protected Game game;
  protected String Name;
  Random r = new Random();

  public RandomComputer(Game g,String n){
    super(g,n);
  }

  /**
  * Method forces the player to take their turn as well as generating
  * a statement to display the attributes of the current card of player.
  * @return the value of the attribute.
  */
  protected int turn(){
    System.out.println("**********************");
  	System.out.println("New round has started!");
      System.out.println("It is now " + Name + "'s turn.");
      for(int i = 0;i<4;i++){
        System.out.println("-"+i+"- " + viewCard().grabAttribute(i).name + ": "+ viewCard().grabAttribute(i).getValue());

      }
    return r.nextInt(4);
  }
}
