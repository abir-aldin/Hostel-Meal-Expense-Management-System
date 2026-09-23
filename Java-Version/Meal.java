import java.util.*;

public class Meal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Person[] p = new Person[6];
        int n = p.length;


        for(int i=0;i<n;i++)
        {
            p[i] = new Person(null, i, n, false);
        }

        p[0].name = "Sajid";
        p[1].name = "Mahdi";
        p[2].name = "Abir";
        p[3].name = "Soyaeeb";
        p[4].name = "Ador";
        p[5].name = "Akkhor";

        int totalMeal = 0;
        double totalMealPayment = 0;

        for(int i=0;i<n;i++)
        {
            System.out.println("Enter Info for "+p[i].name);

            System.out.print("Payment = ");
            double mp = input.nextDouble();

            System.out.print("Meal number = ");
            int mn = input.nextInt();

            System.out.print("Extra? = ");
            boolean extra = input.nextBoolean();

            p[i] = new Person(p[i].name, mp, mn, extra);

            System.out.println();

            totalMeal += mn;
            totalMealPayment += mp;

        }

        double totalExtraPrice = 0;

        for(int i=0;i<n;i++)
        {
            if(p[i].isExtra)
            {
                System.out.println("\nFor "+p[i].name);
                for(int r=0;r<2;r++)
                {
                    System.out.print(p[i].Extra[r][0]+" = ");
                    int number = input.nextInt();

                    p[i].ExtraPrice += number * Integer.parseInt(p[i].Extra[r][1]);
                }

                totalExtraPrice += p[i].ExtraPrice;
            }
        }

        System.out.println("\n");

        double netTotalPayment = totalMealPayment - totalExtraPrice;

        double mealRate = netTotalPayment / totalMeal;

        for(int i=0;i<n;i++)
        {
            p[i].MealCost = (mealRate * p[i].MealNumberCount) + p[i].ExtraPrice;

            if(p[i].MealPayment < p[i].MealCost)
            {
                p[i].status = true;
            }
            else p[i].status = false;
        }

        int x = 0;

        System.out.println("Dibe: ");
        for(int i = 0;i<n;i++)
        {
            if(p[i].status)
            {
                System.out.println((++x)+". "+p[i].name+" ---> "+((int)(p[i].MealCost - p[i].MealPayment))+" tk");
            }
        }

        x = 0;
        System.out.println("\nPabe: ");
        for(int i=0;i<n;i++)
        {
            if(!p[i].status)
            {
                System.out.println((++x)+". "+p[i].name+" ---> "+((int)(p[i].MealPayment - p[i].MealCost))+" tk");
            }
        }

        System.out.println("\nMeal rate = "+mealRate+" tk");


    }
}
