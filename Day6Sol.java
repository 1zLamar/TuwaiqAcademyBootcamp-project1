import java.util.*;

public class Day6Sol {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // 1. Write a Java program to test if the first and the last element of
        // an array of integers is same. The length of the array must be greater
        // than or equal to 2

        int[] array = {50, -20, 0, 30, 40, 60, 10};

        boolean firstLast = false;

        if (array.length >= 2 && array[0] == array[array.length - 1]) {
            firstLast = true;
        }

        System.out.println(firstLast);

        // 2. Write a Java program to find the k largest elements in a given array.
        // Elements in the array can be in any order.

        int[] arrr = {1, 4, 17, 7, 25, 3, 100};

        int k = 0;
        try {
            System.out.println("Enter the K: ");
            k = s.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number: ");
            return;
        }

        System.out.println("Please add numbers: ");

        Arrays.sort(arrr);

        System.out.print(k + " largest elements of the said array are: ");
        for (int i = arrr.length - 1; i >= arrr.length - k; i--) {
            System.out.print(arrr[i] + " ");
        }

        System.out.println();

        // 3. Write a Java program to find the numbers greater than the average
        // of the numbers of a given array.

        int[] arr = {1, 4, 17, 7, 25, 3, 100};

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int avg = 0;
        avg = sum / arr.length;
        System.out.println("The average of the said array is: " + avg);

        System.out.print("The numbers in the said array that are greater than the average are: ");
        for (int num : arr) {
            if (num > avg) {
                System.out.print(num + " ");
            }
        }

        System.out.println();

        // 4. Write a Java program to get the larger value between first and last
        // element of an array of integers.

        int[] larger = {20, 30, 40};

        int num1 = larger[0];

        int num2 = larger[larger.length - 1];
        System.out.println("Larger value between first and last element: " + Math.max(num1, num2));

        // 5. Write a Java program to swap the first and last elements of an array
        // and create a new array.

        ArrayList swap1 = new ArrayList<>();

        swap1.add(20);
        swap1.add(30);
        swap1.add(40);

        List<Integer> swap2 = new ArrayList<>(swap1);

        Collections.swap(swap2, 0, swap2.size() - 1);

        System.out.println("New array after swapping the first and last elements: " + swap2);

        // 6. Write a Java program to find all the longest word in a given dictionary.

        String[] animal = {"cat", "dog", "red", "is", "am"};

        List<String> longWord = new ArrayList<>();
        int len = 0;

        for (String w : animal) {

            int length = w.length();

            if (length > len) {
                longWord.add(w);
                len = length;
            } else if (length == len) {
                longWord.add(w);

            }
        }
        System.out.println("Longest words: " + longWord);

        // 7. Write a menu-driven Java program with following option:
        int[] menu = new int[0];
        boolean exit = false;

        while (!exit) {
            System.out.println("Please choose an option:");
            System.out.println("1- Accept elements of an array");
            System.out.println("2- Display elements of an array");
            System.out.println("3- Search the element within array");
            System.out.println("4- Sort the array");
            System.out.println("5- To Stop");

            int choice = 0;
            try {
                choice = s.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                s.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter the size of the array: ");
                    int size = s.nextInt();
                    menu = new int[size];

                    System.out.println("Enter the elements of the array: ");
                    for (int i = 0; i < size; i++) {
                        menu[i] = s.nextInt();
                    }
                    System.out.println();
                    break;

                case 2:
                    System.out.println("The elements of the array are: ");
                    for (int i = 0; i < menu.length; i++) {
                        System.out.print(menu[i] + " ");
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Enter the element to search: ");
                    int search = s.nextInt();
                    int index = Arrays.binarySearch(menu, search);

                    if (index < 0) {
                        System.out.println(search + " is not found in the array");
                    } else {
                        System.out.println(search + " is found int the array");
                    }
                    System.out.println();
                    break;

                case 4:
                    Arrays.sort(menu);
                    for (int i = 0; i < menu.length; i++) {
                        System.out.print(menu[i] + " ");
                    }
                    System.out.println();
                    System.out.println("The array has been sorted");
                    System.out.println();
                    break;

                case 5:
                    System.out.println("You choose to exit..");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter from 1-5");
                    break;
            }
        }

        // 8. Write a program that's displays the number of occurrences of an element
        // in the array.

        int[] original = {1, 1, 1, 3, 3, 5};

        System.out.print("Enter a number to find its occurrences in the array: ");
        int out = 0;
        try {
            out = s.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer.");
            return;
        }

        int[] output = {out};

        for (int element : output) {
            int counter = 0;
            for (int num : original) {
                if (num == element) {
                    counter++;
                }
            }
            System.out.println(element + " occurs " + counter + " times");
        }
//
//        // 9. Write a program that places the odd elements of an array before
//        // the even elements.
//
        int[] oddEven = {2, 3, 40, 1, 5, 9, 4, 10, 7};
        int[] arrOddEven = new int[oddEven.length];

        int odd = 0;
        int even = oddEven.length - 1;

        for (int num : oddEven) {
            if (num % 2 == 0) {
                arrOddEven[even] = num;
                even--;
            } else {
                arrOddEven[odd] = num;
                odd++;
            }
        }
        System.out.println(Arrays.toString(arrOddEven));
//
//        // 10. Write a program that test the equality of two arrays.
//
        int[] arr1 = {2, 3, 6, 6, 4};
        int[] arr2 = {2, 3, 6, 6, 4};

        boolean istrue = true;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                istrue = false;
                break;
            }
        }
        System.out.println(istrue);

}}