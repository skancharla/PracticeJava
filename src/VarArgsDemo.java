
public class VarArgsDemo {

	public static void printNames(int length,int width,String...names){
		if(names==null ){
			System.out.println("null ");
			return;
	}
		if(names.length==0){
			System.out.println("empty ");
			return;
		}
		System.out.println("length is: "+length);
		System.out.println("breadth is: "+width);
		for(String str:names)
			System.out.println("hello "+str);
	}
	
	
	public static void main(String[] args) {
		printNames(10,8,"vijayakumar","prabhavathi","deepthi","srimanth");
		
		

	}

}
