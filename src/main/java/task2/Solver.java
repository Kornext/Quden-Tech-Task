package task2;

import java.io.*;

public class Solver {
    public static void main(String[] args) throws IOException {
        //********************TEST************************
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String input = in.readLine();
        Diagram diagram = new Diagram(input);
        diagram.sortASC(); //diagram.sortDESC();
        diagram.printDiagram();
    }
}

