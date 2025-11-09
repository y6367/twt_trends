import java.util.*;
import java.io.*;

public class TweetBot {
    // TODO: Your Code Here
    private List<Tweet> tweets;
    private List<Tweet> viewedTweets = new ArrayList<>();

    public TweetBot(List<Tweet> tweets) {
        if (tweets.size() < 1) {
            throw new IllegalArgumentException();
        }
        this.tweets = new ArrayList<>();
        for (Tweet tweet : tweets) {
            this.tweets.add(tweet);
        }
    }

    public int numTweets() {
        return tweets.size() + viewedTweets.size();
    }

    public void addTweet(Tweet tweet) {
        this.tweets.add(tweet);
    }

    public Tweet nextTweet() {
        if (tweets.isEmpty()) {
            throw new IllegalStateException();
        }
        Tweet result = tweets.remove(0);
        viewedTweets.add(result);
        return result;
    }

    public void removeTweet(Tweet tweet) {
        if (!viewedTweets.contains(tweet)) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < viewedTweets.size(); i++) {
            if (viewedTweets.get(i).equals(tweet)) {
                viewedTweets.remove(i);
            }
        }
    }

    public void reset() {
        int size = viewedTweets.size();
        for (int i = 0; i < size; i++) {
            tweets.add(i, viewedTweets.remove(0));
        }
    }
}   