package converter;

import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

import java.util.Locale;

import static java.lang.Character.*;

/**
 * This class implements a converter that takes a string that represents a number in either the
 * Elbonian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/18/17
 */
public class ElbonianArabicConverter {

    // A string that holds the number (Elbonian or Arabic) you would like to convert
    private final String number;

    /**
     * Constructor for the ElbonianArabic class that takes a string. The string should contain a valid
     * Elbonian or Arabic numeral. The String can have leading or trailing spaces. But there should be no
     * spaces within the actual number (ie. "9 9" is not ok, but " 99 " is ok). If the String is an Arabic
     * number it should be checked to make sure it is within the Elbonian number systems bounds. If the
     * number is Elbonian, it must be a valid Elbonian representation of a number.
     *
     * @param number A string that represents either a Elbonian or Arabic number.
     * @throws MalformedNumberException Thrown if the value is an Elbonian number that does not conform
     * to the rules of the Elbonian number system. Leading and trailing spaces should not throw an error.
     * @throws ValueOutOfBoundsException Thrown if the value is an Arabic number that cannot be represented
     * in the Elbonian number system.
     */
    public ElbonianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {

        //Check if arabic
        boolean isArabic = number.contains("0") || number.contains("1") || number.contains("2") || number.contains("3") ||
                number.contains("4") || number.contains("5") || number.contains("6") || number.contains("7") ||
                number.contains("8") || number.contains("9");

        //Check for mixed numbers and chars
        boolean charFlag;
        for(int i = 0; i<number.length();i++){
            charFlag = isLetter(number.charAt(i));
            if(charFlag && isArabic){
                throw new MalformedNumberException("Input contains characters and integers");
            }
        }

        //if arabic, checking for range
        if (isArabic) {
            int castedNum = Integer.parseInt(number);
            if (number.contains("-") || (number.charAt(0) == '0')) {
                throw new ValueOutOfBoundsException("The number is out of range");
            } else if (castedNum > 3999) {
                throw new ValueOutOfBoundsException("Number is bigger than 3999");
            }
        }
        else     //Otherwise is elbonian run these
            {
            for (int i = 0; i < number.length(); i++) {
                if (!isUpperCase(number.charAt(i))) {
                    throw new MalformedNumberException("The format is not all uppercase");
                }
            }

            if (number.contains("F") && number.contains("C")) {
                throw new MalformedNumberException("Can't use F and C in the same Elbonian number");
            } else if (number.contains("N") && number.contains("X")) {
                throw new MalformedNumberException("Can't ise N and X in the same Elbonian number");
            } else if (number.contains("Y") && number.contains("I")) {
                throw new MalformedNumberException("Can't use Y and I in the same Elbonian number");
            }

            //Check for M, C, X, and I can be repeated up to three times in a row
            if (number.contains("M") || number.contains("C")) {
                int flagM = 0;
                int flagC = 0;
                int flagX = 0;
                int flagI = 0;
                for (int i = 0; i < number.length(); i++) {
                    if (number.charAt(i) == 'M') flagM++;
                    else if (number.charAt(i) == 'C') flagC++;
                    else if (number.charAt(i) == 'X') flagX++;
                    else if (number.charAt(i) == 'I') flagI++;
                }
                if (flagM > 3 || flagC > 3 || flagX > 3 || flagI > 3) {
                    throw new MalformedNumberException("M, C, X, and I can only be repeated up to three times in a row");
                }
            }


            //Check for F, N, Y, D, L, and V can each only be used once in a number
            int flagF = 0;
            int flagN = 0;
            int flagY = 0;
            int flagD = 0;
            int flagL = 0;
            int flagV = 0;
            for (int i = 0; i < number.length(); i++) {
                if (number.charAt(i) == 'F') {
                    flagF++;
                } else if (number.charAt(i) == 'N') {
                    flagN++;
                } else if (number.charAt(i) == 'Y') {
                    flagY++;
                } else if (number.charAt(i) == 'D') {
                    flagD++;
                } else if (number.charAt(i) == 'L') {
                    flagL++;
                } else if (number.charAt(i) == 'V') {
                    flagV++;
                }
            }
            if (flagF > 1 || flagN > 1 || flagY > 1 || flagD > 1 || flagL > 1 || flagV > 1) {
                throw new MalformedNumberException("F, N, Y, D, L, and V can each only be used once in a number");
            }

            //Check for correct order of numbers (Subpoint 6)
            for (int i = 0; i < number.length(); i++) {
                switch (number.charAt(i)) {
                    case 'I':
                        for (int j = i; j < number.length(); j++) {
                            if (number.charAt(j) == 'M' || number.charAt(j) == 'C' || number.charAt(j) == 'F' ||
                                    number.charAt(j) == 'D' || number.charAt(j) == 'X' || number.charAt(j) == 'N' || number.charAt(j) == 'L' ||
                                    number.charAt(j) == 'V' || number.charAt(j) == 'Y') {
                                throw new MalformedNumberException("Letter I cannot appear before other letters");
                            }
                        }
                    case 'Y':
                        for (int j = i; j < number.length(); j++) {
                            if (number.charAt(j) == 'M' || number.charAt(j) == 'C' || number.charAt(j) == 'F' ||
                                    number.charAt(j) == 'D' || number.charAt(j) == 'X' || number.charAt(j) == 'N' ||
                                    number.charAt(j) == 'L' || number.charAt(j) == 'V') {
                                throw new MalformedNumberException("Letter Y cannot appear before other letters");
                            }
                        }
                    case 'V':
                        for (int j = i; j < number.length(); j++) {
                            if (number.charAt(j) == 'M' || number.charAt(j) == 'C' || number.charAt(j) == 'F' ||
                                    number.charAt(j) == 'D' || number.charAt(j) == 'X' || number.charAt(j) == 'N' ||
                                    number.charAt(j) == 'L') {
                                throw new MalformedNumberException("Letter V cannot appear before other letters");
                            }
                        }
                    case 'X':
                        for (int j = i; j < number.length(); j++) {
                            if (number.charAt(j) == 'M' || number.charAt(j) == 'C' || number.charAt(j) == 'F' ||
                                    number.charAt(j) == 'D' || number.charAt(j) == 'N' || number.charAt(j) == 'L') {
                                throw new MalformedNumberException("Letter V cannot appear before other letters");
                            }
                        }
                    case 'N':
                        for (int j = i; j < number.length(); j++) {
                            if (number.charAt(j) == 'M' || number.charAt(j) == 'C' || number.charAt(j) == 'F' ||
                                    number.charAt(j) == 'D' || number.charAt(j) == 'L') {
                                throw new MalformedNumberException("Letter V cannot appear before other letters");
                            }
                        }
                    case 'L':
                        for (int j = i; j < number.length(); j++) {
                            if (number.charAt(j) == 'M' || number.charAt(j) == 'C' || number.charAt(j) == 'F' ||
                                    number.charAt(j) == 'D') {
                                throw new MalformedNumberException("Letter V cannot appear before other letters");
                            }
                        }
                    case 'C':
                        for (int j = i; j < number.length(); j++) {
                            if (number.charAt(j) == 'M' || number.charAt(j) == 'F' ||
                                    number.charAt(j) == 'D') {
                                throw new MalformedNumberException("Letter V cannot appear before other letters");
                            }
                        }
                    case 'F':
                        for (int j = i; j < number.length(); j++) {
                            if (number.charAt(j) == 'M' || number.charAt(j) == 'D') {
                                throw new MalformedNumberException("Letter V cannot appear before other letters");
                            }
                        }
                    case 'D':
                        for (int j = i; j < number.length(); j++) {
                            if (number.charAt(j) == 'M') {
                                throw new MalformedNumberException("Letter V cannot appear before other letters");
                            }
                        }
                    default:
                }
            }
        }
        this.number = number;
    }

