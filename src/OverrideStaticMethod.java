
public class OverrideStaticMethod extends SuperClass{
      int width;
	public OverrideStaticMethod(int length , int width) {
		super(length);
		this.width=width;
		
	}

	public static void doStuff(){
		//doStuff();
		System.out.println("hello stuff");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//SuperClass sc= new OverrideStaticMethod(3,3);
		OverrideStaticMethod.doStuff();

	}

}
