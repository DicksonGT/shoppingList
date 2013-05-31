package dolphine.designs.shoppinglist;

public class ShoppingListItem {
	private boolean bought = false;
	private String name;

	public ShoppingListItem(final String name) {
		this.name = name;
	}

	public boolean isBought() {
		return bought;
	}

	public void setBought(boolean bought) {
		this.bought = bought;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return getName();
	}
}
