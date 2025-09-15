package exceptions;

public class StringNotValidException extends Exception {
	// Se estendiamo RuntimeException, questa sarà un'eccezione CHECKED

	public StringNotValidException(String str) {
		super("La stringa " + str + " non è valida!"); // Grazie al costruttore super, andiamo ad impostare il messaggio che comparirà nell'eccezione
	}
}
