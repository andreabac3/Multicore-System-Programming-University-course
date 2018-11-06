import java.util.concurrent.RecursiveAction;

class LocalReverseArray extends RecursiveAction {
    private int[] arr;
    private int lo, hi;
    private static final int SEQUENTIAL_CUTOFF = 2;

    public LocalReverseArray(int[] a, int l, int h) {
        this.arr = a;
        this.lo = l;
        this.hi = h;
    }

    @Override
    protected void compute() {
        if (hi - lo <= SEQUENTIAL_CUTOFF) {
            int index;
            int tmp;
            for (int i = lo; i <= hi; ++i) {
                index = i - (this.arr.length);
                index = (index < 0 ? -index : index) - 1;
                tmp = this.arr[i];
                this.arr[i] = this.arr[index];
                this.arr[index] = tmp;
            }
        } else {
            LocalReverseArray right = new LocalReverseArray(this.arr, lo, (lo + hi) / 2);
            LocalReverseArray left = new LocalReverseArray(this.arr, ((lo + hi) / 2) + 1, hi);
            invokeAll(right, left);
        }
    }
}
