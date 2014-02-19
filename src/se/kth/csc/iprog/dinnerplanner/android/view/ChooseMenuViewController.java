package se.kth.csc.iprog.dinnerplanner.android.view;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;

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
		// Log.d("ChooseMenuController", "constructor");

		/*
		for (int i = 0; i < this.view.starterList.getChildCount(); i++) {
			this.view.starterList.getChildAt(i).setOnClickListener(
					new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							v.setBackgroundColor(Color.GRAY);
							Log.v("Course clicked", "a starter was clicked");
						}
					});
		}

		for (int i = 0; i < this.view.mainCourseList.getChildCount(); i++) {
			this.view.mainCourseList.getChildAt(i).setOnClickListener(
					new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							v.setBackgroundColor(Color.GRAY);
							Log.v("Course clicked", "a main course was clicked");
						}
					});
		}

		for (int i = 0; i < this.view.dessertList.getChildCount(); i++) {
			this.view.dessertList.getChildAt(i).setOnClickListener(
					new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							v.setBackgroundColor(Color.GRAY);
							Log.v("Course clicked", "a dessert was clicked");
						}
					});
		}
*/
	}

	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		Log.d("ChooseMenuViewController", "afterTextChanged." + s);
		int numOfGuest = 0;

		try {
			numOfGuest = Integer.parseInt(String.valueOf(s));
			this.model.setNumberOfGuests(numOfGuest);
			this.view.update(this.model,
					DinnerModel.ChangedDataType.NUM_OF_GUEST);
		} catch (NumberFormatException e) {
			return;
		} finally {

		}

	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		Log.d("ChooseMenuViewController", "beforeTextChanged." + s);
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		Log.d("ChooseMenuViewController", "onTextChanged." + s);

	}
}
