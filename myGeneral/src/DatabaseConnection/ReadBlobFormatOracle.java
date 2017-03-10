package DatabaseConnection;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;

public class ReadBlobFormatOracle {
	public static void main(String args[])
	{
        System.out.println("Oracle Connect START.");
       
        try {
        
            
        
         DatabaseConnection.OracleConn.rs =DatabaseConnection.OracleConn.executeQuery("select blob_column from tableName where somecondition");
         Blob lob = null;
         while (DatabaseConnection.OracleConn.rs.next()) {
        	 lob=DatabaseConnection.OracleConn.rs.getBlob("blob_column");	
		}
 
        InputStream in = lob.getBinaryStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        OutputStream outputStream = new FileOutputStream("blobImage.png");
 
        int bufferSize = 1024;
        int length = (int) lob.length();
 
        byte[] buffer = new byte[bufferSize];
 
        while((length = in.read(buffer)) != -1)
        {
        	out.write(buffer,0,length);
        }
        out.writeTo(outputStream);
        in.close();
        Process p1 =Runtime.getRuntime().exec("mspaint blobImage.png");
 
        }catch (Exception e) {
            e.printStackTrace();
            }
 
		}
}