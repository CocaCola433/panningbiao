public class App {

	
	public static void main(String[] args) {
		int arr[][] = {
				{1,2,3,4,5},
				{6,7,8,9,0},
				{10,11,12,13,14},
				{15,16,17,18,19},
				{20,21,22,23,24},
				{25,26,27,28,29},
		};
		
		for (int row = 0; row < arr.length; row++) {
			for (int i = 0; i < arr[0].length; i++) {
				System.out.print(row+" ");
			}
			System.out.println();
		}
		
		
		//find
		Find find = new Find();
		find.listt();
		
		//find2
		Find2 find2 = new Find2();
		find2.find2();
		
		
		
		
		
	}
}
