package functionalProgramming.level7.A40;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSVToList {
    public static void main(String[] args) {
        String CSV= "1,3,4,5,5,6,7,89,99,8,7,6,5,4,4,3";
        List<Integer>list= Arrays.stream(CSV.split(","))
                .map(Integer  :: parseInt)
                .collect(Collectors.toList());
        System.out.println(list);

    }
}
