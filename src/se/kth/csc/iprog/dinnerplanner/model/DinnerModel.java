package se.kth.csc.iprog.dinnerplanner.model;

import java.util.HashSet;
import java.util.Set;

public class DinnerModel implements IDinnerModel{
	

	Set<Dish> dishes = new HashSet<Dish>();
	Set<Dish> selectedDishes = new HashSet<Dish>();
	int numOfGuest = 0;
	
	/**
	 * TODO: For Lab2 you need to implement the IDinnerModel interface.
	 * When you do this you will have all the needed fields and methods
	 * for the dinner planner (number of guests, selected dishes, etc.). 
	 */
	
	
	/**
	 * The constructor of the overall model. Set the default values here
	 */
	public DinnerModel(){
		
		//!Important! image names under res should NOT contains any file extension, because loading a resource file does not require extension
		//Adding some example data, you can add more
		Dish dish1 = new Dish("French toast",Dish.STARTER,"toast","In a large mixing bowl, beat the eggs. Add the milk, brown sugar and nutmeg; stir well to combine. Soak bread slices in the egg mixture until saturated. Heat a lightly oiled griddle or frying pan over medium high heat. Brown slices on both sides, sprinkle with cinnamon and serve hot.");
		Ingredient dish1ing1 = new Ingredient("eggs",0.5,"",1);
		Ingredient dish1ing2 = new Ingredient("milk",30,"ml",6);
		Ingredient dish1ing3 = new Ingredient("brown sugar",7,"g",1);
		Ingredient dish1ing4 = new Ingredient("ground nutmeg",0.5,"g",12);
		Ingredient dish1ing5 = new Ingredient("white bread",2,"slices",2);
		dish1.addIngredient(dish1ing1);
		dish1.addIngredient(dish1ing2);
		dish1.addIngredient(dish1ing3);
		dish1.addIngredient(dish1ing4);
		dish1.addIngredient(dish1ing5);
		dishes.add(dish1);
		
		Dish dish2 = new Dish("Meat balls",Dish.MAIN,"meatballs","Preheat an oven to 400 degrees F (200 degrees C). Place the beef into a mixing bowl, and season with salt, onion, garlic salt, Italian seasoning, oregano, red pepper flakes, hot pepper sauce, and Worcestershire sauce; mix well. Add the milk, Parmesan cheese, and bread crumbs. Mix until evenly blended, then form into 1 1/2-inch meatballs, and place onto a baking sheet. Bake in the preheated oven until no longer pink in the center, 20 to 25 minutes.");
		Ingredient dish2ing1 = new Ingredient("extra lean ground beef",115,"g",20);
		Ingredient dish2ing2 = new Ingredient("sea salt",0.7,"g",3);
		Ingredient dish2ing3 = new Ingredient("small onion, diced",0.25,"",2);
		Ingredient dish2ing4 = new Ingredient("garlic salt",0.6,"g",3);
		Ingredient dish2ing5 = new Ingredient("Italian seasoning",0.3,"g",3);
		Ingredient dish2ing6 = new Ingredient("dried oregano",0.3,"g",3);
		Ingredient dish2ing7 = new Ingredient("crushed red pepper flakes",0.6,"g",3);
		Ingredient dish2ing8 = new Ingredient("Worcestershire sauce",16,"ml",7);
		Ingredient dish2ing9 = new Ingredient("milk",20,"ml",4);
		Ingredient dish2ing10 = new Ingredient("grated Parmesan cheese",5,"g",8);
		Ingredient dish2ing11 = new Ingredient("seasoned bread crumbs",115,"g",4);
		dish2.addIngredient(dish2ing1);
		dish2.addIngredient(dish2ing2);
		dish2.addIngredient(dish2ing3);
		dish2.addIngredient(dish2ing4);
		dish2.addIngredient(dish2ing5);
		dish2.addIngredient(dish2ing6);
		dish2.addIngredient(dish2ing7);
		dish2.addIngredient(dish2ing8);
		dish2.addIngredient(dish2ing9);
		dish2.addIngredient(dish2ing10);
		dish2.addIngredient(dish2ing11);
		dishes.add(dish2);
		
		Dish dish3 = new Dish("Baked Brie", Dish.STARTER, "bakedbrie", "Preheat oven to 200deg. Put the brie inside. Close the oven. Bake for 50 minutes.");
		dish3.addIngredient(new Ingredient("flour", 1/4, "wheel", 100));
		dish3.addIngredient(new Ingredient("honey", 4, "tablespoons", 5));
		this.dishes.add(dish3);
		
		Dish dish4 = new Dish("Ice-cream", Dish.DESERT, "icecream", "Scoop an ice-cream. Add chocholate chips on top.");
		dish4.addIngredient(new Ingredient("ice-cream", 1, "scoop", 8));
		dish4.addIngredient(new Ingredient("chocolate chips", 2, "sprinkle", 5));
		this.dishes.add(dish4);
		
		Dish dish5 = new Dish("Sour Dough", Dish.DESERT, "sourdough", "blabla bla");
		dish5.addIngredient(new Ingredient("dough", 1, "scoop", 10));
		dish5.addIngredient(new Ingredient("yogurt", 100, "ml", 5));
		this.dishes.add(dish5);
		
		Dish dish6 = new Dish("French toast",Dish.DESERT,"toast","In a large mixing bowl, beat the eggs. Add the milk, brown sugar and nutmeg; stir well to combine. Soak bread slices in the egg mixture until saturated. Heat a lightly oiled griddle or frying pan over medium high heat. Brown slices on both sides, sprinkle with cinnamon and serve hot.");
		dish6.addIngredient(new Ingredient("eggs",0.5,"",1));
		dish6.addIngredient(new Ingredient("milk",30,"ml",6));
		dish6.addIngredient(new Ingredient("brown sugar",7,"g",1));
		dish6.addIngredient(new Ingredient("ground nutmeg",0.5,"g",12));
		dish6.addIngredient(new Ingredient("white bread",2,"slices",2));
		dishes.add(dish6);
		
		Dish dish7 = new Dish("Baked Brie", Dish.DESERT, "bakedbrie", "Preheat oven to 200deg. Put the brie inside. Close the oven. Bake for 50 minutes.");
		dish7.addIngredient(new Ingredient("flour", 1/4, "wheel", 100));
		dish7.addIngredient(new Ingredient("honey", 4, "tablespoons", 5));
		this.dishes.add(dish7);
		
		//**TEMP for Lab1** select some default dishes for display//
		this.selectDish(dish1);
		this.selectDish(dish2);
		this.selectDish(dish4);
		
		this.numOfGuest = 2;
		
	}
	
