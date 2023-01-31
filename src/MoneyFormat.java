//Function I wrote in 2022 to make it possible to filter
//any double into the money format and round it properly.
//To-Do: Use function overloading to make this more flexible!

public class MoneyFormat {
    //Required:
    //Number given as double which you want to round to
    //number rounded and displayed as money.
    //***The value is outputted as string***
    //Currency symbol not included to ensure greater flexibility with any base 10 currency
    public static String doubleToMoney(double num){

        //First I cast the double to a string:
        String numAsString = Double.toString(num);

        //This lets me split the number into an array of two strings
        //seperated on the decimal.
        //After the decimal you will ALWAYS have two numbers
        //for something given a monetary value!
        String[] numStringArray = numAsString.split("\\.", 2);

        //Some logic here which at the first level of the if/else
        //checks if the string, which occurs after the decimal,
        //contains more than two digits.
        //ie something which needs to be treated to be shown like money
        if(numStringArray[1].length() > 2) {

            //The next three lines make a char array with a decimal placed
            //after the second char with one more char after this.
            //Converted to string and then to a double
            char[] ch = {numStringArray[1].charAt(0), numStringArray[1].charAt(1), '.', numStringArray[1].charAt(2)};
            String arrayToString = new String(ch);
            double strToDouble = Double.parseDouble(arrayToString);

            //Converting to a double lets Math.round be used to round the number!
            //Converted back to String after rounding to enable string methods to be used.
            long roundedNumber = Math.round(strToDouble);
            String checkDigits = Long.toString(roundedNumber);

            //This nested if/else just makes sure that a zero gets added to the left (right after the decimal)
            //if needed, as well as accounting for if the number needs to be rounded up.
            if (checkDigits.length() < 2) {
                return numStringArray[0] + "." + "0" + checkDigits;
            } else if (checkDigits.length() == 2){
                return numStringArray[0] + "." + checkDigits;
            } else {
                int leftSide = Integer.parseInt(numStringArray[0]);
                int carrying = leftSide + 1;
                return carrying + ".00";
            }

        //If the string has two digits you can just return it as is.
        //If it's less than 2 than it will need a zero added to the end.
        } else {
            if(numStringArray[1].length() > 1) {
                return numAsString;
            } else {
                return numAsString + "0";
            }
        }
    }

}
