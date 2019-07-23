import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**This class creates a grocery list compiled of ingredients, their quantities, and 
 * lists restricted food allergies.
 * @author rachelsickle
 *
 */
public class GroceryList {
	static HashMap<String,String> availableRecipes= new HashMap<String,String> ();
	 Integer key ;
	
	

	/**This method takes a recipe and compares the ingredients in the recipe to 
	 * sub-ingredients checking for the the selected allergy.  If an allergy exists
	 * the recipe object is set to 1 excluding it from selection.
	 * @param allergyIngredient- user selected restricted ingredient
	 */
	public void getfoodAllergies(String allergyIngredient ) {}
	
	
	/**This method resets all recipe objects with allergyRestriction to 0, so that 
	 * the recipes are not excluded from subsequent searches.
	 * 
	 */
	public void resetAllergy( ) {}
	
	
	
	/**This method displays the recipes without allergyRestriction.  User selects
	 * recipes from the list.
	 * @param cookBook - An Array List of all Recipe objects
	 * return selected Recipes objects in an ArrayList
	 */
	public static ArrayList<Recipe> selectRecipes (ArrayList<Recipe>cookBook) {
		return null;}
	
	
	
	
	
	/**This method combines and sorts alphabetically a list of common ingredients and displays list to user.
	 * It takes the quality of similar ingredients and displays a list of 
	 * quantities for each ingredient;
	 */
	public void combineListOfIngredients(ArrayList<Recipe> selectedRecipes) {}
	
	
public static void main(String[] args) throws FileNotFoundException {
}
}
