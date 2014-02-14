package se.kth.csc.iprog.dinnerplanner.android.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.android.view.ChooseMenuView;

public class ChooseMenuViewController implements TextWatcher {
	ChooseMenuView view;
	DinnerModel model;

	public ChooseMenuViewController(DinnerModel model, ChooseMenuView view) {
		this.model = model;
		this.view = view;

		// Here we setup the listeners
		this.view.numOfGuestEditText.addTextChangedListener(this);
//		Log.d("ChooseMenuController", "constructor");
	}

	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		Log.d("ChooseMenuViewController", "afterTextChanged." + s);
		int numOfGuest = 0;

		try {
			numOfGuest = Integer.parseInt(String.valueOf(s));
			this.model.setNumberOfGuests(numOfGuest);
			this.view.update(this.model, DinnerModel.ChangedDataType.NUM_OF_GUEST);
		} catch (NumberFormatException e) {
			return;
		}finally {

		}

	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub

		Log.d("ChooseMenuViewController", "beforeTextChanged." + s);

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub

		Log.d("ChooseMenuViewController", "onTextChanged." + s);

	}

}
