import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.CDL;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CategoryList {
	//ArrayList<CategoryItem> categoryList;
	private static final String CATEGORIES_API_URL = "https://api.nal.usda.gov/ndb/V2/reports?ndbno=45282024&ndbno=01009&ndbno=45282024&ndbno=35193&type=b&format=json&api_key=DEMO_KEY";
	private static final String USER_AGENT = "Mozilla/5.0";
	static int confirmAllergen=0;

	//public CategoryList() throws Exception {
	//	//categoryList = getCategoryListFromApi();
	//}

	public static  int getCategoryListFromApi(String CATEGORIES_API_URL) throws IOException, JSONException {

		URL obj = new URL(CATEGORIES_API_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		JSONObject json = new JSONObject(response.toString());
		JSONArray jsonarray;

		jsonarray = json.getJSONArray("foods");
		//ArrayList<CategoryItem> tempCategories = new ArrayList<CategoryItem>(jsonarray.length() + 100);
		System.out.println(jsonarray.length());
		System.out.println(jsonarray);
		for (int i = 0; i < jsonarray.length(); i++) {
			json = new JSONObject(jsonarray.get(i).toString());
			System.out.println(jsonarray.get(i));
			String json2=json.toString();
			System.out.println(GroceryList.allergen);
			if(json2.contains(GroceryList.allergen.toUpperCase())) {
				confirmAllergen=1;
				System.out.println("hi");
				return confirmAllergen;
			}}
		return 0;
			
			
		
		}

	public static void main(String[] args) throws IOException, JSONException {
		getCategoryListFromApi("https://api.nal.usda.gov/ndb/V2/reports?ndbno=45282024&ndbno=01009&ndbno=45282024&ndbno=35193&type=b&format=json&api_key=QplOffXjlhDbrqF5magVebNz0loaRLjAXEvPQMgN");
		
	}}


	
