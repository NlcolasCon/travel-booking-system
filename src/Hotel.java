package hw2;

/**
 * The Hotel Class creates {@link Hotel} instances that contain {@link hw2.Room}
 * instances. The Hotel Class is used in the {@link hw2.HotelReservation} class
 * to make reservations.
 * 
 * @author Nicolas Constantinou
 * @since 14/03/2024
 * 
 */
public class Hotel {

	private String name;
	private Room[] rooms;

	/**
	 * The Constructor of class {@link Hotel}.
	 * 
	 * @param name  The name of the {@link Hotel}.
	 * @param rooms The {@link hw2.Room} instances in the {@link Hotel}.
	 */
	public Hotel(String name, Room[] rooms) {
		this.name = new String(name);
		this.rooms = new Room[rooms.length];
		for (int i = 0; i < rooms.length; i++) {
			this.rooms[i] = new Room(rooms[i]);
		}
	}

	/**
	 * This method finds a specific type of {@link hw2.Room} that is available and
	 * reserves it.
	 * 
	 * @param type The type of {@link hw2.Room} to be reserved.
	 * @return The cost of the {@link hw2.Room} if found, else returns 0.
	 */
	public int reserveRoom(String type) {
		try {
			if (Room.findAvailableRoom(rooms, type) != null) {
				int cost = Room.findAvailableRoom(rooms, type).getPrice();
				Room.findAvailableRoom(rooms, type).changeAvailability();
				return cost;
			} else {
				throw new IllegalArgumentException("The Room Type you are looking for is not available.");
			}
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
		return 0;
	}

	/**
	 * This method makes a {@link hw2.Room} available.
	 * 
	 * @param type The type of {@link hw2.Room} to cancel.
	 * @return True if a {@link hw2.Room} was cancelled, else returns false.
	 */
	public boolean cancelRoom(String type) {
		return Room.makeRoomAvailable(rooms, type);
	}

}
