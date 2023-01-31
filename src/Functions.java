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

    //Method to create programmatically decided space before output
    //Message to be printed
    //Display length is the width of the "window"
    public static void indent(String message, int displayWidth){
        int gap = (displayWidth - message.length()) / 2;
        int divide = gap / 4;
        int mod = gap % 4;

        for(int i = 0; i < divide; i++){
            System.out.print("\t");
        };

        for(int i = 0; i < mod; i++){
            System.out.print("\s");
        }

        System.out.println(message);
    }
}
