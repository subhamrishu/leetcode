class Food implements Comparable<Food>{
    String food; 
    int rating;
    Food(String food, int rating){
        this.food = food;
        this.rating = rating;
    }
    
    @Override
    public int compareTo(Food other){
        if (rating == other.rating){
            return food.compareTo(other.food);
        }
        return -1 * Integer.compare(rating, other.rating);
    }
}

class FoodRatings {
    Map<String, Integer> foodRatingMap;
    Map<String, String> foodCuisineMap;
    Map<String, PriorityQueue<Food>> cuisineMap;
    
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRatingMap = new HashMap<>();
        foodCuisineMap = new HashMap<>();
        cuisineMap = new HashMap<>();
        
        for (int i = 0; i < foods.length; i++){
            foodRatingMap.put(foods[i], ratings[i]);
            foodCuisineMap.put(foods[i], cuisines[i]);
            if (!cuisineMap.containsKey(cuisines[i])){
                cuisineMap.put(cuisines[i], new PriorityQueue<>());
            }
            cuisineMap.get(cuisines[i]).add(new Food(foods[i], ratings[i]));
            
        }
    }
    
    public void changeRating(String food, int newRating) {
        foodRatingMap.put(food, newRating);
        cuisineMap.get(foodCuisineMap.get(food)).add(new Food(food, newRating));
    }
    
    public String highestRated(String cuisine) {
        while (!cuisineMap.get(cuisine).isEmpty()){
            Food top = cuisineMap.get(cuisine).peek();
            if (foodRatingMap.get(top.food) != top.rating){
                cuisineMap.get(cuisine).poll();
            }else{
                break;
            }
        }
        return cuisineMap.get(cuisine).peek().food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */