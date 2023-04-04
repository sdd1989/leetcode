import java.util.Arrays;

public class Compress {
    
    public static void main(String[] args) {
        String[] strs = new String[]{"a", "a", "b", "b", "c", "c", "c"};
        Compress compress = new Compress();
        String[] result = compress.compress(strs);
        System.out.println(Arrays.toString(result));
    }

    public String[] compress(String[] strs) {
        int cnt = 1;
        int pre = 0;
        int curr = 0;
        while(curr < strs.length - 1) {
            if (strs[curr].equals(strs[curr + 1])) {
                cnt ++;
            } else {
                for (int j = pre + 2; j < curr && j < strs.length - 1; j ++) {
                    strs[j] = strs[j+1];
                }
                pre = curr = pre + 2;
                if (pre < strs.length - 1) {
                    strs[pre+1] = String.valueOf(cnt);
                }
        
                cnt = 1;
            }
            curr ++;
        }

        return strs;

    }
}
