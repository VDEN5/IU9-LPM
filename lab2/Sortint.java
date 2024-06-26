public class Sortint {
    private int[] arr;
    public Sortint(int[] arr) {
        this.arr = arr;
    }
    public boolean found(int a) {
        int ar[] = this.arr;
        int le = ar.length;
        if (le == 1)
            return ar[0] == 0;
        int l = le / 2;
        if (a < ar[l]) {
            int arr1[] = new int[l];
            for (int i = 0; i < l; i++) arr1[i] = ar[i];
            Sortint ar1 = new Sortint(arr1);
            return ar1.found(a);
        }
        int arr1[] = new int[le - l];
        for (int i = l; i < le; i++) arr1[i - l] = ar[i];
        Sortint ar1 = new Sortint(arr1);
        return ar1.found(a);
    }
    private void sort(int arr[]) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }
    private void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
    public int[] add(int a) {
        int ar[] = this.arr;
        int res[] = new int[ar.length + 1];
        for (int i = 0; i < ar.length; i++) res[i] = ar[i];
        res[ar.length] = a;
        Sortint res1 = new Sortint(res);
        res1.sort(res);
        return res1.arr;
    }
}