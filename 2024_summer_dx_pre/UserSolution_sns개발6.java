package com.algo.swea_2024_dx_pre;

import java.util.*;

class UserSolution_sns개발6 {
    static final int MAXL = 5;
    static final int MAXF = 10;

    static int[][] friends;
    static int[] list;

    public void init(int N) {
        friends = new int[N + 1][N + 1];
        System.out.println("init");
    }

    public void add(int id, int F, int ids[]) {
        for (int i = 0; i < F; i++) {
            friends[id][ids[i]] = 1;
            friends[ids[i]][id] = 1;
        }
        System.out.println(id+"add"+F);
    }

    public void del(int id1, int id2) {
        friends[id1][id2] = 0;
        friends[id2][id1] = 0;
        System.out.println(id1+"del"+id2);
    }

    public int recommend(int id, int list[]) {
        List<Integer> friendsOfId = new ArrayList<>();
        Map<Integer, Integer> recommendedFriendsAndMutualFriendCount = new HashMap<>();
        System.out.println("recommend to"+id);

        for (int i = 0; i < friends.length; i++) {
            if (friends[id][i] == 1) {
                friendsOfId.add(i);
            }
        }

        //만약 친구가 x
        if(friendsOfId.isEmpty())
            return 0;

        //친구 id, 함께 아는 친구 수 저장
        for (int i = 0; i < friendsOfId.size(); i++) {
            for (int j = 0; j < friends[i].length; j++) {
                if (friends[id][j] == 0 && friends[friendsOfId.get(i)][j] == 1 && id != j) {
                    if (recommendedFriendsAndMutualFriendCount.containsKey(j)) {
                        recommendedFriendsAndMutualFriendCount.put(j, recommendedFriendsAndMutualFriendCount.get(j)+1);
                    } else {
                        recommendedFriendsAndMutualFriendCount.put(j, 1);
                    }
                }
            }
        }

        System.out.println(recommendedFriendsAndMutualFriendCount);

        //1. 함께 아는 친구가 많은지( value 내림차순 )
        List<Integer> recommendedFriends = new ArrayList<>(recommendedFriendsAndMutualFriendCount.keySet());
        recommendedFriends.sort((o1, o2) -> recommendedFriendsAndMutualFriendCount.get(o2).compareTo(recommendedFriendsAndMutualFriendCount.get(o1)));
        //2. id가 작은지 ( key 오름차순 )
        //Collections.sort(recommendedFriends);

        System.out.println(recommendedFriends);

        //최대 5명. list[]에 추천되는 사용자 id 반환
        //list[] -> recommendedFriendsArray 이렇게 하면 안되는디 왜 ㅠㅠ?
        if (recommendedFriends.size() <= 5) {
            this.list = recommendedFriends.stream().mapToInt(Integer::intValue).toArray();
            return list.length;
        } else {
            Object objectArray = Arrays.copyOfRange(recommendedFriends.toArray(), 0, 5);
            this.list = (int[]) objectArray;
            return list.length;
        }
    }
}
