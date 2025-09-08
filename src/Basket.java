package hw2;

/**
 * The Basket class is a list of {@link Reservation} instances.
 * 
 * This class implements various functions regarding a {@link Basket} instance.
 * 
 * @author Nicolas Constantinou
 * @since 14/03/2024
 * 
 */
public class Basket {

	private Reservation[] list;

	/**
	 * The Constructor of class {@link Basket} creates an empty list of
	 * {@link Reservation}.
	 * 
	 */
	public Basket() {
		list = new Reservation[0];
	}

	/**
	 * The Getter method of products of class {@link Basket}.
	 * 
	 * @return A digital copy of the list of the {@link Reservation} instances of
	 *         the {@link Basket}.
	 */
	public Reservation[] getProducts() {
		return list;
	}

	/**
	 * The add method of class {@link Basket}.
	 * 
	 * This method adds to the {@link Reservation} list a new {@link Reservation}.
	 * 
	 * @param reserve The {@link Reservation} to be added to the list.
	 * @return The number of current {@link Reservation} in the list.
	 */
	public int add(Reservation reserve) {
		if (list.length != 0) {
			Reservation[] copy = new Reservation[list.length];
			for (int i = 0; i < list.length; i++) {
				copy[i] = list[i];
			}
			list = new Reservation[copy.length + 1];
			for (int i = 0; i < list.length - 1; i++) {
				list[i] = copy[i];
			}
			list[list.length - 1] = reserve;
		} else {
			list = new Reservation[list.length + 1];
			list[0] = reserve;
		}
		return list.length;
	}

	/**
	 * The remove method of class {@link Reservation}.
	 * 
	 * This method removes a {@link Reservation} from the list.
	 * 
	 * @param reserve The {@link Reservation} to be removed.
	 * @return True if the {@link Reservation} was found and removed, else return
	 *         false.
	 */
	public boolean remove(Reservation reserve) {
		for (int i = 0; i < list.length; i++) {
			if (list[i].equals(reserve)) {
				list[i] = null;
				sortBasket();
				return true;
			}
		}
		return false;
	}

	/**
	 * The clear method of class {@link Basket} clears the list of
	 * {@link Reservation}.
	 */
	public void clear() {
		list = new Reservation[0];
	}

	/**
	 * The Getter method of the number of {@link Reservation} of class
	 * {@link Basket}.
	 * 
	 * @return The number of current {@link Reservation} instances in the list.
	 */
	public int getNumOfReservations() {
		return list.length;
	}

	/**
	 * The sortBasket method of class {@link Basket}.
	 * 
	 * This method removes the null values that exist in the list if they do.
	 * 
	 */
	private void sortBasket() {
		for (int i = 0; i < list.length - 1; i++) {
			if (list[i] == null) {
				Reservation t = list[i + 1];
				list[i + 1] = list[i];
				list[i] = t;
			}
		}
		Reservation[] copy = new Reservation[list.length - 1];
		for (int i = 0; i < list.length - 1; i++) {
			copy[i] = list[i];
		}
		list = new Reservation[list.length - 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = copy[i];
		}

	}

	/**
	 * The getTotalCost method of class {@link Basket} calculates the cost of each
	 * {@link Reservation} in the list and adds the up.
	 * 
	 * @return The total cost of every {@link Reservation} in the {@link Basket}.
	 */
	public int getTotalCost() {
		int total = 0;
		for (int i = 0; i < list.length; i++) {
			total += list[i].getCost();
		}
		return total;
	}

}
