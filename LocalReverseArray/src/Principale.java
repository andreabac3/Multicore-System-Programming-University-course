import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class Principale {

    static void reverseArray(ForkJoinPool fj, int[] arr) {
        fj.invoke(new LocalReverseArray(arr, 0, ((arr.length - 1) / 2)));
    }

    public static void main(String[] args) {
        int[] myIntArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
        System.out.println(Arrays.toString(myIntArray));
        reverseArray(new ForkJoinPool().commonPool(), myIntArray);
        System.out.println(Arrays.toString(myIntArray));

    }
}
