/* C13 = 1
 * Визначити ієрархію цукерок та інших солодощів. Створити кілька об'єктів-цукерок.
 * Зібрати дитячий подарунок з визначенням його ваги. Провести сортування цукерок у подарунку за одним із параметрів.
 * Знайти цукерку в подарунку, що відповідає заданому діапазону вмісту шоколаду в цукерці.
 */

package Lab6;

public class Main {
    public static void main(String[] args) {
        ChocolateGift chocolateGift = new ChocolateGift();
        chocolateGift.add(new WhiteChocolate("Candy 1", 20.0));
        chocolateGift.add(new MilkChocolate("Candy 2", 15.30));
        chocolateGift.add(new MilkChocolate("Candy 3", 12.98));
        chocolateGift.add(new MilkChocolate("Candy 4", 8));
        chocolateGift.add(new BlackChocolate("Candy 5", 21.12));
        chocolateGift.add(new BlackChocolate("Candy 6", 12.9));

        System.out.print(chocolateGift);
        System.out.print("\u001B[32m" + "\nВага дитячого подарунку з цукерками: "  + "\u001B[0m"
                + chocolateGift.wholeWeight() + " грамів");
        System.out.print("\n---------------------------------------------\n");

        Candy[] findCandies = chocolateGift.getCandiesInRange(0, 18);

        System.out.print("\u001B[32m" + "Цукерки, вага яких відповідає заданому діапазону:\n" + "\u001B[0m");
        for (Candy foundCandy : findCandies) {
            System.out.println(foundCandy);
        }

        System.out.print("---------------------------------------------\n");
        System.out.print("\u001B[32m" + "Цукерки, відсортовані за вагою:\n" + "\u001B[0m");
        chocolateGift.sortByWeight();
    }
}
