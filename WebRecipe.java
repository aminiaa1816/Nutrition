import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.text.Document;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import com.sun.jdi.connect.spi.Connection;

public class  WebRecipe{
	static String uRL= "https://www.hellofresh.com/recipes/southwestern-shrimp-tacos-5d1bb6f4fca63a001616bc78?locale=en-US";
	static String recipeTitle="";
	static String recipeInfo="";
	static String recipeAllergies="";
	static HashMap<String,String> recipeIngredients= new HashMap<>();



	

public static void getWebRecipe(String url) throws IOException {
	uRL=url;
	int x=0;

	ArrayList<String> htmlIndredient= new ArrayList<>();
	ArrayList<String> htmlAmount= new ArrayList<>();


	org.jsoup.nodes.Document doc = Jsoup.connect(url).get();
	Elements ingredientHTML=doc.select("p");
	for (org.jsoup.nodes.Element e : ingredientHTML) {
		if (x==0){recipeInfo=e.text();
		x++;
		continue;
		}
		if (x==1){recipeAllergies=e.text();
		x++;
		continue;
		}
		else {if(x%2==1) {String recipeIngredient=e.text();
		htmlIndredient.add(recipeIngredient);
		//System.out.println(htmlIndredient);
		x++;
		}
		else {String recipeIngredient=e.text();
		htmlAmount.add(recipeIngredient);
		//System.out.println(htmlAmount);
		x++;}
		}




	}
	org.jsoup.nodes.Element firstArticle = doc.select("title").first();
	String recipeTitle=firstArticle.text();
	System.out.println(recipeTitle);
	//System.out.println(htmlIndredient);
	//System.out.println(htmlAmount);
	System.out.println(recipeInfo);
	System.out.println(recipeAllergies);
	//String recipeIngredient=ingredientHTML.text();
	System.out.println(recipeTitle);
	int n=htmlIndredient.indexOf("Pepper");
	//System.out.println(n);
	for (int i=0; i<n; i++)
	{recipeIngredients.put(htmlIndredient.get(i),htmlAmount.get(i));}
		
	Recipe recipe= new Recipe(recipeTitle,recipeIngredients,0,0);
	System.out.println(recipeIngredients);
	Recipe.cookBook.add(recipe);


	}



	public static void main(String[] args) throws IOException {
		
		getWebRecipe(uRL);
	}
}

	
