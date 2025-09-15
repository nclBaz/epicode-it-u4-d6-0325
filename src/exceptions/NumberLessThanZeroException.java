package exceptions;

public class NumberLessThanZeroException extends RuntimeException {
	// Se estendiamo RuntimeException, questa sarà un'eccezione UNCHECKED

//	public NumberLessThanZeroException(String msg) {
//		super(msg); // Grazie al costruttore super, andiamo ad impostare il messaggio che comparirà nell'eccezione
//	}

	public NumberLessThanZeroException(int num) {
		super("Il numero inserito: " + num + " è inferiore allo zero!");
	}

	public NumberLessThanZeroException(double num) {
		super("Il numero inserito: " + num + " è inferiore allo zero!");
	}
}
