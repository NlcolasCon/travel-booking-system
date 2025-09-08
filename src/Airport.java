package hw2;

/**
 * The Airport Class creates {@link Airport} instances to be used in further
 * implementations.
 * 
 * @author Nicolas Constantinou
 * @since 14/03/2024
 */
public class Airport {

	private int x; // ratio of x is 1:1000 meters
	private int y; // ratio of y is 1:1000 meters
	private int fees;

	/**
	 * The Constructor of class {@link Airport}.
	 * 
	 * @param x    The x coordinate of the {@link Airport} in the Full-World map.
	 * @param y    The y coordinate of the {@link Airport} in the Full-World map.
	 * @param ends The fees of the {@link Airport}.
	 */
	public Airport(int x, int y, int fees) {
		this.x = x;
		this.y = y;
		this.fees = fees;
	}

	/**
	 * The Constructor of class {@link Airport}.
	 * 
	 * @param port The {@link Airport} instance to be copied.
	 */
	public Airport(Airport port) {
		this.x = port.x;
		this.y = port.y;
		this.fees = port.fees;
	}

	/**
	 * The Getter method of fees of class {@link Airport}.
	 * 
	 * @return The fees of the {@link Airport}.
	 */
	public int getFees() {
		return this.fees;
	}

	/**
	 * The Getter Method of Distance of class {@link Airport}.
	 * 
	 * This method calculates the distance of two {@link Airport} instances in km.
	 * 
	 * @param portOne An {@link Airport} instance.
	 * @param portTwo An {@link Airport} instance.
	 * @return The Distance in km of two {@link Airport} instances.
	 */
	public static int getDistance(Airport portOne, Airport portTwo) {
		return (int) Math.ceil(Math.sqrt(Math.pow(portOne.x - portTwo.x, 2) + Math.pow(portOne.y - portTwo.y, 2)));
	}

}
