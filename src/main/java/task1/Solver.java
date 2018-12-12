package task1;

import java.io.*;

public class Solver {

    public static void main(String[] args) throws IOException {
        //********************TEST************************

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String input = in.readLine();
        HashTable hashTable = new HashTable(5, 10);
        hashTable.insert(input);
        //hashTable.insert(1, 2, 3, 4, 5, 6);
        hashTable.output();
    }
}
