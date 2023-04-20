import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * В файле содержится строка с исходными данными в такой форме:
 * {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 * 
 * Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
 * SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
 * 
 * Для разбора строки используйте String.split. 
 * Сформируйте новую строку, используя StringBuilder. 
 * Значения null не включаются в запрос.
 */
public class homework01 {
	public static void main(String[] args) {
		String fileName = "json1.txt";
		try (BufferedReader reader = new BufferedReader (new FileReader(fileName))){
			String line = "";
			while ((line = reader.readLine()) != null) {
				System.out.println (JsonToSql(line));
			}
		}		
		catch (IOException ex){
			System.out.println ("Error: " + ex.getMessage ());
		}
	}

	public static String JsonToSql(String jsonObject){
		
		jsonObject = jsonObject.substring(1, jsonObject.length() - 1);
		jsonObject = jsonObject.replace("\"", "");
		jsonObject = jsonObject.replace(" ", "");
		
		StringBuilder sb = new StringBuilder("SELECT * FROM students WHERE");
	
		for (String item : jsonObject.split(",")) {
			sb.append(" AND ");
			sb.append(String.join(" = ", item.split(":")[0],"\"" + item.split(":")[1] + "\""));
		}		
		return sb.toString(); 
	}

   
}
