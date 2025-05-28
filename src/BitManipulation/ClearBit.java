package BitManipulation;

public class ClearBit {
    static int clearBit(int num, int i)
    {

        // Create the mask for the ith
        // bit unset
        int mask = ~(1 << i);

        // Return the updated value
        return num & mask;
    }

}
