package input;

public class Input {
	private String name;
	
	public Input(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	private boolean compareThisInputTo(Input otherInput) {
		return name.equals(otherInput.getName());
	}
	
	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
	
		Input comparableInput = (Input) object;
		return compareThisInputTo(comparableInput);
	}
}
