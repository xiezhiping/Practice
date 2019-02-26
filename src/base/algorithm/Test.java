package base.algorithm;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int[] array = new int[10];
		for (int i = 0; i < 5; i++) {
			array[i] = sc.nextInt();
		}
		// Ê¹ÓÃËã·¨
		quicksort(array, 0, 4);
		for (int i = 0; i < 5; i++) {
			System.out.print(array[i] + " ");
		}
	}
	private static void quicksort(int[] array, int left, int right) {
		if (left > right) {
			return;
		}
		int temp = array[left];
		int i = left;
		int j = right;
		while (i < j) {
			while(array[j] >= temp && j > i) {
				j--;
			}
			while(array[i] <= temp && i < j) {
				i++;
			}
			if (i < j) {
				swap(array, i, j);
			}
		}
		array[left] = array[i];
		array[i] = temp;
		quicksort(array, left, i - 1);
		quicksort(array, i + 1, right);
	}
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
