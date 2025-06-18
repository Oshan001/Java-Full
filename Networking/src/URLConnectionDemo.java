import java.net.*;
import java.io.*;
public class URLConnectionDemo {
    public static void main(String[] args)throws  Exception {
        URL u= new URL("https://github.com/Oshan001/Numerical_lab");
        URLConnection con = u.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        while(true){
            String line = br.readLine();
            if(null == line) break;
            System.out.println(line);
        }
    }
}
