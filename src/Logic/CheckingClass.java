package Logic;

/**
 * This class represents a Checking Class. Basically, from this class all the fields that need to be checked will go through
 * control methods, which are checking the fields on GUI that can take undefined values.
 *
 * @author Charalampos Stefanidis - AEM:3246
 * @author Sotirios Loukas Kampylis - AEM:3805
 */
public class CheckingClass {

    /**
     * Method that checks if the number of digits of the code is correct.
     *
     * @param code the code of the accommodation
     * @return true or false if the digits are 4 or not
     */
    public boolean checkDigitsOfCodeName(int code) {
        return String.valueOf(code).length() == 4;
    }

    /**
     * Method that checks if the code is string and if it is,then parses it in integer and returns true.Else, it returns
     * false.
     *
     * @param code the code of the accommodation
     * @return true or false if the code has changed or not
     */
    public boolean checkCode(String code) {
        try {
            Integer.parseInt(code);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Method that checks if the price is string and if it is,then parses it in double and returns true.Else, it returns
     * false.
     *
     * @param price the price per night in an accommodation
     * @return true or false if the price has changed or not
     */
    public boolean checkPrice(String price) {
        try {
            Double.parseDouble(price);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Method that checks if the sqMeters is string and if it is,then parses it in double and returns true.Else, it returns
     * false.
     *
     * @param sqMeters the price per night in an accommodation
     * @return true or false if the price is double or not
     */
    public boolean checkSqMeters(String sqMeters) {
        try {
            Double.parseDouble(sqMeters);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Method that checks if the day is valid and if it is returns true, else it returns false.
     *
     * @param day the day of the booking that is made (from or until)
     * @param month the month of the booking that is made (from or until)
     * @return if the day is valid if it is returns true, else it returns false
     */
    public boolean checkDay(int day,int month){
       if(month == 1) {
           return day <= 31 && day > 0;
       } else if (month == 2) {
           return day <= 28 && day > 0;
       } else if (month == 3) {
           return day <= 31 && day > 0;
       } else if (month == 4) {
           return day <= 30 && day > 0;
       } else if (month == 5) {
           return day <= 31 && day > 0;
       } else if (month == 6) {
           return day <= 30 && day > 0;
       } else if (month == 7) {
           return day <= 31 && day > 0;
       } else if (month == 8) {
           return day <= 31 && day > 0;
       } else if (month == 9) {
           return day <= 30 && day > 0;
       } else if (month == 10) {
           return day <= 31 && day > 0;
       } else if (month == 11) {
           return day <= 30 && day > 0;
       } else
           return day <= 31 && day > 0;
    }

    /**
     * Method that checks if the month is valid and if it is returns true, else it returns false.
     *
     * @param month the month of the booking that is made (from or until)
     * @return if the day is valid if it is returns true, else it returns false
     */
    public  boolean checkMonth(int month) {
        return month == 1 || month == 2 || month == 3 || month == 4 || month == 5 || month == 6 || month == 7 || month == 8 || month == 9 || month == 10 || month == 11 || month == 12;
    }

}
