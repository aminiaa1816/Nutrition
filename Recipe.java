import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;


/**This Class creates and compiles recipes with their ingredients.  It has an indicator
 * for recipe selection or food allergy.
 * @author rachelsickle
 *
 */
public class Recipe {
	 public String  recipeName;
	 int allergyRestriction;
	 int recipeSelected;
	 
	 static String recipeNamestatic;
	String recipeIngredient;
	String recipeIngredientQuantity;
	HashMap<String,String> recipeIngredients=new HashMap< >();
	 static String recipeIngredientStatic;
	 static String recipeIngredientQuantityStatic;
	 static String recipeFilename;
	 static int x=1;
	 static ArrayList<Recipe> cookBook= new ArrayList<Recipe>();
	 static String recipeNameScanned;
	 int selected;
	 static File cookBookFile =new File("cookbook.txt");
	
		
	 
	
 Recipe (String recipeName1,HashMap<String,String> recipeIngredients1, int allergy,int selected ) {
	 recipeName=recipeName1;
	 allergyRestriction=allergy;
	 recipeSelected=selected; 
	 recipeIngredients=recipeIngredients1;
 }
	

/**This method allows the user to manually input recipes.
 * 
 */
public void inputRecipeManual(){
	System.out.println("Please enter recipe Name");
	Scanner in =new Scanner(System.in);
	recipeName=in.nextLine();
	System.out.println("Recipe Name is  "+ recipeName);
	int y=0;
	while(y==0){
	System.out.println("Enter Ingredient Name or 'q' if complete");
	recipeIngredient= in.nextLine();
	System.out.println("Enter Ingredient Quantity");
	recipeIngredientQuantity=in.nextLine();
	recipeIngredients.put(recipeIngredientStatic, recipeIngredientQuantityStatic);}	
	System.out.println("Recipe Name  "+ recipeName + "Loaded");
	Recipe recipe= new Recipe(recipeName, recipeIngredients,0,0);
	//cookBook.put(x,recipe);

	
}	
	

/**This method allows a user to upload a recipe file in a specified format.  
 * .txt document  with the first line the recipe name and subsequent lines the recipe ingredient and 
 * quantities alternating.
 * This method asks the user to check file input for load into the cookBook file.
 * It loads the file to the cookBook in csv format. 
 * @throws FileNotFoundException for files not loaded
 */
public static void uploadRecipeFile() throws FileNotFoundException{	
	
	int load=0;
	File recipeFile = null;
	while(load==0) 
	{
		
	System.out.println("Please enter recipe filename");
	Scanner in = new Scanner(System.in);
	recipeFilename=in.nextLine();
	recipeFile =new File(recipeFilename);
	Scanner scanner = new Scanner(recipeFile);
	System.out.println(" Importing " + recipeFilename+ "  recipe......");
	String recipeNamed=scanner.nextLine();
	System.out.println(recipeNamed  + "  is the recipe name");
	while (scanner.hasNext()) 
	{
	recipeIngredientStatic=scanner.nextLine();
	recipeIngredientQuantityStatic=scanner.nextLine();
	String csvLine=recipeNamed +","+recipeIngredientStatic+","+recipeIngredientQuantityStatic+'\n';
	System.out.println(csvLine);}
	
	System.out.println(recipeNamed + "   has been scanned");
	System.out.println("Did recipe load properly? Enter 'yes' or 'no'");
	load=in.nextInt();
	System.out.println(load);
	}
	
	try {
		appendToCookbook(recipeFile);
	} catch (IOException e) {
		System.out.println("File not found: " + recipeFilename);
		e.printStackTrace();
	}

}
	

/**This method adds the recipe to the cookBookfile in a .csv format
 * @param recipeFile
 * @throws IOException
 */
public static void appendToCookbook(File recipeFile) throws IOException
	{
	
	try (Writer fileWriter = new FileWriter(cookBookFile, true))
	{
		{
			Scanner scanner = new Scanner(recipeFile);
			String recipeName=scanner.nextLine();
		while (scanner.hasNext()) 
		{
	    String indredientToAppend = scanner.nextLine();	
	    String quantityToAppend = scanner.nextLine();	
	    fileWriter.write(recipeName+','+ indredientToAppend +','+quantityToAppend +'\n' );
		}
		}
		fileWriter.close();
		System.out.println("loaded");}
	catch (IOException e) {
	System.out.println("Problem occurs when adding the recipe : " + cookBookFile);
	e.printStackTrace();
	

	}}
    

	/**This method parses the CookBook file into recipe objects .
	 * @throws FileNotFoundException is the cookBook.txt file is not found
	 */
	public static void CookBookInformationReader() throws FileNotFoundException{	
		 HashMap<String, String> ingredients=new HashMap< >();;
		  HashMap<String, HashMap<String, String>> cookbookInformation=new HashMap< >();; 
		  ArrayList <String> recipeList= new ArrayList <String> ();
		
		int x=1;
		try {
			Scanner scanner = new Scanner(cookBookFile);
			String blank=scanner.nextLine();
			while(scanner.hasNextLine()) 
			{
				String cookbookRow=scanner.nextLine();
				//System.out.println(scanner.nextLine());// Scanner
				String[]columnData=cookbookRow.split(",");
				String crecipeName=columnData[0];
				//System.out.println(recipeName);
				String recipeIngredient=columnData[1];
				//System.out.println(recipeIngredient);
				String recipeIngredientQuantity=columnData[2];
				//System.out.println(recipeIngredientQuantity);
				
				if(recipeList.contains(crecipeName)){
				ingredients.put(recipeIngredient,recipeIngredientQuantity);}
				else
				{if (recipeList.size()>0){
				//cookbookInformation.put(recipeList.get(recipeList.size() - 1),ingredients);
				HashMap<String, String> new_hash_map = new HashMap<String, String>(); 
			        new_hash_map.putAll(ingredients); 
				cookBook.add(new Recipe((recipeList.get(recipeList.size() - 1)),new_hash_map,0,0));
				
				//new HashMap<String,String> Object ingredients1;
				
				ingredients.clear();
				recipeList.add(crecipeName);
				ingredients.put(recipeIngredient,recipeIngredientQuantity);
				}else {recipeList.add(crecipeName);
				ingredients.put(recipeIngredient,recipeIngredientQuantity);}
				
				}
				
			}HashMap<String, String> new_hash_map = new HashMap<String, String>(); 
	        new_hash_map.putAll(ingredients); 
	        cookBook.add(new Recipe((recipeList.get(recipeList.size() - 1)),new_hash_map,0,0));
		
			scanner.close();}
				
				catch(FileNotFoundException e){
					e.printStackTrace();}
		for (int x1=0; x1<cookBook.size(); x1++)
		{
			System.out.println(cookBook.get(x1).recipeName);
			System.out.println(cookBook.get(x1).recipeIngredients);
			}}
		
		
		
	
		
	
		
	




public static void main(String[] args) throws FileNotFoundException {
	
	CookBookInformationReader();
	
	
	


}
	
}//end

