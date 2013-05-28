
public class Dog {
	
	private String name;
    //public static int hash=0;
	public String getName() {
		return name;
	}
    public Dog(String name){
    	this.name=name;
    }
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean equals(Object o){
		if(o instanceof Dog ){
			Dog d=(Dog)o;
			if(d.getName().equals(this.name))
				return true;
		}
		return false;
	}
	public int hashCode(){
		/*int hash=0;
		for(int i=0;i<this.name.length();i++){
			hash=hash+name.charAt(i);
		}
		return hash;*/
		return 17;
	}

}
