package pour.test;

import java.util.function.Consumer;

public class FluentMailer {

	private FluentMailer() {
	}

	public static void main(String[] args) {
		FluentMailer.send(mailer ->
				mailer.from("quentin@test.fr")
						.to("quentin@test.com")
						.subject("un super test")
						.body("C'est un super test"));
	}

	public static void send(final Consumer<FluentMailer> block) {
		final FluentMailer mailer = new FluentMailer();
		block.accept(mailer);
		System.out.println("Sending...");
	}

	public FluentMailer from(final String address) { /*... */
		return this;
	}

	public FluentMailer to(final String address) { /*... */
		return this;
	}

	public FluentMailer subject(final String line) { /*... */
		return this;
	}

	public FluentMailer body(final String message) { /*... */
		return this;
	}

}
