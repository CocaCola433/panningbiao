public class App {

	public static void main(String[] args) {
		System.out.println("你想知道斐波那契数列第几项的值");
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		
		System.out.println("数列的第n项值为"+f(n));
	}
	
	public static int f(int n) {
		if (n<=0) {
			System.out.println("输入的n应该大于0");
			return -1;
			
		}else if(n==1||n==2){
			return 1;
		}else {
			return f(n-1)+f(n-2);
		}
	} 

}
