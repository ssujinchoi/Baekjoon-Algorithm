import java.util.*;

public class Main {
	static long[] fi;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
	
		System.out.println(fibonnaci(n));
	}
	
	public static long fibonnaci(int n) {
		fi = new long[n+1];
		
		fi[0] = 0;
		fi[1] = 1;
		 
		if(n>=2) {
			for(int i=2; i<=n; i++) {
				fi[i] = fi[i-1] + fi[i-2];
			}
		}
		return fi[n];
	}
}
