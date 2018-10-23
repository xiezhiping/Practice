public class BinarySort {
	public static void binarySort(int[] source) {
		int i, j;
		int high, low, mid;
		int temp;
		for (i = 1; i < source.length; i++) {
			// 查找区上界
			low = 0;
			// 查找区下界
			high = i - 1;
			//将当前待插入记录保存在临时变量中
			temp = source[i];
			while (low <= high) {
				// 找出中间值
				// mid = (low + high) / 2;
				mid = (low + high) >> 1;
				//如果待插入记录比中间记录小
				if (temp<source[mid] ) {
					// 插入点在低半区
					high = mid - 1;
				} else {
					// 插入点在高半区
					low = mid + 1;
				}
			}
			 //将前面所有大于当前待插入记录的记录后移 
			for (j = i - 1; j >=low; j--) {
				source[j + 1] = source[j];
			}
			//将待插入记录回填到正确位置. 
			source[low] = temp;
			System.out.print("第" + i + "趟排序：");
			printArray(source);
		}
	}
 
	private static void printArray(int[] source) {
		for (int i = 0; i < source.length; i++) {
			System.out.print("\t" + source[i]);
		}
		System.out.println();
	}
 
	public static void main(String[] args) {
		int source[] = new int[] { 12, 15, 9, 14, 4, 18, 23, 6 };
		System.out.print("初始关键字：");
		printArray(source);
		System.out.println("");
 
		binarySort(source);
 
		System.out.print("\n\n排序后结果：");
		printArray(source);
	}
}
