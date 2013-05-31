package dolphine.designs.shoppinglist;

import dolphine.designs.shoppinglist.R;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

public class shopshopActivity extends ListActivity {

	private ShoppingListAdapter adapter;

	@Override
	public void onCreate(Bundle icicle) {

		super.onCreate(icicle);

		setTitle(R.string.defaultShoppingListName);

		adapter = new ShoppingListAdapter(this, R.layout.shoppinglistrow);
		setListAdapter(adapter);
		setContentView(R.layout.main);

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		ShoppingListItem item = (ShoppingListItem) getListAdapter().getItem(
				position);
		item.setBought(!item.isBought());
		adapter.notifyDataSetChanged();
	}

	public void addItem(View view) {

		AutoCompleteTextView itemText = (AutoCompleteTextView) findViewById(R.id.itemText);

		final String newItemName = itemText.getText().toString();
		if ("".equals(newItemName)) {
			Toast.makeText(this, "Empty input not allowed!", Toast.LENGTH_LONG)
					.show();
			return;
		}

		// Add new item to list
		final ShoppingListItem shoppingListItem = new ShoppingListItem(
				newItemName);
		adapter.add(shoppingListItem);
		adapter.notifyDataSetChanged();

		// Clear input field
		itemText.setText("");

		// Return focus to list and hide keyboard
		getListView().requestFocus();
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(itemText.getWindowToken(), 0);
	}

}