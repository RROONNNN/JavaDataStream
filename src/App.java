import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class App {
static void bufferOutputStream(String file,String data) throws IOException{
 // Creates a FileOutputStream
            FileOutputStream out = new FileOutputStream(file);

            // Creates a BufferedOutputStream
            BufferedOutputStream output = new BufferedOutputStream(out,1000);

            byte[] array = data.getBytes();

            // Writes data to the output stream
              
                output.write(array,5,3);
        //output.flush();
            
            output.close();
}
static void writeToFile(String file,double[] prices ,int[] units,String[] descs) throws IOException{
 DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
              new FileOutputStream(file)));
              for (int i = 0; i < prices.length; i ++) {
                out.writeDouble(prices[i]);
                out.writeInt(units[i]);
                out.writeUTF(descs[i]);
            }
            out.flush();
            out.close();
}
static void readFromFile(String file,double[] prices ,int[] units,String[] descs) throws IOException
{
 DataInputStream in = new DataInputStream(new
            BufferedInputStream(new FileInputStream(file)));

double price;
int unit;
String desc;
double total = 0.0;
try {
    while (true) {
        price = in.readDouble();
        unit = in.readInt();
        desc = in.readUTF();
        System.out.format("You ordered %d" + " units of %s at $%.2f%n",
            unit, desc, price);
        total += unit * price;
    }
} catch (EOFException e) {
}

}
   public static void main(String args[]) throws IOException {

    final String dataFile = "invoicedata";

    double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
    int[] units = { 12, 8, 13, 29, 50 };
     String[] descs = {
        "Java T-shirt",
        "Java Mug",
        "Duke Juggling Dolls",
        "Java Pin",
        "Java Key Chain"};
  //writeToFile("textfilee.txt",prices,units,descs);
readFromFile("textfilee.txt", prices, units, descs);

   }
  }