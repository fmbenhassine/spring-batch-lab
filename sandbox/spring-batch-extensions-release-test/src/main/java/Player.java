public class Player {

	private String id;

	private String position;

	private String lastName;

	private String firstName;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "Player{" +
				"id='" + id + '\'' +
				", position='" + position + '\'' +
				", lastName='" + lastName + '\'' +
				", firstName='" + firstName + '\'' +
				'}';
	}
}