package TestPackage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Alghorithm {

    private static final Logger log = LoggerFactory.getLogger(Alghorithm.class);

    public static String binarySearch(int[] array, int target) {

        log.info("использован метод бинарного поиска");
        Arrays.sort(array);

        int x = 0;
        int y = array.length-1;

        while (x <= y) {
            int middle = x+(y-x)/2;

            if (target == array[middle]) {
                return target + " найден на позиции " + middle;
            } else if (target > array[middle]) {
                x = middle+1;
            } else {
                y = middle-1;
            }
        }

        return "цель не найдена";
    }

    public static String linearSearch(int[] array, int target) {

        log.info("использован метод линейного поиска");

        int l = 0;
        while (l < array.length) {
            if (target == array[l]) {
                return "цель найдена под индексом "+l;
            }
            l++;
        }

        return "цель не найдена";
    }

    public static ArrayList<Integer> quickSort(List<Integer> array) {

        if (array.size() <= 1) {
            return new ArrayList<>(array);
        }

        int pivot = array.get(array.size()/2);

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for (int num: array) {
            if (num < pivot) {
                left.add(num);
            } else if (num > pivot) {
                right.add(num);
            } else {
                equal.add(num);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        ArrayList<Integer> sortedLeft = quickSort(left);
        ArrayList<Integer> sortedRight = quickSort(right);

        result.addAll(sortedLeft);
        result.addAll(equal);
        result.addAll(sortedRight);

        return result;

    }

    public static void main(String[] args) {
        int[] array = {11, 2, 53, 2 , 4, 7, 1, 19};

        System.out.println(Alghorithm.binarySearch(array, 11));

        ArrayList<Integer> i = new ArrayList<>(List.of(10, 2, 1, 8, 3));
        System.out.print(Alghorithm.quickSort(i));


    }

}
