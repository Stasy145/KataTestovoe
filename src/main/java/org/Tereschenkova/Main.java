package org.Tereschenkova;

import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите предложение, нажмите клавишу Enter");
        String userInput = scan.nextLine();


        System.out.println(digitSum(changePlusToMinus(swapCharacters(removeExtraSpaces(userInput)))));

        scan.close();


    }




    public static String changePlusToMinus(String sample) {

        String modifiedSample = sample.replace("+", "!");

        return modifiedSample;


    }


    public static String removeExtraSpaces(String sample) {

        StringBuilder modifiedSample = new StringBuilder();
        boolean isSpace = false;

        for (char currentChar : sample.toCharArray()) {
            if (currentChar != ' ') {
                modifiedSample.append(currentChar);
                isSpace = false;
            } else if (!isSpace) {
                modifiedSample.append(currentChar);
                isSpace = true;
            }
        }


        if (modifiedSample.length() > 0 && modifiedSample.charAt(0) == ' ') {
            modifiedSample.deleteCharAt(0);
        }
        if (modifiedSample.length() > 0 && modifiedSample.charAt(modifiedSample.length() - 1) == ' ') {
            modifiedSample.deleteCharAt(modifiedSample.length() - 1);
        }

        return modifiedSample.toString();

    }

    public static String swapCharacters(String sample) {

        StringBuilder modifiedSample = new StringBuilder(sample);

        if (modifiedSample.length() < 2) {

            return sample;
        }

        for (int i = 0; i < modifiedSample.length() - 1; i++) {
           if (modifiedSample.charAt(i) == '-') {

                if (i - 1 < 0 || i + 1 >= modifiedSample.length()) {
                    throw new IndexOutOfBoundsException("Индекс выходит за пределы строки.");
                }


                char temp = modifiedSample.charAt(i - 1);
                modifiedSample.setCharAt(i - 1, modifiedSample.charAt(i + 1));
                modifiedSample.setCharAt(i + 1, temp);


                modifiedSample.deleteCharAt(i);
                i--;
            }
        }

        return modifiedSample.toString();
   }

    public static String digitSum(String sample) {
        StringBuilder modifiedSample = new StringBuilder();
        int sum = 0;

        for (char currentChar : sample.toCharArray()) {
            if (Character.isDigit(currentChar)) {

                sum += Character.getNumericValue(currentChar);
           } else {
                modifiedSample.append(currentChar);
            }

        }
        if (sum != 0) {
            modifiedSample.append(" ").append(sum);
        }

        return modifiedSample.toString();

    }

}









