package pac;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int arr2d[][]=new int[10][10];
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入矩阵你要输入的行：");
        int row=scanner.nextInt();
        System.out.println("请输入矩阵你要输入的列：");
        int column=scanner.nextInt();
        System.out.println("请输入该位置的值：");
        int value=scanner.nextInt();
        //将输入的值赋值给矩阵具体元素
        arr2d[row][column]=value;
        //遍历输出
        for(int x=0;x<arr2d.length;x++){
            for(int y=0;y<arr2d[x].length;y++){
                System.out.print(arr2d[x][y]);
            }
            System.out.println();
        }
    }

}
