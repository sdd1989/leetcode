class Solution3 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
        int sum = 0;
        String nStr = Integer.toBinaryString(n);
        for (int i = 0;i < nStr.length(); i++) {
            if (nStr.charAt(i) == '1') {
                sum += 1;
            }
        }
        return sum;
    }
    
}

class Main3 {

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int sum = solution3.hammingWeight(3);
        System.out.println(sum);
    }
}
