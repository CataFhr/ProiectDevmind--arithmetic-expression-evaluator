package sort;
import java.util.Arrays;

public class TestRadixSort {

	public static void main(String[] args) {
		int[] array = { 1000, 4, 25, 319, 88, 51, 3430, 8471, 701, 1, 2989, 657, 713 };
		System.out.println(Arrays.toString(RadixSort.sortAscending(array)));
		System.out.println(Arrays.toString(RadixSort.sortDescending(array)));
		
		int[] array1 = { 0, 4, 25, 25, 88, 51, 3430, 0, 55 , 657, 5782 };
		System.out.println(Arrays.toString(RadixSort.sortAscending(array1)));
		System.out.println(Arrays.toString(RadixSort.sortDescending(array1)));
	}

}
