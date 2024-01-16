package rapport;

public class FraisCharges {
	
    private String propertyName;
    private String description;
    private int amount;

    public FraisCharges(String propertyName, String description, int amount) {
        this.propertyName = propertyName;
        this.description = description;
        this.amount = amount;
    }

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
    
    
}