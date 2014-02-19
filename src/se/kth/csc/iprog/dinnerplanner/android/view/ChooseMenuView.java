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
import se.kth.csc.iprog.dinnerplanner.android.view.DishItemViewController;
import se.kth.csc.iprog.dinnerplanner.android.view.DishPopupView;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.LinearLayout;


public class ChooseMenuView implements Observer {

	ViewGroup view = null;
	DinnerModel model = null;
	
	public PopupWindow pressedDishWindow;
	DishPopupView popUpContent;

	EditText numOfGuestEditText;
	TextView totalCostLabel;
	
	LinearLayout starterList;
	LinearLayout mainCourseList;
	LinearLayout dessertList;
	
	Context context;
	
	//Temp for popup
			Dish popupDish = null;

	public ChooseMenuView(View view, DinnerModel dinnerModel) {

		// store in the class the reference to the Android View
		this.view = (ViewGroup) view;
		this.model = dinnerModel;
		context = this.view.getContext();

		// register the view to the DinnerModel as an observer
		dinnerModel.addObserver(this);

		// TODO: update the change of the number of guests and the total price
		// update(model, model.numOfGuest );

		// Set num of Guest
		this.numOfGuestEditText = (EditText) view.findViewById(R.id.num_of_guest);
		this.numOfGuestEditText.setText(String.valueOf(this.model.getNumberOfGuests()));
		

		// Set total cost
		this.totalCostLabel = (TextView) view.findViewById(R.id.total_cost);
		this.updateTotalCost();
		
		// Add dishes to Starter/ Main/ Dessert list accordingly
		starterList = (LinearLayout) view.findViewById(R.id.starter_list);
		mainCourseList = (LinearLayout) view.findViewById(R.id.main_course_list);
		dessertList = (LinearLayout) view.findViewById(R.id.dessert_list);
		
		Set<Dish> allDishes = dinnerModel.getDishes();
		for (Dish d : allDishes) {
			if (d.getType() == Dish.STARTER) {
				DishItemView dishView = new DishItemView(context, d);
				starterList.addView(dishView);
				
				DishItemViewController dishViewController = new DishItemViewController(model, dishView, this);
				
			} else if (d.getType() == Dish.MAIN) {
				DishItemView dishView = new DishItemView(context, d);
				mainCourseList.addView(dishView);

				DishItemViewController dishViewController = new DishItemViewController(model, dishView, this);
			} else if (d.getType() == Dish.DESERT) {
				DishItemView dishView = new DishItemView(context, d);
				dessertList.addView(dishView);

				DishItemViewController dishViewController = new DishItemViewController(model, dishView, this);
			}
			
			popupDish = d;
			
		}
		
		//test popupWindow
		/*popUpContent = new DishPopupView (context, popupDish , model); 
		/*pressedDishWindow = new PopupWindow((View)popUpContent, 300, 300);
		pressedDishWindow.setTouchable(false);
		pressedDishWindow.showAsDropDown(numOfGuestEditText); 
		
		popUpContent.post(new Runnable() {
			   public void run() {
			     pressedDishWindow = new PopupWindow((View)popUpContent, 400, 600, true);
					pressedDishWindow.setTouchable(true);
					pressedDishWindow.setBackgroundDrawable(null);
					//pressedDishWindow.setFocusable(true);
					pressedDishWindow.showAsDropDown(numOfGuestEditText, -50, 0);    }
			})*/

		
		 
	}

	// implement update in ChooseMenuView
	public void update(Observable observable, Object changedItem) {
		if (observable instanceof DinnerModel) {
			DinnerModel model = (DinnerModel) observable;
			
			if (changedItem == DinnerModel.ChangedDataType.NUM_OF_GUEST) {
				Log.v("observer","Number of guests have changed");
				this.updateTotalCost();
			}else if(changedItem instanceof Dish){
				//below log msg will lead to null pointer exception if there is no selected dishes
//				Log.v("observer","dishes have changed. Chosen starter: " + model.getSelectedDish(1).getName() + " chosen main: " + model.getSelectedDish(2).getName() + " chosen dessert: " + model.getSelectedDish(3).getName());
				Log.v("Observer", this.model.getFullMenu().toArray().toString());
				Dish selectedDish = (Dish) changedItem;
				
				LinearLayout changedList = null;
				if(selectedDish.getType() == Dish.STARTER){
					changedList = this.starterList;
				}else if(selectedDish.getType() == Dish.MAIN){
					changedList = this.mainCourseList;
				}else if(selectedDish.getType() == Dish.DESERT){
					changedList = this.dessertList;
				}
				
				if(changedList != null){
					//Unhightlight all dishes
					//Highlight selected dishes
					for (int i = 0; i < changedList.getChildCount(); i++) {
						DishItemView eachDishView = (DishItemView) changedList.getChildAt(i);
						if(eachDishView.dish != selectedDish){
							eachDishView.setHighlight(false);	
						}
					}	
				}
				
				//also update price
				this.updateTotalCost();
			}else{
				Log.e("Observer:ChooseMenuView:", "unknown update data type");
			}
		}
	}

	public void showPopup(Dish dish){
		//TODO: implement this method to showPopup
		Log.d("ChooseMenuView", "showPopup()");
		
		
		popUpContent = new DishPopupView (context, dish , model); 
		popUpContent.post(new Runnable() {
			   public void run() {
			     pressedDishWindow = new PopupWindow((View)popUpContent, 400, 600, true);
					pressedDishWindow.setTouchable(true);
					pressedDishWindow.setBackgroundDrawable(null);
					//pressedDishWindow.setFocusable(true);
				    pressedDishWindow.showAsDropDown(numOfGuestEditText, -50, 0);    }
			});
		
		
	}
	
	protected void updateTotalCost(){

		this.totalCostLabel.setText(String.valueOf(model.getTotalMenuPrice()));
	}

}
