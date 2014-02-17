package se.kth.csc.iprog.dinnerplanner.android.view;

import java.util.Set;
import java.util.Iterator;
import java.lang.String;
import se.kth.csc.iprog.dinnerplanner.android.DinnerPlannerApplication;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;
import android.util.Log;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;

import android.util.Log;

public class SummaryView{

	View view;
	DinnerModel model;
	int selectedDishType = 0;
	
	// android view objects
	View ingredientView = null;
	View instructionView = null;
	ImageButton ingredientBtn = null;
	ImageButton dish1Btn = null;
	ImageButton dish2Btn = null;
	ImageButton dish3Btn = null;
	TableLayout ingredientTable = null;

	public SummaryView(View view, DinnerModel dinnerModel){
		//Init all member vars
		// store in the class the reference to the Android View
		this.view = view;
		this.model = dinnerModel;
		
		this.ingredientView = view.findViewById(R.id.ingredient_layout);
		this.instructionView = view.findViewById(R.id.instruction_layout);
		this.ingredientBtn = (ImageButton) this.view.findViewById(R.id.btn_ingredient);
		this.dish1Btn = (ImageButton) this.view.findViewById(R.id.btn_dish1);
		this.dish2Btn = (ImageButton) this.view.findViewById(R.id.btn_dish2);
		this.dish3Btn = (ImageButton) this.view.findViewById(R.id.btn_dish3);
		
		//Init all local vars
		Context context = this.view.getContext();

		//Set total cost
		TextView totalCost = (TextView) view.findViewById(R.id.total_cost);	
		totalCost.setText(String.valueOf(this.model.getTotalMenuPrice()));

		//Set Ingredients layout
		this.ingredientTable = (TableLayout) view.findViewById(R.id.tableIngredients);
		this.ingredientTable.removeAllViews();
		
		//Set the selected dish imageView
		TextView dishCaption1 = (TextView) view.findViewById(R.id.dish1_caption);
		TextView dishCaption2 = (TextView) view.findViewById(R.id.dish2_caption);
		TextView dishCaption3 = (TextView) view.findViewById(R.id.dish3_caption);
		
		//	reset all images
		this.dish1Btn.setImageDrawable(null);
		this.dish2Btn.setImageDrawable(null);
		this.dish3Btn.setImageDrawable(null);

		//  get selected dishes
		Set<Dish> selectedDishes = dinnerModel.getFullMenu();
		Log.d("Selected Dish", "Showing selected dish: " + selectedDishes.size());
		
		Iterator<Dish> itDish = selectedDishes.iterator();
		while(itDish.hasNext()){
			Dish d = itDish.next();
			
			// select the first looped dish by default
			if(this.selectedDishType == 0){
				this.selectedDishType = d.getType();
			}
			
			if(d.getType() == Dish.STARTER){
				this.dish1Btn.setImageResource(DinnerPlannerApplication.getImageResId(context, d.getImage()));
				dishCaption1.setText(d.getName());
			}else if(d.getType() == Dish.MAIN){
				this.dish2Btn.setImageResource(DinnerPlannerApplication.getImageResId(context, d.getImage()));
				dishCaption2.setText(d.getName());
			}else if(d.getType() == Dish.DESERT){
				this.dish3Btn.setImageResource(DinnerPlannerApplication.getImageResId(context, d.getImage()));
				dishCaption3.setText(d.getName());
			}
			
			// also add ingredients to ingredientTable
			Iterator<Ingredient> itIngre = d.getIngredients().iterator();
			while(itIngre.hasNext()){
				Ingredient ingre = itIngre.next();
				TextView nameText = new TextView(context);
				nameText.setPadding(0,0,20,0);
				nameText.setText(ingre.getName());

				TextView quantityText = new TextView(context);
				double ingreQuan = ingre.getQuantity();
				//format double nicely
				String strIngreQuan = (ingreQuan == (int) ingreQuan) ? String.format("%.0f",ingreQuan) : String.format("%s",ingreQuan);
				quantityText.setText(strIngreQuan + " "+ingre.getUnit());
				
				TableRow row = new TableRow(context);
				row.addView(nameText);
				row.addView(quantityText);
				
				this.ingredientTable.addView(row);
				
			}
			
		}

		//show ingredientView by default
		this.ingredientView.setVisibility(View.VISIBLE);
		this.instructionView.setVisibility(View.GONE);
		
//		this.updateIntruction();
		
	}
	
	public void showDishByType(int dishType){
		Dish targetDish = this.model.getSelectedDish(dishType);
		
		// Set Instructions layout
		TextView selDishTypeTitle = (TextView) view.findViewById(R.id.dish_type_title);
		selDishTypeTitle.setText(Dish.getTypeString(targetDish.getType()));
				
		TextView selDishTitle = (TextView) view.findViewById(R.id.dish_name_title);
		selDishTitle.setText(targetDish.getName());
				
		TextView selDishRecipe = (TextView) view.findViewById(R.id.receipe_desc);
		selDishRecipe.setText(targetDish.getDescription());	
	}

}
