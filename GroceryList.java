import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;


/**This class creates a grocery list compiled of ingredients, their quantities, and 
 * lists restricted food allergies.
 * @author rachelsickle
 *
 */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.json.JSONArray;

public class GroceryList {
	static HashMap<String,String> availableRecipes= new HashMap<String,String> ();
	 Integer key ;
	String api_url;
	
	private final String USER_AGENT = "Mozilla/5.0";

	public GroceryList()  throws Exception {
		
		/**
		String api_url = "https://chompthis.com/api/request.php?token=2skdb1TlRXf23Vs1JzC&allergen=milk&country=united%20states&brand=starbucks";
		
		URL obj = new URL(api_url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to API URL : " + api_url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		JSONObject json =  new JSONObject(response.toString());
		
		json=json.getJSONObject("products");

		Iterator<String> keys = json.keys();

		while(keys.hasNext()) {
		    String key = keys.next();
		    if (json.get(key) instanceof JSONObject) {
		    	System.out.println(json.getJSONObject(key));
		    	
		    }
		}
		**/
		//
//		System.out.println(response.toString());		
	}
	
	
	public ArrayList<String>  getRecipes(String allergen)   throws Exception {

		String api_url = "https://chompthis.com/api/request.php?token=2skdb1TlRXf23Vs1JzC&allergen="+allergen+"&country=united%20states";
		
		URL obj = new URL(api_url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to API URL : " + api_url);
		System.out.println("Response Code : " + responseCode+"\n\n");

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		JSONObject json =  new JSONObject(response.toString());
		
		json=json.getJSONObject("products");

		Iterator<String> keys = json.keys();
		ArrayList<String> allergen_recipes = new ArrayList<String>(); 
		int cnt=0;
		while(keys.hasNext()) {
		    String key = keys.next();
		    if (json.get(key) instanceof JSONObject) {
		    	allergen_recipes.add((String)json.getJSONObject(key).get("name"));
		    	cnt++;
			    	
		    }
		    
		    if(cnt==100) break;
		    
		}
				
		
		return allergen_recipes;
		
	}
	
	/**This method takes a recipe and compares the ingredients in the recipe to 
	 * sub-ingredients checking for the the selected allergy.  If an allergy exists
	 * the recipe object is set to 1 excluding it from selection.
	 * @param allergyIngredient- user selected restricted ingredient
	 */
	public void getfoodAllergies(String allergyIngredient ) {
		
		
	}
	
	
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

}
