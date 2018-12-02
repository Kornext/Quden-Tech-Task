package task3;

public class Solver {

    public static void main(String[] args) {
        //********************TEST************************
        //String input = "4 5 + 7 - 95 * 10 /";
        String input = "5 10 + 10 * 14 -";
        Calculator calculator = new Calculator(input);
        calculator.showResult();
    }
}
