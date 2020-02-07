/**
 * @author Michael Zhou
 * @version 13/11/2017
 * @since 7/11/2017
 */

/**
* This class holds the name and value of the attribute of the cards generated.
*/
public class Attribute{
  protected int skillValue = 0;
  protected String name = "No name";
  protected Player Parent = null;

  /**
   *
   * @param attributeName - returns the name of the attribute of generated card.
   * @param attributeValue - returns the value of the attribute of generated card.
   */
  public Attribute(String attributeName, int attributeValue){
    name = attributeName;
    skillValue = attributeValue;
  }

  /**
   * @return Method returns the name of the card,
   */
  protected String printAttribute(){
    String attributeNames = ( name + " : " + skillValue);
    return attributeNames;
  }

  /**
   * @return the value of the skill
   */
  protected int getValue(){
    return skillValue;
  }

}
