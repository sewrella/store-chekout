import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Product prices
        double mousePrice = 20;
        double keyboardPrice = 40;
        double headphonesPrice = 50;
        double standPrice = 45;
        double monitorPrice = 100;

        // Product counters
        int mouseCount = 0;
        int keyboardCount = 0;
        int headphonesCount = 0;
        int standCount = 0;
        int monitorCount = 0;

        // Accumulators
        double subtotal = 0;
        double bulkDiscount = 0;
        int totalItems = 0;

        int choice = 0;

        // Shopping menu
        while (choice != 6) {
            System.out.println("\n===== SIMPLE STORE =====");
            System.out.println("1. Mouse - $20");
            System.out.println("2. Keyboard - $40");
            System.out.println("3. Headphones - $50");
            System.out.println("4. Laptop Stand - $45");
            System.out.println("5. Monitor - $100");
            System.out.println("6. Checkout");
            System.out.println("Choose a product:");

            choice = input.nextInt();

            if (choice == 6) {
                break;
            } else if (choice < 1 || choice > 6) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            System.out.println("Enter quantity:");
            int quantity = input.nextInt();

            if (quantity <= 0) {
                System.out.println("Invalid quantity.");
                continue;
            }

            // Update quantities and subtotal
            if (choice == 1) {
                mouseCount += quantity;
                subtotal += mousePrice * quantity;
            } else if (choice == 2) {
                keyboardCount += quantity;
                subtotal += keyboardPrice * quantity;
            } else if (choice == 3) {
                headphonesCount += quantity;
                subtotal += headphonesPrice * quantity;
            } else if (choice == 4) {
                standCount += quantity;
                subtotal += standPrice * quantity;
            } else if (choice == 5) {
                monitorCount += quantity;
                subtotal += monitorPrice * quantity;
            }

            totalItems += quantity;

            System.out.println("Current subtotal: $" + subtotal);
        }

        // Check if the customer bought anything
        if (totalItems == 0) {
            System.out.println("No items purchased.");
            input.close();
            return;
        }

        // Bonus 1: 5% discount for 5 or more units
        // of the same product
        if (mouseCount >= 5) {
            bulkDiscount += mouseCount * mousePrice * 0.05;
        }

        if (keyboardCount >= 5) {
            bulkDiscount += keyboardCount * keyboardPrice * 0.05;
        }

        if (headphonesCount >= 5) {
            bulkDiscount += headphonesCount * headphonesPrice * 0.05;
        }

        if (standCount >= 5) {
            bulkDiscount += standCount * standPrice * 0.05;
        }

        if (monitorCount >= 5) {
            bulkDiscount += monitorCount * monitorPrice * 0.05;
        }

        // Bonus 2: Discount based on subtotal
        double levelDiscount = 0;

        if (subtotal >= 200) {
            levelDiscount = subtotal * 0.15;
        } else if (subtotal >= 100) {
            levelDiscount = subtotal * 0.10;
        } else {
            levelDiscount = 0;
        }

        // Calculate final total
        double totalDiscount = bulkDiscount + levelDiscount;
        double finalTotal = subtotal - totalDiscount;

        // Bonus 3: Display quantities of all products
        System.out.println("\n===== ITEMS PURCHASED =====");
        System.out.println("Mouse: " + mouseCount);
        System.out.println("Keyboard: " + keyboardCount);
        System.out.println("Headphones: " + headphonesCount);
        System.out.println("Laptop Stand: " + standCount);
        System.out.println("Monitor: " + monitorCount);

        // Bonus 4: Find the most purchased product
        String mostPurchased = "Mouse";
        int highestQuantity = mouseCount;

        if (keyboardCount > highestQuantity) {
            highestQuantity = keyboardCount;
            mostPurchased = "Keyboard";
        }

        if (headphonesCount > highestQuantity) {
            highestQuantity = headphonesCount;
            mostPurchased = "Headphones";
        }

        if (standCount > highestQuantity) {
            highestQuantity = standCount;
            mostPurchased = "Laptop Stand";
        }

        if (monitorCount > highestQuantity) {
            highestQuantity = monitorCount;
            mostPurchased = "Monitor";
        }

        System.out.println("\n===== MOST PURCHASED PRODUCT =====");
        System.out.println("Most purchased product: " + mostPurchased);
        System.out.println("Quantity: " + highestQuantity);

        // Bonus 5: Reward for purchasing 10 or more items
        if (totalItems >= 10) {
            System.out.println(
                    "You earned a $10 coupon for your next visit!"
            );
        }

        // Checkout summary
        System.out.println("\n===== CHECKOUT =====");
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Bulk discount: -$" + bulkDiscount);
        System.out.println("Level discount: -$" + levelDiscount);
        System.out.println("Total discount: -$" + totalDiscount);
        System.out.println("Total to pay: $" + finalTotal);

        // Payment validation
        double payment;

        do {
            System.out.println("Enter payment amount:");
            payment = input.nextDouble();

            if (payment < finalTotal) {
                System.out.println("Insufficient payment. Try again.");
            }
        } while (payment < finalTotal);

        double change = payment - finalTotal;

        // Final receipt
        System.out.println("\n===== RECEIPT =====");

        if (mouseCount > 0) {
            System.out.println("Mouse x " + mouseCount +
                    " = $" + (mouseCount * mousePrice));
        }

        if (keyboardCount > 0) {
            System.out.println("Keyboard x " + keyboardCount +
                    " = $" + (keyboardCount * keyboardPrice));
        }

        if (headphonesCount > 0) {
            System.out.println("Headphones x " + headphonesCount +
                    " = $" + (headphonesCount * headphonesPrice));
        }

        if (standCount > 0) {
            System.out.println("Laptop Stand x " + standCount +
                    " = $" + (standCount * standPrice));
        }

        if (monitorCount > 0) {
            System.out.println("Monitor x " + monitorCount +
                    " = $" + (monitorCount * monitorPrice));
        }

        System.out.println("----------------------");
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Bulk discount: -$" + bulkDiscount);
        System.out.println("Level discount: -$" + levelDiscount);
        System.out.println("Total discount: -$" + totalDiscount);
        System.out.println("Final total: $" + finalTotal);
        System.out.println("Payment: $" + payment);
        System.out.println("Change: $" + change);
        System.out.println("======================");
        System.out.println("Thank you for shopping!");

        input.close();
    }
}


