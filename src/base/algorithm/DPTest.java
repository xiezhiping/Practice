package base.algorithm;

import java.util.Scanner;

/*
## ��Ŀ����
�㳡��վ��һ֧���飬����������ȫ�����ص�Ť������ӣ����������ǵ�������ݣ������æ�ҳ�������ε����������С� ����������������ǣ�1��7��3��5��9��4��8�����������ε������������У�1��7������1��3��5��9������1��3��4��8���ȣ�������ĳ���Ϊ4��
### ��������:
��������������ݣ�ÿ�����ݵ�һ�а���һ��������n��1��n��1000����

�����ŵڶ��а���n��������m��1��n��10000�������������ÿλ��Ա����ߡ�
### �������:
��Ӧÿһ�����ݣ��������������еĳ��ȡ�
### ʾ��1
#### ����
> 7

> 1 7 3 5 9 4 8

> 6

> 1 3 5 2 4 6

#### ���
> 4

> 4
 */
public class DPTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = sc.nextInt();
			}
			if (array.length < 1) {
				continue;
			}
			int max = 1;
			int[] dp = new int[n]; // dp[i]��ʾ���±�i��β���������������
			for (int i = 0; i < n; i++) {
				dp[i] = 1;
				for (int j = 0; j < i; j++) {
					if (array[i] > array[j]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
						max = Math.max(dp[i], max);
					}
				}
			}
			System.out.println(max);
		}
	}
}
