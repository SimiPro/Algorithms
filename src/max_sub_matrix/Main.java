package max_sub_matrix;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StreamTokenizer;

class Main {

	// public static void main(String[] args) {
	// int[] A = { -2, -1 };
	// System.out.println(maxSubArray(A, 0, A.length));
	//
	// }

	int getMaxSumOfMatrix(int[][] M) {
		int n = M[0].length;
		for (int i = 0; i < n; i++) {
			int[] currRow = M[i];
			int[] temp = new int[n];
			int currRowSum = maxSubArray(currRow, 0, currRow.length - 1);

		}
	}

	// end should not be size thus end is the index of the last elment in A
	static int maxSubArray(int[] A, int start, int end) {
		if (end - start == 1) {
			return A[start];
		}

		int m = (start + end) / 2;
		int maxLeft = maxSubArray(A, start, m); // left
		int maxRight = maxSubArray(A, m, end); // right

		int maxLeftPrefixSum = lPrefix(A, start, m);
		int maxRightPrefixSum = rPrefix(A, m, end);

		int max = getMax(maxLeft, maxRight);
		max = getMax(max, maxLeftPrefixSum + maxRightPrefixSum);
		return max;
	}

	private static int lPrefix(int[] A, int start, int m) {
		int max = Integer.MIN_VALUE;
		int anyway = 0;
		for (int i = m - 1; i >= start; i--) {
			anyway += A[i];
			max = getMax(max, anyway);
		}
		return max;
	}

	private static int rPrefix(int[] A, int m, int end) {
		int max = Integer.MIN_VALUE;
		int anyway = 0;
		for (int i = m; i < end; i++) {
			anyway += A[i];
			max = getMax(max, anyway);
		}
		return max;
	}

	static int getMax(int a, int b) {
		return a > b ? a : b;
	}

	StreamTokenizer in;
	static PrintWriter out;
	Reader reader;

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

	void run() throws IOException {
		reader = new InputStreamReader(System.in);
		in = new StreamTokenizer(new BufferedReader(reader));
		out = new PrintWriter(new OutputStreamWriter(System.out));

		read();
		out.flush();
	}

	private void read() throws IOException {
		int t = getInt();
		for (int i = 0; i < t; i++) {
			int n = getInt();
			int[][] M = new int[n][n];
			for (int j = 0; j < n; j++) {
				M[i][j] = getInt();
			}
			solve(M);
		}
	}

	int nextToken() throws IOException {
		return in.nextToken();
	}

	int getInt() throws IOException {
		nextToken();
		return (int) in.nval;
	}

}
