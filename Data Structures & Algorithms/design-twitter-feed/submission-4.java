class Twitter {
/*
postTweet(1, 101)   // time = 0
postTweet(2, 201)   // time = 1
postTweet(1, 102)   // time = 2
postTweet(3, 301)   // time = 3
postTweet(2, 202)   // time = 4
postTweet(4, 401)   // time = 5

follow(1, 2)
follow(1, 3)

getNewsFeed(1)

 1， 101， 0
 1， 102， 2
 2， 201， 1
 2， 202， 4
 3， 301， 3
 4， 401， 5

 follow(1,2) ->  
 follow(1,3)


 Straight Forward Solution

 HashMaps + PriorityQueue
 

*/
static class Tweet{
    int id;
    int time;
    Tweet next;
    Tweet(int id, int time){
        this.id = id;
        this.time = time;
    }
}
private Map<Integer, Tweet> users;
private Map<Integer, Set<Integer>> follows;
private int time;
    public Twitter() {
        users = new HashMap<>();
        follows = new HashMap<>();
        time =0;
    }
    
    public void postTweet(int userId, int tweetId) {
            Tweet newTweet = new Tweet(tweetId, time);
            time++;
            if(users.containsKey(userId)){
                newTweet.next = users.get(userId);
            }
            users.put(userId, newTweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
         //add myself
         PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b) -> b.time - a.time); 
         if(users.containsKey(userId)){
            pq.offer(users.get(userId));
         }
         //Add followers
         if(follows.containsKey(userId)){
            for(int followeeId : follows.get(userId)){ //2
                if(users.containsKey(followeeId)){
                     pq.offer(users.get(followeeId));
                }
            }
         }
         List<Integer> res = new ArrayList<>();
         while(!pq.isEmpty() && res.size() < 10){
            Tweet t = pq.poll();
            res.add(t.id);
            if(t.next != null){
                pq.offer(t.next);
            }
         }
         return res;
    }
    
    public void follow(int followerId, int followeeId) {
        //Follow itself
        if(followerId == followeeId){
            return;
        }
         if(!follows.containsKey(followerId)){
            follows.put(followerId, new HashSet<>());
        }
       follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId){
            return;
        }
        if(!follows.containsKey(followerId)){
            return;
        }
         follows.get(followerId).remove(followeeId);
    }
}
