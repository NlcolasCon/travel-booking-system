package hw2;

/**
 * The Customer class utilises the {@link Basket} to create a
 * {@link Reservation} list for a {@link Customer} and pay for it in the end.
 * 
 * @author Nicolas Constantinou
 * @since 14/03/2024
 * 
 */
public class Customer {

	private String name;
	private int balance;
	private Basket basket;

	/**
	 * The Constructor of class {@link Customer}.
	 * 
	 * @param name    The name of the {@link Customer}.
	 * @param balance The balance of the {@link Customer}.
	 */
	public Customer(String name, int balance) {
		this.name = new String(name);
		this.balance = balance;
		basket = new Basket();
	}

	/**
	 * The getName method of class {@link Customer}.
	 * 
	 * @return The name of the {@link Customer}.
	 */
	public String getName() {
		return new String(name);
	}

	/**
	 * The getBalance method of class {@link Customer}.
	 * 
	 * @return The current balance of the {@link Customer}.
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * The getBasket method of class {@link Customer}.
	 * 
	 * @return The handle of the basket of the {@link Customer}.
	 */
	public Basket getBasket() {
		return basket;
	}

	/**
	 * The addFunds method of class {@link Customer}.
	 * 
	 * This method adds an amount to the balance of the {@link Customer}. If the
	 * funds to be added are a negative number it throws an exception.
	 * 
	 * @param funds The funds to be added.
	 * @throws IllegalArgumentException if the funds to be added are negative.
	 */
	public int addFunds(int funds) {
		try {
			if (funds >= 0) {
				balance += funds;
				return balance;
			} else {
				throw new IllegalArgumentException("Funds cannot be a negative number!");
			}
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
		return balance;
	}

	/**
	 * The addToBasket method of class {@link Customer}.
	 * 
	 * This method adds any type of {@link Reservation} in the basket only if the
	 * {@link Reservation} name is equal to the name of the {@link Customer}.
	 * 
	 * @param reserve The {@link Reservation} to be added to the {@link Basket}.
	 * @throws IllegalArgumentException if the name of the {@link Customer} is not
	 *                                  equal to the name of the
	 *                                  {@link Reservation}.
	 * @return The number of {@link Reservation} in the {@link Basket}F so far.
	 */
	public int addToBasket(Reservation reserve) {
		try {
			if (lowerCase(reserve.reservationName()).equals(lowerCase(name))) {
				basket.add(reserve);
				return basket.getNumOfReservations();
			} else {
				throw new IllegalArgumentException("The name of the customer dos not match with the reservation name!");
			}
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
		return basket.getNumOfReservations();
	}

	/**
	 * The addToBasket method of class {@link Customer}.
	 * 
	 * This method adds a {@link HotelReservation} in the basket only if the
	 * {@link Reservation} name is equal to the name of the {@link Customer}.
	 * 
	 * This method also checks if there will be breakfast included or not. If
	 * breakfast is included a {@link BnBReservation} is added, else a
	 * {@link HotelReservation} is added.
	 * 
	 * @param hotel         The name of the {@link Hotel}.
	 * @param type          The type of the {@link Room}.
	 * @param numOfNights   The number of nights of the {@link Reservation}.
	 * @param withBreakfast The boolean expression that states if breakfast is
	 *                      included in the {@link Reservation} or not.
	 * @return The number of {@link Reservation} in the {@link Basket}F so far.
	 */
	public int addToBasket(Hotel hotel, String type, int numOfNights, boolean withBreakfast) {
		if (!withBreakfast) {
			HotelReservation reserve = new HotelReservation(new String(name), hotel, type, numOfNights);
			basket.add(reserve);
		} else {
			BnBReservation reserve = new BnBReservation(new String(name), hotel, type, numOfNights);
			basket.add(reserve);
		}
		return basket.getNumOfReservations();
	}

	/**
	 * The addToBasket method of class {@link Customer}.
	 * 
	 * This method adds a {@link FlightReservation} in the basket only if the
	 * {@link Reservation} name is equal to the name of the {@link Customer}.
	 * 
	 * This method also checks if the starting {@link Airport} of the
	 * {@link Reservation} is not equal to the ending {@link Airport} of the
	 * {@link Reservation}. If so, the {@link FlightReservation} is added to the
	 * {@link Basket}, else it does not.
	 * 
	 * @param start The starting {@link Airport} of the {@link Reservation}.
	 * @param end   The ending {@link Airport} of the {@link Reservation}.f
	 * @return The number of {@link Reservation} in the {@link Basket}F so far.
	 */
	public int addToBasket(Airport start, Airport end) {
		if (!start.equals(end)) {
			FlightReservation reserve = new FlightReservation(new String(name), start, end);
			basket.add(reserve);
		}
		return basket.getNumOfReservations();
	}

	/**
	 * The removeFromBasket method of class {@link Customer}.
	 * 
	 * This method removes a {@link Reservation} from the {@link Basket}.
	 * 
	 * @param reserve The {@link Reservation} to be removed.
	 * @return True if the {@link Reservation} was found and removed, else returns
	 *         false.
	 */
	public boolean removeFromBasket(Reservation reserve) {
		return basket.remove(reserve);
	}

	/**
	 * The checkOut method of class {@link Customer}.
	 * 
	 * This method charges the {@link Customer} the total amount of cost of every
	 * {@link Reservation} in the {@link Basket}.
	 * 
	 * @throws IllegalStateException if the balance of the {@link Customer} is not
	 *                               enough to pay the cost.
	 * 
	 * @return The remaining amount of the balance if the amount is paid, else
	 *         return 0.
	 */
	public int checkOut() {
		try {
			if (basket.getTotalCost() <= getBalance()) {
				balance -= basket.getTotalCost();
				basket.clear();
				return getBalance();
			} else {
				throw new IllegalStateException("Not enough funds for this transaction");
			}
		} catch (IllegalStateException e) {
			System.err.println(e.getMessage());
		}
		return 0;
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
