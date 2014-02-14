package se.kth.csc.iprog.dinnerplanner.android.view;

import java.util.HashSet;
import java.util.Set;
import java.util.Observer;
import java.util.Observable;
import java.lang.Integer;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.android.view.DishItemView;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.LinearLayout;

public class ChooseMenuView implements Observer {

	View view;
	DinnerModel model;

	EditText numOfGuestEditText;
	TextView totalCostLabel;

	public ChooseMenuView(View view, DinnerModel dinnerModel) {

		// store in the class the reference to the Android View
		this.view = view;
		this.model = dinnerModel;
		Context context = this.view.getContext();

		// register the view to the DinnerModel as an observer
		dinnerModel.addObserver(this);

		// TODO: update the change of the number of guests and the total price
		// update(model, model.numOfGuest );

		// Set num of Guest
		this.numOfGuestEditText = (EditText) view.findViewById(R.id.num_of_guest);
		this.numOfGuestEditText.setText(String.valueOf(this.model.getNumberOfGuests()));
		

		// Set total cost
		this.totalCostLabel = (TextView) view.findViewById(R.id.total_cost);
		this.totalCostLabel.setText(String.valueOf(this.model.getTotalMenuPrice()));

		// Add dishes to Starter/ Main/ Dessert list accordingly
		LinearLayout starterList = (LinearLayout) view.findViewById(R.id.starter_list);
		LinearLayout mainCourseList = (LinearLayout) view.findViewById(R.id.main_course_list);
		LinearLayout dessertList = (LinearLayout) view.findViewById(R.id.dessert_list);

		Set<Dish> allDishes = dinnerModel.getDishes();
		for (Dish d : allDishes) {
			if (d.getType() == Dish.STARTER) {
				DishItemView dishView = new DishItemView(context, d);
				starterList.addView(dishView);
			} else if (d.getType() == Dish.MAIN) {
				DishItemView dishView = new DishItemView(context, d);
				mainCourseList.addView(dishView);
			} else if (d.getType() == Dish.DESERT) {
				DishItemView dishView = new DishItemView(context, d);
				dessertList.addView(dishView);
			}
		}
	}

	// implement update in ChooseMenuView
	public void update(Observable observable, Object changedItem) {
		if (observable instanceof DinnerModel) {
			DinnerModel model = (DinnerModel) observable;
			if (changedItem == DinnerModel.ChangedDataType.NUM_OF_GUEST) {
//				this.numOfGuestEditText.setText(String.valueOf(model.getNumberOfGuests()));
				
				this.totalCostLabel.setText(String.valueOf(model.getTotalMenuPrice()));
			}else if(changedItem == DinnerModel.ChangedDataType.SELECTED_DISH){
				//TODO: hightlight selected dishes
				
			}
			
			
			
		}
	}

}
