

import java.util.ArrayList;
import java.util.Scanner;

abstract class Delivery {
    protected int distance;
    protected int weight;

    public Delivery() {
        this.distance = 0;
        this.weight = 0;
    }

    public Delivery(int distance, int weight) {
        this();
        this.distance = distance;
        this.weight = weight;
    }

    public abstract long calculateFee();
}

class RegularDelivery extends Delivery {
    public RegularDelivery(int distance, int weight) {
        super(distance, weight);
    }

    @Override
    public long calculateFee() {
        return 10L + 2L * distance + weight;
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(int distance, int weight) {
        super(distance, weight);
    }

    @Override
    public long calculateFee() {
        return 25L + 4L * distance + 2L * weight;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Delivery> deliveries = new ArrayList<>();

        System.out.print("How many deliveries? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Delivery " + i + " - type (R/E): ");
            char type = Character.toUpperCase(sc.next().charAt(0));

            System.out.print("Delivery " + i + " - distance (km): ");
            int distance = sc.nextInt();

            System.out.print("Delivery " + i + " - weight (kg): ");
            int weight = sc.nextInt();

            if (type == 'R') {
                deliveries.add(new RegularDelivery(distance, weight));
            } else {
                deliveries.add(new ExpressDelivery(distance, weight));
            }
        }

        System.out.println("--- DELIVERY FEE SUMMARY ---");
        long total = 0;
        for (int i = 0; i < deliveries.size(); i++) {
            long fee = deliveries.get(i).calculateFee();
            System.out.println("Delivery " + (i + 1) + ": " + fee + " units");
            total += fee;
        }
        System.out.println("Total delivery fees: " + total + " units");

        sc.close();
    }
}



