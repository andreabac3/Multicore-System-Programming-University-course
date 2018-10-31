import java.util.concurrent.ForkJoinPool;

public class Principale {
    
    public static int sum(ForkJoinPool fj, int[] arr) {
        return (int) fj.invoke(new SumArray(arr, 0, arr.length));
    }

    public static void main(String[] args) {
        int[] myIntArray = {1, 8, 9, 10, 11};
        final ForkJoinPool fjPool = new ForkJoinPool();

        System.out.println(sum(fjPool, myIntArray));
    }

}
