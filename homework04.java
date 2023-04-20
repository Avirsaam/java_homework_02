
import java.util.Scanner;
import java.util.logging.Logger;

import com.sun.tools.javac.Main;


/*
 * Реализовать простой калькулятор
 * Добавить логирование в калькулятор из прошлой домашки.
 */

 public class homework04 {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());

        System.out.print("\033[H\033[2J");  
        System.out.flush();   

        System.out.println("Формат ввода:");
        System.out.println("2+2 или 2-2 или 2*2 или 2/2");
        System.out.println("-2 + 2 или 2.12356 / -24 ");
        System.out.println("доступные действия: +, -, *, /");

        Scanner myScanner = new Scanner(System.in);
        System.out.print("Введите выражение в вышеуказанном формате и нажмите ввод: ");
        String inpuString = myScanner.nextLine();
        myScanner.close();
        
        if (!inpuString.matches("^[-]?([1-9]\\d*(\\.|\\,)\\d*|0?(\\.|\\,)\\d*[1-9]\\d*|[1-9]\\d*)([ ]*)([\\+\\-\\*\\/]?)([ ]*)[-]?([1-9]\\d*(\\.|\\,)\\d*|0?(\\.|\\,)\\d*[1-9]\\d*|[1-9]\\d*)$")){
            System.out.println("Неправильный формат ввода выражения или неверный оператор, повторите ввод");
        } else {
            inpuString.replaceAll(" ", "");
            int operandPostion = -1;
            if (inpuString.contains("+"))      operandPostion = inpuString.indexOf("+");
            else if (inpuString.contains("*")) operandPostion = inpuString.indexOf("*");
            else if (inpuString.contains("/")) operandPostion = inpuString.indexOf("/");
            else if (inpuString.contains("-")) operandPostion = inpuString.indexOf("-");
            
            char operation = inpuString.charAt(operandPostion);
            double firstNumber = Double.parseDouble(inpuString.substring(0, operandPostion));
            double secondNumber = Double.parseDouble(inpuString.substring(operandPostion+1, inpuString.length()));
            
            double result = 0;            

            switch (operation) {
                case '+':
                    result = firstNumber + secondNumber;
                    break;
            
                case '-':
                    result = firstNumber - secondNumber;
                    break;
                
                case '*':
                    result = firstNumber * secondNumber;
                    break;
                
                case '/':
                    if (secondNumber != 0) result = firstNumber / secondNumber;
                    else logger.warning("Недопустимая операция: деление на ноль");
                    break;                
            }
            
            logger.info(String.format("%.2f %c %.2f = %.2f", firstNumber, operation, secondNumber, result));            
        }
    }
}


