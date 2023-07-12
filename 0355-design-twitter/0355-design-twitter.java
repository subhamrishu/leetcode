class Twitter {
    
    Map<Integer, Set<Integer>> userList;
    Map<Integer, ArrayList<int[]>> tweets;
    int currTime;

    public Twitter() {
        userList = new HashMap<>();
        tweets = new HashMap<>();
        currTime = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        currTime += 1;
        if (!tweets.containsKey(userId)){
            tweets.put(userId, new ArrayList<>());
        }
        tweets.get(userId).add(new int[]{currTime, tweetId});
    }
    
    public void getTweetsFromUser(int userId, PriorityQueue<int[]> feed){
        ArrayList<int[]> pqUser  = tweets.get(userId);
        if (pqUser == null)
            return;
        int count = 0, n = pqUser.size()-1;
        while (n >= 0 && count < 10){
            feed.offer(pqUser.get(n--));
            count++;
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> feed = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        List<Integer> sol = new ArrayList<>();
        
        getTweetsFromUser(userId, feed);
        
        if (userList.containsKey(userId)){
            for (int user: userList.get(userId)){
                getTweetsFromUser(user, feed);
            }
        }
        
        for (int i = 0; i < 10 && !feed.isEmpty(); i++){
            sol.add(feed.poll()[1]);
        }
        return sol;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!userList.containsKey(followerId)){
            userList.put(followerId, new HashSet<>());
        }
        userList.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!userList.containsKey(followerId)){
            return;
        }
        userList.get(followerId).remove(followeeId);
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