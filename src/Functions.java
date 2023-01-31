public class Functions {

    //Method to create a line from symbols using loop
    //Requires:
    //which symbol as a string
    //how many times the symbol should be printed on the line as an int
    public static void lineBreak(String symbol, int num) {
        for (int i = 0; i < num; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }
}
