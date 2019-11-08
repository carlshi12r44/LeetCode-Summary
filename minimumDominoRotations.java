public class minimumDominoRotations {
    private static int check(int start, int[] A, int[] B, int n) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (A[i] == start) {
                continue;
            } else if (B[i] == start) {
                count++;
            } else {
                // if both are not equal to start, which is unacceptable, return a impossible count
                count = n + 1;
                break;
            }
        }

        return count;

    }
    public static int minDominoRotations(int[] A, int[] B) {
        // 4 situations to consider
        // A --> A[0]
        // A --> B[0]
        // B --> A[0]
        // B --> B[0]
        if (A.length == 0 || B.length == 0) {
            return -1;
        }

        int n = A.length;

        int count1 = check(A[0], A, B, n);
        int count2 = check(B[0], A, B, n);
        int count3 = check(A[0], B, A, n);
        int count4 = check(B[0], B, A, n);

        int ans = Math.min(Math.min(count1, count2), Math.min(count3, count4));

        return (ans == n + 1) ? -1 : ans;
    }


    public static void main(String[] args) {
        int[] A = {2,1,2,4,2,2};
        int[] B = {5,2,6,2,3,2};

        int res = minDominoRotations(A, B);

        System.out.println(res);

    }

}
