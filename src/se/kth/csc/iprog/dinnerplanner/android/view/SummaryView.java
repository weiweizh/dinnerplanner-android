package se.kth.csc.iprog.dinnerplanner.android.view;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

import android.util.Log;

public class SummaryView {

	View view;
	DinnerModel model;
	
	Dish selectedDish = null;

	public SummaryView(View view, DinnerModel dinnerModel) {

		// store in the class the reference to the Android View
		this.view = view;
		this.model = dinnerModel;
		


		//Set total cost
		TextView totalCost = (TextView) view.findViewById(R.id.total_cost);	
		totalCost.setText(String.valueOf(this.model.getTotalMenuPrice()));

		//Set the selected dish imageView
		
		ImageView dishImage1 = (ImageView) this.view.findViewById(R.id.imageDish1);
		ImageView dishImage2 = (ImageView) this.view.findViewById(R.id.imageDish2);
		ImageView dishImage3 = (ImageView) this.view.findViewById(R.id.imageDish3);

		TextView dishCaption1 = (TextView) view.findViewById(R.id.dish1_caption);
		TextView dishCaption2 = (TextView) view.findViewById(R.id.dish2_caption);
		TextView dishCaption3 = (TextView) view.findViewById(R.id.dish3_caption);
		
		//	reset all images
		dishImage1.setImageDrawable(null);
		dishImage2.setImageDrawable(null);
		dishImage3.setImageDrawable(null);

		//  get selected dishes
		Set<Dish> selectedDishes = dinnerModel.getFullMenu();
		Log.d("Selected Dish", "Showing selected dish: " + selectedDishes.size());
		for(Dish d : selectedDishes){
			//***temp*** select a dish here
			this.selectedDish = d;
			//***temp end***
			
			Uri uri = Uri.parse("android.resource://se.kth.csc.iprog.dinnerplanner.android/drawable/" + d.getImage());
			if(d.getType() == Dish.STARTER){
				dishImage1.setImageURI(uri);
				dishCaption1.setText(d.getName());
			}else if(d.getType() == Dish.MAIN){
				dishImage2.setImageURI(uri);
				dishCaption2.setText(d.getName());
			}else if(d.getType() == Dish.DESERT){
				dishImage3.setImageURI(uri);
				dishCaption3.setText(d.getName());
			}
		}
		
		TextView selDishTypeTitle = (TextView) view.findViewById(R.id.dish_type_title);
		selDishTypeTitle.setText(Dish.getTypeString(this.selectedDish.getType()));
		
		TextView selDishTitle = (TextView) view.findViewById(R.id.dish_name_title);
		selDishTitle.setText(this.selectedDish.getName());
		
		TextView selDishRecipe = (TextView) view.findViewById(R.id.receipe_desc);
		selDishRecipe.setText(this.selectedDish.getDescription());
		
		// Setup the rest of the view layout
	}

}
