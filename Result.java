/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pcluff
 */
public class Result 
{
<<<<<<< .mine
	private int highScore = 0;

	public static void ReadHighScoreFile()) throws IOException{
		ReadWriteTextFileJDK7 text = new ReadWriteTextFileJDK7();
    
    	//treat as a small file

		List<Integer> lines = text.readSmallTextFile(FILE_NAME);
    	log(lines);
    	lines.add(highScore);
    	text.writeSmallTextFile(lines, FILE_NAME);

    	final static String FILE_NAME = "C:\\Temp\\HighScore.txt";
		final static String OUTPUT_FILE_NAME = "C:\\Temp\\HighScore.txt";
	
		List<String> readSmallTextFile(String aFileName) throws IOException
		{
	    	Path path = Paths.get(aFileName);
	    	return Files.readAllLines(path, ENCODING);
		}
=======
	public Result()
	{
		//HighScore hs = new HighScore();
>>>>>>> .r76
		
		
		}
	}
}