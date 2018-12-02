package task2;

public class Main {
    public static void main(String[] args) {
        //********************TEST************************
        String text = "aa aa aa aa aa bbb bbb bbb bbb c c c c c c c c c c c c c c c";
        Diagram diagram = new Diagram(text);
        diagram.sortASC(); //diagram.sortDESC();
        diagram.printDiagram();
    }
}

