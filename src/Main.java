import entities.Student;
import entities.StudentType;
import exceptions.NumberLessThanZeroException;
import exceptions.StringNotValidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private static Logger logger = LoggerFactory.getLogger(Main.class);

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
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}


		Student aldo = new Student("Aldo", "Baglio", true, StudentType.BACKEND);

		try {
			aldo.setName("A");
		} catch (StringNotValidException e) {
			// throw new RuntimeException(e); // Attenzione alla soluzione proposta da Intellij!
			// Qua di base propone di inserire dentro il catch il lancio di una nuova eccezione
			// che quindi non verrà gestita da nessuno e l'applicazione crasherà!
			System.err.println(e.getMessage());
		}


		System.out.println("CIAO");


		// ------------------------------------------------ TRY-CATCH -------------------------------------------
		try {
			aldo.setName("A");
		} catch (StringNotValidException | ArrayIndexOutOfBoundsException ex) {
			// Catch multi-eccezione, cioè mi permette di gestire 2 o più eccezioni alla stessa maniera
			System.out.println("inviata un'email con errore a Donald J.Trump");
		} catch (ArithmeticException ex) {
			// Concatenando più catch differenti ho la possibilità di gestire eccezioni diverse in maniere diverse
			System.out.println("inviata un'email con errore a Elon Musk");
		} catch (Exception ex) { // Questo è un catch "polimorfico" nel senso che può catturare tutti i tipi di eccezione
			System.err.println(ex.getMessage());
		}

//		Scanner sc = new Scanner(System.in);
//
//		int[] numbers2 = {0, 1, 2, 3};
//		System.out.println("Inserisci un numero da 0 a 3");
//		try {
//			int i = sc.nextInt();
//			System.out.println(5 / numbers2[i]);
//		} catch (ArithmeticException ex) {
//			System.out.println("Non si può dividere per zero!!");
//		} catch (InputMismatchException ex) {
//			System.out.println("Non hai inserito un numero!");
//		} catch (Exception ex) {
//			System.out.println("Errore generico");
//		} finally {
//			sc.close();
//			// Non importa se è andato tutto bene o c'è stata un'eccezione, il blocco finally viene eseguito sempre
//			// Quindi è utile (non obbligatorio) in tutte quelle situazioni in cui è bene ricordarsi di rilasciare delle risorse come chiudere
//			// uno scanner aperto o terminare una connessione ad un db
//		}

		logger.info("Questo è un messaggio informativo");
		logger.error("Questo è un messaggio di errore");


	}


//	public static void print(String msg) {
//		print(msg);
//	}

	public static void calculate(int number) {
		if (number < 0) throw new NumberLessThanZeroException(number); // E' sempre bene all'interno dei nostri metodi, effettuare dei controlli
		// di conformità dei parametri che ci vengono forniti. Se questi non soddisfano certi criteri, allora solitamente si lancia un'eccezione
		// (custom o meno) in maniera tale da bloccare subito l'esecuzione di tale metodo
		System.out.println("Risultato: " + (number * 10));
	}
}
