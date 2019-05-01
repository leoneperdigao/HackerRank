package br.com.leoneperdigao.sockmerchant;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static int sockMerchant(int n, int[] ar) {
		Set<Integer> colors = new HashSet<>();
		int pairs = 0;
		for (int i = 0; i < n; i++) {
			if (!colors.add(ar[i])) {
				colors.remove(ar[i]);
				pairs++;
			}
		}
		return pairs;
	}

	private Solution() {
	}

}
