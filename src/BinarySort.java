public class BinarySort {
	public static void binarySort(int[] source) {
		int i, j;
		int high, low, mid;
		int temp;
		for (i = 1; i < source.length; i++) {
			// �������Ͻ�
			low = 0;
			// �������½�
			high = i - 1;
			//����ǰ�������¼��������ʱ������
			temp = source[i];
			while (low <= high) {
				// �ҳ��м�ֵ
				// mid = (low + high) / 2;
				mid = (low + high) >> 1;
				//����������¼���м��¼С
				if (temp<source[mid] ) {
					// ������ڵͰ���
					high = mid - 1;
				} else {
					// ������ڸ߰���
					low = mid + 1;
				}
			}
			 //��ǰ�����д��ڵ�ǰ�������¼�ļ�¼���� 
			for (j = i - 1; j >=low; j--) {
				source[j + 1] = source[j];
			}
			//���������¼�����ȷλ��. 
			source[low] = temp;
			System.out.print("��" + i + "������");
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
		System.out.print("��ʼ�ؼ��֣�");
		printArray(source);
		System.out.println("");
 
		binarySort(source);
 
		System.out.print("\n\n���������");
		printArray(source);
	}
}
