package price;

import java.util.Arrays;
import java.util.Scanner;

class StoreNotFoundException extends Exception {
    public StoreNotFoundException(String message) {
        super(message);
    }
}

    public class Price implements Comparable<Price> {
        private String goodsName;
        private String storeName;
        private double cost;

        public Price() {
        }

        public Price(String goodsName, String storeName, double cost) {
            this.goodsName = goodsName;
            this.storeName = storeName;
            this.cost = cost;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public String getStoreName() {
            return storeName;
        }

        public double getCost() {
            return cost;
        }

        public String toString() {
            return "Назва товару: " + getGoodsName() + ", магазин: " + getStoreName() + " вартість товару: " + getCost() + " UAH";
        }

        @Override
        public int compareTo(Price o) {
            int result = this.storeName.compareTo(o.storeName);
            return result;
        }

        Price[] prices = new Price[2];

        public void displayInfo() {
            for (int i = 0; i < prices.length; i++) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Введіть назву товару: ");
                String goods = sc.nextLine();
                System.out.println("Введіть назву магазину: ");
                String store = sc.nextLine();
                System.out.println("Введіть вартість товару: ");
                double cost = sc.nextInt();
                sc.nextLine();
                prices[i] = new Price(goods, store, cost);
            }
            Arrays.sort(prices);
            System.out.println("Відсортований за назвою магазинів список товарів:");
            for (Price temp : prices) {
                System.out.println(temp.toString());
            }
        }

        public void searchGoods() {
            System.out.println("Введіть назву магазину для пошуку товарів із попереднього списку:");
            Scanner sc = new Scanner(System.in);
            String searchGoods = sc.nextLine();
            try {
                boolean found = false;
                for (Price temp : prices) {
                    if (temp.getStoreName().equalsIgnoreCase(searchGoods)) {
                        System.out.println(temp);
                        found = true;
                    }
                }
                if (!found) {
                    throw new StoreNotFoundException("Магазин " + searchGoods + " не знайдено!");
                }
            } catch (StoreNotFoundException e) {
                System.out.println("Вийняток " + e.getMessage());
            }
        }
    }

    class Main {
        public static void main(String[] args) {
           Price price = new Price();
           price.displayInfo();
           price.searchGoods();
        }
    }