package com.laioffer2022;

public class CountAndSay {
    // count how many continue single number and append it
    public static String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int last = -1;
        while (n != 0) {
            int digit = n % 10;
            if (last == -1) {
                // means start
                sb.append(digit);
                last = digit;
                cnt++;
            } else if (digit == last) {
                // not start, need to compare with the last digit
                cnt++;
            } else {
                // append the count
                sb.append(cnt);
                // reset the digit
                sb.append(digit);
                last = digit;
                cnt = 1;
            }
            n = n / 10;
        }
        sb.append(cnt);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        int input = 122333;
        String res = CountAndSay.countAndSay(input);
        System.out.println(res);
//        Assert.check(res.equals(112233));
    }
}
