package jajung;

import java.util.Collection;
import java.util.List;

public class IntersectionCheck {
    public static void main(String[] args) {
        List<Integer> listA = List.of(1, 2, 3, 4, 5);
        List<Integer> listB = List.of(3, 5);

        boolean result = solution(listA, listB);

        System.out.println("List A and List B have intersection: " + result);
    }

    public static boolean solution(Collection<Integer> collectionA, Collection<Integer> collectionB) {
        // 이 부분에 구현해주세요!
        return collectionA.containsAll(collectionB);
    }
}
