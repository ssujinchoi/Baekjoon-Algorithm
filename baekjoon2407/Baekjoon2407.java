import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	// 범위가 100까지 이기 때문에 n! 을 했을 경우 어마어마하게 숫자가 커집니다. -> BigInteger사용	
	static BigInteger bn;
	static BigInteger bm;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine()); // 공백으로 구분
        	int n = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(st.nextToken());
        
        	bn = factorial(n); // n!
        	bm = factorial(n-m).multiply(factorial(m)); // r!(n-r)!
        
        	System.out.println(bn.divide(bm));
        
    }
    
    public static BigInteger factorial(int x) {
    	if(x == 0 || x == 1) return BigInteger.valueOf(1);
    	
    	BigInteger fac = BigInteger.valueOf(x);
    	for(int i=x-1; i>=2; i--) {
    		 fac = fac.multiply(BigInteger.valueOf(i));
    	}
    	return fac;
    }
}
