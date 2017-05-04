import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JumpsInArrayDp {

    private static class DragonArray {
        int JumpsInArrayDp;
        int value;
        List<DragonArray> previous = new ArrayList<DragonArray>();

        DragonArray(int distanceFromStart, int value) {
            this.JumpsInArrayDp = distanceFromStart;
            this.value = value;
        }
    }

    public static void minLengthSeq(ArrayList<Integer> flights) {
        DragonArray[] check = new DragonArray[flights.size()];
        check[0] = new DragonArray(0, 0);
        for (int i = 1; i < flights.size(); i++) {
            check[i] = new DragonArray(Integer.MAX_VALUE, i);
        }

        for (int index = 0; index < flights.size(); index++) {
            try {
                updateHopsInRange(flights, check, index);
            } catch (RuntimeException r) {
                System.out.println("failure");
                return;
            }
        }

        DragonArray end = check[check.length-1];
        List<ArrayList<Integer>> sequences = sequencesTo(end);
        int i=0;
        for (ArrayList<Integer> sequence : sequences) {
        	if(i==(sequences.size()-1)){
        		for(int a : sequence)
        			System.out.print(a+", ");
        		System.out.print("out");
        	}
        	else i++;
        }

        System.out.println();
    }

    private static void updateHopsInRange(ArrayList<Integer> flights, DragonArray[] check, int index_curr) {
        if (check[index_curr].JumpsInArrayDp == Integer.MAX_VALUE) {
            throw new RuntimeException("unreachable DragonArray");
        }

        int range = flights.get(index_curr);
        for (int i = index_curr + 1; i <= (index_curr + range); i++) {
            if (i == flights.size()) return;
            int currentHops = check[i].JumpsInArrayDp; 
            int jumpViaNewDragonArray = check[index_curr].JumpsInArrayDp + 1;

            if (jumpViaNewDragonArray < currentHops) {
                check[i].JumpsInArrayDp = jumpViaNewDragonArray;
                check[i].previous.clear();
                check[i].previous.add(check[index_curr]);
            } else if (jumpViaNewDragonArray == currentHops) { 
                check[i].previous.add(check[index_curr]);
            }
        }
    }

    private static List<ArrayList<Integer>> sequencesTo(DragonArray DragonArray) {
        List<ArrayList<Integer>> sequences = new ArrayList<ArrayList<Integer>>();
        if (DragonArray.previous.size() == 0) {
            sequences.add(new ArrayList<Integer>(Arrays.asList(DragonArray.value)));
        }

        for (DragonArray previ : DragonArray.previous) {
            List<ArrayList<Integer>> sequencesToprevi = sequencesTo(previ);
            for (ArrayList<Integer> sequence : sequencesToprevi) {
                sequence.add(DragonArray.value);
            }

            sequences.addAll(sequencesToprevi);
        }

        return sequences;
    }

    public static void main(String[] args) {
        ArrayList<Integer> array1 = new ArrayList<Integer>();
        Scanner sc= new Scanner(System.in);
        while(sc.hasNextInt()){
        	array1.add(sc.nextInt());
        }
        
        minLengthSeq(array1);
    }

}