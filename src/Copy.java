import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {
	public static void main(String[] args) throws IOException {
		int numberOfBytes = 0;
 
		// Check usage
		if (args.length < 2) {
			System.out.println("usage: java Copy [source file] [target file] ");
			System.exit(1);
		}

		// Check if the source file exists
		File sourceFile = new File(args[0]);
		if (!(sourceFile.exists())) {
			System.out.println("File " + sourceFile + " does not existed");
			System.exit(2);
		}

		// Check if the target file exists
		File targetFile = new File(args[1]);
		if (targetFile.exists()) {
			System.out.println("File " + targetFile + " already existed");
			System.exit(3);
		}

		try (
				// Create BufferedInputStream to read data from the source file
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
				// Create BufferedOutputStream to write data to the target file
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFile));) {
			int value; 
			while ((value = bis.read()) != -1) {
				bos.write((byte) value);
				numberOfBytes++;
			}
		}
System.out.println("Copied successfully");
System.out.println("Number of copied bytes: " + numberOfBytes);
	}
}
