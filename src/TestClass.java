package hw2;

public class TestClass {

	public static void main(String[] args) {

		Airport a1 = new Airport(100, 100, 100);
		Airport a2 = new Airport(200, 200, 100);
		Airport a3 = new Airport(a1);

		// Room r1 = new Room("s2s");
		Room r2 = new Room("queen");
		Room r3 = new Room("KinG");
		Room r4 = new Room(r2);

		/*
		 * System.out.println(r4.getPrice()); System.out.println(r3.getType());
		 * 
		 * System.out.println(Airport.getDistance(a3, a1));
		 * System.out.println(Airport.getDistance(a2, a1));
		 * System.out.println(a2.getFees());
		 */

		Hotel h1 = new Hotel("Arizona", new Room[] { r2, r3, r4 });
		Hotel h2 = new Hotel("Arizona", new Room[] { r2, r3, r4 });
		/*
		 * h1.reserveRoom("double");
		 *
		 * System.out.println(h1.reserveRoom("kING"));
		 * System.out.println(h1.reserveRoom("king"));
		 * System.out.println(h1.reserveRoom("king"));
		 * System.out.println(h1.reserveRoom("queen"));
		 * System.out.println(h1.reserveRoom("quEen"));
		 * System.out.println(h1.reserveRoom("queen"));
		 * System.out.println(h1.reserveRoom("queen"));
		 * 
		 * System.out.println(h1.cancelRoom("k"));
		 * System.out.println(h1.cancelRoom("kinG"));
		 * System.out.println(h1.cancelRoom("kiNG"));
		 * System.out.println(h1.cancelRoom("QUEEN"));
		 * System.out.println(h1.cancelRoom("QueeN"));
		 * System.out.println(h1.cancelRoom("QueeN"));
		 */

		FlightReservation f1 = new FlightReservation("Nicolas", a2, a3);
		// FlightReservation f2 = new FlightReservation("Reservation 1", a3, a3);
		// FlightReservation f3 = new FlightReservation("Reservation 1", a2, a3);
		/*
		 * System.out.println(f1.getCost()); System.out.println(f1.equals(f3));
		 * 
		 */
		HotelReservation hr1 = new HotelReservation("Nicolas", h1, "king", 4);
		// System.out.println(hr1.getCost());
		// System.out.println(hr1.getNumOfNights());
		// HotelReservation hr2 = new HotelReservation("Nicolas", h1, "QUEEN", 4);
		// System.out.println(hr1.equals(hr2));

		BnBReservation bnb1 = new BnBReservation("Nicols", h1, "queen", 4);
		// System.out.println(bnb1.equals(hr1));
		/*
		 * Basket b = new Basket(); b.add(f1); b.add(hr1); b.clear();
		 * System.out.println(b.getNumOfReservations());
		 * System.out.println(b.getTotalCost()); b.add(f1); b.add(hr1);
		 * System.out.println(b.getNumOfReservations());
		 * System.out.println(b.getTotalCost()); b.remove(f1);
		 * System.out.println(b.getNumOfReservations());
		 * System.out.println(b.getTotalCost());
		 * 
		 */
		Customer me = new Customer("Nicolas", 20000);
		System.out.println(me.getBalance());
		System.out.println(me.getName());
		System.out.println(me.getBasket());
		System.out.println();
		me.addFunds(100000);
		System.out.println(me.getBalance());
		System.out.println(me.getBasket().getNumOfReservations());
		System.out.println();
		System.out.println(me.addToBasket(hr1));
		System.out.println(me.addToBasket(a2, a3));
		System.out.println(me.addToBasket(h1, "queen", 4, true));
		System.out.println(me.removeFromBasket(hr1));

		System.out.println(me.getBalance());
		System.out.println(me.getBasket().getTotalCost());
		System.out.println(me.checkOut());

	}

}
