import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int checkBed(List<String> currentTraffic, String guest) {
        int counter = 0;
        //ha van hely
        if (currentTraffic.contains(null)) {
            //nincs benne
            if (!currentTraffic.contains(guest)) {
                currentTraffic.set(currentTraffic.indexOf(null), guest);
            } else {
                //benne van mar
                currentTraffic.set(currentTraffic.indexOf(guest), null);
            }
            //ha nincs hely
        } else if (!currentTraffic.contains(null)) {
            if (currentTraffic.contains(guest)) {
                currentTraffic.set(currentTraffic.indexOf(guest), null);
            } else {
                //benne van mar
                ++counter;
            }
        }
        return counter;
    }

    public static void main(String[] args) {

        List<List<String>> input = new ArrayList<>();

        /////////////////////
        List<String> inputLines1 = new ArrayList<>();
        inputLines1.add("2");
        inputLines1.add("ABBAJJKZKZ");
        input.add(inputLines1);

        List<String> inputLines2 = new ArrayList<>();
        inputLines2.add("3");
        inputLines2.add("GACCBDDBAGEE");
        input.add(inputLines2);

        List<String> inputLines3 = new ArrayList<>();
        inputLines3.add("3");
        inputLines3.add("GACCBGDDBAEE");
        input.add(inputLines3);

        List<String> inputLines4 = new ArrayList<>();
        inputLines4.add("1");
        inputLines4.add("ABCBCA");
        input.add(inputLines4);

        List<String> inputLines5 = new ArrayList<>();
        inputLines5.add("0");
        input.add(inputLines5);

        ///////////////////////Input transfer

        String result = "";
        ///belepunk a napba

        for (List<String> inputLines : input) {

            Integer availableBeds = Integer.parseInt(inputLines.get(0));

            if (inputLines.size() < 2) {
                break;
            }
            String guestList = inputLines.get(1);

            String[] beds = new String[availableBeds];
            int missedGuest = 0;

            List<String> currentTraffic = Arrays.asList(beds);

            for (int i = 0; i < guestList.length(); i++) {
                String currentGuest = String.valueOf(guestList.charAt(i));
                missedGuest += checkBed(currentTraffic, currentGuest);
                System.out.println(missedGuest);
            }
        }
    }
}


