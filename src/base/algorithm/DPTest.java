package base.algorithm;

import java.util.Scanner;

/*
## 题目描述
广场上站着一支队伍，她们是来自全国各地的扭秧歌代表队，现在有她们的身高数据，请你帮忙找出身高依次递增的子序列。 例如队伍的身高数据是（1、7、3、5、9、4、8），其中依次递增的子序列有（1、7），（1、3、5、9），（1、3、4、8）等，其中最长的长度为4。
### 输入描述:
输入包含多组数据，每组数据第一行包含一个正整数n（1≤n≤1000）。

紧接着第二行包含n个正整数m（1≤n≤10000），代表队伍中每位队员的身高。
### 输出描述:
对应每一组数据，输出最长递增子序列的长度。
### 示例1
#### 输入
> 7

> 1 7 3 5 9 4 8

> 6

> 1 3 5 2 4 6

#### 输出
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
			int[] dp = new int[n]; // dp[i]表示以下标i结尾的最大增长子序列
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
