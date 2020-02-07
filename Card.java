import java.util.*;
/**
 * @author Michael Zhou
 * @version 13/11/2017
 * @since 7/11/2017
 */

/**
* This class holds the attributes and properties of the deck.
*/
public class Card {
	protected ArrayList<Attribute> Attributes;
	String name;

	// Constructor
	public Card(String name){
			Attributes = new ArrayList<Attribute>();
			this.name = name;
	}

	// This method retrieves the name of the card.
	public String getCardName(){
		return name;
	}

	// This method adds an attribute to an arraylist called Attributes.
	protected void addAttribute(Attribute a){
		Attributes.add(a);
	}

	// This method prints out the name and skill value of the selected attribute by one of the players.
	protected void printAll(){
		for (int i=0; i<Attributes.size();i++){
			Attribute selectedAttribute = Attributes.get(i);
			System.out.println("---" + selectedAttribute.name + ": " + selectedAttribute.skillValue);
		}
		System.out.println("***");
	}

	/**
	 * @param index - determines the choice of attribute depending on postiion in the array attribute.
	 * @return the value of attribute.
	 */
	protected Attribute grabAttribute(int index){
		return Attributes.get(index);
	}
}
