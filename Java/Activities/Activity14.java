package Activities;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Activity14 {

    public static void main(String[] args) throws IOException {

        String filepath = "src/main/resources/Activity14Input.txt";
        //create file
        File file = new File(filepath);
        boolean fstat = file.createNewFile();

        //check if file created
        if (fstat == true){
            System.out.println("File created.");
        }
        else{
            System.out.println("File not created.");
        }

        //read data from file
        File filereader = FileUtils.getFile(filepath);
        System.out.println("Contents of file are: " + FileUtils.readFileToString(filereader));

        //create directory and copy file
        File destDir = new File("Activity_resources");
        FileUtils.copyFileToDirectory(file, destDir);

        //Get file from new directory
        File newFile = FileUtils.getFile(destDir, "Activity14Input.txt");
        //Read data from file
        String newFileData = FileUtils.readFileToString(newFile, "UTF8");
        //Print it
        System.out.println("Data in new file: " + newFileData);

    }
}
