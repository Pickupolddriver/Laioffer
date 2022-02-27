package com.laioffer2022;

import java.util.ArrayList;
import java.util.List;

public class CombinationOfCoins {
    public static void main(String[] args) {
        CombinationOfCoins combinationOfCoins = new CombinationOfCoins();
        int[] coins = {25, 10, 5, 2, 1};
        int target = 6;
        List<List<Integer>> res = combinationOfCoins.combinations(target, coins);
        for(List<Integer> currList: res){
            for(int x:currList){
                System.out.print(x + ",");
            }
            System.out.println();
        }
        System.out.println("finished");
    }

    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // Corner case
        if (target == 0 || coins == null || coins.length == 0) {
            return res;
        }
        List<Integer> currCom = new ArrayList<>();
        findAllComb(res, target, coins, currCom, 0);
        return res;
    }

    private void findAllComb(List<List<Integer>> res, int target, int[] coins, List<Integer> currCom, int currIdx) {
        // Terminate condition
        if (currIdx == coins.length) {
            if (target == 0) {
                res.add(new ArrayList<>(currCom));
            }
            return;
        }
        // Expanding Rule
        int maxCount = target / coins[currIdx];
        for (int i = 0; i <= maxCount; i++) {
            currCom.add(i);
            // Go deeper
            findAllComb(res, target - coins[currIdx] * i, coins, currCom, currIdx + 1);
            currCom.remove(currCom.size() - 1);
        }
    }
}
