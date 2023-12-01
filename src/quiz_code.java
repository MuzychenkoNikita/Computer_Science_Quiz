import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class quiz_code {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Write down your name: ");
        String name = console.nextLine();
        System.out.println("Write down your surname: ");
        String surname = console.nextLine();
        int score = 0;



        System.out.println("What does LAN stand for?\n   1.Local Air Network\n   2.Local Area Network\n   3.Landline Area Network\n   4.Localised Area Network");
        if (console.nextInt() == 2){
            score++;
            System.out.println("correct!");
        }
        else {
            System.out.println("not correct!");
        }

        System.out.println("What does WAN stand for?\n   1.Wide Area Network\n   2.While Air Network\n   3.Wide Air Network\n   4.Which Area Network");
        if (console.nextInt() == 1){
            score++;
            System.out.println("correct!");
        }
        else {
            System.out.println("not correct!");
        }

        System.out.println("Which of these is most likely to use a WAN?\n   1.School\n   2.University\n   3.Multi-National Company\n   4.Local Company");
        if (console.nextInt() == 3){
            score++;
            System.out.println("correct!");
        }
        else {
            System.out.println("not correct!");
        }

        System.out.println("In a  LAN every computer has to be managed individually\n   1.True\n   2.False");
        if (console.nextInt() == 2){
            score++;
            System.out.println("correct!");
        }
        else {
            System.out.println("not correct!");
        }

        System.out.println("Which type of Network connects devices in the range of a person?\n   1.Local Area Network\n   2.Personal Area Network\n   3.Virtual Private Network\n   4.Wide Area Network");
        if (console.nextInt() == 2){
            score++;
            System.out.println("correct!");
        }
        else {
            System.out.println("not correct!");
        }

        System.out.println("In a LAN all files are shared between the computers on in the network\n   1.True\n   2.False");
        if (console.nextInt() == 1){
            score++;
            System.out.println("correct!");
        }
        else {
            System.out.println("not correct!");
        }


        System.out.println("You have completed the quiz\nYour score is:   " + score + " points");
        user_data(name, surname, score);
        top_score();
    }

    public static void user_data(String name, String surname, int score){
        try {
            FileWriter writer = new FileWriter("src/data/user_data/top_score.txt", true);
            writer.append(name).append(" ").append(surname).append("\n").append(String.valueOf(score)).append("\n");
            writer.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void top_score(){
        String filePath = "src/data/user_data/top_score.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            ArrayList<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();

            ArrayList<String> top_array = new ArrayList<>();
            for(int a = 0; a < 5; a++){
                if (lines.isEmpty()) {
                    return; //empty lines check
                }

                int highestValue = Integer.MIN_VALUE;
                int indexToRemove = -1;

                for (int i = 1; i < lines.size(); i = i + 2) {
                    int currentValue = Integer.parseInt(lines.get(i));
                    if (currentValue > highestValue) {
                        highestValue = currentValue;
                        indexToRemove = i;
                    }
                }

                if (indexToRemove != -1) {
                    // Remove the line with the highest value
                    top_array.add(lines.get(indexToRemove - 1));
                    top_array.add(lines.get(indexToRemove));
                    lines.remove(indexToRemove);
                    lines.remove(indexToRemove - 1);
                }
            }
            for(int i = 0; i < top_array.size(); i++){
                System.out.println(top_array.get(i));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
