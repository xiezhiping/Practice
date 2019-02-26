package base.algorithm;

public class Merge {
	public static void main(String[] args) {
		int[] data = {2, 8, 7, 6, 9, 1, 4, 5};
		sort(data, 0, 7);
		for(int v : data) {
			System.out.print(v + " ");
		}
	}
	private static void sort(int[] data, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			sort(data, left, mid);
			sort(data, mid + 1, right);
			merge(data, left, mid, mid + 1, right);	
		}
	}
	private static void merge(int[] data, int start1, int end1, int start2, int end2) {
		int[] result = new int[(end2 + end1 - start1 - start2) + 2]; // 声明一个长度为数组两个区间个数和的结果数组
		int i = start1;
		int j = start2;
		int k = 0;
		while(i <= end1 && j <= end2) {
			if (data[j] < data[i]) {
				result[k] = data[j];
				j++;
			} else {
				result[k] = data[i];
				i++;
			}
			k++;
		}
		while(i <= end1) {
			result[k] = data[i];
			i++;
		}
		while(j <= end2) {
			result[k] = data[j];
			j++;
		}
		k = start1;
		for (int v : result) {
			data[k++] = v;
		}
	}
	private static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}
