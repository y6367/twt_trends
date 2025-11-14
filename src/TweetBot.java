// Joewah Yu
// 11/10/2025
// CSE 122
// C2: Twitter Trends
// TA: Katharine Zhang

import java.util.*;
import java.io.*;

// This is a class is used to analyze tweets in our program. It takes in tweets to allow us to
// simulate viewing tweets that show up in our feed.
public class TweetBot {
    // TODO: Your Code Here
    private List<Tweet> tweets;
    private List<Tweet> viewedTweets = new ArrayList<>();

    // This constructor takes the given tweets and passes them into our TweetBot. This happens
    // only if we are passing in more than 1 tweet.
    // Exception: If the amount of tweets we are passing in is less than 1, then throw
    // IllegalArgumentException
    // Returns: Does not return anything
    // Parameters:
    // - tweets: a collection of our tweets.
    public TweetBot(List<Tweet> tweets) {
        if (tweets.size() < 1) {
            throw new IllegalArgumentException();
        }
        this.tweets = new ArrayList<>();
        for (Tweet tweet : tweets) {
            this.tweets.add(tweet);
        }
    }

    // This method returns the number of tweets in TweetBot, regardless if the tweets have been
    // viewed or not.
    // Returns: numbers of tweets in total in TweetBot.
    public int numTweets() {
        return tweets.size() + viewedTweets.size();
    }

    // This method adds a tweet to the end of the unviewed tweets.
    // Returns: Does not return anything.
    public void addTweet(Tweet tweet) {
        this.tweets.add(tweet);
    }

    // This method views the next unviewed tweet and adds it to the collection of viewed tweets.
    // This happens only if there are still unviewed tweets.
    // Exception: If the collection of unviewed tweets is empty, then throw IllegalStateException
    // Returns: the next tweet
    public Tweet nextTweet() {
        if (tweets.isEmpty()) {
            throw new IllegalStateException();
        }
        Tweet result = tweets.remove(0);
        viewedTweets.add(result);
        return result;
    }

    // This method deletes a selected tweet from the collection of viewed tweets. This only
    // happens if we viewed the selected tweet already.
    // Exception: If the we haven't viewed the tweet yet, then throw IllegalArgumentException
    // Returns: Does not return anything
    // Parameters:
    // - tweet: a tweet we want to remove
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

    // This method makes our viewed tweets unviewed again, in the same order when tweets
    // were passed.
    // Returns: Does not return anything
    public void reset() {
        int size = viewedTweets.size();
        for (int i = 0; i < size; i++) {
            tweets.add(i, viewedTweets.remove(0));
        }
    }
}   