import java.io.File;
import java.util.HashMap;
import java.util.Map;

/*
Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида
    1 Расширение файла: txt
    2 Расширение файла: pdf
    3 Расширение файла: 
    4 Расширение файла: jpg
*/

public class seminar_task06 {
    public static void main(String[] args) {
        
        for (Map.Entry<String,Integer> thisFileTypeRecord :
            GetFileCountsByType(System.getProperty("user.dir")).entrySet()) {
                StringBuilder sb = new StringBuilder("Всего с расширением ");
                sb.append(thisFileTypeRecord.getKey().substring(1));
                sb.append(": " + thisFileTypeRecord.getValue());                
                System.out.println(sb);
        } ;
    }

    public static HashMap<String, Integer>  GetFileCountsByType (String pathToDir){        
        
        HashMap<String, Integer> result = new HashMap <String, Integer>();       

        File file = new File(pathToDir);

        int count = 1;

        for (File item : file.listFiles()) {            
            if (item.isFile()){
                String fileName = item.getName();
                String extension;

                if (fileName.indexOf('.') != -1)                    
                    extension = fileName.substring(fileName.lastIndexOf("."), fileName.length());
                else extension = ".";

                System.out.println(count + " Расширение файла: " + extension.substring(1));
                                
                if (result.containsKey(extension)) result.put(extension, result.get(extension) + 1);
                else result.put(extension, 1);
            }            
        }         
        return result;
    }
}
