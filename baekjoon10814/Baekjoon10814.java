import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Person implements Comparable{
	private int age;
	private String name;
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}


	@Override
	public int compareTo(Object o) {
		Person p2 = (Person)o;
		
		return this.age - p2.age;
	}


	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

public class Main {
	public static Person[] person;
	
	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // 사람 명 수
		person = new Person[t];
		
		// 나이, 이름 입력 받기
		for(int i=0; i<t; i++) {
			int age = sc.nextInt();
			String name = sc.next();
			person[i] = new Person(age, name);
		}
		
		Arrays.sort(person);
		
		for(Person i : person) {
			System.out.println(i.getAge() + " " + i.getName());
		}
			
	}
}
