import java.util.concurrent.RecursiveTask;

class SumArray extends RecursiveTask {
    private int lo, hi, result;
    private int[] arr;
    private int SEQUENTIAL_CUTOFF = 2;

    SumArray(int[] a, int l, int h) {
        this.lo = l;
        this.hi = h;
        this.arr = a;
    }

    protected Integer compute() {
        if (hi - lo < SEQUENTIAL_CUTOFF) {
            for (int i = lo; i < hi; i++) this.result += arr[i];
            return this.result;
        } else {
            SumArray left = new SumArray(arr, lo, (lo + hi) / 2);
            SumArray right = new SumArray(arr, (lo + hi) / 2, hi);
            invokeAll(right, left);
            /*
            instead of invokeAll() you can use these
            left.fork();
            right.compute();
            left.join();
             */
            this.result = left.result + right.result;
            return this.result;
        }
    }
}
