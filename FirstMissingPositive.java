public class Solution {

    public int firstMissingPositive(int[] A) {
        // 空集return 0
        if (A == null) {
            return 1;
        }

        for (int i = 0; i < A.length; i++) {
            // 1. A[i] positive
            // 2. A[i] in the range
            // 3. 当前位置不对
            // use while to keep swapping until the right place is found
            while (A[i] > 0 && A[i] <= A.length && A[i] != (i+1)) {
                int tmp = A[A[i]-1]; 
                // break cloest loop
                // avoid dead loop
                if (tmp == A[i]) {
                    break;
                }
                A[A[i]-1] = A[i];
                A[i] = tmp;
            }
        }

        // find the first place that is not right
        for (int i = 0; i < A.length; i ++) {
                if (A[i] != i + 1) {
                    return i + 1;
                }
        }

        // for array.length = 0, return 1
        return A.length + 1;
    }
}
