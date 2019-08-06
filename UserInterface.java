import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.io.File;
import java.awt.Component;

/**
 * This class provides the GUI to load recipes, enter allergy restrictions,
 * Display recipes free from the allergen, select recipes for a grocery list,
 * and displays a list of ingredients as a grocery list.
 */
public class UserInterface extends JFrame implements ActionListener {

	// Container for the 6 display panels
	Container container = new JFrame("Grocey Assistant");

	static JTextField recipeCheck = new JTextField();
	JPanel p2 = new JPanel();
	JPanel p1 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	JPanel p6 = new JPanel();

	// Panel 1 components
	static JButton button2 = new JButton("Load New Recipe");
	static JButton button3 = new JButton("Confirm Recipe");
	static JButton button4 = new JButton("Add Recipe URL");
	static JButton button5 = new JButton("Get Recipe List");
	static JButton button7 = new JButton("Extra");
	static JTextField allergyTextArea = new JTextField("Allergen Input");

	// Panel 2 components and default labels
	ArrayList<JButton> rlist = new ArrayList<>();
	String[] test = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
	JButton buttonR1 = new JButton(test[0]);
	JButton buttonR2 = new JButton(test[1]);
	JButton buttonR3 = new JButton(test[2]);
	JButton buttonR4 = new JButton(test[3]);
	JButton buttonR5 = new JButton(test[4]);
	JButton buttonR6 = new JButton(test[5]);
	JButton buttonR7 = new JButton(test[6]);
	JButton buttonR8 = new JButton(test[7]);
	JButton buttonR9 = new JButton(test[8]);
	JButton buttonR10 = new JButton(test[9]);

	// Panel 4 Components (table) - table used to display HashMaps
	static JTable table = new JTable(10, 2);

	// Panel 5 Components (Get Grocery List Button, User info test field(labArea),
	static JButton buttonGetList = new JButton("Get Grocery List");
	static JTextArea labArea = new JTextArea("Welcome");
	static JButton button6 = new JButton("Reset List");

	// Panel 6 Components
	static JTextArea gTextArea = new JTextArea("");
	static JTextField urlTextArea = new JTextField("Enter Recipe URL Here");

	// count for method display compiling recipe file.
	static int y = 1;

	// a default constructor
	UserInterface() {
	}

