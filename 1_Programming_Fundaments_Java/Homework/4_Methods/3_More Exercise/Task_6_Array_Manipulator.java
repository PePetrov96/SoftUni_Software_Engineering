import java.util.Arrays;
import java.util.Scanner;

public class Task_6_Array_Manipulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] intArray = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer :: parseInt).toArray();
        String[] input = scan.nextLine().split("\\s+");

        while (!input[0].equals("end")) {
            String command = input[0];
            switch (command) {
                case "exchange":
                    if (Integer.parseInt(input[1]) >= 0 && Integer.parseInt(input[1]) < intArray.length) {
                        intArray = exchange(Integer.parseInt(input[1]), intArray);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "max":
                    System.out.println(max(input[1], intArray));
                    break;
                case "min":
                    System.out.println(min(input[1], intArray));
                    break;
                case "first":
                    System.out.println(first(Integer.parseInt(input[1]), intArray, input[2]));
                    break;
                case "last":
                    System.out.println(last(Integer.parseInt(input[1]), intArray, input[2]));
                    break;
            }

            input = scan.nextLine().split("\\s+");
        }
        System.out.println(Arrays.toString(intArray));
    }
    private static int[] exchange (int index, int[] intArray) {
        int[] temp = new int[intArray.length];
        int first = 0;
        for (int i = index + 1; i < temp.length; i++) {
            temp[first] = intArray[i];
            first++;
        }
        int second = 0;
        for (int i = first; i < temp.length; i++) {
            temp[i] = intArray[second];
            second++;
        }
        return temp;
    }
    private static String max (String command, int[] intArray) {
        String maxNumber = "No matches";
        int max = Integer.MIN_VALUE;
        if (command.equals("odd")) {
            for (int i = 0; i < intArray.length; i++) {
                if (intArray[i] % 2 != 0 && intArray[i] >= max) {
                    max = intArray[i];
                    maxNumber = i + "";
                }
            }
        } else if (command.equals("even")) {
            for (int i = 0; i < intArray.length; i++) {
                if (intArray[i] % 2 == 0 && intArray[i] >= max) {
                    max = intArray[i];
                    maxNumber = i + "";
                }
            }
        }
        return maxNumber;
    }
    private static String min (String command, int[] intArray) {
        String minNumber = "No matches";
        int min = Integer.MAX_VALUE;
        if (command.equals("odd")) {
            for (int i = 0; i < intArray.length; i++) {
                if (intArray[i] % 2 != 0 && intArray[i] <= min) {
                    min = intArray[i];
                    minNumber = i + "";
                }
            }
        } else if (command.equals("even")) {
            for (int i = 0; i < intArray.length; i++) {
                if (intArray[i] % 2 == 0 && intArray[i] <= min) {
                    min = intArray[i];
                    minNumber = i + "";
                }
            }
        }
        return minNumber;
    }
    private static String first (int index, int[] intArray, String command) {
        String output;
        if (index < 0 || index > intArray.length - 1) {
            output = "Invalid count";
            return output;
        }
        int[] temp = new int[index];
        int start = 0;
        int count = 0;
        if (command.equals("even")) {
            for (int j : intArray) {
                if (j % 2 == 0) {
                    temp[start] = j;
                    start++;
                    count++;
                }
                if (start == index) {
                    break;
                }
            }
        } else if (command.equals("odd")) {
            for (int j : intArray) {
                if (j % 2 != 0) {
                    temp[start] = j;
                    start++;
                    count++;
                }
                if (start == index) {
                    break;
                }
            }
        }
        if (count == 0) {
            output = "[]";
        } else {
            int[] arrayToPrint = new int[count];
            int count2 = 0;
            for (int j : temp) {
                arrayToPrint[count2] = j;
                count2++;
                if (count2 == count) {
                    break;
                }
            }
            output = Arrays.toString(arrayToPrint);
        }
        return output;
    }
    private static String last (int index, int[] intArray, String command) {
        String output;
        if (index < 0 || index > intArray.length - 1) {
            output = "Invalid count";
            return output;
        }
        int[] temp = new int[index];
        int start = index - 1;
        int count = 0;
        if (command.equals("even")) {
            for (int i = intArray.length - 1; i >= 0; i--) {
                if (intArray[i] % 2 == 0) {
                    temp[start] = intArray[i];
                    start--;
                    count++;
                }
                if (start < 0) {
                    break;
                }
            }
        } else if (command.equals("odd")) {
            for (int j = intArray.length - 1; j >= 0; j--) {
                if (intArray[j] % 2 != 0) {
                    temp[start] = intArray[j];
                    start--;
                    count++;
                }
                if (start < 0) {
                    break;
                }
            }
        }
        if (count == 0) {
            output = "[]";
        } else {
            int[] arrayToPrint = new int[count];
            int count2 = count - 1;
            for (int i = temp.length - 1; i >= 0; i--) {
                arrayToPrint[count2] = temp[i];
                count2--;
                if (count2 < 0) {
                    break;
                }
            }
            output = Arrays.toString(arrayToPrint);
        }
        return output;
    }
}