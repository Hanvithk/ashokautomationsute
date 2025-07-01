package array;

public class Twodaimenstions {

	public static void main(String[] args) {

		int arr [][]= { {10,20,30,40,50,60},
				    {100,200,300,400,500,600}
		};
		//System.out.println(arr[1][1]);
		
		for (int i=0; i<2; i++)
		{
			for (int j=0; j<5; j++) {	
			
			System.out.print(arr[i][j] + "    ");
		}
			System.out.println();
	}

}}