	void setLayout() throws IOException {

		// Container settings
		container.setLayout(new GridLayout(2, 3));
		container.setSize(650, 650);
		container.setVisible(true);
		((JFrame) container).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Panel 1 settings
		labArea.setText("Welcome");
		p1.setLayout(new BorderLayout());
		p1.add(button2, BorderLayout.WEST);
		p1.add(button3, BorderLayout.WEST);
		p1.add(button4, BorderLayout.WEST);
		p1.add(button5, BorderLayout.WEST);
		p1.add(button7, BorderLayout.WEST);
		p1.add(allergyTextArea, BorderLayout.NORTH);

		button2.setBounds(75, 25, 120, 50);
		button3.setBounds(75, 75, 120, 50);
		button4.setBounds(75, 125, 120, 50);
		button5.setBounds(75, 175, 120, 50);

		button7.setVisible(false);
		button3.setEnabled(false);

		// P1 add action listener to the button to capture user
		// response on buttons

		button2.addActionListener(new MyOKListener());
		button3.addActionListener(new MyOKListener());
		button4.addActionListener(new MyOKListener());
		button5.addActionListener(new MyOKListener());
		allergyTextArea.addActionListener(new MyOKListener());
		

		// Display for p2
		p2.setLayout(new GridLayout(10, 3, 33, 7));
		container.setSize(650, 500);

		// gTextArea.setBounds(10, 100, 300, 30);

		// Add components p2 and add Listener

		p2.add(buttonR1);
		rlist.add(buttonR1);
		p2.add(buttonR2);
		rlist.add(buttonR2);
		p2.add(buttonR3);
		rlist.add(buttonR3);
		p2.add(buttonR4);
		rlist.add(buttonR4);
		p2.add(buttonR5);
		rlist.add(buttonR5);
		p2.add(buttonR6);
		rlist.add(buttonR6);
		p2.add(buttonR7);
		rlist.add(buttonR7);
		p2.add(buttonR8);
		rlist.add(buttonR8);
		p2.add(buttonR9);
		rlist.add(buttonR9);
		p2.add(buttonR10);
		rlist.add(buttonR10);
		buttonR1.addActionListener(new MyOKListener());
		buttonR1.setActionCommand("R1");
		buttonR2.addActionListener(new MyOKListener());
		buttonR2.setActionCommand("R2");
		buttonR3.addActionListener(new MyOKListener());
		buttonR3.setActionCommand("R3");
		buttonR4.addActionListener(new MyOKListener());
		buttonR4.setActionCommand("R4");
		buttonR5.addActionListener(new MyOKListener());
		buttonR5.setActionCommand("R5");
		buttonR6.addActionListener(new MyOKListener());
		buttonR6.setActionCommand("R6");
		buttonR7.addActionListener(new MyOKListener());
		buttonR7.setActionCommand("R7");
		buttonR8.addActionListener(new MyOKListener());
		buttonR8.setActionCommand("R8");
		buttonR9.addActionListener(new MyOKListener());
		buttonR9.setActionCommand("R9");
		buttonR10.addActionListener(new MyOKListener());
		buttonR10.setActionCommand("R10");

		// Panel 3 settings
		//BufferedImage image = ImageIO.read(new File("pictures/hash2.jpg"));
		//JLabel picLabel = new JLabel(new ImageIcon(image));
		//p3.add(picLabel, BorderLayout.CENTER);
		

		// Panel 4 settings
		p4.setLayout(new BorderLayout());
		p4.add(table);

		// Panel 5 settings
		p5.setLayout(new BorderLayout());

		p5.add(buttonGetList, BorderLayout.SOUTH);
		buttonGetList.addActionListener(new MyOKListener());
		labArea.setLineWrap(true);
		p5.add(labArea, BorderLayout.CENTER);
		p5.add(urlTextArea,BorderLayout.NORTH);
		// Panel 6 settings
		urlTextArea.addActionListener(new MyOKListener());
		
		button6.addActionListener(new MyOKListener());
		button6.setBounds(75, 200, 120, 50);
		p6.setLayout(new BorderLayout());
		p6.add(gTextArea, BorderLayout.CENTER);
		p6.add(button6, BorderLayout.NORTH);
		gTextArea.setLineWrap(true);
		button6.setVisible(false);

		container.add(p1);
		container.add(p5);
		container.add(p3);
		container.add(p6);
		container.add(p2);
		container.add(p4);
		container.show();

	}

	/**
	 * This method takes the first 10 recipe names in the nonAllergen Recipe list
	 * and adds the names to the button text.
	 */
	void addButtons(ArrayList<Recipe> condensedList) {

		for (int n = 0; n < condensedList.size() && n < 10; n++) {
			rlist.get(n).setText(condensedList.get(n).recipeName);
			//System.out.println(condensedList.get(n).recipeName);
			rlist.get(n).setEnabled(true);
			//p2.revalidate();
			//p2.repaint();
		}
	}

	/**
	 * This method resets the button text with a number incrementing from 1 to 10
	 * when. It clears the button text of recipe names.
	 */
	void removeButtons() {
		for (int n = 0; n < 10; n++) {
			String numberAsString = Integer.toString(n + 1);
			rlist.get(n).setText(numberAsString);
			rlist.get(n).setEnabled(false);
			rlist.get(n).setForeground(Color.BLACK);
			//p2.revalidate();
			//p2.repaint();
		}
	}

	public static void main(String[] args) throws IOException {
		new UserInterface().setLayout();

		System.out.println("This is the " + Recipe.cookBook);

	}

