import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("WELCOME TO ROCK SIMULATOR v:1.0");
        runGame(genNew());
    }
    public static String genNew() {
        String rock = "";
        int min = 3;
        int max = 5;
        int r = 0;
        int height = (int)(Math.random() * (max - min + 1)) + min;
        min = 4;
        max = 6;
        int width = (int)(Math.random() * (max - min + 1)) + min;;
        String rockTop = "";
        for (int i = 1; i <= height/2; i++) {
            rockTop = rockTop + " ";
        }
        for (int i = 1; i <= width; i++) {
            rockTop = rockTop + "_";
        }
        rock = rockTop + "\n" + rock;
        for (int i = 1; i <= height; i++ ) {
            min = 1;
            max = 2;
            r = (int)(Math.random() * (max - min + 1)) + min;
            if (r == 1) {
                for (int x = 1; x <= (-1 * i + height)/2; x++ ) {
                    rock = rock + " ";
                }
                rock = rock + "|";
            } else {
                for (int x = 1; x <= (-1 * i + height)/2; x++ ) {
                    rock = rock + " ";
                }
                rock = rock + "/";
            }
            for (int x = 1; x <= width; x++ ) {
                if (i == height) {
                    rock = rock + "_";
                } else {
                rock = rock + " ";
                }
            }
            r = (int)(Math.random() * (max - min + 1)) + min;
            if (r == 1) {
                rock = rock + "|";
            } else {
                rock = rock + "\\";
            }
            width = width + 1;
            rock = rock + "\n";
        }
        return(rock);
    }
    public static String runGame(String inputRock) {
        String options = "";
        Scanner s = new Scanner (System.in);
        Boolean running = true;
        int action = 0;
        int rockAge = 1;
        int subAction = 0;
        int subSubAction = 0;
        do {
            System.out.println("Here is your rock:");
            System.out.println(inputRock);
            System.out.println("Your rock is " + rockAge + " years old.");
            System.out.println("What would you like to do?\n[1]:Feed Rock   [2]:Play With Rock   [3]:Ignore Rock   [4]:Destroy Rock");
            action = s.nextInt();
            if (action == 1) {
                System.out.println("What would you like to feed your rock?\n[1]:Rock Snacks [2]:Water");
                subAction = s.nextInt();
                if (subAction == 1) {
                    System.out.println("How many ounces of rock snacks will you feed your rock?");
                    subSubAction = s.nextInt();
                    if (subSubAction > rockAge) {
                        System.out.println("Your rock has died, it couldn't handle that much food.");
                        running = false;
                    }
                }
                if (subAction == 2) {
                    System.out.println("How many ounces of water will you feed your rock?");
                    subSubAction = s.nextInt();
                    if (subSubAction > rockAge) {
                        System.out.println("Your rock has died, it couldn't handle that much water.");
                        running = false;
                    }
                }
            }
            if (action == 4) {
                System.out.println("Your rock has been destroyed.");
                running = false;
            }
            if (action == 2) {
                System.out.println("Playing hasn't been added yet, but it is in the works.");
            }
            rockAge++;
        } while (running == true);
        s.close();
        return(options);
    }
}
