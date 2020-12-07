public class Find {
	public void find(){
		int array2d[][]={
				{1,2,3,4,5,6},
				{7,8,9,10,0,12},
				{8,8,9,10,11,12},
				{7,8,3,10,11,12},
				{88,66,92,102,151,999}
				};
		
		for (int row = 0; row < array2d.length; row++) {
			for (int i = 0; i < array2d[0].length; i++) {
				if (row==1 && i==4) {
					System.out.println("R_zero："+array2d[row][i]);
				}
				if (row==0&& i==4) {
					System.out.println("R_zero上："+array2d[row][i]);
				}
				if (row==1 && i==3) {
					System.out.println("R_zero左："+array2d[row][i]);
				}
				if (row==2 && i==4) {
					System.out.println("R_zero下："+array2d[row][i]);
				}
				if (row==1 && i==5) {
					System.out.println("R_zero右："+array2d[row][i]);
				}
				
			}
			
		}		
	}	
}
