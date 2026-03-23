package src.FireDrillFour;
import java.util.*;

public class AssignmentThree {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Map<String, List<String>> zones = new HashMap<>();

        zones.put("North Central", Arrays.asList("Benue", "FCT", "Kogi", "Kwara", "Nasarawa", "Niger", "Plateau"));
        zones.put("North East", Arrays.asList("Adamawa", "Bauchi", "Borno", "Gombe", "Taraba", "Yobe"));
        zones.put("North West", Arrays.asList("Kaduna", "Katsina", "Kano", "Kebbi", "Sokoto", "Jigawa", "Zamfara"));
        zones.put("South East", Arrays.asList("Abia", "Anambra", "Ebonyi", "Enugu", "Imo"));
        zones.put("South-South", Arrays.asList("Akwa-Ibom", "Bayelsa", "Cross-River", "Delta", "Edo", "Rivers"));
        zones.put("South West", Arrays.asList("Ekiti", "Lagos", "Osun", "Ondo", "Ogun", "Oyo"));

        System.out.print("Enter a state: ");
        String input = scanner.nextLine().trim();

        String result = findZone(zones, input);

        if (result != null) {
            System.out.println(input + " belongs to " + result);
        } else {
            System.out.println("State not found.");
        }
    }

    public static String findZone(Map<String, List<String>> zones, String state) {

        for (Map.Entry<String, List<String>> entry : zones.entrySet()) {
            for (String s : entry.getValue()) {
                if (s.equalsIgnoreCase(state)) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }
}
