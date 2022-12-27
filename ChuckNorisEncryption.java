package chucknorris;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // first we get the input
        System.out.println("Input string:");
        String inputString = scanner.nextLine();
        // System.out.println(inputString);

        // now lets convert this string to ascii in 7 bit form
        int inputStringLength = inputString.length();
        int tempInt;
        String tempBinary;
        String seriesToBeAdded = "";
        String binaryString = "";

        for (int i = 0; i < inputStringLength; i++) {
            tempInt = inputString.charAt(i);

            // now as it is only integer representation in ascii
            // we convert it to binary
            tempBinary = Integer.toBinaryString(tempInt);


            // let's check if it only has 6 bits
            if (tempBinary.length() != 7) {
                tempBinary = "0" + tempBinary;
            }


            // lets concat into a binary version of the string
            binaryString += tempBinary;
            // System.out.println(binaryString);
        }

        // ENCODING SECTION
        // Declaration
        char tempBit;
        int continuousBits = 1;
        int j;

        // format
        System.out.println();
        System.out.println("The result:");

        // loop to find and return all the characters
        for (j = 0; j < binaryString.length() ; j++) {
            tempBit = binaryString.charAt(j);

            // let us find if it is a series
            while ((j + 1) < 7 && binaryString.charAt(j) == binaryString.charAt(j+1)) {
                j++;
                continuousBits++;
            }

            /* Test
            System.out.println(tempBit);
            System.out.println(continuousBits);
            System.out.println(j);
            */

            // now that we got the series we can encode it
            switch (tempBit) {
                case '0':
                    // first we find the series length
                    while (continuousBits != 0) {
                        seriesToBeAdded += "0";
                        continuousBits--;
                    }
                    System.out.printf("00 %s ", seriesToBeAdded);
                    break;

                case '1':
                    // first we find the series length
                    while (continuousBits != 0) {
                        seriesToBeAdded += "0";
                        continuousBits--;
                    }
                    System.out.printf("0 %s ", seriesToBeAdded);
                    break;
            }
            // reset
            continuousBits = 1;
            seriesToBeAdded = "";
        }
    }
}

