import java.util.*;
/**
 * @author Michael Zhou
 * @version 13/11/2017
 * @since 7/11/2017
 */

public class Human extends Player{
  Scanner s = new Scanner(System.in);
  protected String name;
  protected Game game;

  /**
   *
   * @param g
   * @param Name
   */
  public Human(Game g, String Name){
    super(g,Name);
  }

  protected int turn(){
    System.out.println("It is now " +  Name + "'s turn.");
    System.out.println("Please select an attribute: (0-3)");
    System.out.println("***********************************");
    System.out.println(queueCards.peek().getCardName());
    for(int i = 0;i<4;i++){
      System.out.println("-"+i+"- " + " " + viewCard().grabAttribute(i).name+" : "+ viewCard().grabAttribute(i).getValue());
    }

    int turn = s.nextInt();
    return turn;
  }
}
