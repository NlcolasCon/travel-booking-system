package hw2;

/**
 * The sub-class FlightReservation class of the {@link Reservation} class.
 * 
 * This class is used for flight reservations.
 * 
 * @author Nicolas Constantinou
 * @since 14/03/2024
 * 
 */
public class FlightReservation extends Reservation {

	private Airport startPort;
	private Airport endPort;

	/**
	 * The Constructor of class {@link FlightReservation}.
	 * 
	 * @param name  The name of the person that made the {@link Reservation}.
	 * @param start The start {@link Airport} of the flight.
	 * @param end   The end {@link Airport} of the flight.
	 */
	public FlightReservation(String name, Airport start, Airport end) {
		super(new String(name));
		try {
			if (!start.equals(end)) {
				startPort = new Airport(start);
				endPort = new Airport(end);
			} else {
				throw new IllegalArgumentException("Starting Port and Ending Port are the Same!");
			}
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * The method getCost calculates the cost of a {@link FlightReservation}.
	 * 
	 * @return The cost of a {@link FlightReservation}.
	 */
	@Override
	public int getCost() {
		return (int) Math.ceil((5375) + (double) this.startPort.getFees() + (double) this.endPort.getFees()
				+ ((double) Airport.getDistance(startPort, endPort) / 167.52 * 124));
	}

	/**
	 * The method equals checks if two {@link FlightReservation} instances are equal
	 * to each other.
	 * 
	 * @return True if the two {@link FlightReservation} instances are equal to each
	 *         other, else returns false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightReservation reserve = (FlightReservation) obj;
		return ((lowerCase(this.reservationName()).equals(lowerCase(reserve.reservationName())))
				&& (this.startPort.equals(reserve.startPort)) && (this.endPort.equals(reserve.endPort)));
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
