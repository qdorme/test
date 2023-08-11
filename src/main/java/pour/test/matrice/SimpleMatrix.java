package pour.test.matrice;

import java.time.Duration;
import java.time.LocalDateTime;

public class SimpleMatrix {

	private final double[][] data;

	public SimpleMatrix(double[][] data) {
		this.data = data;
	}
	public SimpleMatrix(int line, int column) {
		this.data = new double[line][column];
	}

	public SimpleMatrix mul(SimpleMatrix other){
		if(this.data[0].length != other.data.length)
			throw new IllegalArgumentException();
		SimpleMatrix newMatrix = new SimpleMatrix(this.data.length, other.data[0].length);
		for(int line = 0; line < this.data.length ; line ++)
			for(int column = 0; column < other.data[0].length; column++)
				newMatrix.data[line][column]= scalarProduct(line(line), column(column));
		return newMatrix;
	}

	protected double[] column(int index){
		if(index > data[0].length)
			throw new IllegalArgumentException("index trop grand");
		double[] column = new double[data[0].length];
		for(int i=0; i < column.length; i++){
			column[i]=data[i][index];
		}
		return column;
	}

	protected double[] line(int index){
		if(index > data.length)
			throw new IllegalArgumentException("index trop grand");
		return data[index];
	}

	protected double scalarProduct(double[] line, double[] column){
		if(line.length != column.length)
			throw new IllegalArgumentException("tailles incompatible");
		double produit = 0;
		for(int index=0; index < line.length; index++){
			produit += line[index]*column[index];
		}
		return produit;
	}

	public double[][] data() {
		return data;
	}

	public static void main(String[] args) {
		SimpleMatrix first = new SimpleMatrix(1000, 100);
		SimpleMatrix second = new SimpleMatrix(100, 100);
		LocalDateTime before = LocalDateTime.now();
		first.mul(second);
		LocalDateTime after = LocalDateTime.now();
		System.out.println(Duration.between(before,after).toSeconds());

	}
}
