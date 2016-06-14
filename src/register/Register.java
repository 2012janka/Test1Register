package register;

public interface Register {

	/**
	 * Returns the number of persons in this register.
	 * 
	 * @return the number of persons in this register
	 */
	public abstract int getCount();

	/**
	 * Returns the maximum number of persons in this register.
	 * 
	 * @return the maximum number of persons in this register.
	 */
	public abstract int getSize();

	/**
	 * Returns the person at the specified position in this register.
	 * 
	 * @param index
	 *            index of the person to return
	 * @return person the person at the specified position in this register
	 */
	public abstract Person getPerson(int index);

	/**
	 * Appends the specified person to the end of this register.
	 * 
	 * @param person
	 *            person to append to this register
	 */
	public abstract void addPerson(Person person);
	
	public abstract int getIndex(Person person);

	/**
	 * Returns the person with specified name in this register or
	 * <code>null</code>, if match can not be found.
	 * 
	 * @param name
	 *            name of a person to search for
	 * @return person with specified phone number
	 */
	public abstract Person findPersonByName(String name);

	/**
	 * Returns the person with specified phone number in this register or
	 * <code>null</code>, if match can not be found.
	 * 
	 * @param phoneNumber
	 *            phone number of a person to search for
	 * @return person with specified phone number
	 */
	public abstract Person findPersonByPhoneNumber(String phoneNumber);

	/**
	 * Removes the specified person from the register.
	 * 
	 * @param person
	 *            person to remove
	 */
	public abstract void removePerson(Person person);
	
	public abstract void sortByName();
	public abstract int compare(Person osoba1, Person osoba2);
	public abstract void swap(Person osoba1, Person osoba2, int index);
	
	

}