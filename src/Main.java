import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int checkBed(List<String> currentTraffic, String guest) {
        int counter = 0;
        if (currentTraffic.contains(null)) {
            if (!currentTraffic.contains(guest)) {
                currentTraffic.set(currentTraffic.indexOf(null), guest);
            } else {
                currentTraffic.set(currentTraffic.indexOf(guest), null);
            }
        } else if (!currentTraffic.contains(null)) {
            if (currentTraffic.contains(guest)) {
                currentTraffic.set(currentTraffic.indexOf(guest), null);
            } else {
                ++counter;
            }
        }
        return counter;
    }

    public static void main(String[] args) {

        List<List<String>> input = new ArrayList<>();

        //data
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

        for (List<String> inputLines : input) {
            String result;
            Integer availableBeds = Integer.parseInt(inputLines.get(0));

            if (inputLines.size() < 2) {
                break;
            }
            String guestList = inputLines.get(1);

            String[] beds = new String[availableBeds];


            List<String> currentTraffic = Arrays.asList(beds);

            int missedGuest = 0;
            List<String> leftGuests = new ArrayList<>();

            for (int i = 0; i < guestList.length(); i++) {

                String currentGuest = String.valueOf(guestList.charAt(i));
                if (leftGuests.contains(currentGuest)) continue;
                int actualLeftGuest = checkBed(currentTraffic, currentGuest);
                if (actualLeftGuest != 0) {
                    ++missedGuest;
                    leftGuests.add(currentGuest);
                }
            }

            if (missedGuest != 0) {
                result = missedGuest + " customer(s) walked away.";
            } else {
                result = "All customers tanned successfully.";
            }
            System.out.println(result);
        }
    }
}

/*
//to emulator, e.g. https://techiedelight.com/compiler/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

	 static class HandlingDataDTO {

        static List<String> getData(Scanner scanner) {

            List<String> inputInArrayList = new ArrayList<>();

            while (scanner.hasNextLine()) {
                // List<String> inputPerLine = new ArrayList<>();
                Scanner lineScanner = new Scanner(scanner.nextLine());

                while (lineScanner.hasNext()) {
                    inputInArrayList.add(lineScanner.next());
                }

                lineScanner.close();

            }

            return inputInArrayList;
        }
    }

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		List <String> data = HandlingDataDTO.getData(myObj);
		System.out.println(data.get(2));
	}
}
 */