	class MyOKListener implements ActionListener {
		/**
		 * This method implements actions upon mouse click. It opens a file displays the
		 * last line of the file. Stores the content into a larger file. It also
		 * contains a frame form displaying static information
		 *
		 */
		public void actionPerformed(ActionEvent event) {
			{
				String absFile;
				String com = event.getActionCommand();

				// Listens for the allergen input from the user and updates the variable
				GroceryList.allergen = allergyTextArea.getText();
				WebRecipe.uRL=urlTextArea.getText();
				
				if (com.equals("Load New Recipe")) {
					// clear table
					JTable table = new JTable(2, 2);
					p4.add(table);
					// Opens file chooser and returns the absolute path of the file
					JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
					jfc.setDialogTitle("Select a text file");
					jfc.setAcceptAllFileFilterUsed(false);
					FileNameExtensionFilter filter = new FileNameExtensionFilter("text files", "txt");
					jfc.addChoosableFileFilter(filter);

					int returnValue = jfc.showOpenDialog(null);
					if (returnValue == JFileChooser.APPROVE_OPTION) {
						// Creates a new file object using the absolute path as input
						absFile = jfc.getSelectedFile().getAbsolutePath();
						Recipe.recipeFile = new File(absFile);
						
						//Enables the recipe confirm button
						//Allows user to see the last ingredient loaded to verify format
						//Runs the uploadRecipe method
						try {
							labArea.setText(absFile + "\n" + "For Review");
							Recipe.uploadRecipeFile(absFile);
							button3.setEnabled(true);
							labArea.setText("Confirm Last ingredient" + "\n" + " to load recipe");
						} catch (FileNotFoundException e) {
							labArea.setText("File Not Found");
							e.printStackTrace();
						}
					}
					// if the user cancelled the operation
					else {
						labArea.setText("the user cancelled the operation");
					}
				}

				if (com.equals("Confirm Recipe")) {
					// Confirms the recipe, loads the recipe to the cookBook, disables the 
					//confirm button, and displays load information to user and next step options
					try {
						Recipe.appendToCookbook(Recipe.recipeFile);
						button3.setEnabled(false);
						gTextArea.setText("");
						labArea.setText("Load New Recipe" + "\n" + "or" + "\n" + "Input Allergy Ingredient" + "\n"
								+ "and click Get Recipe List");
					} catch (IOException e) {
						labArea.setText("cookBook Not Found");
						e.printStackTrace();

					}
				}
				;

				if (com.equals("Get Recipe List")) {

					//try {
						//if (Recipe.counter==0) {Recipe.CookBookInformationReader();
						
							//Loads new recipes for display
							
						//Recipe.counter++;
						//}

					//} catch (FileNotFoundException e) {
						//labArea.setText("cookBook Not Found");
						//e.printStackTrace();
					//}
					try {
						// Runs the method that returns the nonAllergenRecipes.
						//!!!!!!Add the following line when method the getfoodAllergies is working!!!
						GroceryList.getAllergnRecipes(); 
						GroceryList.getfoodAllergies();
					} catch (Exception e) {
						// labArea.setText("GroceryList Not Found");
						e.printStackTrace();
					}
					labArea.setText("Select Ingredients to" + "\n" + "add to grocery list");
					//!!!!!!Remove when getfoodAllergies is working
					addButtons(GroceryList.nonAllergenRecipes);
					//!!!!!!Add the following line when method getfoodAllergies is working!!!
					//addButtons(GroceryList.nonAllergenRecipes);
					button5.setEnabled(false);
					button6.setVisible(true);
					button2.setEnabled(false);
					button4.setEnabled(false);
					button2.setEnabled(false);
					
				}
				if (com.equals("Reset List")) {
					removeButtons();
					JTable table = new JTable(2, 2);
					p4.add(table);
					//!!!!!!Enable next line when resets are defined in groceryList
					GroceryList.resetAllergy();
					button5.setEnabled(true);
					button2.setEnabled(true);
					button4.setEnabled(true);
					button6.setVisible(false);
					allergyTextArea.setText("Allergen Input");
					labArea.setText("Input Allergy Ingredient" + "\n" + "then click Get Recipe List");

				}
				if (com.equals("Add Recipe URL")) {
					try {
						WebRecipe.getWebRecipe(WebRecipe.uRL);
						urlTextArea.setText(WebRecipe.recipeTitle);
						labArea.setText(WebRecipe.recipeInfo);
						gTextArea.setText(WebRecipe.recipeAllergies);
						JTable table = new JTable(WebRecipe.recipeIngredients.size(), 2);
						int row = 0;

						for (Entry<String, String> entry :WebRecipe.recipeIngredients.entrySet()) {
							table.setValueAt(entry.getKey(), row, 0);
							table.setValueAt(entry.getValue(), row, 1);
							row++;
							//Recipe.CookBookInformationReader();
						}
						p4.add(table);
						
						
						
						
						
					} catch (IOException e) {
						labArea.setText("Invalid URL");
						e.printStackTrace();
					}
				}
				if (com.contentEquals("Get Grocery List")) {
					//!!!!!!Will not work until combineListOfIngredients is working
					// and returns shoppingList HashMAP
					GroceryList.combineListOfIngredients(GroceryList.selectedRecipes);
					
					JTable table = new JTable(GroceryList.shoppingList.size(), 2);
					int row = 0;

					for (Entry<String, String> entry :GroceryList.shoppingList.entrySet()) {
						table.setValueAt(entry.getKey(), row, 0);
						table.setValueAt(entry.getValue(), row, 1);
						row++;
					}
					p4.add(table);
				}

				/// For R1 to R10 any reference CookBook needs to be replaced by 
				//nonAllergn Recipes
				/// 
				/// Selected recipes need to be added where noted

				if (com.equals("R1")) 
				{	p4.remove(table);
					buttonR1.setForeground(Color.BLUE);
					labArea.setText(Recipe.cookBook.get(0).recipeName + " Added");
					//labArea.setText(GroceryList.nonAllergenRecipes.get(0).recipeName + " Added");
					// GroceryList.selectedRecipes.add(GroceryList.nonAllergenRecipes.get(0));
					HashMap<String, String> map = Recipe.cookBook.get(0).recipeIngredients;
					//HashMap<String, String> map = nonAllergenRecipes.get(0).recipeIngredients;
					JTable table = new JTable(map.size(), 2);
					int row = 0;
					for (Entry<String, String> entry : map.entrySet()) {
						table.setValueAt(entry.getKey(), row, 0);
						table.setValueAt(entry.getValue(), row, 1);
						row++;
					}
					p4.add(table);
				}
				
				if (com.equals("R2")) 
				{	p4.remove(table);
					buttonR2.setForeground(Color.BLUE);
					labArea.setText(Recipe.cookBook.get(1).recipeName + " Added");
					//labArea.setText(GroceryList.nonAllergenRecipes.get(1).recipeName + " Added");
					// GroceryList.selectedRecipes.add(GroceryList.nonAllergenRecipes.get(1));
					HashMap<String, String> map = Recipe.cookBook.get(1).recipeIngredients;
					//HashMap<String, String> map = nonAllergenRecipes.get(1).recipeIngredients;
					JTable table = new JTable(map.size(), 2);
					int row = 0;
					for (Entry<String, String> entry : map.entrySet()) {
						table.setValueAt(entry.getKey(), row, 0);
						table.setValueAt(entry.getValue(), row, 1);
						row++;
					}
					p4.add(table);
				}
				if (com.equals("R3")) 
				{	p4.remove(table);
					buttonR3.setForeground(Color.BLUE);
					labArea.setText(Recipe.cookBook.get(2).recipeName + " Added");
					//labArea.setText(GroceryList.nonAllergenRecipes.get(2).recipeName + " Added");
					// GroceryList.selectedRecipes.add(GroceryList.nonAllergenRecipes.get(2));
					HashMap<String, String> map = Recipe.cookBook.get(2).recipeIngredients;
					//HashMap<String, String> map = nonAllergenRecipes.get(2).recipeIngredients;
					JTable table = new JTable(map.size(), 2);
					int row = 0;
					for (Entry<String, String> entry : map.entrySet()) {
						table.setValueAt(entry.getKey(), row, 0);
						table.setValueAt(entry.getValue(), row, 1);
						row++;
					}
					p4.add(table);
				}
				if (com.equals("R4")) 
				{	p4.remove(table);
					buttonR4.setForeground(Color.BLUE);
					labArea.setText(Recipe.cookBook.get(3).recipeName + " Added");
					//labArea.setText(GroceryList.nonAllergenRecipes.get(3).recipeName + " Added");
					// GroceryList.selectedRecipes.add(GroceryList.nonAllergenRecipes.get(3));
					HashMap<String, String> map = Recipe.cookBook.get(3).recipeIngredients;
					//HashMap<String, String> map = nonAllergenRecipes.get(3).recipeIngredients;
					JTable table = new JTable(map.size(), 2);
					int row = 0;
					for (Entry<String, String> entry : map.entrySet()) {
						table.setValueAt(entry.getKey(), row, 0);
						table.setValueAt(entry.getValue(), row, 1);
						row++;
					}
					p4.add(table);
				}
				if (com.equals("R5")) 
				{	p4.remove(table);
					buttonR5.setForeground(Color.BLUE);
					labArea.setText(Recipe.cookBook.get(4).recipeName + " Added");
					//labArea.setText(GroceryList.nonAllergenRecipes.get(4).recipeName + " Added");
					// GroceryList.selectedRecipes.add(GroceryList.nonAllergenRecipes.get(4));
					HashMap<String, String> map = Recipe.cookBook.get(4).recipeIngredients;
					//HashMap<String, String> map = nonAllergenRecipes.get(4).recipeIngredients;
					JTable table = new JTable(map.size(), 2);
					int row = 0;
					for (Entry<String, String> entry : map.entrySet()) {
						table.setValueAt(entry.getKey(), row, 0);
						table.setValueAt(entry.getValue(), row, 1);
						row++;
					}
					p4.add(table);
				}
				if (com.equals("R6")) 
				{	p4.remove(table);
					buttonR6.setForeground(Color.BLUE);
					labArea.setText(Recipe.cookBook.get(5).recipeName + " Added");
					//labArea.setText(GroceryList.nonAllergenRecipes.get(5).recipeName + " Added");
					// GroceryList.selectedRecipes.add(GroceryList.nonAllergenRecipes.get(5));
					HashMap<String, String> map = Recipe.cookBook.get(5).recipeIngredients;
					//HashMap<String, String> map = nonAllergenRecipes.get(5).recipeIngredients;
					JTable table = new JTable(map.size(), 2);
					int row = 0;
					for (Entry<String, String> entry : map.entrySet()) {
						table.setValueAt(entry.getKey(), row, 0);
						table.setValueAt(entry.getValue(), row, 1);
						row++;
					}
					p4.add(table);
				}
				if (com.equals("R7")) 
				{	p4.remove(table);
					buttonR7.setForeground(Color.BLUE);
					labArea.setText(Recipe.cookBook.get(6).recipeName + " Added");
					//labArea.setText(GroceryList.nonAllergenRecipes.get(6).recipeName + " Added");
					// GroceryList.selectedRecipes.add(GroceryList.nonAllergenRecipes.get(6));
					HashMap<String, String> map = Recipe.cookBook.get(6).recipeIngredients;
					//HashMap<String, String> map = nonAllergenRecipes.get(6).recipeIngredients;
					JTable table = new JTable(map.size(), 2);
					int row = 0;
					for (Entry<String, String> entry : map.entrySet()) {
						table.setValueAt(entry.getKey(), row, 0);
						table.setValueAt(entry.getValue(), row, 1);
						row++;
					}
					p4.add(table);
				}
				if (com.equals("R8")) 
				{	p4.remove(table);
					buttonR8.setForeground(Color.BLUE);
					labArea.setText(Recipe.cookBook.get(7).recipeName + " Added");
					//labArea.setText(GroceryList.nonAllergenRecipes.get(7).recipeName + " Added");
					// GroceryList.selectedRecipes.add(GroceryList.nonAllergenRecipes.get(7));
					HashMap<String, String> map = Recipe.cookBook.get(7).recipeIngredients;
					//HashMap<String, String> map = nonAllergenRecipes.get(7).recipeIngredients;
					JTable table = new JTable(map.size(), 2);
					int row = 0;
					for (Entry<String, String> entry : map.entrySet()) {
						table.setValueAt(entry.getKey(), row, 0);
						table.setValueAt(entry.getValue(), row, 1);
						row++;
					}
					p4.add(table);
				}
				if (com.equals("R9")) 
				{	p4.remove(table);
					buttonR9.setForeground(Color.BLUE);
					labArea.setText(Recipe.cookBook.get(8).recipeName + " Added");
					//labArea.setText(GroceryList.nonAllergenRecipes.get(8).recipeName + " Added");
					// GroceryList.selectedRecipes.add(GroceryList.nonAllergenRecipes.get(8));
					HashMap<String, String> map = Recipe.cookBook.get(8).recipeIngredients;
					//HashMap<String, String> map = nonAllergenRecipes.get(8).recipeIngredients;
					JTable table = new JTable(map.size(), 2);
					int row = 0;
					for (Entry<String, String> entry : map.entrySet()) {
						table.setValueAt(entry.getKey(), row, 0);
						table.setValueAt(entry.getValue(), row, 1);
						row++;
					}
					p4.add(table);
				}
				if (com.equals("R10")) 
				{	p4.remove(table);
					buttonR10.setForeground(Color.BLUE);
					labArea.setText(Recipe.cookBook.get(9).recipeName + " Added");
					//labArea.setText(GroceryList.nonAllergenRecipes.get(9).recipeName + " Added");
					// GroceryList.selectedRecipes.add(GroceryList.nonAllergenRecipes.get(9));
					HashMap<String, String> map = Recipe.cookBook.get(9).recipeIngredients;
					//HashMap<String, String> map = nonAllergenRecipes.get(9).recipeIngredients;
					JTable table = new JTable(map.size(), 2);
					int row = 0;
					for (Entry<String, String> entry : map.entrySet()) {
						table.setValueAt(entry.getKey(), row, 0);
						table.setValueAt(entry.getValue(), row, 1);
						row++;
					}
					p4.add(table);
				}
			}}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}

