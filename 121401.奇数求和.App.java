public class App {

	//奇数求和
	public static void main(String[] args) {
		long sum=0;
		for (long i = 0; i <=2147483647L; i++) {
			if(i%2!=0) {
				
				sum=sum+i;
			}
		}
		System.out.println(sum);
	}

}
