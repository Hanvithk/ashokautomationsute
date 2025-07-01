package array;

public class Test {

	@org.testng.annotations.Test
	public void tc001() {
		
		int arr [] = {100,200,300,400,500};
		System.out.println(arr[2]);
	}
	
	@org.testng.annotations.Test
	public void tc002_assending() {
		
		int  [] arrmarkes= new int [] {55,88,45,66,77,99,50};
		
		int temp;
		
		for(int i=0; i<arrmarkes.length; i++) {
			for(int j=i; j<arrmarkes.length; j++) {
				
				if(arrmarkes [i] > arrmarkes[j]) {
					temp = arrmarkes[i];
					
					arrmarkes[i]= arrmarkes[j];
					arrmarkes[j]= temp;
				}
			}
		}
		for(int a: arrmarkes) {
			System.out.println(a);
			
		}
	}
}
