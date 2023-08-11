package pour.test;

public class CopyTab {

	public static void main(String[] args) {
		int [][] matrix = new int[3][4];
		int [] vector = new int[4];
		matrix[0][0]=0;
		matrix[0][1]=1;
		matrix[0][2]=2;
		matrix[0][3]=3;

		System.arraycopy(matrix[0],0,vector,0,vector.length);
		System.out.println(vector[0]);
		System.out.println(vector[1]);
		System.out.println(vector[2]);
		System.out.println(vector[3]);
	}
}
