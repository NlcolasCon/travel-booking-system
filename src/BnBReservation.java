package hw2;

/**
 * The sub-class BnBReservation class of the {@link HotelReservation} class.
 * 
 * This class is used for BnB reservations.
 * 
 * @author Nicolas Constantinou
 * @since 14/03/2024
 * 
 */
public class BnBReservation extends HotelReservation {

	/**
	 * The Constructor of class {@link BnBReservation}.
	 * 
	 * @param name   The name of the person that made the {@link BnBReservation}.
	 * @param hotel  The {@link Hotel} of the {@link BnBReservation}.
	 * @param type   The type of {@link Room} of the {@link BnBReservation}.
	 * @param nights The number of nights of the {@link BnBReservation}.
	 */
	public BnBReservation(String name, Hotel hotel, String type, int nights) {
		super(name, hotel, type, nights);
	}

	/**
	 * The method getCost calculates the cost of a {@link BnBReservation}.
	 * 
	 * @return The cost of a {@link BnBReservation}.
	 */
	@Override
	public int getCost() {
		return ((super.getCost() / this.getNumOfNights()) + 1000) * this.getNumOfNights();
	}

	/**
	 * The method equals checks if two {@link BnBReservation} instances are equal to
	 * each other.
	 * 
	 * @return True if the two {@link BnBReservation} instances are equal to each
	 *         other, else returns false.
	 */
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}
