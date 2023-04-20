import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import com.sun.tools.javac.Main;







/*
 * Напишите метод, который вернет содержимое текущей папки в виде массива строк. 
 *
 * Напишите метод, который запишет массив, возвращенный предыдущим методом в файл. 
 *
 * Обработайте ошибки с помощью try-catch конструкции. 
 * В случае возникновения исключения, оно должно записаться в лог-файл.


 */
public class seminar_task05 {    

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());                
        
        try{
            WriteStringArrayToFile(FolderContentAsStringArray(), "dir_content.txt");
        }
        catch (IOException ex){
            logger.warning("Oшибка записи в файл журнала" + ex.getMessage());
        }
    }

    
    public static String [] FolderContentAsStringArray(){        
            File file = new File(System.getProperty("user.dir"));            
            return file.list();        
    }

    public static void WriteStringArrayToFile(String [] arr, String path) throws IOException{
        
        Logger logger = Logger.getLogger(Main.class.getName());
        FileHandler fh = new FileHandler("seminar_task05.log");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        try (FileWriter writer = new FileWriter (path)) {
            for (String string : arr) {
                writer.append (string + '\n');
            }            
            logger.info("Written " + arr.length + " records");
        }
        catch (IOException ex) {
            logger.warning("Error: " + ex.getMessage ());            
        }        
    }

}
