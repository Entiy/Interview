package com.demo.datastruct;

public class MergeSort {

	public static void main(String[] args) {
		int[] a = { 57, 68, 59, 52, 72, 28, 96, 33 };
		sort(a, 0, a.length - 1);
		for (int tmp : a) {
			System.out.print(tmp + " ");
		}
	}

	public static void sort(int[] a, int left, int right) {
		if (left >= right)
			return;

		int center = (left + right) >> 1;
		sort(a, left, center);
		sort(a, center + 1, right);
		merge(a, left, center, right);
	}

	public static void merge(int[] data, int left, int center, int right) {
		int[] tmpArr = new int[right + 1];
		int mid = center + 1;
		int index = left; // index��¼��ʱ���������
		int tmp = left;

		// ������������ȡ����С�ķ�������ʱ����
		while (left <= center && mid <= right) {
			tmpArr[index++] = (data[left] <= data[mid]) ? data[left++] : data[mid++];
		}
		// ʣ�ಿ�����η�����ʱ����
		while (mid <= right) {
			tmpArr[index++] = data[mid++];
		}
		while (left <= center) {
			tmpArr[index++] = data[left++];
		}
		// ����ʱ�����е����ݸ��ƻ�ԭ����
		for (int i = tmp; i <= right; i++) {
			data[i] = tmpArr[i];
		}
	}
}
