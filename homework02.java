
/*
 * Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл
 */

import java.util.Arrays;
import java.util.Random;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import com.sun.tools.javac.Main;


public class homework02 {
    public static void main(String[] args) {
        final int ARR_SIZE = 10;

        Logger logger = Logger.getLogger(Main.class.getName());
        logger.setLevel(Level.INFO);
        ConsoleHandler ch = new ConsoleHandler();
        logger.addHandler(ch);
        logger.setUseParentHandlers(false); // иначе вываливает в консоль все по два раза
        SimpleFormatter sFormat = new SimpleFormatter();
        ch.setFormatter(sFormat);

        int[] arr = new int[ARR_SIZE];
        arr = GetIntRandomArray(arr);
        logger.info(Arrays.toString(arr));
        
        boolean swapped = true;
        while (swapped){            
            swapped = false;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i-1] > arr[i]){
                    int temp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
            logger.info(Arrays.toString(arr));                    
        }        
    }

    public static int[] GetIntRandomArray(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }
        return arr;
    }

}
