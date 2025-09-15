package entities;

import exceptions.StringNotValidException;

import java.util.Objects;
import java.util.Random;

public class Student {
	// Attributi Statici
	private static int numStudentiCreati = 0;

	// Attributi
	private final int id;
	private String name;
	private String surname;
	private boolean isFullStacK;
	private StudentType studentType;

	// Costruttori
	public Student(String name, String surname, boolean isFullStacK, StudentType studentType) {
		Random rndm = new Random();
		this.name = name;
		this.surname = surname;
		this.isFullStacK = isFullStacK;
		this.id = rndm.nextInt(1, 10000);
		numStudentiCreati++;
		this.studentType = studentType;
	}


	// Metodi Statici
	public static int getNumStudentiCreati() {
		return numStudentiCreati;
	}

	// GETTERS
	// Non sono costretto a fare tutti i getter per tutti gli attributi
	// Ho la possibilità di scegliere chi rimarrà privato quindi non leggibile dall'esterno


	//	public int getId() { // Se non mettiamo il getter per l'id, allora non si potrà leggere l'id dal mondo esterno
	//		return id;
	//	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws StringNotValidException { // Nel caso delle eccezioni CHECKED, una soluzione alternativa a try-catch
		// è il THROWS il quale delega la gestione del problema a chi userà il metodo, chi lo userà a sua volta potrà scegliere se usare anch'esso
		// il throws per delegare a qualcun altro o usare try-catch (se ci troviamo nel main fare throws non è una bella idea)
		if (name.length() < 2) throw new StringNotValidException(name); // E' un'eccezione CHECKED
			// Il vantaggio di avere dei Setter è quello di dare un accesso NON DIRETTO agli attributi
			// quindi posso fare dei controlli prima di permettere di settare un valore
		else this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public boolean isFullStacK() {
		return isFullStacK;
	}

	public StudentType getStudentType() {
		return studentType;
	}

	// SETTERS
	// Non sono costretto a fare tutti i setter per tutti gli attributi
	// Ho la possibilità di scegliere chi rimarrà privato quindi non scrivibile dall'esterno
	public void setStudentType(StudentType studentType) {
		this.studentType = studentType;
		;
	}

	// METODI

	// Per far generare il toString automaticamente ad IntelliJ:
	// Tasto DX -> GENERATE -> toString()

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", isFullStacK=" + isFullStacK +
				", studentType=" + studentType +
				'}';
	}

	// Tasto DX -> GENERATE -> equals() and hashCode() (questo non ci serve però)
	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Student student = (Student) o; // CAST ESPLICITO
		return isFullStacK == student.isFullStacK && Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
	}

}
