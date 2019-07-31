import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;


/**This Class creates and compiles recipes with their ingredients.  It has an indicator
 * for recipe selection or food allergy.
 * @author rachelsickle
 *
 */
public class Recipe {
	 public String  recipeName;
	 int allergyRestriction;
	 int recipeSelected;
	 static File selectedFile;
	 
	 static String recipeNamestatic;
	String recipeIngredient;
	String recipeIngredientQuantity;
	HashMap<String,String> recipeIngredients=new HashMap< >();
	 static String recipeIngredientStatic;
	 static String recipeIngredientQuantityStatic;
	 static String recipeFilename;
	 static String recipeNamed;
	 static File recipeFile;
	 static int x=1;
	 static ArrayList<Recipe> cookBook= new ArrayList<Recipe>();
	 static String recipeNameScanned;
	 int selected;
	 static File cookBookFile =new File("cookbook.txt");
	 static String prompt="Hello";
	
		 

 Recipe (String recipeName1,HashMap<String,String> recipeIngredients1, int allergy,int selected ) {
	 recipeName=recipeName1;
	 allergyRestriction=allergy;
	 recipeSelected=selected; 
	 recipeIngredients=recipeIngredients1;
 }
	
 /**
	 * This method allows a user to upload a recipe file in a specified format. .txt
	 * document with the first line the recipe name and subsequent lines the recipe
	 * ingredient and quantities alternating. This method asks the user to check
	 * file input for load into the cookBook file. It loads the file to the cookBook
	 * in csv format.
	 * 
	 * @throws FileNotFoundException for files not loaded
	 */
	public static void uploadRecipeFile(String absFile) throws FileNotFoundException {

		ArrayList<String> csvArray = new ArrayList<>();
		Recipe.recipeFile = new File(absFile);
		Scanner scanner = new Scanner(Recipe.recipeFile);
		Recipe.recipeNamed = scanner.nextLine();
		
		//parses ingredients into a HashMap so user can confirm format is correct
		while (scanner.hasNext()) {
			Recipe.recipeIngredientStatic = scanner.nextLine();
			Recipe.recipeIngredientQuantityStatic = scanner.nextLine();
			String csvLine = "\n"+ "\n"+Recipe.recipeNamed +"\n"+ " Last Ingredient " + "\n"+Recipe.recipeIngredientStatic + ", "
					+ Recipe.recipeIngredientQuantityStatic + '\n';
			csvArray.add(csvLine);
			UserInterface.gTextArea.setText(csvLine);
			
		}

	}

	/**
	 * This method adds the recipe to the cookBookfile in a .csv format
	 * @param recipeFile is a file created in .csv format with recipe name,
	 *                   ingredient,and quantity on each line
	 * @throws IOException if a problem occurs with the cookBook file when adding the
	 *                     recipe
	 */
	public static void appendToCookbook(File recipeFile) throws IOException {

		try (Writer fileWriter = new FileWriter(Recipe.cookBookFile, true)) {
			{
				UserInterface.recipeCheck.setVisible(false);
				Scanner scanner = new Scanner(recipeFile);
				String recipeName = scanner.nextLine();
				while (scanner.hasNext()) {
					String indredientToAppend = scanner.nextLine();
					String quantityToAppend = scanner.nextLine();
					fileWriter.write(recipeName + ',' + indredientToAppend + ',' + quantityToAppend + '\n');
				}
			}
			fileWriter.close();
			UserInterface.labArea.setText(Recipe.recipeNamed+ " loaded");
		} catch (IOException e) {
			System.out.println("Problem occurs when adding the recipe : " + Recipe.cookBookFile);
			e.printStackTrace();
			UserInterface.button3.setEnabled(false);
			

		}
	}

	/**
	 * This method parses the CookBook file into recipe objects .
	 * 
	 * @throws FileNotFoundException is the cookBook.txt file is not found
	 */
	public static void CookBookInformationReader() throws FileNotFoundException {
		HashMap<String, String> ingredients = new HashMap<>();
		;
		HashMap<String, HashMap<String, String>> cookbookInformation = new HashMap<>();
		;
		ArrayList<String> recipeList = new ArrayList<String>();

		int x = 1;
		try {
			Scanner scanner = new Scanner(Recipe.cookBookFile);
			String blank = scanner.nextLine();
			while (scanner.hasNextLine()) {
				String cookbookRow = scanner.nextLine();
				String[] columnData = cookbookRow.split(",");
				String crecipeName = columnData[0];
				String recipeIngredient = columnData[1];
				String recipeIngredientQuantity = columnData[2];


				if (recipeList.contains(crecipeName)) {
					ingredients.put(recipeIngredient, recipeIngredientQuantity);
				} else {
					if (recipeList.size() > 0) {
						HashMap<String, String> new_hash_map = new HashMap<String, String>();
						new_hash_map.putAll(ingredients);
						Recipe.cookBook.add(new Recipe((recipeList.get(recipeList.size() - 1)), new_hash_map, 0, 0));
						ingredients.clear();
						recipeList.add(crecipeName);
						ingredients.put(recipeIngredient, recipeIngredientQuantity);
					} else {
						recipeList.add(crecipeName);
						ingredients.put(recipeIngredient, recipeIngredientQuantity);
					}

				}

			}
			HashMap<String, String> new_hash_map = new HashMap<String, String>();
			new_hash_map.putAll(ingredients);
			Recipe.cookBook.add(new Recipe((recipeList.get(recipeList.size() - 1)), new_hash_map, 0, 0));

			scanner.close();
		}

		catch (FileNotFoundException e) {
			System.out.println("cookBook.txt file not found");
			e.printStackTrace();
		}
		

	}

}
	


