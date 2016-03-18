package max_sub_matrix;
public class MaxSubProduct {

	public static void main(String[] args) {
		System.out.println(new MaxSubProduct().maxSubArray(new int[] { -4, -3, -2 }));
	}

	public int maxSubArray(int[] nums) {
		return maxSubArray(nums, 0, nums.length);
	}

	int maxSubArray(int[] A, int start, int end) {
		if (end - start == 1) {
			return A[start];
		}

		int m = (start + end) / 2;
		int maxLeft = maxSubArray(A, start, m); // left
		int maxRight = maxSubArray(A, m, end); // right

		int maxLeftPrefixSum = lPrefix(A, start, m);
		int maxRightPrefixSum = rPrefix(A, m, end);

		int max = getMax(maxLeft, maxRight);
		max = getMax(max, maxLeftPrefixSum * maxRightPrefixSum);
		return max;
	}

	private int lPrefix(int[] A, int start, int m) {
		int max = Integer.MIN_VALUE;
		int anyway = 1;
		for (int i = m - 1; i >= start; i--) {
			anyway *= A[i];
			max = getMax(max, anyway);
		}
		return max;
	}

	private int rPrefix(int[] A, int m, int end) {
		int max = Integer.MIN_VALUE;
		int anyway = 1;
		for (int i = m; i < end; i++) {
			anyway *= A[i];
			max = getMax(max, anyway);
		}
		return max;
	}

	int getMax(int a, int b) {
		return a > b ? a : b;
	}
}
