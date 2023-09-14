package bit701.day0914;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex7_Set {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Set<Integer> set = new HashSet<Integer>();		// 비순차적
		Set<Integer> set = new TreeSet<Integer>();		// 오름차순 정렬돼서 들어감
		System.out.println(set.size());		// size는 데이터의 개수(배열은 length)
		set.add(30);
		set.add(1);
		set.add(5);
		set.add(10);
		set.add(5);
		set.add(7);

		System.out.println(set.size());		// 5 (5는 1번만 계산)
		
		// 컬렉션들을 출력하는 방법 여러가지가 있다.
		// 출력 1
		System.out.println("---------------");
		for (Integer n : set)
			System.out.println(n);
		System.out.println("---------------");
		
		// 출력 2
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());	
			}
		System.out.println("---------------");
	}
}
