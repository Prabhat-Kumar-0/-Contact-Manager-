import java.util.*;

public class Recipee {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Recipe> recipes = new ArrayList<>();

    public static void main(String[] args) {
        boolean exit = false;
        
        while (!exit) {
            System.out.println("Recipe Manager");
            System.out.println("1. Add Recipe");
            System.out.println("2. View Recipes");
            System.out.println("3. Delete Recipe");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            switch (choice) {
                case 1:
                    addRecipe();
                    break;
                case 2:
                    viewRecipes();
                    break;
                case 3:
                    deleteRecipe();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting Recipe Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    break;
            }
        }
    }

    private static void addRecipe() {
        System.out.print("Enter recipe name: ");
        String name = scanner.nextLine();
        System.out.print("Enter ingredients (comma-separated): ");
        String[] ingredients = scanner.nextLine().split(",");
        System.out.print("Enter instructions: ");
        String instructions = scanner.nextLine();
        
        Recipe recipe = new Recipe(name.trim(), Arrays.asList(ingredients), instructions.trim());
        recipes.add(recipe);
        System.out.println("Recipe added successfully!");
    }

    private static void viewRecipes() {
        if (recipes.isEmpty()) {
            System.out.println("No recipes available. Add a recipe first.");
        } else {
            System.out.println("List of Recipes:");
            int count = 1;
            for (Recipe recipe : recipes) {
                System.out.println(count + ". " + recipe.getName());
                count++;
            }
            System.out.print("Enter recipe number to view details (0 to return): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            if (choice > 0 && choice <= recipes.size()) {
                Recipe selectedRecipe = recipes.get(choice - 1);
                System.out.println("Recipe Details:");
                System.out.println("Name: " + selectedRecipe.getName());
                System.out.println("Ingredients: " + String.join(", ", selectedRecipe.getIngredients()));
                System.out.println("Instructions:\n" + selectedRecipe.getInstructions());
            } else if (choice != 0) {
                System.out.println("Invalid recipe number.");
            }
        }
    }

    private static void deleteRecipe() {
        if (recipes.isEmpty()) {
            System.out.println("No recipes available to delete.");
        } else {
            System.out.print("Enter recipe number to delete (0 to return): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            if (choice > 0 && choice <= recipes.size()) {
                Recipe deletedRecipe = recipes.remove(choice - 1);
                System.out.println("Deleted recipe: " + deletedRecipe.getName());
            } else if (choice != 0) {
                System.out.println("Invalid recipe number.");
            }
        }
    }

    // Recipe class to represent each recipe
    static class Recipe {
        private String name;
        private List<String> ingredients;
        private String instructions;

        public Recipe(String name, List<String> ingredients, String instructions) {
            this.name = name;
            this.ingredients = ingredients;
            this.instructions = instructions;
        }

        public String getName() {
            return name;
        }

        public List<String> getIngredients() {
            return ingredients;
        }

        public String getInstructions() {
            return instructions;
        }
    }
}
