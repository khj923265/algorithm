package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HashRace {

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        HashRace.solution(participant,completion);

    }

    public static String solution(String[] participant, String[] completion) {

        //효율이 쓰레기
//        ArrayList<String> participants = new ArrayList<>(Arrays.asList(participant));
//        int containedIndex;
//
//        for (String s : completion) {
//            containedIndex = participants.indexOf(s);
//            participants.remove(containedIndex);
//        }
//
//        return participants.get(0);

        Map<String, Integer> hash = new HashMap<>();
        for (String arg : participant) {
            hash.put(arg, hash.getOrDefault(arg, 0) + 1);
        }
        for (String arg : completion){
            hash.put(arg, hash.get(arg) - 1);
        }
        for (String key : hash.keySet()) {
            if (hash.get(key) != 0){ return key; }
        }
        return null;

    }

}
