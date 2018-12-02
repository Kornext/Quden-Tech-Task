package task3;

import com.sun.media.sound.InvalidFormatException;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    private String inputText;
    private List<String> arraySymbols;

    public Calculator(String inputText) {
        this.inputText = inputText;
        arraySymbols = Arrays.asList(inputText.split(" "));
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
        arraySymbols = Arrays.asList(inputText.split(" "));
    }

    private int calculation() throws InvalidInputFormatException {
        if (!checkInputText()) {
            throw new InvalidInputFormatException();
        }
        int result = 0;
        for (int i = 0; i < arraySymbols.size(); i++) {
            if (isOperation(i)) {
                int x = 0;
                int y = 0;
                try {
                    x = Integer.parseInt(arraySymbols.get(i-2));
                    y = Integer.parseInt(arraySymbols.get(i-1));
                }
                catch (Exception ex) {
                    System.out.println("Невернный формат ввода");
                    ex.printStackTrace();
                }
                switch (arraySymbols.get(i)) {
                    case "/": result = x / y;
                        break;
                    case "+": result = x + y;
                        break;
                    case "-": result = x - y;
                        break;
                    case "*": result = x * y;
                }
                arraySymbols.set(i, String.valueOf(result));
            }
        }
        return Integer.parseInt(arraySymbols.get(arraySymbols.size()-1)); // return last
    }

    public void showResult() {
        try {
            System.out.println(calculation());
        }
        catch (InvalidInputFormatException ex) {
            System.out.println(ex.getMessage());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private boolean checkInputText() {
        if(isOperation(0) || isOperation(1)) { //первые два элемента символы операций?
            return false;
        }
        if(!isOperation(arraySymbols.size()-1)) { //последний символ не операция?
            return false;
        }
        for (int i = 2; i<arraySymbols.size(); i+=2) { //каждый второй символ начиная с третьего не операция?
            if(!isOperation(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isOperation(int i) { //предикат проверки, является ли символ операцией
        if(arraySymbols.get(i).equals("/") || arraySymbols.get(i).equals("+") ||
                arraySymbols.get(i).equals("-") || arraySymbols.get(i).equals("*")) {
            return true;
        } else {
            return false;
        }
    }

    class InvalidInputFormatException extends Exception {
        String message = "Неправильный формат ввода";

        @Override
        public String getMessage() {
            return message;
        }
    }
}
