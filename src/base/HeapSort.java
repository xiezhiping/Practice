package base;

public class HeapSort {
	public static void main(String[] args) {
		int[] data = {0, 49, 38, 65, 97, 76, 13, 27, 50}; // 第一个位置空出来
		heapSort(data, 8);
		for(int i = 1; i < 9; i++) {
			System.out.print(data[i] + " ");
		}
	}
	private static void heapSort(int[] data, int length) {
		for (int i = length; i > 1; i--) {
			swap(data, 1, i);
			heapAdjust(data, 1, length);
		}
	}
	private static void heapAdjust(int[] data, int i, int length) {
		if (i > length / 2) {
			return;
		}
		int child = larger(data, left(i), right(i), length);
		if (data[i] < data[child]) {
			swap(data, i, child);
			heapAdjust(data, child, length);
		}
	}
	private static int larger(int[] data, int left, int right, int length) {
		if (left <= length && right <= length) {
			return data[left] > data[right] ? left : right;
		} else if (left <= length) {
			return left;
		} else if (right <= length) {
			return right;
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	private static int right(int i) {
		return (i << 1) + 1;
	}
	private static int left(int i) {
		return i << 1;
	}
	private static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}
