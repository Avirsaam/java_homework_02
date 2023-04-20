import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;


/*
 * 3.* В файле содержится строка с данными:
 *[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
 *Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:
 
 *Студент Иванов получил 5 по предмету Математика.
 *Студент Петрова получил 4 по предмету Информатика.
 *Студент Краснов получил 5 по предмету Физика.
 */

public class homework03 {
    public static void main(String[] args) {
		String fileName = "json2.txt";
        String [] resultData = null;
		try (BufferedReader reader = new BufferedReader (new FileReader(fileName))){
			String line = "";
			while ((line = reader.readLine()) != null) {				
                resultData = line.substring(1, line.length() - 1).split(", ");
                for (int i = 0; i < resultData.length; i++) {
                    resultData[i] = ParsejsonObject(resultData[i]);                    
                }
			}
		}        
		catch (IOException ex){
			System.out.println ("Error: " + ex.getMessage ());
		}

        if (resultData != null){
            for (String record : resultData) {
                System.out.println(record);            
            }
        }
	}

    public static String ParsejsonObject(String jsonObject){
        
        jsonObject = jsonObject.substring(1, jsonObject.length() - 1);
		jsonObject = jsonObject.replace("\"", "");
		jsonObject = jsonObject.replace(" ", "");
		                
        Dictionary <String, String> dict = new Hashtable<>();
		for (String item : jsonObject.split(",")) {            
            dict.put(item.split(":")[0], item.split(":")[1]);            
		}
        
        StringBuilder sb = new StringBuilder();
        sb.append("Студент "  + dict.get("фамилия"));
        sb.append(" получил " + dict.get("оценка"));
        sb.append(" по предмету " + dict.get("предмет"));
		return sb.toString(); 
	}
}
