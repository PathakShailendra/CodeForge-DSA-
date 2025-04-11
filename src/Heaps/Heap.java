package Heaps;

public class Heap {
    int arr[] = new int[100];
    int size = 0;
    public void insert(int element){
        size = size+1;
        int index = size;
        arr[index] = element;
        while (index > 1) {
            int parent = index / 2;
            if (arr[parent] < arr[index]) {
                int temp = arr[parent];
                arr[parent] = arr[index];
                arr[index] = temp;
                index = parent;
            } else return;
        }
    }

    public int peek(){
        return arr[0];
    }


    public void deletion() {
        arr[1] = arr[size];
        size--;
        int index = 1;
        while (index < size) {
            int left = arr[2 * index];
            int right = arr[2 * index + 1];
            int larger = left > right ? 2 * index : (2 * index) + 1;
            if (arr[larger] > arr[index]) {
                int temp = arr[larger];
                arr[larger] = arr[index];
                arr[index] = temp;
                index = larger;
            } else return;
        }
    }

    void printArray() {
        for (int i = 1; i <= size; i++) {
            System.out.print(arr[i] + " ");
        }
    }


    void heapify(int num[], int n, int i) {
        int largest = i;
        int left = 2 * i;
        int right = 2 * i + 1;

        if (left <= n && num[left] > num[largest]) {
            largest = left;
        }
        if (right <= n && num[right] > num[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(num, largest, i);
            heapify(num, n, largest);
        }
    }

    void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void heapSort(int arr[], int n) {
        // Step 1: Build Max Heap
        for (int i = n / 2; i >= 1; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Heap Sort
        int size = n;
        while (size > 1) {
            swap(arr, size, 1); // swap root with last
            size--;
            heapify(arr, size, 1); // heapify root again
        }
    }


    public static void main(String[] args) {
        Heap obj = new Heap();
       /* obj.insertion(51);
        obj.insertion(53);
        obj.insertion(52);
        obj.insertion(54);
        obj.insertion(55);
        obj.printArray();
        System.out.println();
        obj.deletion();
        obj.printArray();
        */
        int nums[] = {-1, 15, 26, 17, 54, 55};
        int n = 5;
        for (int i = n / 2; i > 0; i--) {
            obj.heapify(nums, n, i);
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        System.out.println("after sorting");
        obj.heapSort(nums , n);
        for (int i = 1; i <= n; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
