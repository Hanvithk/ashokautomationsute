package array;

public class Assendibn {

public static void main(String[] args) {
	
	int []marksarray = new int [] {33,44,55,22,85,30};
	
	int temp;
	
	for(int i=0; i<marksarray.length; i++) {
	for(int j=i; j<marksarray.length; j++)	{
		if(marksarray [i] < marksarray [j]) {
			temp = marksarray[i];
			marksarray [i] = marksarray[j];
			marksarray [j]=temp;
		}
	}
	}
	for(int a:marksarray) {
		System.out.println(a);
		
	}
}
}
