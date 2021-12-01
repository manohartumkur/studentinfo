
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;

public class Conversion {

	public static void main(String[] args) {
		
		System.out.println("Please enter the Text Filename");
		
		Scanner sc1=new Scanner(System.in);
		
		String fileName=sc1.nextLine();
		

		String path = System.getProperty("user.dir");
		System.out.println(System.getProperty("file.separator"));

		File file = new File(path + System.getProperty("file.separator") + fileName + ".txt");
		if (!(file.isFile())) {
			System.out.println("The file doesnot exist in the path");
		}

		try {
			// the file to be opened for reading
			FileInputStream fis = new FileInputStream(fileName + ".txt");
			Scanner sc = new Scanner(fis); // file to be scanned
			// returns true if there is another line to read
			FileWriter fw=new FileWriter(new File(fileName+"Converted"+".txt"));
			while (sc.hasNextLine()) {

				String number = sc.nextLine();
				//System.out.println(DigestUtils.shaHex(number)); // returns the line that was skipped
				
				fw.write(DigestUtils.shaHex(number));
				fw.append("\n");
			}
			sc.close(); // closes the scanner
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
