/*
1.The chef receives exactly 1 ingredient per day from the market.The
ingredients never repeat.
2. Every ingredient belongs to 1 of the 3 categories namely FIBER,FAT & CARB.
3.Every ingredient has a unique ingredient id.
4.The ingredient id always starts with the category name (ex:FIBERBroccoli,FATCheese,CARBRice)

Chef's Dishes
1. All of the chef's dishes have a constant number of ingredients.(this will be your program's input)
2. All the ingredients used will be fully used in a Dish. The chef doesn' use some part/quntity of an ingredient.
3. All of the chef's dishes mush have at least 60% of the ingredients from a single category.(i.e. if the chef cooks using
4. ingredients,then at leaast 3 FAT ingredients OR at least 3 FIBER ingredients OR at least 3 CARB ingredients are needed)

* DISH X - at least 2 FAT
* DISH Y - at least 1 CARB & 1 FIBER
* INGREDIENTS have Portions : FAT -> 2, FIBER -> 4 , CARB -> 2
* ONLY ONE portion can be used at a time
* BOTH Dishes Cooked alternate days.
* Start Dish could be anyone.

Chef's Cooking style:-
1. If the chef has multiple options of ingredients for the dish,then he takes the oldest possible ones to cook
in the order of their arrival.
2.After the chef prepares a dish,the ingredients used can Not be reused as theyhave been already used.
3.The chef prepares a maximum of 1 dish per day.
4.if the Chef does not have enough ingredients to cook the dish with above mentioned rules,then he does not
cook on that day.

Input:-
Line 1: The total number of days for the scope of the problem(1<=input<=20)
Line 2: The exact number of ingredients that chef uses to cook(1<=input<=20)
Line 3: The space separated ingredient ids.(6<=length(ingredientid)<=20)

Output:- Print the ":" separated used ingredient ids in order of their arrival if the chef cooks on that day
and print "-" if the chef doesn't cook anything on that day.Print the output as single string. 

Example Input:
6
2
FATOil FATCheese FATEgg FIBERSpinach CARBRice FIBERBeans 
Example Output: 
-XXXYY

The chef tries to prepare a dish each day.
The chef receives exactly 1 ingredient per day from the market.
Every ingredient belongs to 1 of the 3 categories namely FIBER,FAT & CARB.
The ingredient id always starts with the category name (ex:FIBERBroccoli,FATCheese,CARBRice)

All of the chef's dishes have a constant number of ingredients.(this will be your program's input)
All the ingredients used will be fully used in a Dish. The chef doesn' use some part/quntity of an ingredient.

There are 2 Dishes available to create
* DISH X - at least 2 FAT
* DISH Y - at least 1 CARB & 1 FIBER
* BOTH Dishes are Cooked alternately.
* Start Dish could be anyone.
* INGREDIENTS have Portions : FAT -> 2, FIBER -> 4 , CARB -> 2
* ONLY ONE portion can be used at a time

Example :
5
2
FIBERSpinach CARBRice FIBERBeans FATOil FATCheese

Result : -Y--X

*/

import java.util.*;

public class ChefDishIng {

    static int[] fiber, fat, carb;
    static int numberOfIngredients;
    static char dishTurn = '0';
    static String finalResult = "";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfDays = input.nextInt();
        fiber = new int[numberOfDays];
        fat = new int[numberOfDays];
        carb = new int[numberOfDays];
        numberOfIngredients = input.nextInt();
        input.nextLine();
        for (int count = 0; count < numberOfDays; count++) {
            String ingredients = input.next();
            if (ingredients.matches("^FIBER.*")) {
                fiber[count] = 4;
            }
            if (ingredients.matches("^FAT.*")) {
                fat[count] = 2;
            }
            if (ingredients.matches("^CARB.*")) {
                carb[count] = 2;
            }
            finalResult += prepare();
        }
        input.close();
        System.out.println(finalResult);
        for (int k : fat)
            System.out.println(k);
        for (int k : fiber)
            System.out.println(k);
        for (int k : carb)
            System.out.println(k);
    }

    static String prepare() {
        String result = "-";
        if (dishTurn == '0') {
            result = prepareDishX();
            if (result.equals("-")) {
                result = prepareDishY();
            }
            return result;
        } else if (dishTurn == 'X') {
            return prepareDishX();
        } else if (dishTurn == 'Y') {
            return prepareDishY();
        }
        return result;
    }

    static String prepareDishX() {
        int ingLeft = numberOfIngredients;
        List<Integer> fatIndexes = new ArrayList<Integer>();
        List<Integer> fiberIndexes = new ArrayList<Integer>();
        for (int i = 0; i < fat.length; i++) {
            if (fat[i] > 0 && ingLeft > 0) {
                fatIndexes.add(i);
                ingLeft--;
            }
        }
        if (ingLeft > numberOfIngredients - 2){
            return "-";
        }
        for (int i = 0; i < fiber.length; i++) {
            if (fiber[i] > 0 && ingLeft > 0) {
                fiberIndexes.add(i);
                ingLeft--;
            }
        }
        if (ingLeft > 0) {
            return "-";
        }
        for (int index : fatIndexes)
            fat[index]--;
        for (int index : fiberIndexes)
            fiber[index]--;
        dishTurn = 'Y';
        return "X";
    }

    static String prepareDishY() {
        int ingLeft = numberOfIngredients;
        List<Integer> carbIndexes = new ArrayList<Integer>();
        List<Integer> fiberIndexes = new ArrayList<Integer>();
        for (int i = 0; i < carb.length; i++) {
            if (carb[i] > 0 && ingLeft > 1) {
                carbIndexes.add(i);
                ingLeft--;
            }
        }
        if (ingLeft == numberOfIngredients) {
            return "-";
        }
        for (int i = 0; i < fiber.length; i++) {
            if (fiber[i] > 0 && ingLeft > 0) {
                fiberIndexes.add(i);
                ingLeft--;
            }
        }
        if (ingLeft > 0) {
            return "-";
        }
        for (int index : carbIndexes)
            carb[index]--;
        for (int index : fiberIndexes)
            fiber[index]--;
        dishTurn = 'X';
        return "Y";
    }

}