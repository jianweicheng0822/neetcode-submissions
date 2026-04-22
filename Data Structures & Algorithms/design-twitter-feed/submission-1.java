
/*
System design problem:

post tweet, follow/unfollow, view the 10 most recent tweets

Users and tweets are uniquely identified by their ids


post tweet(int userId, int tweetId)


Users table              followers       tweet table
                          followerId
userID -> primary key     followeeId       tweetId
tweetId -> foreign key

I can use a hashmap to store the users, where each user maps to their own tweet list with timestamp.
For the relationship between the users, I can use another map to do it.

Map<Integer, Tweet> users;
Map<Integer, Integer> followers;

I can use PQ to find most recent 10 tweets from thsi user and user's realationship.
But adding all the tweets is kind wasting time.
instead of using linked list to design a tweet object. and we just need merge k sorted linkedlist
with pq. Tweet{ int id int time Tweet next

a user can follow many users.

1. can user follow itself? no
2. can user follow the same people twice? no
}
*/

class Twitter {
    static class Tweet {
        int id;
        int time;
        Tweet next;
        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
    Map<Integer, Tweet> users;
    Map<Integer, Set<Integer>> followers;
    private int time;
    public Twitter() {
        users = new HashMap<>();
        followers = new HashMap<>();
        time =0;
    }

    public void postTweet(int userId, int tweetId) {
        Tweet head = users.get(userId); // find the current Tweet
        Tweet newTweet = new Tweet(tweetId, time); // a new Tweet
        newTweet.next = head; // make a newTweet as first node
        time++; // add the time
        users.put(userId, newTweet);// post it 
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b) -> b.time - a.time);
        if(users.containsKey(userId)){
            if(users.get(userId) != null){
            pq.offer(users.get(userId));
            }
        }
        if(followers.containsKey(userId)){
            for(int i : followers.get(userId)){
                if(users.containsKey(i)){
                    if(users.get(i)!= null){
                          pq.offer(users.get(i));
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty() && res.size() < 10){
            Tweet cur = pq.poll();
            res.add(cur.id);
            if(cur.next != null){
                pq.offer(cur.next);
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        //Avoid to follow itself
        if(followerId == followeeId){
            return;
        }
        if(!followers.containsKey(followerId)){
            followers.put(followerId, new HashSet<>());
        }
        followers.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        //avoid to unfollow itself
         if(followerId == followeeId){
            return;
        }
        //Nothing happened
          if(!followers.containsKey(followerId)){
             return;
        }
        //Find it
        followers.get(followerId).remove(followeeId);
    }
}
