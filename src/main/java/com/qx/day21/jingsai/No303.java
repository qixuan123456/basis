package com.qx.day21.jingsai;

import java.util.*;

/**
 * @author xuan
 * @date 2022/7/24 13:54
 */
public class No303 {



    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if(!set.add(s.charAt(i))){
                return s.charAt(i);
            }
        }
        return 'a';
    }

    public int equalPairs(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(equalPairs(i,j,grid)){
                    ans++;
                }
            }
        }
        return ans;
    }

    public boolean equalPairs(int i,int j,int[][] grid){
        for (int k = 0; k <grid.length; k++) {
            if(grid[i][k]!=grid[k][j]){
                return false;
            }
        }
        return true;
    }

//["FoodRatings","highestRated","highestRated","changeRating","highestRated","highestRated","changeRating","highestRated","highestRated","changeRating","highestRated","highestRated"]
//[[["mpsaowuxj","vpjohob","fn","clvugdxsaf","rujps","conjq","rpqdawz"],["shrkuo","shrkuo","shrkuo","shrkuo","shrkuo","shrkuo","shrkuo"],[3,7,1,8,4,16,11]],["shrkuo"],["shrkuo"],["rpqdawz",13],["shrkuo"],["shrkuo"],["conjq",15],["shrkuo"],["shrkuo"],["rujps",17],["shrkuo"],["shrkuo"]]

    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(new String[]{"mpsaowuxj", "vpjohob", "fn", "clvugdxsaf", "rujps", "conjq", "rpqdawz"},
                new String[]{"shrkuo", "shrkuo", "shrkuo", "shrkuo", "shrkuo", "shrkuo", "shrkuo"},
                new int[]{3, 7, 1, 8, 4, 16, 11});
        foodRatings.highestRated("shrkuo");
        foodRatings.highestRated("shrkuo");
        foodRatings.changeRating("rpqdawz",13);
        foodRatings.highestRated("shrkuo");
        foodRatings.highestRated("shrkuo");
        foodRatings.changeRating("conjq",15);
        foodRatings.highestRated("shrkuo");
        foodRatings.highestRated("shrkuo");
        foodRatings.changeRating("rujps",17);
        foodRatings.highestRated("shrkuo");
        foodRatings.highestRated("shrkuo");
    }
    public static class FoodRatings {
        Map<String,A> map = new HashMap<>();
        Map<String,PriorityQueue<A>> map1 = new HashMap<>();
        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                A a = new A(foods[i],cuisines[i],ratings[i]);

                map.put(foods[i],a);

                PriorityQueue<A> p = map1.getOrDefault(cuisines[i],new PriorityQueue<>((c,b)->{
                    if(c.rating==b.rating){
                        return c.food.compareTo(b.food);
                    }else {
                        return b.rating-c.rating;
                    }
                }));
                p.add(a);
                map1.put(cuisines[i],p);
            }
        }

        public void changeRating(String food, int newRating) {
            A a = map.get(food);
            PriorityQueue<A> p = map1.get(a.cuisine);
            p.remove(a);
            a.rating = newRating;
            p.add(a);
        }

        public String highestRated(String cuisine) {
            PriorityQueue<A> p = map1.get(cuisine);
            A a = p.poll();
            p.add(a);
            return a.food;
        }
        static class A{
            String food;
            String cuisine;
            int rating;

            public A(String food, String cuisine, int rating) {
                this.food = food;
                this.cuisine = cuisine;
                this.rating = rating;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                A a = (A) o;
                return rating == a.rating && Objects.equals(food, a.food) && Objects.equals(cuisine, a.cuisine);
            }

            @Override
            public int hashCode() {
                return Objects.hash(food, cuisine, rating);
            }
        }
    }

    public long countExcellentPairs(int[] nums, int k) {
        long ans = 0L;
        int b = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                continue;
            }
            int n = 0;
            int a = nums[i];
            while(a>0){
                n+=(a&1);
                a = a>>1;
            }
            if(2*b==k){
                b++;
            }
            map.put(nums[i],n);
        }
        int[] ints = map.values().stream().sorted().mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < ints.length; i++) {
            int a = k-ints[i];
            int left = 0,right = ints.length;
            while(left<=right){
                int mid = (left+right)>>1;
                if(ints[mid]<a){
                    left = mid+1;
                }else if(ints[mid]>=a){
                    right = mid;
                }
            }
            ans+= (ints.length-left);
        }
        return ans-b;
    }
}
