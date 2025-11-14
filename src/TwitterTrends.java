// Joewah Yu
// 11/10/2025
// CSE 122
// C2: Twitter Trends
// TA: Katharine Zhang

import java.util.*;
import java.io.*;

// This class analyzes tweets in TweetBot. It takes in tweets and gives us more information on
// these tweets.

public class TwitterTrends {
    private TweetBot bot;
    // TODO: Your Code Here

    // This constructor takes in tweets from the TweetBot and passes those tweets into our
    // TweetBot so we can further analyze the tweets.
    // Parameters:
    // - bot: tweets that are going to be further analyzed
    public TwitterTrends(TweetBot bot) {
        this.bot = bot;
    }

    // This method analyzes all the captions in our tweets and return the word that appears the
    // most across all the captions of the tweets. We ignore capitalization but keep punctuation
    // when keeping track of our most frequent word.
    // Returns: the most frequent word
    public String getMostFrequentWord() {
        String result = "";
        int resultCount = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < bot.numTweets(); i++) {
            Scanner lineScan = new Scanner(bot.nextTweet().getCaption());
            while (lineScan.hasNext()) {
                String current = lineScan.next().toLowerCase();
                if (map.containsKey(current)) {
                    map.put(current, map.get(current) + 1);
                } else {
                    map.put(current, 1);
                }
            }
        }

        for (String word : map.keySet()) {
            if (map.get(word) > resultCount) {
                result = word;
                resultCount = map.get(word);
            }
        }
        bot.reset();
        return result;
    }

    // Creative Extension
    // This method takes the tweets and counts the number of likes and retweets each post has and
    // returns the tweet with the most.
    // Returns: the tweet with most likes and tweets
    public Tweet mostTrendingTweet() {
        Tweet result = null;
        // count contains likes + retweets
        int resultCount = 0;
        bot.reset();
        for (int i = 0; i < bot.numTweets(); i++) {
            Tweet current = bot.nextTweet();
            int count = current.getLikes() + current.getRetweets();
            if (count > resultCount) {
                result = current;
            }
        }
        bot.reset();
        return result;
    }
}