package se.kth.csc.iprog.dinnerplanner.android.view;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.ChooseMenuActivity;
import se.kth.csc.iprog.dinnerplanner.android.DinnerPlannerApplication;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.util.Log;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.ImageButton;
import android.view.View.OnClickListener;

import android.util.Log;

public class SummaryView{

	View view;
	DinnerModel model;
	Dish selectedDish = null;
	
	// android view objects
	View ingredientView = null;
	View instructionView = null;
	ImageButton ingredientBtn = null;

	public SummaryView(View view, DinnerModel dinnerModel){

		// store in the class the reference to the Android View
		this.view = view;
		this.model = dinnerModel;
		
		this.ingredientView = view.findViewById(R.id.ingredient_layout);
		this.instructionView = view.findViewById(R.id.instruction_layout);
		this.ingredientBtn = (ImageButton) this.view.findViewById(R.id.btn_ingredient);
		
		Context context = this.view.getContext();

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
			
			if(d.getType() == Dish.STARTER){
				dishImage1.setImageResource(DinnerPlannerApplication.getImageResId(context, d.getImage()));
				dishCaption1.setText(d.getName());
			}else if(d.getType() == Dish.MAIN){
				dishImage2.setImageResource(DinnerPlannerApplication.getImageResId(context, d.getImage()));
				dishCaption2.setText(d.getName());
			}else if(d.getType() == Dish.DESERT){
				dishImage3.setImageResource(DinnerPlannerApplication.getImageResId(context, d.getImage()));
				dishCaption3.setText(d.getName());
			}
		}

		//show ingredientView by default
		this.ingredientView.setVisibility(View.GONE);
//		this.instructionView.setVisibility(View.GONE);
		
		// Set Instructions layout
		TextView selDishTypeTitle = (TextView) view.findViewById(R.id.dish_type_title);
		selDishTypeTitle.setText(Dish.getTypeString(this.selectedDish.getType()));
		
		TextView selDishTitle = (TextView) view.findViewById(R.id.dish_name_title);
		selDishTitle.setText(this.selectedDish.getName());
		
		TextView selDishRecipe = (TextView) view.findViewById(R.id.receipe_desc);
		selDishRecipe.setText(this.selectedDish.getDescription());
		
		//TODO: Set Ingredients layout
	}

}
