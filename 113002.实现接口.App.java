public class App implements R{

	public static void main(String[] args) {
		System.out.println(R.boy_filePath);
		System.out.println(R.girl_filePath);
		
		for (int row = 0; row < R.array2d.length; row++) {
			for (int column = 0; column < R.array2d[0].length; column++) {
				System.out.print(R.array2d[row][column]+" ");
			}
		 System.out.println();
		}
	}
}
