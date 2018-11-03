import java.util.concurrent.RecursiveTask;

class SumArray extends RecursiveTask {
    private int lo, hi;
    private int[] arr;
    private int SEQUENTIAL_CUTOFF = 2;

    SumArray(int[] a, int l, int h) {
        this.lo = l;
        this.hi = h;
        this.arr = a;
    }

    protected Integer compute() {
        if (hi - lo < SEQUENTIAL_CUTOFF) {
            int ans = 0;
            for (int i = lo; i < hi; i++) ans += arr[i];
            return ans;
        } else {
            SumArray left = new SumArray(arr, lo, (lo + hi) / 2);
            SumArray right = new SumArray(arr, (lo + hi) / 2, hi);
            left.fork();
            return right.compute() + left.join();
        }

    }
}
