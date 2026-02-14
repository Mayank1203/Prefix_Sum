public class RangeCoverages {
    public static void main(String[] args) {
        int[][] ranges = {{1, 2}, {3, 4}, {5, 6}};
        int left = 2;
        int right = 5;

        boolean result = isCovered(ranges, left, right);
        System.out.println("Is range [" + left + ", " + right + "] covered? " + result);
    }

    public static boolean isCovered(int[][] ranges, int left, int right) {
        int[] line = new int[52]; // Range is 1-50, we use 52 for safety

        // Mark the starts and ends of all ranges
        for (int[] r : ranges) {
            line[r[0]]++;
            line[r[1] + 1]--;
        }

        // Prefix sum to calculate coverage at each point
        int currentCoverage = 0;
        for (int i = 1; i <= right; i++) {
            currentCoverage += line[i];
            // If we are within [left, right] and coverage is 0, it's not covered
            if (i >= left && currentCoverage <= 0) {
                return false;
            }
        }
        return true;
    }
}
