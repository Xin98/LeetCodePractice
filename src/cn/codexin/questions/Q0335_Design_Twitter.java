package cn.codexin.questions;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by xinGao 2020/4/13
 */

public class Q0335_Design_Twitter {

    static class Twitter {
        int time;
        class MyData{
            int id;
            int timestamp;
            public MyData(int id, int timestamp){
                this.id = id;
                this.timestamp =timestamp;
            }
        }
        private HashMap<Integer, Deque<MyData>> message;
        private HashMap<Integer, HashSet<Integer>> follows;
        /** Initialize your data structure here. */
        public Twitter() {
            message = new HashMap<>();
            follows = new HashMap<>();
            time = 0;
        }
        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            if(!message.containsKey(userId)){
                message.putIfAbsent(userId, new LinkedList<>(Arrays.asList(new MyData(tweetId, time++))));
            }
            else {
                //维持大小为10的双端队列
                Deque<MyData> myData = message.get(userId);
                myData.addFirst(new MyData(tweetId, time++));
                if(message.get(userId).size() > 10) myData.removeLast();
            }
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            //优先级队列，插入时，时间最迟的排前面
            Queue<MyData> newsData = new PriorityQueue<>((x,y)->y.timestamp-x.timestamp);
            if(!message.containsKey(userId) && !follows.containsKey(userId)) return new LinkedList<>();
            if(message.containsKey(userId)) {
                message.get(userId).forEach(x->newsData.offer(x));
            }
            if(follows.containsKey(userId)){
                for (Integer follow : follows.get(userId)) {
                    if(message.containsKey(follow)) {
                        message.get(follow).forEach(x -> newsData.offer(x));
                    }
                }
            }
            List<Integer> news = new LinkedList<>();
            int count = 0;
            while(!newsData.isEmpty()){
                if(count++ == 10) break;
                news.add(newsData.poll().id);
            }
            //List<Integer> news = newsData.stream().map(x -> x.id).collect(Collectors.toList());
            return news;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if(followeeId == followerId) return;
            if(!follows.containsKey(followerId)){
                follows.putIfAbsent(followerId, new HashSet<>(Arrays.asList(followeeId)));
            }
            else {
                follows.get(followerId).add(followeeId);
            }
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if(followeeId == followerId) return;
            if(follows.containsKey(followerId)){
                follows.get(followerId).remove(followeeId);
                if(follows.get(followerId).isEmpty()) follows.remove(followerId);
            }
        }
    }
}
