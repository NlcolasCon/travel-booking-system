package hw2;

/**
 * The sub-class HotelReservation class of the {@link Reservation} class.
 * 
 * This class is used for hotel reservations.
 * 
 * @author Nicolas Constantinou
 * @since 14/03/2024
 * 
 */
public class HotelReservation extends Reservation {

	private Hotel hotel;
	private String type;
	private int nights;
	private int costPerNight; // se cents

	/**
	 * The Constructor of class {@link HotelReservation}.
	 * 
	 * @param name   The name of the person that made the {@link HotelReservation}.
	 * @param hotel  The {@link Hotel} of the {@link HotelReservation}.
	 * @param type   The type of {@link Room} of the {@link HotelReservation}.
	 * @param nights The number of nights of the {@link HotelReservation}.
	 */
	public HotelReservation(String name, Hotel hotel, String type, int nights) {
		super(new String(name));
		try {
			if (isValidType(type)) {
				this.type = new String(type);
				this.hotel = hotel;
				this.costPerNight = this.hotel.reserveRoom(type);
				this.nights = nights;
			} else {
				throw new IllegalArgumentException("The Room Type is not Included in the Hotel!");
			}
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * The getter method of the number of nights of the {@link HotelReservation}
	 * class.
	 * 
	 * @return The number of nights of the {@link HotelReservation}.
	 */
	public int getNumOfNights() {
		return nights;
	}

	/**
	 * The method getCost calculates the cost of a {@link HotelReservation}.
	 * 
	 * @return The cost of a {@link HotelReservation}.
	 */
	@Override
	public int getCost() {
		return this.getNumOfNights() * this.costPerNight;
	}

	/**
	 * The method equals checks if two {@link HotelReservation} instances are equal
	 * to each other.
	 * 
	 * @return True if the two {@link HotelReservation} instances are equal to each
	 *         other, else returns false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HotelReservation reserve = (HotelReservation) obj;
		return ((this.hotel.equals(reserve.hotel)) && (lowerCase(this.type).equals(lowerCase(reserve.type)))
				&& (lowerCase(this.reservationName()).equals(lowerCase(reserve.reservationName())))
				&& (this.nights == reserve.nights) && (this.getCost() == reserve.getCost()));
	}

	/**
	 * This method checks if the given type for a {@link Room} is valid.
	 * 
	 * @param type The {@literal String} to be checked.
	 * @return True if the type is valid, else return false.
	 */
	private static boolean isValidType(String type) {
		return (lowerCase(type).equals("double") || lowerCase(type).equals("king") || lowerCase(type).equals("queen"));
	}

	/**
	 * This method converts a {@literal String} to lower-case for a not case
	 * sensitive program.
	 * 
	 * @param word The {@literal String}.
	 * @return The lower-cased word.
	 */
	private static String lowerCase(String word) {
		String st = new String();
		st = new String(word.toLowerCase());
		return st;
	}

}
