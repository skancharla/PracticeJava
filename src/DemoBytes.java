
public class DemoBytes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

      String str="Asrimanthz";
      Byte bt=new Byte("127");
      System.out.println(bt);
      byte[] byteArray=str.getBytes();
      for(byte b:byteArray)
         System.out.print((char)b+" ");
      System.out.println();
      System.out.println((3>9));
      System.out.println("everything is being printed");
      
      
	}

}
