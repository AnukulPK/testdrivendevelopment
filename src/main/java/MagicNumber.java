import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MagicNumber {
    public boolean hasPairExist(List<Integer> list, int magicNumberSum) {
        Map<Integer,Integer> hashMapOfNumber = new HashMap<>();
        list.forEach(prepareHashMapFromList(hashMapOfNumber));

        return list.stream().anyMatch(isNumberExistInHashMap(magicNumberSum, hashMapOfNumber));

    }

    private Predicate<Integer> isNumberExistInHashMap(int magicNumberSum, Map<Integer, Integer> hashMapOfNumber) {
        return number -> {
            int otherNumber = magicNumberSum - number;
            if (hashMapOfNumber.containsKey(otherNumber) && (otherNumber != number || hashMapOfNumber.get(otherNumber) > 1)) {
                return true;
            }
            return false;
        };
    }

    private Consumer<Integer> prepareHashMapFromList(Map<Integer, Integer> hashMapOfNumber) {
        return number -> {
            if (hashMapOfNumber.containsKey(number)) {
                hashMapOfNumber.put(number, hashMapOfNumber.get(number) + 1);
            } else {
                hashMapOfNumber.put(number, 1);
            }
        };
    }
}
