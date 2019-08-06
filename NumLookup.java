
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class  NumLookup {
	//ArrayList<CategoryItem> categoryList;
	static HashMap<String, String> ingredientDictAPI=new HashMap<>();
	//static String search="potato";
	
	
	private static final String USER_AGENT = "Mozilla/5.0";
	

	public NumLookup() throws Exception {
		//String NumLookup = getNumberFromApi();
		
		
	}

	static String getNumberFromApi(String search) throws IOException, JSONException {
		final String NUM_LOOKUP_API_URL ="https://api.nal.usda.gov/ndb/search/?format=json&q="+search.replaceAll("\\s","%20")+"&sort=n&max=25&offset=0&api_key=QplOffXjlhDbrqF5magVebNz0loaRLjAXEvPQMgN";
		{String ingredientNumber="00000000";
		
		URL obj = new URL(NUM_LOOKUP_API_URL);
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
		
		JSONObject object = new JSONObject(response.toString());
		 
		//System.out.println(object);
		Iterator<String> num = object.keys();
		 while (num.hasNext()) {
		        Object key = num.next();
		        String value = object.get((String) key).toString();
		        String value2 = value.substring(0);
		        //System.out.println(value);;
		        String value1=value.substring(value.indexOf("item")+8);
		        
		        String[] firstNums =value1.split("\"ndbno\":");
		        for (int x =0; x<firstNums.length;x++) {
		        	//System.out.println(firstNums[x]);
		        	if(firstNums[x].length()>0) 
		        	{
		        	String  newNum = firstNums[x].substring(1, 9);
		        	//System.out.println(newNum);
		        	String[] firstNames=value2.split("\"name\":");
		        	 //System.out.println(firstNames[x]);
				     String  newString= firstNames[x].substring(1,( firstNames[x].indexOf(",")));
				     System.out.println(newString);
		        	 ingredientDictAPI.put(newString,newNum);
		        	}
				        			
		        }}
		 for(String key : ingredientDictAPI.keySet()) 
		 {String shortName=key;
		 System.out.println(key);
		 //System.out.println(search);
		 if(shortName.contains(search)) {
			 ingredientNumber=ingredientDictAPI.get(key);
			 System.out.println(ingredientNumber);
			 return ingredientNumber;
		 }
		 }
		 System.out.println(ingredientNumber);      
		 return ingredientNumber; }      
		 }
	
	



	public static void main(String[] args) throws IOException, JSONException {
		
		//getNumberFromApi("POTATO");
		
		
	}

}

		
