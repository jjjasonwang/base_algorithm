package DP;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DFSTemplate{

    List<List<Integer>> res = new LinkedList<>();


    public void getAllSort(int[] nums){
        LinkedList<Integer> track = new LinkedList<>();
        recur(nums,track);
    }

    public void recur(int[] nums, LinkedList<Integer> track){
        if (nums.length == track.size()){
            res.add(new LinkedList(track));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            //排除不合理选择
            if (track.contains(nums[i])){
                continue;
            }
            //做选择
            track.add(nums[i]);
            //进入下一层决策树
            recur(nums,track);
            //撤销选择
            track.removeLast();
        }
    }


    @Test
    public void test(){
        int[] nums = new int[]{1,2,3};
        getAllSort(nums);
        System.out.println(res.toString());
    }
}
