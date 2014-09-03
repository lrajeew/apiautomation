import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.lrajeew.util.FileHandler;


public class PropertyTest {
	
	public static void main(String[] args){
		try {
			Properties propertiesProd = FileHandler.readPropertyFile("C:/DWork/Data/Prod.properties");
			Properties propertiesDelete = FileHandler.readPropertyFile("C:/DWork/Data/Delete.properties");
			
			Map<String,String> prodMap = new HashMap<>();
			Map<String,String> deleteMap = new HashMap<>();
			
			for (final String name: propertiesProd.stringPropertyNames()){
				prodMap.put(name, propertiesProd.getProperty(name));
			}
			
			for (final String name: propertiesDelete.stringPropertyNames()){
				if(prodMap.containsKey(name)){
					continue;
				}
				deleteMap.put(name, propertiesDelete.getProperty(name));
			}
			
			for (Map.Entry entry : deleteMap.entrySet()) {
			    System.out.println("'"+entry.getKey() + "',");
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
