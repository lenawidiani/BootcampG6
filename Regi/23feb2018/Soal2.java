import java.util.Scanner;

public class Soal2 {
	public static void main( String[] args ) {
		Scanner keyboard = new Scanner(System.in);
		int[] arr1 = { 25, 14, 56, 15, 36, 56, 77, 18, 29, 49 };
		int[] arr2 = new int [10];
		int[] arr3 = { 2, 39, 47, 14, 36, 56, 57, 49, 43, 79 };
		int[] arr4 = new int [10];
		int toFind;
		boolean found;

		for ( int num : arr1 ) {
			System.out.println( num + " " );
		}
		System.out.println();

		System.out.print( "Masukan nilai yang anda cari: " );
		toFind = keyboard.nextInt();
		found = false;

		// for
		found = false;
		for ( int num : arr1 ) {
			if ( num == toFind ) {
				System.out.println( num + " found.");
				found = true;
			}

		}
		if ( found == false ) {
				System.out.println( "not found.");
			}
	}
}