public class Main {
	public static void main(String[] args) {

		// -------------------------------------------- ERRORS ---------------------------------------------
		/*
		Gli ERRORS sono delle problematiche non gestibili tramite classica gestione errori (tipo lo StackOverflowError)
		Non posso semplicemente andare appunto ad implementare un try-catch nel codice, bensì l'intervento che viene richiesto è quello
		di dover modificare in maniera importante il codice incriminato o addirittura, in casi più gravi, dover risolvere anche problemi
		hardware del computer
		*/

		// print("");

		// ------------------------------------------------ UNCHECKED EXCEPTIONS --------------------------------------
		// Sono tutte quelle eccezioni per le quali NON ABBIAMO ALCUN OBBLIGO DI GESTIONE tramite try-catch.
		// Sono invece solitamente problematiche prevenibili con qualche tipo di controllo in più (es. if-else...)

		int[] numbers = {1, 2, 3, 4};
		int input = 8;
		if (input < 0 || input > 3) System.out.println("Hai inserito un valore non valido!");
		else
			System.out.println(numbers[input]); // <-- ArrayIndexOutOfBoundsException

		System.out.println("Ciao, dammi un numero");
		String input2 = "asdadsadasd";
		// System.out.println(Integer.parseInt(input2)); // <-- NumberFormatException

		String qualcosa = "Qualcosa";
		qualcosa = null;

		if (qualcosa != null)
			System.out.println(qualcosa.toUpperCase()); // <-- NullPointerException
		else System.out.println("Guarda che è null!");


		int num1 = 10;
		int num2 = 0;
		if (num2 != 0)
			System.out.println(num1 / num2); // <-- ArithmeticException
		else System.out.println("Non si può dividere per zero capra!");

		// ----------------------------------------- CHECKED EXCEPTIONS ----------------------------------------
		// Sono eccezioni per le quali SONO COSTRETTO A DOVER USARE UN TRY-CATCH SE VOGLIO FAR PARTIRE IL CODICE
		// In questi casi non mi basterà un controllo tramite if/if-else per prevenire l'eccezione, in quanto
		// questa potrebbe comunque presentarsi con relativo crash dell'applicazione. Quindi l'unica è usare
		// try-catch

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		System.out.println("CIAO");
	}


//	public static void print(String msg) {
//		print(msg);
//	}
}
