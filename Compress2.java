import java.util.ArrayList;
import java.util.List;

public class Compress2 {

    public static void main(String[] args) {
        String[] arr = {"a","a","b","b","c","c","c"};
        List<Object> list = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                list.add(arr[i]);
                list.add(count);
            } else if (arr[i].equals(arr[i + 1])) {
                count++;
            } else {
                list.add(arr[i]);
                list.add(count);
                count = 1;
            }
        }
        System.out.println(list);
    }


}