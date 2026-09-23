public class Person {
    public String name;
    public double MealPayment;
    public int MealNumberCount;
    public double MealCost;
    public boolean isExtra;
    public String[][] Extra = {
        {"Rice", "20"},
        {"Egg", "15"}
    };
    public double ExtraPrice = 0;
    public boolean status;


    public Person(String n, double mp, int mnc, boolean extra)
    {
        name = n;
        MealPayment = mp;
        MealNumberCount = mnc;
        isExtra = extra;
    }


}
