class Tweet {
    int tweetId;
    int time;

    Tweet(int tweetId, int time) {
        this.tweetId = tweetId;
        this.time = time;
    }
}

class Twitter {

    HashMap<Integer, ArrayList<Tweet>> tweet_DB = new HashMap<>();
    HashMap<Integer, HashSet<Integer>> follower = new HashMap<>();

    int timer = 0;

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {

        tweet_DB.computeIfAbsent(userId, k -> new ArrayList<>())
                .add(new Tweet(tweetId, timer++));

        follower.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Tweet> allTweets = new ArrayList<>();

        if (!follower.containsKey(userId))
            return new ArrayList<>();

        for (int followee : follower.get(userId)) {

            ArrayList<Tweet> tweets = tweet_DB.get(followee);

            if (tweets != null)
                allTweets.addAll(tweets);
        }

        allTweets.sort((a, b) -> b.time - a.time);

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < Math.min(10, allTweets.size()); i++) {
            ans.add(allTweets.get(i).tweetId);
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {

        follower.computeIfAbsent(followerId, k -> new HashSet<>())
                .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (followerId == followeeId)
            return;

        if (follower.containsKey(followerId))
            follower.get(followerId).remove(followeeId);
    }
}