	/**
	 * Returns the set of dishes.
	 */
	public Set<Dish> getDishes(){
		return dishes;
	}
	
	/**
	 * Returns the set of dishes of specific type. (1 = starter, 2 = main, 3 = desert).
	 */
	public Set<Dish> getDishesOfType(int type){
		Set<Dish> result = new HashSet<Dish>();
		for(Dish d : dishes){
			if(d.getType() == type){
				result.add(d);
			}
		}
		return result;
	}
	
	/**
	 * Returns the set of dishes of specific type, that contain filter in their name
	 * or name of any ingredient. 
	 */
	public Set<Dish> filterDishesOfType(int type, String filter){
		Set<Dish> result = new HashSet<Dish>();
		for(Dish d : dishes){
			if(d.getType() == type && d.contains(filter)){
				result.add(d);
			}
		}
		return result;
	}
	
	
	public int getNumberOfGuests(){
		return this.numOfGuest; 
	}
	public void setNumberOfGuests(int numberOfGuests){
		this.numOfGuest = numberOfGuests;
	}
	
	/**
	 * Returns the dish that is on the menu for selected type (1 = starter, 2 = main, 3 = desert).
	 */
	public Dish getSelectedDish(int type){
		for(Dish d : this.selectedDishes){
			if(d.getType() == type){
				return d;
			}
		}
		return null;
	}
	public void selectDish(Dish selDish){
		boolean isReplace = false;
		
		// Check and replace originally selected dish of same type
		for(Dish d : this.selectedDishes){
			if(d.getType() == selDish.getType()){
				d = selDish;
				isReplace = true;
			}
		}
		
		if(!isReplace){
			this.selectedDishes.add(selDish);			
		}
	}
	
	/**
	 * Returns all the dishes on the menu (selected dishes).
	 */
	public Set<Dish> getFullMenu(){
		return this.selectedDishes;
	}
	
	/**
	 * Returns all ingredients for all the dishes on the menu.
	 */
	public Set<Ingredient> getAllIngredients(){
		Set<Ingredient> result = new HashSet<Ingredient>();
		for(Dish d : this.selectedDishes){
			result.addAll(d.getIngredients());
		}
		return result;
	}
	
	/**
	 * Returns the total price of the menu (all the ingredients multiplied by number of guests).
	 */
	public float getTotalMenuPrice(){
		float totalPrice = 0;
		for(Dish d : this.selectedDishes){
			for(Ingredient eachIngredient: d.getIngredients()){
				totalPrice += eachIngredient.getPrice();
			}			
		}
		return totalPrice*this.numOfGuest;
	}
	
	

}
