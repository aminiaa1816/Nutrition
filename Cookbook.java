import java.util.ArrayList;

public class Cookbook {
	  // Use an ArrayList to store the Recipe in the cookbook
    static ArrayList<Recipe> cookBook = new ArrayList<>();
	
	public void addToCookbook (Recipe recipe) {
		this.getCookBook().add(recipe);}
		


	public ArrayList<Recipe> getCookBook() {
		System.out.println(cookBook);
		return cookBook;
	}

	public static void main(String[] args) {
		new Cookbook=
		getCookBook();
		
	}
	
	}
