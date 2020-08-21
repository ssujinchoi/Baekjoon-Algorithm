import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int[] level;
	static int idx; // hashmap<String, Integer>의 value값
	private static ArrayList<Integer> result = new ArrayList<Integer>();
	
	public static int find(int x) {
		if(parent[x] == x) return x;
		else return parent[x] = find(parent[x]);
	}
	
	public static int union(int p1, int p2) { // 사람두명의 친구관계를 만들어줌
		int answer = 0;
		
		p1 = find(p1);
		p2 = find(p2);
		
		if(p1 == p2) return answer = level[p1];
		
		if(p1 < p2) {
			parent[p2] = p1;
			answer = level[p1] += level[p2];
		} else if(p2 < p1){
			parent[p1] = p2;
			answer = level[p2] += level[p1];
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); // 테스트 케이스
		
		while(t-- > 0) {
			int f = Integer.parseInt(br.readLine()); // 친구의 관계수
			HashMap<String, Integer> personhm = new HashMap<>();
			
			parent = new int[f*2];
			level = new int[f*2];
		
			for (int i = 0; i < f*2; i++) {
                			parent[i] = i;
                			level[i] = 1;
            			}
			idx = 0;
			for(int i=0; i<f; i++) {
				// 입력한 이름 공백기준으로 받기
				StringTokenizer st = new StringTokenizer(br.readLine());
	            String name1 = st.nextToken(); 
	            String name2 = st.nextToken();
	            
	            // map의 key에 name1(사람이름1)이 없다면 map에 넣어줌
	            if(!personhm.containsKey(name1)) {
	            	personhm.put(name1, idx++);
	            }
	            
	            // map의 key에 name2(사람이름2)이 없다면 map에 넣어줌
	            if(!personhm.containsKey(name2)) {
	            	personhm.put(name2, idx++);
	            }
	            
	            result.add(union(personhm.get(name1), personhm.get(name2)));
	            
			}
		}
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
