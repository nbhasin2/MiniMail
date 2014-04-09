import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;


public abstract class Helper {

	
    public static boolean isInternetReachable()
    {
        try {
            //make a URL to a known source
            URL url = new URL("http://www.google.com");

            //open a connection to that source
            HttpURLConnection urlConnect = (HttpURLConnection)url.openConnection();

            //trying to retrieve data from the source. If there
            //is no connection, this line will fail
            Object objData = urlConnect.getContent();

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    
    //Reads the usnername from the data file.
    public static String read_Username() throws IOException
    {
    	String filename = "src\\user.txt";
    	String user ="";
    	String s = "";
    	
    	//Reading
    	FileReader fileread = new FileReader(filename);
    	BufferedReader buff = new BufferedReader(fileread);
    	while((user=buff.readLine())!=null)
    	{
    		s = s + user;
    	}
    	buff.close();
    	
    	return s;
    	
    }
    
    //Reads the password from the data file
    public static String read_Password() throws IOException
    {
       	String filename = "src\\pass.txt";
    	String user ="";
    	String s = "";
    	//Reading
    	FileReader fileread = new FileReader(filename);
    	BufferedReader buff = new BufferedReader(fileread);
    	while((user=buff.readLine())!=null)
    	{
    		s = s + user;
    	}
    	buff.close();
    	
    	return s;
    }
    
    //Writes username to the file
    public static void write_Username(String s) throws IOException
    { 
        String fileName = "src\\user.txt";

  
            FileWriter fileWriter = new FileWriter(fileName);


            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);


            bufferedWriter.write(s);
            

            bufferedWriter.close();
 

    }
    
    //Writes password to the file
    public static void write_Password(String s) throws IOException
    {
    	String fileName = "src\\pass.txt";

    	  
        FileWriter fileWriter = new FileWriter(fileName);


        BufferedWriter bufferedWriter =
            new BufferedWriter(fileWriter);


        bufferedWriter.write(s);
        

        bufferedWriter.close();

  
    	
    }
}
