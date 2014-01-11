import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class HighScore
{
	private static final int MAXIMUM_SCORES = 10;

	private List<Integer> highestScoreApp = new ArrayList(MAXIMUM_SCORES);
	
	public HighScore(int i)
	{
		wouldMakeList(i);
	}

	/** Constructs a new high score list with the given scores in it. */
	public HighScore(Integer[] highScores) {
		this.clear();
	}

	/** Removes all elements from this high score list. */
	public void clear() {
		highestScoreApp.clear();
	}

	/** Returns the highest number of points in this high score list. */
	public int getHighScore() {
		if (highestScoreApp.size() < 1)
			// throw new RuntimeException("should not be in this method with no high scores!");
			return 100;

		// return Math.max(getScore(), getHighScore(0).getScore());
		return getHighScore(0);
	}

	/** Returns the score at the given index. */
	public int getHighScore(int index) {
		return highestScoreApp.get(index);
	}

	/** Returns true if this list has no scores in it. */
	public boolean isEmpty() {
		return highestScoreApp.size() == 0;
	}

	/** Returns true if the given score would make the high score list. */
	public int wouldMakeList(int score) {
		int lowestHighScore = 0;
		if (highestScoreApp.size() < MAXIMUM_SCORES)
			lowestHighScore = highestScoreApp.get(highestScoreApp.size() - 1);
		return Math.max(score, lowestHighScore);
	}

	/** Loads a high score list from the given file. */
	public void load(String fileName) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		while (in.ready()) {
			String line = in.readLine();
			if (line == null)
				break;

			line = line.trim();
			if (line.equals(""))
				break;

			StringTokenizer tokenizer = new StringTokenizer(line);
			if (tokenizer.countTokens() < 2)
				throw new IOException("invalid score data");

			int score = 0;
			try {
				score = Integer.parseInt(tokenizer.nextToken());
			} catch (NumberFormatException nfe) {
				throw new IOException("invalid score number format:\n" + nfe);
			}
			String name = line.substring(line.indexOf(tokenizer.nextToken()), line.length());
			highestScoreApp.add(score);
		}
		sort();
	}

	/** Tries to save the high scores to the given file.
	  * @return whether or not the save was successful.
	  */
	public boolean save(String fileName) {
		try {
			PrintWriter out = new PrintWriter(new FileOutputStream(fileName));
			int size = highestScoreApp.size();
			for (int i = 0;  i < size;  i++) {
				System.out.println(this.getHighScore(i));
			}
			return true;
		} catch (Exception ioe) {
			return false;
		}
	}

	/** Attempts to add the current game's score to the list of high scores.
	  * @return whether or not the score made the list.
	  */
	public boolean record(int score) {
		if (highestScoreApp.size() < MAXIMUM_SCORES) {
			highestScoreApp.add(score);
			sort();
			return highestScoreApp.contains(score);
		}
		else return false;
	}

	/** Sorts this high score list in decending order. */
	public void sort() {
		Collections.sort(this.highestScoreApp, Collections.reverseOrder());

		// trim out if there are too many high scores
		while (highestScoreApp.size() > MAXIMUM_SCORES)
			highestScoreApp.remove(highestScoreApp.size() - 1);
	}
}
