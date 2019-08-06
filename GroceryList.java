/**This class creates a grocery list compiled of ingredients, their quantities, and 
 * lists restricted food allergies.
 * @author rachelsickle
 *
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONString;



public class GroceryList {
	static HashMap<String,String> availableRecipes= new HashMap<String,String> ();
	 Integer key ;
	String api_url;
	static String allergen= "TOMATO";
	static ArrayList<Recipe>selectedRecipes =new ArrayList<Recipe>();
	static ArrayList<Recipe>nonAllergenRecipes =new ArrayList<Recipe>();
	static HashMap<String,String> shoppingList=new HashMap<String,String>();
	static ArrayList<String> LookUpIngredients=new ArrayList<>();
	private final String USER_AGENT = "Mozilla/5.0";

	public GroceryList()  throws Exception {}
		
	
	
	
	/**This method takes a recipe and compares the ingredients in the recipe to 
	 * sub-ingredients checking for the the selected allergy.  If an allergy exists
	 * the recipe object is set to 1 excluding it from selection.
	 * @param allergyIngredient- user selected restricted ingredient
	 */
	public static ArrayList<String> getAllergnRecipes() throws IOException, JSONException  {
		if (Recipe.counter==0) {Recipe.CookBookInformationReader();Recipe.counter++;} ;
		int n=0;
		ArrayList<String> lookUPArray=new ArrayList<String>();
		for (n=0; n<Recipe.cookBook.size();n++) {
				for(String key : Recipe.cookBook.get(n).recipeIngredients.keySet()) 
				{//System.out.println(key);
				
				System.out.println(GroceryList.allergen.toUpperCase());
					if(key.toUpperCase().contains(allergen.toUpperCase())) {
						//System.out.println(key.toUpperCase() + GroceryList.allergen.toUpperCase());
					Recipe.cookBook.get(n).setAllergyRestriction(1);
					break;
				}
					String numfind= NumLookup.getNumberFromApi(key.toUpperCase() );
					//System.out.println(key.toUpperCase() +numfind);
					if(lookUPArray.size()<24);
					lookUPArray.add(numfind);}
				
				if (lookUPArray.size()>0) {
				constructTheAPI(lookUPArray);
				CategoryList.getCategoryListFromApi(constructTheAPI(lookUPArray));}
				System.out.println(CategoryList.confirmAllergen);
				if (CategoryList.confirmAllergen==1){
					Recipe.cookBook.get(n).setAllergyRestriction(1);
					System.out.println("Recipe "+Recipe.cookBook.get(n)+ Recipe.cookBook.get(n).allergyRestriction+ "sucesssssssssssssssss");
				}lookUPArray.clear();
				//return lookUPArray;}}
		
				}
		return lookUPArray;}
	
			




	public static String constructTheAPI(ArrayList<String>ndbnoNumbers ) throws IOException, JSONException {
	String addNdbo="";
	String addNdbos="";
	String webpart1="https://api.nal.usda.gov/ndb/V2/reports?";
	String webpart2="type=f&format=json&api_key=QplOffXjlhDbrqF5magVebNz0loaRLjAXEvPQMgN";
	for(int n=0;n<ndbnoNumbers.size();n++ ) {
		String ndbnoNumber=ndbnoNumbers.get(n);
		addNdbo="ndbno="+ndbnoNumber+"&";
		
		addNdbos=addNdbos+addNdbo;
		System.out.println(addNdbos);
	}
	String fullUrl=webpart1+addNdbos+webpart2;
	//System.out.println(fullUrl);
	CategoryList.getCategoryListFromApi(fullUrl);
	return fullUrl;
	}
	
	
	
	
	
	/**This method resets all recipe objects with allergyRestriction to 0, so that 
	 * the recipes are not excluded from subsequent searches.
	 * 
	 */
	public static void resetAllergy( ) {
	for (int x1 = 0; x1 < Recipe.cookBook.size(); x1++) {
		Recipe.cookBook.get(x1).setAllergyRestriction(0);}
		//GroceryList.allergen="Allergen Input";
		//GroceryList.selectedRecipes.clear();
		//GroceryList.shoppingList.clear();
	
	}
	
	
	
	/**This method displays the recipes without allergyRestriction.  User selects
	 * recipes from the list.
	 * @param cookBook - An Array List of all Recipe objects
	 * return selected Recipes objects in an ArrayList
	 */
public static ArrayList<Recipe> getfoodAllergies() {
	
	int n=0;
	for (n=0; n<Recipe.cookBook.size();n++) {
		//System.out.println(Recipe.cookBook.get(n).recipeName);
		if (Recipe.cookBook.get(n).getAllergyRestriction()==0) {
			System.out.println(Recipe.cookBook.get(n).getAllergyRestriction()==0);
			nonAllergenRecipes.add(Recipe.cookBook.get(n));
				System.out.println(nonAllergenRecipes.get(n).recipeName + "non allergy");}
		}
	return nonAllergenRecipes;
	}
	
	
	
	
	
	/**This method combines and sorts alphabetically a list of common ingredients and displays list to user.
	 * It takes the quality of similar ingredients and displays a list of 
	 * quantities for each ingredient;
	 */
	public static HashMap<String,String> combineListOfIngredients(ArrayList<Recipe> selectedRecipes) {
		GroceryList.selectedRecipes=selectedRecipes;
		for(int n =0; n< GroceryList.selectedRecipes.size(); n++)  ///for every selected recipe
		{ 
			for (int m=0; m< Recipe.cookBook.get(n).recipeIngredients.size();m++) {  
				//shoppingList .add(    Add each key and value in the  recipeIngredients Hashmap to the shoppingList HashMap)
				//sort the shopping list HashMap by Ingredients
				//Return a sorted HashMap	
	}

}
		return shoppingList;
	}
	
	
	
	
	
public static void main(String[] args) throws IOException, JSONException {
	//ArrayList<String> nums= new ArrayList<String>(Arrays.asList("45001594","45001595","45001596","45001597"));
	//constructTheAPI(nums);
	//Recipe.CookBookInformationReader() ;
	//getAllergnRecipes();
	//Recipe.CookBookInformationReader() ;
	//for (int x1 = 0; x1 < Recipe.cookBook.size(); x1++) {
		//Recipe.cookBook.get(x1).getAllergyRestriction();
		//System.out.println(x1);
		//System.out.println(Recipe.cookBook.get(x1).recipeName + Recipe.cookBook.get(x1).getAllergyRestriction() + "?");}
	
	getfoodAllergies() ;
}
		
		

}