import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int[] zero = new int[41];
	public static int[] one = new int[41];
	
	public static void main(String[] args) throws IOException {
	
		int[] n; // 입력받을 n을 담는 배열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int t = Integer.parseInt(br.readLine()); // 테스트케이스 갯수
		n = new int[t];

		for(int i=0; i<t; i++) {
			n[i] = Integer.parseInt(br.readLine());
			fibonacci(n[i]);
		}
		
		for(int i=0; i<t; i++) {
			System.out.println(zero[n[i]] + " " + one[n[i]]);
		}
	}
	
	public static void fibonacci(int n) {
		zero[0] = 1; // n이0일 때는 0: 1, 1: 0
		one[1] = 1; // n이1일 때는 0: 0, 1: 1

		if(n >= 2) {
			for(int i=2; i<=n; i++) {
				zero[i] = zero[i-1] + zero[i-2];
				one[i] = one[i-1] + one[i-2];
			}
		}
	}
}

