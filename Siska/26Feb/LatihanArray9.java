//Siska Pitriani 26 Februari 2018
import java.util.Scanner;
public class LatihanArray9{
	public static void main (String[]args){
		Scanner keyboard = new Scanner (System.in);
		int [] arr1 = { 25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
		int [] arr2 = new int [10];
		int [] arr3 = {2, 39, 47, 36, 56, 57, 49, 43, 79};
		int [] arr4 = new int [10];
		int temp=arr1[0];

		System.out.print ("Arr1 : ");
		for (int n : arr1) {
			System.out.print (n + " ");
		}

		for (int i = 0; i < arr1.length-1; i++){
			if (arr1[i] > arr1[i+1]){
				if ( arr1[i] > temp ){
					temp=arr1[i];
				}
			}
		}
		System.out.println ("Nilai maksimun pada Array 1 adalah: " + temp);
	}
}