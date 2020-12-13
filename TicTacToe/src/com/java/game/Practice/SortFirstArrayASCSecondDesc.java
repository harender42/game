package com.java.game.Practice;

import java.util.Scanner;

public class SortFirstArrayASCSecondDesc {
	public static void main(String[] args) {
		Scanner scan = null;
		try {
			scan = new Scanner(System.in);
			System.out.println("enter the split size");
			int n = scan.nextInt();
			System.out.println("enter the size of the array");
			int size = scan.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				System.out.println(i + 1 + " elemnt enter the vale");
				arr[i] = scan.nextInt();
			}
			quickSortsort(arr, 0, size - 1);
			for (int i = 0; i < n; i++) {
				System.out.print(arr[i]);
			}
			for (int j = size - 1; j >= n; j--) {
				System.out.print(arr[j]);
			}
		} catch (Exception e) {
			System.out.println("exception" + e);
		} finally {
			if (scan != null) {
				scan.close();
			}
		}
	}

	private static void quickSortsort(int[] arr, int l, int r) {
		if (l < r) {
			int pi = partition(arr, l, r);
			quickSortsort(arr, l, pi - 1);
			quickSortsort(arr, pi + 1, r);

		}
	}

	private static int partition(int[] arr, int l, int r) {
		int pivot = arr[r];
		int i = l - 1;
		int j = l;
		while (j < r) {
			if (arr[j] < pivot) {
				i += 1;
				;
				swap(arr, i, j);
				j += 1;
			} else {
				j++;
			}
		}
		i++;
		swap(arr, i, r);
		return i;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}
}
