package pour.test.singleton;

import java.util.function.Supplier;

import static java.lang.System.out;

public class FunctionalWay {

	private static FunctionalWay instance;

	private static Supplier<FunctionalWay> methode = () -> createAndCacheInstance();
	private static final Supplier<FunctionalWay> functionalWaySupplier = () ->  instance;
	private FunctionalWay(){}

	public static FunctionalWay getInstance(){
		return methode.get();
	}

	private synchronized static FunctionalWay createAndCacheInstance(){
		if(methode == functionalWaySupplier)
			return functionalWaySupplier.get();

		instance = new FunctionalWay();
		out.println(" instance created");

		methode = functionalWaySupplier;
		return instance;
	}

	public static void main(String[] args) {
		FunctionalWay.createAndCacheInstance();
		FunctionalWay.createAndCacheInstance();
		FunctionalWay.createAndCacheInstance();
		FunctionalWay.createAndCacheInstance();
	}
}
