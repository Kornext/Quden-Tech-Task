package task3;

import java.io.*;

public class Solver {

    public static void main(String[] args) throws IOException {
        //********************TEST************************
        //String input = "4 5 + 7 - 95 * 10 /";
        //String input = "5 10 + 10 * 14 -";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String input = in.readLine();
        Calculator calculator = new Calculator(input);
        calculator.showResult();
    }
}
