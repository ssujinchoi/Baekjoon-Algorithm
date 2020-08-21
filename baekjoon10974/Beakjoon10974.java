import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static ArrayList<Integer> perArr;
	public static int[] perCheck;
	
	private static void permutation(int n, ArrayList<Integer> perArr, int[] perCheck) {
        if(perArr.size() == n){
            for(int i : perArr){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
         
        for(int i=0; i<n; i++){
            if(perCheck[i] == 0){
            	perArr.add(i+1);
                perCheck[i] = 1;
                permutation(n, perArr, perCheck);
                perCheck[i] = 0;
                perArr.remove(perArr.size()-1);
            }
        }
         
    }
	
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
	
		n = sc.nextInt();

		perArr = new ArrayList<Integer>();
		perCheck = new int[n];
		permutation(n, perArr, perCheck);
	}
}
