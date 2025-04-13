package HeapsAndPriorityQueue;

public class ConvertMinHeapToMaxHeap {
    static int []arr = new int[6];
    static int size = 0;

    public static void insert(int element){
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

    static void printArray() {
        for (int i = 1; i <= size; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int []minHeap = {10, 20, 30, 21, 23};
        //Output: [30, 21, 23, 10, 20]
        for(int i : minHeap) {
            insert(i);
        }
        printArray();
    }
}
