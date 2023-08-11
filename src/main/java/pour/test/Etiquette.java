package pour.test;

public class Etiquette {

	public static void main(String[] args) {

		for1:
		for (int un = 0; un < 4; un++) {
			System.out.println("un : " + un);
			if (un == 2)
				continue for1;
			for2:
			for (int deux = 0; deux < 3; deux++) {
				System.out.println("deux : " + deux);
				for3:
				for (int trois = 0; trois < 5; trois++) {
					System.out.println("trois : " + trois);
					if (trois == 3)
						break for2;
				}
			}
		}
	}

}
