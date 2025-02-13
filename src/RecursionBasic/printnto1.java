package RecursionBasic;

public class printnto1 {
    void printNos(int N) {
        if(N == 1) {
            System.out.print(N +" ");
            return;
        }
        System.out.print(N +" ");
        printNos(N-1);
    }
}
