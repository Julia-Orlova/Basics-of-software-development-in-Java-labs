package Lab6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ChocolateGift {
    private static final int MAX = 12;
    private Candy[] candies = new Candy[MAX];
    private int calculator;

    public void add(Candy candy){
        candies[calculator++] = candy;
    }

    @Override
    public String toString() {
        String result = "---------Дитячий подарунок з цукерками---------\n";
        for (int i = 0; i < calculator; i++) {
            result += i + 1 + ". " + candies[i].toString() + "\n";
        }
        return result + "---------------------------------------------";
    }

    public int wholeWeight() {
        int result = 0;
        for (Candy candy : candies) {
            if (candy != null) {
                result += candy.getWeight();
            }
        }
        return result;
    }

    // Отримати кількість цукерок, вага яких знаходиться в заданому діапазоні
    private int getAmountOfCandiesInRange(double from, double to)
    {
        int counter = 0;
        for (Candy candy : this.candies) {
            if (candy != null) {
                if (candy.getWeight() > from && candy.getWeight() < to) {
                    counter++;
                }
            }
        }
        return counter;
    }

    // Отримати список цукерок, вага яких знаходиться в заданому діапазоні
    public Candy[] getCandiesInRange(double from, double to)
    {
        // знайдемо кількість цукерок, щоб зформувати масив
        Candy[] candiesInRange = new Candy[getAmountOfCandiesInRange(from, to)];
        int index = 0;

        for (int i = 0; i < this.candies.length; i++) {
            // перевіримо, чи це цукерка
            if(this.candies[i] instanceof Candy) {
                if(this.candies[i].getWeight() > from && this.candies[i].getWeight() < to) {
                    candiesInRange[index] = this.candies[i];
                    index++;
                }
            }
        }
        return candiesInRange;
    }

    //сортування цукерок за вагою
    public void sortByWeight(){
        List<Candy> candiesList = new ArrayList();
        for (Candy candy : candies) {
            //якщо компонент подарунку є цукеркою, то додаємо його у список
            if (candy instanceof Candy){
                candiesList.add((Candy) candy);
            }
        }
        //порівнюємо за вагою
        candiesList.sort(Comparator.comparing(Candy::getWeight));
        for (Candy candy : candiesList) {
            System.out.println(candy);
        }
    }
}
