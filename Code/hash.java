
public class hash {
	public int maxSize;
	public int[] table = new int[maxSize];
	public static int size = 0;
	
	public static int hash1(String k){
		int key1 = map(k);
		return key1;
	}
	
	public static int map(String k){
		String k1 = k;
		int val = 0;
		int a = 33;
		int e = k1.length();
		
		for(int i = 0; i < k1.length(); i++){
				val = val + ((int)k1.charAt(i) * (int)Math.pow(a, e));
				e--;
			}
		return val;
	}
	
	public static int hash2(String k, int m){
		int key2 = hash1(k);
		int key = (int) Math.sqrt(Math.pow((double)(key2%m), 2));
		return key;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String k = "080-9929383";
		int x = hash2(k, 10);
		
		System.out.println(x);
		
	}

}
