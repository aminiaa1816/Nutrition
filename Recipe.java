import java.util.HashMap; 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * @author rachelsickle
 *
 */
public class Recipe {
	 static String  recipeName;
	//String recipeType;
	 static String recipeIngredient;
	 static String recipeIngredientQuantity;
	 static String recipeFilename;
	 static HashMap<String,String> recipeIngredients=new HashMap< >();
	 static HashMap<Integer,Recipe> cookBook=new HashMap< >();;
	
 private Recipe (String recipeName,HashMap<String,String> recipeIngredients1 ) {
	 this.recipeName=recipeName;
	 //this.recipeType=recipeType;
	recipeIngredients=recipeIngredients1;
 }
	

public static  HashMap<String,String> imputRecipeManual(){
	System.out.println("Please enter recipe Name");
	Scanner in =new Scanner(System.in);
	recipeName=in.nextLine();
	System.out.println("Recipe Name is  "+ recipeName);
	System.out.println("Please select recipe type: 1. Main course 2. Appetizer 3. Dessert");
	int recipeTypenum=in.nextInt();
	
	int x=0;
	while(x==0){
	System.out.println("Enter Ingredient Name or 'q' if complete");
	recipeIngredient= in.nextLine();
	System.out.println("Enter Ingredient Quantity");
	recipeIngredientQuantity=in.nextLine();
	recipeIngredients.put(recipeIngredient, recipeIngredientQuantity);}	
	System.out.println("Recipe Name  "+ recipeName + "Loaded");
	return recipeIngredients;
}	
	
public static HashMap<String,String> uploadRecipeFile() throws FileNotFoundException{	
	System.out.println("Please enter recipe filename");
	Scanner in = new Scanner(System.in);
	recipeFilename=in.nextLine();
	File recipeFile =new File(recipeFilename);
	Scanner scanner = new Scanner(recipeFile);
	System.out.println(" Importing " + recipeFilename+ "  recipe......");
	recipeName=scanner.nextLine();
	System.out.println(recipeName  + "  is the recipe name");
while (scanner.hasNext()) {
	recipeIngredient=scanner.nextLine();
	recipeIngredientQuantity=scanner.nextLine();
	recipeIngredients.put(recipeIngredient, recipeIngredientQuantity);}
	scanner.close();
	
	for(String key : recipeIngredients.keySet()) 
	{
		String ing= recipeIngredients.get(key);
		System.out.println(key + "   "+ ing);}
	System.out.println(recipeName + "   has been scanned");
	return recipeIngredients;
}

public static void setRecipeIngredients(HashMap<String, String> recipeIngredients) {
	Recipe.recipeIngredients = recipeIngredients;}

public static HashMap<Integer,Recipe> createRecipe() {
	int x=1;
	Recipe recipe= new Recipe(recipeName, Recipe.recipeIngredients);
	cookBook.put(x,recipe);
	x++;
	return cookBook;
}


public static void main(String[] args) throws FileNotFoundException {
	//Recipe.imputRecipeManual();
	uploadRecipeFile();
	setRecipeIngredients(recipeIngredients);
	createRecipe();
	
	


}
	
}//end

