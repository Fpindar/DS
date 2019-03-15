
public class hash {
	public int maxSize;
	public int[] table = new int[maxSize];
	public static int size = 0;
	
	public static int hashf1(String k){
		int key1 = map1(k);
		return key1;
	}
	
	public static int map1(String k){
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
	
	public static int hashcompress1(String k, int m){
		int key2 = hashf1(k);
		int key = (int) Math.sqrt(Math.pow((double)(key2%m), 2));
		return key;
	}
	
	
	public static int hashf2(String k){
		int key2 = map2(k);
		return key2;
	}
	
	public static int map2(String k){
		String k1 = k;
		int val = 0;
		int a = 67;
		int e = k1.length();
		
		for(int i = 0; i < k1.length(); i++){
				val = val + ((int)k1.charAt(i) * (int)Math.pow(a, e));
				e--;
			}
		return val;
	}
	
	public static int hashcompress2(String k, int m){
		int key2 = hashf2(k);
		int key = (int) Math.sqrt(Math.pow((double)(key2%m), 2));
		return key;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String k = "kjdjckedjo";
		int x = hashcompress1(k, 10);
		int y = hashcompress2(k, 10);
		
		System.out.println("First key is "+ x);
		System.out.println("Second key is "+ y);
		
	}

}
