import java.util.ArrayList;
import java.util.Scanner;

/**This class prompts users to define how they want to use the application.  This can either add recipes, 
 * or create grocery list.
 * @author rachelsickle
 *
 */
public class RecipeRunner {

	public static void main(String[] args) throws Exception {
		
		GroceryList gl=new GroceryList();
		String allergen="";
		Scanner in=new Scanner(System.in);
		System.out.print("Enter Allergen: ");
		allergen=in.nextLine();
		ArrayList<String> allergen_recipes = gl.getRecipes(allergen);
		System.out.println("*******Recipes of allergen "+allergen+"*****");
		for(int i=0;i<allergen_recipes.size();i++) {
			System.out.println((i+1)+". "+allergen_recipes.get(i));
		}
		
		
	}
}

