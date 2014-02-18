package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.DinnerPlannerApplication;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.annotation.SuppressLint;
import android.content.Context;


@SuppressLint("ViewConstructor")
public class DishPopupView extends RelativeLayout{
	
	Dish dish;
	Context context;
	DinnerModel model;
	
	public DishPopupView (Context context, Dish longPressed, DinnerModel model){
		super(context);
		// get the layout of dish_popup_view from the xml
		this.dish = longPressed;
		this.context = context;
		this.model = model;
		
        // inflate the layout
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.dish_popup_view, this, true);
		
		
		
		// set the longPressed dish caption
		TextView dishCaption = (TextView) this.findViewById(R.id.dish_item_caption);	
		dishCaption.setText(String.valueOf(this.dish.getName()));
		
		// set the image
		ImageView image = (ImageView) this.findViewById(R.id.popupDishImage);
		image.setImageResource(DinnerPlannerApplication.getImageResId(context, this.dish.getImage()));
		
		// set the cost / person
		TextView dishPrice = (TextView) this.findViewById(R.id.oneDishCostPerP);
		float price = dish.getPrice();
		dishPrice.setText(String.valueOf(price));
		
		// set the total cost
		TextView oneDish4All = (TextView) this.findViewById(R.id.oneDishCostTotal);
		float oneDishCostAll = model.getNumberOfGuests() * price;
		oneDish4All.setText(String.valueOf(oneDishCostAll));
		
		
	}
	
}