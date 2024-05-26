import java.util.ArrayList;
import java.util.HashSet;

public class WorkingSet {

    public static int calculatePageFaults(Process[] processes, int frameNum, int timeWindow) {
        int sizeOfProcess = processes[0].getCalls().length;
        ArrayList<HashSet<Integer>> setsOfPages = new ArrayList<>();
        int sumOfFaults = 0;
        int filledFrames = 0;

        for(int i = 0; i< processes.length; i++ ){
            setsOfPages.add(new HashSet<>());
        }

        for (int i = 0; i < sizeOfProcess; i++) { //number of call
            for (int j = 0; j < processes.length; j++) { //number of process

                ArrayList<Integer> workingSet = new ArrayList<>();

                for (int k = 0; k < timeWindow && i - k >= 0; k++) {
                    if (!workingSet.contains(processes[j].getCalls()[i - k])) {
                        workingSet.add(processes[j].getCalls()[i - k]);
                    }
                }

                filledFrames -= setsOfPages.get(j).size();
                int allocatedFrames = Math.min(frameNum - filledFrames , workingSet.size());
                filledFrames += allocatedFrames;



                if (!setsOfPages.get(j).contains(workingSet.get(0))) {
                    sumOfFaults++;
                }
                HashSet<Integer> newSetOfPages = new HashSet<>();
                for (int k = 0; k < allocatedFrames; k++) {
                    newSetOfPages.add(workingSet.get(k));
                }

                setsOfPages.set(j, newSetOfPages);

            }
        }

        return sumOfFaults;
    }
}
