package sort;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

// Sorting numbers
public class RadixSort {

	// I
	public static int[] sortAscending(int[] arr) {
		ArrayList<Deque<Integer>> queueList = new ArrayList<>();
		for (int queueNo = 0; queueNo < 10; queueNo++) {
			queueList.add(new LinkedList<>());
		}
		int max = RadixSort.getMax(arr);
		int maxDigitsNo = RadixSort.countDigits(max);
		int factor = 1;

		for (int k = 0; k < maxDigitsNo; k++) {
			for (int i = 0; i < arr.length; i++) {
				int digit = arr[i] / factor % 10;
				queueList.get(digit).offer(arr[i]);
			}
			factor *= 10;
			int index = 0;
			for (int queueNo = 0; queueNo < queueList.size(); queueNo++) {
				while (!queueList.get(queueNo).isEmpty()) {
					arr[index++] = queueList.get(queueNo).poll();
				}
			}
		}
		return arr;
	}

	public static int[] sortDescending(int[] arr) {
		ArrayList<Deque<Integer>> queueList = new ArrayList<>();
		for (int queueNo = 0; queueNo < 10; queueNo++) {
			queueList.add(new LinkedList<>());
		}
		int max = getMax(arr);
		int maxDigitsNo = countDigits(max);
		int factor = 1;

		for (int k = 0; k < maxDigitsNo; k++) {
			for (int i = 0; i < arr.length; i++) {
				int digit = arr[i] / factor % 10;
				queueList.get(digit).offer(arr[i]);
			}
			factor *= 10;
			int index = 0;
			for (int queueNo = queueList.size() - 1; queueNo >= 0; queueNo--) {
				while (!queueList.get(queueNo).isEmpty()) {
					arr[index++] = queueList.get(queueNo).poll();
				}
			}
		}
		return arr;
	}

	private static int countDigits(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n /= 10;
		}
		return count;
	}

	private static int getMax(int arr[]) {
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}


	// II

//	private static Deque<Integer> q0 = new LinkedList<>();
//	private static Deque<Integer> q1 = new LinkedList<>();
//	private static Deque<Integer> q2 = new LinkedList<>();
//	private static Deque<Integer> q3 = new LinkedList<>();
//	private static Deque<Integer> q4 = new LinkedList<>();
//	private static Deque<Integer> q5 = new LinkedList<>();
//	private static Deque<Integer> q6 = new LinkedList<>();
//	private static Deque<Integer> q7 = new LinkedList<>();
//	private static Deque<Integer> q8 = new LinkedList<>();
//	private static Deque<Integer> q9 = new LinkedList<>();
//
//	public static int[] sortAscending(int[] arr) {
//		int max = getMax(arr);
//		int maxDigitsNo = countDigitsNo(max);
//		int factor = 1;
//		for (int k = 0; k < maxDigitsNo; k++) {
//			for (int i = 0; i < arr.length; i++) {
//				switch (arr[i] / factor % 10) {
//				case 0:
//					q0.offer(arr[i]);
//					break;
//				case 1:
//					q1.offer(arr[i]);
//					break;
//				case 2:
//					q2.offer(arr[i]);
//					break;
//				case 3:
//					q3.offer(arr[i]);
//					break;
//				case 4:
//					q4.offer(arr[i]);
//					break;
//				case 5:
//					q5.offer(arr[i]);
//					break;
//				case 6:
//					q6.offer(arr[i]);
//					break;
//				case 7:
//					q7.offer(arr[i]);
//					break;
//				case 8:
//					q8.offer(arr[i]);
//					break;
//				case 9:
//					q9.offer(arr[i]);
//					break;
//				}
//			}
//			factor *= 10;
//			int index = 0;
//			while (!q0.isEmpty()) {
//				arr[index] = q0.poll();
//				index++;
//			}
//			while (!q1.isEmpty()) {
//				arr[index] = q1.poll();
//				index++;
//			}
//			while (!q2.isEmpty()) {
//				arr[index] = q2.poll();
//				index++;
//			}
//			while (!q3.isEmpty()) {
//				arr[index] = q3.poll();
//				index++;
//			}
//			while (!q4.isEmpty()) {
//				arr[index] = q4.poll();
//				index++;
//			}
//			while (!q5.isEmpty()) {
//				arr[index] = q5.poll();
//				index++;
//			}
//			while (!q6.isEmpty()) {
//				arr[index] = q6.poll();
//				index++;
//			}
//			while (!q7.isEmpty()) {
//				arr[index] = q7.poll();
//				index++;
//			}
//			while (!q8.isEmpty()) {
//				arr[index] = q8.poll();
//				index++;
//			}
//			while (!q9.isEmpty()) {
//				arr[index] = q9.poll();
//				index++;
//			}
//		}
//		return arr;
//	}
//
//	public static int[] sortDescending(int[] arr) {
//		int max = getMax(arr);
//
//		int maxDigitsNo = countDigitsNo(max);
//		int factor = 1;
//		for (int k = 0; k < maxDigitsNo; k++) {
//			for (int i = 0; i < arr.length; i++) {
//				switch (arr[i] / factor % 10) {
//				case 0:
//					q0.offer(arr[i]);
//					break;
//				case 1:
//					q1.offer(arr[i]);
//					break;
//				case 2:
//					q2.offer(arr[i]);
//					break;
//				case 3:
//					q3.offer(arr[i]);
//					break;
//				case 4:
//					q4.offer(arr[i]);
//					break;
//				case 5:
//					q5.offer(arr[i]);
//					break;
//				case 6:
//					q6.offer(arr[i]);
//					break;
//				case 7:
//					q7.offer(arr[i]);
//					break;
//				case 8:
//					q8.offer(arr[i]);
//					break;
//				case 9:
//					q9.offer(arr[i]);
//					break;
//				}
//			}
//			factor *= 10;
//			int index = 0;
//			while (!q9.isEmpty()) {
//				arr[index] = q9.poll();
//				index++;
//			}
//			while (!q8.isEmpty()) {
//				arr[index] = q8.poll();
//				index++;
//			}
//			while (!q7.isEmpty()) {
//				arr[index] = q7.poll();
//				index++;
//			}
//			while (!q6.isEmpty()) {
//				arr[index] = q6.poll();
//				index++;
//			}
//			while (!q5.isEmpty()) {
//				arr[index] = q5.poll();
//				index++;
//			}
//			while (!q4.isEmpty()) {
//				arr[index] = q4.poll();
//				index++;
//			}
//			while (!q3.isEmpty()) {
//				arr[index] = q3.poll();
//				index++;
//			}
//			while (!q2.isEmpty()) {
//				arr[index] = q2.poll();
//				index++;
//			}
//			while (!q1.isEmpty()) {
//				arr[index] = q1.poll();
//				index++;
//			}
//			while (!q0.isEmpty()) {
//				arr[index] = q0.poll();
//				index++;
//			}
//		}
//		return arr;
//	}

}
