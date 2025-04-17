package HeapsAndPriorityQueue;

import java.util.*;

class Twitter {
    private Map<Integer, Set<Integer>> followingMap;
    private Map<Integer, List<Tweet>> tweetsMap;
    private int timestamp;

    private class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    public Twitter() {
        followingMap = new HashMap<>();
        tweetsMap = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweetsMap.putIfAbsent(userId, new ArrayList<>());
        tweetsMap.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

        // Add own tweets
        if (tweetsMap.containsKey(userId)) {
            for (Tweet tweet : tweetsMap.get(userId)) {
                pq.offer(tweet);
            }
        }

        // Add tweets from followees
        Set<Integer> followees = followingMap.getOrDefault(userId, new HashSet<>());
        for (int followeeId : followees) {
            if (tweetsMap.containsKey(followeeId)) {
                for (Tweet tweet : tweetsMap.get(followeeId)) {
                    pq.offer(tweet);
                }
            }
        }

        // Get top 10 tweets
        List<Integer> res = new ArrayList<>();
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            res.add(pq.poll().tweetId);
            count++;
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // can't follow yourself
        followingMap.putIfAbsent(followerId, new HashSet<>());
        followingMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followingMap.containsKey(followerId)) {
            followingMap.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */