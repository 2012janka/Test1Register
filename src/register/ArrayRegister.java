package register;

/**
 * register.Person register.
 */
public class ArrayRegister implements Register {
	/** register.Person array. */
	private Person[] persons;

	/** Number of persons in this register. */
	private int count;

	/**
	 * Constructor creates an empty register with maximum size specified.
	 * 
	 * @param size
	 *            maximum size of the register
	 */
	public ArrayRegister(int size) {
		persons = new Person[size];
		count = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#getCount()
	 */
	@Override
	public int getCount() {
		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#getSize()
	 */
	@Override
	public int getSize() {
		return persons.length;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#getPerson(int)
	 */
	@Override
	public Person getPerson(int index) {
		return persons[index];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#addPerson(register.Person)
	 */
	@Override
	public void addPerson(Person person) {
		persons[count] = person;
		count++;
	}

	public int getIndex(Person person) {
		int i = 0;
		while (this.getPerson(i) != person) {
			i++;
		}
		return i + 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#findPersonByName(java.lang.String)
	 */
	@Override
	public Person findPersonByName(String name) {
		Person person = null;
		for (int i = 0; i < this.getCount(); i++) {
			if (this.getPerson(i).getName().equals(name)) {
				person = this.getPerson(i);
			}
		}
		return person;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#findPersonByPhoneNumber(java.lang.String)
	 */
	@Override
	public Person findPersonByPhoneNumber(String phoneNumber) {
		Person person = null;
		for (int i = 0; i < this.getCount(); i++) {
			if (this.getPerson(i).getPhoneNumber().equals(phoneNumber)) {
				person = this.getPerson(i);
			}
		}
		return person;
	}

	@Override
	public void removePerson(Person person) {
		for (int i = 0; i < this.getCount(); i++) {
			if (this.getPerson(i).equals(person)) {
				while (i < this.getCount() - 1) {
					persons[i] = persons[i + 1];
					i++;
				}
				count--;
			}
		}
	}

	public void sortByName() {
		for (int i = 0; i < this.getCount() - 1; i++) {
			for (int j = 0; j < this.getCount() - i - 1; j++) {
				if (this.compare(this.getPerson(i), this.getPerson(i + 1)) < 0) {
					this.swap(this.getPerson(i), this.getPerson(i + 1), i);
				}
			}
		}
	}

	public int compare(Person osoba1, Person osoba2) {
		int i = 0;
		char pismeno1 = osoba1.getName().charAt(i);
		char pismeno2 = osoba2.getName().charAt(i);
		while (pismeno1 == pismeno2) {
			i++;
			pismeno1 = osoba1.getName().charAt(i);
			pismeno2 = osoba2.getName().charAt(i);
		}
		if (pismeno1 < pismeno2) {
			return -1;
		} else
			return 1;
	}

	public void swap(Person osoba1, Person osoba2, int index) {
		Person tmp = osoba1;
		persons[index] = osoba2;
		persons[index + 1] = tmp;
	}
}
