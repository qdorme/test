package pour.test.singleton;

public class OldWay {

	private static OldWay instance;

	private OldWay(){}

	public static OldWay getInstance() {
		if(instance == null) instance = new OldWay();
		return instance;
	}
}
