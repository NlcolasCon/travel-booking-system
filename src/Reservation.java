package hw2;

/**
 * The Supper-Class Reservation.
 * 
 * This class is the base class to every type of reservation.
 * 
 * @author Nicolas Constantinou
 * @since 14/03/2024
 * 
 */
public abstract class Reservation {

	private String name;

	/**
	 * The Constructor of abstract class {@link Reservation}.
	 * 
	 * @param name The name of the person the makes the reservation.
	 */
	public Reservation(String name) {
		this.name = new String(name);
	}

	/**
	 * The Getter method of the reservation name.
	 * 
	 * @return The name of the person that has this {@link Reservation}.
	 */
	public final String reservationName() {
		return name;
	}

	/**
	 * The abstract method getCost calculates the cost of a {@link Reservation}.
	 * 
	 * @return The cost of a {@link Reservation}.
	 */
	public abstract int getCost();

	/**
	 * The abstract method equals checks if two {@link Reservation} instances are
	 * equal to each other.
	 * 
	 * @return True if the two {@link Reservation} instances are equal to each
	 *         other, else returns false.
	 */
	public abstract boolean equals(Object obj);

}
