import java.util.HashSet;
import java.util.Iterator;


public class TestClassMain {

	public String toString(){
		return "this is test class object";
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestClassMain testClass=new TestClassMain();
		System.out.println(testClass);
		System.out.println(testClass.hashCode());
        HashSet<Dog> hashSet=new HashSet<Dog>();
        Dog d=new Dog("alfred");
        Dog d1=new Dog("bukky");
        Dog d2=new Dog("seth");
        hashSet.add(d);
        hashSet.add(d1);
        hashSet.add(d2);
        
        System.out.println(hashSet.size());
        Iterator<Dog> it=hashSet.iterator();
        while(it.hasNext()){
        	System.out.println(it.next().getName());
        }
	}

}
