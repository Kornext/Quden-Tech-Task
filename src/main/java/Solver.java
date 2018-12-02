import task1.HashTable;
import task2.Diagram;
import task3.Calculator;

import java.io.*;
import java.util.StringTokenizer;

public class Solver {

    public static void main(String[] args) throws IOException {
        //********************TEST************************

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String input = in.readLine();

        HashTable hashTable = new HashTable(5, 10); //1 2 3 4 5 6
        hashTable.insert(input);
        hashTable.output();
        //
        input = in.readLine(); //aa aa aa aa aa bbb bbb bbb bbb c c c c c c c c c c c c c c c
        Diagram diagram = new Diagram(input);
        diagram.sortASC(); //diagram.sortDESC();
        diagram.printDiagram();
        //
        input = in.readLine(); //5 10 + 10 * 14 -
        Calculator calculator = new Calculator(input);
        calculator.showResult();
    }
}
