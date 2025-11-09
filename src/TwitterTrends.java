import java.util.*;
import java.io.*;

public class TwitterTrends {
    private TweetBot bot;
    // TODO: Your Code Here
    public TwitterTrends(TweetBot bot) {
        this.bot = bot;
    }

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

    public String mostTrendingTweet() {
        Tweet result = null;
        // count contains likes + retweets
        int resultCount = 0;

        while (bot.numTweets() > 0) {
            Tweet current = bot.nextTweet();
            int count = current.getLikes() + current.getRetweets();
            if (count > resultCount) {
                result = current;
            }
        }
        bot.reset();
        return result.toString();
    }
}