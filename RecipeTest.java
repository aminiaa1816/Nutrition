import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class RecipeTest {


	private Ingredients ing = new Ingredients();


	@Test
	public void uploadRecipeFileTest() throws FileNotFoundException {

		HashMap<String,Ingredients> uploadedRecipeFile=ing.uploadIngredientInformation();
		
		assertTrue(uploadedRecipeFile.get("45001530").long_name_1.equals("BARBECUE SAUCE"));
		
	}


}
