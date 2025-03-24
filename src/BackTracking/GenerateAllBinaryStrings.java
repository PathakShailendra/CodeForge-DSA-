package BackTracking;

public class GenerateAllBinaryStrings {
    static void generateBinaryString(int n, String str) {
        // Base case: Jab length n ho jaye, print kar do
        if (str.length() == n) {
            System.out.println(str);
            return;
        }

        // Pehle 0 ko add karke explore karo
        generateBinaryString(n, str + "0");

        // Agar last character 1 nahi hai to 1 bhi add kar sakte hain
        if (str.isEmpty() || str.charAt(str.length() - 1) != '1') {
            generateBinaryString(n, str + "1");
        }
    }

    public static void main(String[] args) {
        int n = 3;  // Input length
        generateBinaryString(n, "");
    }
}
