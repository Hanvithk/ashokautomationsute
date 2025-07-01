package array;

public class AssendingOrderandDissendingOrder {

	public static void main(String[] args) {
		
		int [] marksArray = new int []{2,6,1,8,0,9,5};
		
		int temp ;
		for(int i=0; i<marksArray.length; i++) {
			
			for(int j=i; j<marksArray.length; j++) {
				
				if(marksArray[i] >marksArray[j]) {
					
					temp = marksArray[i];
					marksArray[i] = marksArray[j];
					marksArray[j] = temp;
				}
			}
		}
		for(int a: marksArray) {
			System.out.print(a);
		}
	}
}
