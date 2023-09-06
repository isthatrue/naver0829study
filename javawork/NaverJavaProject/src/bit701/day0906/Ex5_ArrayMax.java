package bit701.day0906;

public class Ex5_ArrayMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 최댓값, 최솟값 구하기
		int[] data;
		data = new int[] {5, -100, 67, 89, 45, -9, 123, 58, 110, 200, -300};
		int max, min;
		
		// 최댓값
		max = data[0];	// 첫 번째 데이터를 최댓값에 저장한다.
		// 최솟값
		min = data[0];	// 첫 번째 데이터를 최솟값에 저장한다.
		
		
		//두 번째부터 끝까지 비교해서 더 큰 값이 나오면 max값을 변경한다.
		for (int i=1; i<data.length; i++) {
			if(max<data[i])
				max=data[i];
				
			if(min>data[i])
				min=data[i];
		}
		System.out.println("데이터 개수: "+data.length);
		System.out.println("max = "+max);
		System.out.println("min = "+min);
	}

}
