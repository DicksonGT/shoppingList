package dolphine.designs.shoppinglist;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ShoppingListAdapter extends ArrayAdapter<ShoppingListItem> {

	public ShoppingListAdapter(Context context, int textViewResourceId) {

		super(context, textViewResourceId);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		TextView view = (TextView) super.getView(position, convertView, parent);

		ShoppingListItem item = getItem(position);
		if (item.isBought()) {
			view.setPaintFlags(view.getPaintFlags()
					| Paint.STRIKE_THRU_TEXT_FLAG);
		} else {
			view.setPaintFlags(view.getPaintFlags()
					& (~Paint.STRIKE_THRU_TEXT_FLAG));
		}
		return view;
	}
}
