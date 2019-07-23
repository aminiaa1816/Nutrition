import java.util.HashMap; 
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.Scanner;
	import java.util.ArrayList;
/**
 * This class extracts the  ingredients and sub ingredients including
 *  allergy information from the .csv file for food composition data from the usda.gov 
 * @author rachelsickle
 *
 */
public class Ingredients {
	static String ingredientsFilename="Products.csv";
			static String NDB_Number_0;
			String long_name_1;
			//data_source
			//gtin_upc
			//manufacturer_4
			//date_modified_5
			//date_available_6
			String Ingredients_english_7;
			static ArrayList<String> allergyList= new ArrayList<String>();
			static HashMap<String,Ingredients> ingredientDict=new HashMap< >();;
			public Ingredients( ) {

			}
	private Ingredients(String IngredientNumber, String long_name, ArrayList<String> Allergy ) {
		NDB_Number_0=IngredientNumber;
		long_name_1=long_name;
		allergyList=Allergy;
	}
		


/**This method  parses the  ingredients and sub ingredients including
 *  allergy information from the .csv file for food composition data from the usda.gov 
 * @throws FileNotFoundException-Exception if file not found
 */
public static HashMap<String,Ingredients>  uploadIngredientInformation() throws FileNotFoundException{	
	int n=0;
	File IngredientFile =new File(ingredientsFilename);
	Scanner scanner = new Scanner(IngredientFile);
	System.out.println(" Importing " + IngredientFile+ "  Ingredients......");
	String headers=scanner.nextLine();
	while(scanner.hasNextLine()) {
		String stringOfIndredients=scanner.nextLine();
		//System.out.println(scanner.nextLine());// Scanner
		String[]columnData=stringOfIndredients.split(",");
		NDB_Number_0=columnData[0];
		String long_name_1 =columnData[1];
		String Ingredients_english_7=columnData[7];
			String[]ingredientData=Ingredients_english_7.split(",");
			allergyList.clear();
			for(int x=0; x< ingredientData.length; x++) {
				allergyList.add(ingredientData[x]);
				//System.out.println(allergyList);
				}
			
		
			Ingredients ingredients= new Ingredients(NDB_Number_0,long_name_1,allergyList);
			ingredientDict.put(NDB_Number_0, ingredients);
				n++;
				//System.out.println(Ingredients.NDB_Number_0);
				for(String key : ingredientDict.keySet()) 
				{
					String longname= ingredientDict.get(key).long_name_1;
					
					//System.out.println(longname);
					 
			}
	}
	System.out.println("Done");

	return ingredientDict;
}
	
public static void main(String[] args) {
	try {
		uploadIngredientInformation();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

}


