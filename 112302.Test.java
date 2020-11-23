package com.pnb;

public class Test {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		int arr[][]={
				{100,200},
				{50,60},
				{90,100},
				{70,80}	
			
		};
		
		while (true) {
			Thread.sleep(1000);
			System.out.println("你好靓仔");
			int rum=(int)(Math.random()*10%4);
			System.out.println(arr[rum][0]+","+arr[rum][1]);
		}
		
		

	}

}
