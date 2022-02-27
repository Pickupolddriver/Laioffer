package com.laioffer2022;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static void main(String[] args) {
        Combination combination = new Combination();
        List<List<Integer>> res = combination.combine(3, 2);
        for (List<Integer> list : res) {
            for (int x : list) {
                System.out.print(x + " , ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        combination(res, new ArrayList<Integer>(), 1, n, k);
        return res;
    }

    public void combination(List<List<Integer>> res, List<Integer> path, int begin, int n, int k) {
        // Terminate condition
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // Expanding Rule
        for (int i = begin; i <= n; i++) {
            path.add(i);
            combination(res, path, i + 1, n, k);
            path.remove(path.size() - 1);
        }
    }
}
