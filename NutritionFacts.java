import java.text.DecimalFormat;
import java.text.NumberFormat;

class NutritionFacts {
  /* In this class, you will print out a Nutrition Facts label
     Your class should:
     - Write a constructor to assign values to fat, cholesterol, sodium, carbs, and protein
     - Write a void method named "computeCalories" to calculate the calories as a double using this formula:
               (9*fat) + (4*carbs) + (4*protein)
     - Write a method named "getFat" to return the value of fat
     - Write a void method named "dailyValues" to calculate the % Daily Value for ints fatDV, cholesterolDV, sodiumDV, and carbsDV using these formulas:
               fatDV = (fat / 65) * 100
               cholesterolDV = (cholesterol / 300) * 100
               sodiumDV = (sodium / 2400) * 100
               carbsDV = (carbs / 300) * 100
     - Write a void method named "label" to print out the Nutrition Facts label in the following example format:
               NUTRITION FACTS       
               Calories 136
               Fat 4g, 6% DV
               Cholesterol 0mg, 0% DV
               Sodium 240mg, 10% DV
               Carbohydrate 22g, 7% DV
               Protein 3g                      */
  
  private double fat, cholesterol, sodium, carbs, protein, calories;
  private int fatDV, cholesterolDV, sodiumDV, carbsDV;
  private String labelText;
  
  public NutritionFacts(double fat, double cholesterol, double sodium, double carbs, double protein) {
    this.fat = fat;
    this.cholesterol = cholesterol;
    this.sodium = sodium;
    this.carbs = carbs;
    this.protein = protein;

    calculateCalories();
    calculateDailyValues();
    generateLabelText();
  }

  public double calculateCalories() {
    calories = (9 * fat) + (4 * carbs) + (4 * protein);
    return calories;
  }
  
  public void calculateDailyValues() {
    fatDV = (int) (fat / 0.65);
    cholesterolDV = (int) (cholesterol / 3);
    sodiumDV = (int) (sodium / 24);
    carbsDV = (int) (carbs / 3);
  }
  
  public void dailyValues() {
    calculateDailyValues();
  }
  
  public double getFat() {
    return fat;
  }
  
  public void label() {
    System.out.println(labelText);
  }

  private String generateLabelText() {
    NumberFormat nf = new DecimalFormat("#.#");
    labelText = String.format(
             "NUTRITION FACTS\n" +
             "Calories %d\n" +
             "------------------------------\n" +
             "Fat %sg         \t %4d%% DV\n" +
             "Cholesterol %smg\t %4d%% DV\n" +
             "Sodium %smg     \t %4d%% DV\n" +
             "Carbohydrate %sg\t %4d%% DV\n" +
             "Protein %sg", Math.round(calories),
                            nf.format(fat), fatDV,
                            nf.format(cholesterol), cholesterolDV,
                            nf.format(sodium), sodiumDV,
                            nf.format(carbs), carbsDV,
                            nf.format(protein));

    return labelText;
    /*Calories 136
    Fat 4g, 6% DV
    Cholesterol 0mg, 0% DV
    Sodium 240mg, 10% DV
    Carbohydrate 22g, 7% DV
    Protein 3g */
  }
}