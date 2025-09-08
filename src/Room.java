package hw2;

/**
 * The Room Class creates {@link Room} instances to be used by the {@link Hotel}
 * class and the {@link Reservation} class.
 * 
 * @author Nicolas Constantinou
 * @since 14/03/2024
 * 
 */
public class Room {

	private String roomType;
	private int price; // Currency is set to cents
	private boolean isReserved;

	/**
	 * The Constructor of Class {@link Room}.
	 * 
	 * @param type The type of the {@link Room}.
	 * @throws IllegalAccessException If the type of the {@link Room} is not valid.
	 */
	public Room(String type) {
		try {
			if (isValidType(type)) {
				roomType = new String(type);
				price = calcPrice();
				isReserved = false;
			} else {
				throw new IllegalArgumentException("Specific Room Type Is Not Found!");
			}
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * The copy Constructor of class {@link Room}.
	 * 
	 * @param original The {@link Room} instance to be copied.
	 */
	public Room(Room original) {
		roomType = new String(original.roomType);
		price = calcPrice();
		isReserved = false;
	}

	/**
	 * The Getter method of type of class {@link Room}.
	 * 
	 * @return The type of the {@link Room}.
	 */
	public String getType() {
		return new String(lowerCase(roomType));
	}

	/**
	 * The Getter method of price of class {@link Room}.
	 * 
	 * @return The price of the {@link Room} depending on its type.
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * This method changes the availability of a {@link Room} from available (true)
	 * to reserved (false) vice versa.
	 * 
	 */
	public void changeAvailability() {
		if (isReserved) {
			isReserved = false;
			return;
		}
		isReserved = true;
	}

	/**
	 * This method finds a {@link Room} of a specific type that is available and
	 * returns it.
	 * 
	 * @param rooms An array of {@link Room} instances.
	 * @param type  The type of the available {@link Room} that is searched.
	 * @return The available {@link Room} if found, else returns
	 *         {@literal <code>null</code>};
	 */
	public static Room findAvailableRoom(Room[] rooms, String type) {
		for (int i = 0; i < rooms.length; i++) {
			if (lowerCase(type).equals(lowerCase(rooms[i].roomType)) && !rooms[i].isReserved)
				return rooms[i];
		}
		return null;
	}

	/**
	 * This method makes a {@link Room} of a specific type that is reserved,
	 * available.
	 * 
	 * @param rooms An array of {@link Room} instances.
	 * @param type  The type of the {@link Room} that is searched.
	 * @return True, if the {@link Room} is found, else returns false
	 */
	public static boolean makeRoomAvailable(Room[] rooms, String type) {
		for (int i = 0; i < rooms.length; i++) {
			if (lowerCase(type).equals(lowerCase(rooms[i].roomType)) && rooms[i].isReserved) {
				rooms[i].changeAvailability();
				return true;
			}
		}
		return false;
	}

	/**
	 * This method calculates the price of a {@link Room} instance.
	 * 
	 * @return The price of the {@link Room} instance.
	 */
	private int calcPrice() {
		int p = 0;
		switch (lowerCase(roomType)) {
		case "king":
			p = 150 * 100;
			break;
		case "queen":
			p = 110 * 100;
			break;
		case "double":
			p = 90 * 100;
			break;
		}
		return p;
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
