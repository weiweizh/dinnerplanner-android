package se.kth.csc.iprog.dinnerplanner.android.view;

import java.util.HashSet;
import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.android.view.DishItemView;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.LinearLayout;

public class ChooseMenuView {

	View view;
	DinnerModel model;

	public ChooseMenuView(View view, DinnerModel dinnerModel) {

		// store in the class the reference to the Android View
		this.view = view;
		this.model = dinnerModel;
		Context context = this.view.getContext();

		//Set num of Guest
		EditText numOfGuest = (EditText) view.findViewById(R.id.num_of_guest);
		numOfGuest.setText(String.valueOf(this.model.getNumberOfGuests()));
		
		//Set total cost
		TextView totalCost = (TextView) view.findViewById(R.id.total_cost);	
		totalCost.setText(String.valueOf(this.model.getTotalMenuPrice()));

		//Add dishes to Starter/ Main/ Dessert list accordingly
		LinearLayout starterList = (LinearLayout) view.findViewById(R.id.starter_list);
		LinearLayout mainCourseList = (LinearLayout) view.findViewById(R.id.main_course_list);
		LinearLayout dessertList = (LinearLayout) view.findViewById(R.id.dessert_list);

		Set<Dish> allDishes = dinnerModel.getDishes();
		for(Dish d : allDishes){
			if(d.getType() == Dish.STARTER){
				DishItemView dishView = new DishItemView(context, d);
				starterList.addView(dishView);
			}else if(d.getType() == Dish.MAIN){
				DishItemView dishView = new DishItemView(context, d);
				mainCourseList.addView(dishView);
			}else if(d.getType() == Dish.DESERT){
				DishItemView dishView = new DishItemView(context, d);
				dessertList.addView(dishView);
			}
		}
	}

}
