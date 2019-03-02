package base;

import java.util.Scanner;

public class MaxNumTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n + 1];
		for (int i = 1; i <= n;i++) {
			array[i] = sc.nextInt();
		}
		StringBuffer sb = new StringBuffer();
		// 构建一个最大堆
		for (int i = 1; i <= n; i++) {
			maxHeap(array, n);
//			System.out.print(array[i] + " ");
			sb.append(array[1]);
			array[1] = -999;
	
		}
		System.out.println(sb.toString());
	}
	private static void maxHeap(int[] array, int length) {
		for (int i = length; i >= 1; i--) {
			swap(array, 1, length);
			adjust(array, 1, length);
		}
	}
	// 调整堆
	private static void adjust(int[] array, int i, int length) {
		int child = 0;
		// 选择孩子节点最大的那个
		while(i <= (length/2)) {
			child = max(array, left(i), right(i), length);
			if (array[i] < array[child]) {
				swap(array, child, i);
			}
			i = child;
		}
	}
	// 获取较大的孩子节点
	private static int max(int[] array, int left, int right, int length) {
		if (left <= length && right <= length) {
			return array[left] > array[right] ? left : right;
		} else if(left <= length) {
			return left;
		} else if(right <= length) {
			return right;
		} else {
			return length; // 这个值是一个无效值
		}
	}
	// 获取右孩子坐标索引
	private static int right(int parent) {
		return (parent << 1) + 1;
	}
	// 获取左孩子坐标索引
	private static int left(int parent) {
		return parent << 1;
	}
	// 交换两个元素
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
