class Solution {
    void dfs(String recipe, Map<String, List<String>> rmap, Set<String> sm, Set<String> visited){
        visited.add(recipe);
        int count = 0;
        for (String food: rmap.get(recipe)){
            if (!visited.contains(food) && rmap.containsKey(food)){
                dfs(food, rmap, sm, visited);
            }
            if (sm.contains(food)){
                count++;
            }
        }
        if (count == rmap.get(recipe).size())
            sm.add(recipe);
    }
    
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> rmap = new HashMap<>();
        Set<String> sm = new HashSet<>();
        
        for (int i = 0; i < recipes.length; i++){
            rmap.put(recipes[i], new ArrayList<>());
            for (int j = 0; j < ingredients.get(i).size(); j++){
                rmap.get(recipes[i]).add(ingredients.get(i).get(j));
            }
        }
        
        for (int i = 0; i < supplies.length; i++){
            sm.add(supplies[i]);
        }
        Set<String> visited = new HashSet<>();
        List<String> sol = new ArrayList<>();
        
        for (String recipe: recipes){
            if (!visited.contains(recipe)){
                dfs(recipe, rmap, sm, visited);
            }
            if (sm.contains(recipe))
                sol.add(recipe);
        }
        return sol;
    }
}