        /**
         * Converts the number to an Arabic numeral or returns the current value as an int if it is already
         * in the Arabic form.
         *
         * @return An arabic value
         */
        public int toArabic () {
            int finalNum = 0;
            for (int i = 0; i < number.length(); i++) {
                switch (number.charAt(i)) {
                    case 'M':
                        finalNum = finalNum + 1000;
                    case 'D':
                        finalNum = finalNum + 500;
                    case 'F':
                        finalNum = finalNum + 400;
                    case 'C':
                        finalNum = finalNum + 100;
                    case 'L':
                        finalNum = finalNum + 50;
                    case 'N':
                        finalNum = finalNum + 40;
                    case 'X':
                        finalNum = finalNum + 10;
                    case 'V':
                        finalNum = finalNum + 5;
                    case 'Y':
                        finalNum = finalNum + 4;
                    case 'I':
                        finalNum = finalNum + 1;
                }
            }
            return finalNum;
        }

        /**
         * Converts the number to an Elbonian numeral or returns the current value if it is already in the Elbonian form.
         *
         * @return An Elbonian value
         */
        public String toElbonian () {
            int numCast = Integer.parseInt(number);
            String finalNum = "";
            while (numCast != 0) {
                if (numCast >= 1000) {
                    finalNum = finalNum + 'M';
                    numCast = numCast - 1000;
                } else if (numCast >= 500) {
                    finalNum = finalNum + 'D';
                    numCast = numCast - 500;
                } else if (numCast >= 400) {
                    finalNum = finalNum + 'F';
                    numCast = numCast - 400;
                } else if (numCast >= 100) {
                    finalNum = finalNum + 'C';
                    numCast = numCast - 100;
                } else if (numCast >= 50) {
                    finalNum = finalNum + 'L';
                    numCast = numCast - 50;
                } else if (numCast >= 40) {
                    finalNum = finalNum + 'N';
                    numCast = numCast - 40;
                } else if (numCast >= 10) {
                    finalNum = finalNum + 'X';
                    numCast = numCast - 10;
                } else if (numCast >= 5) {
                    finalNum = finalNum + 'V';
                    numCast = numCast - 5;
                } else if (numCast >= 4) {
                    finalNum = finalNum + 'Y';
                    numCast = numCast - 4;
                } else if (numCast >= 1) {
                    finalNum = finalNum + 'I';
                    numCast = numCast - 1;
                }
            }
            return finalNum;
        }

}
