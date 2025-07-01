package array;

public class A {

	public static void main(String[] args) {

		int arr [] = {100,200,300,400,500};
		System.out.println(arr[2]);
		
		arr [2] = 1000;
		System.out.println(arr[2]);
		System.out.println("length is -- " +  arr.length);
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
			
		}
	}

}
