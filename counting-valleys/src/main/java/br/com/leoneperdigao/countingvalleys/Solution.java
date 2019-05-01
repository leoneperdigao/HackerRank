package br.com.leoneperdigao.countingvalleys;

public class Solution {

	public static int countingValleys(int n, String s) {
		int l = 0;
		int v = 0;
		for (char c : s.toCharArray()) {
			if (c == 'U')
				l++;
			else if (c == 'D')
				l--;
			if (l == 0 && c == 'U')
				v++;
		}
		return v;
	}

	private Solution() {
	}
}
