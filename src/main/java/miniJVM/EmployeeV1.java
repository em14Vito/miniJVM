
package miniJVM;
/** 
  * @author  作者 Denny
  * @date 创建时间：Jan 21, 2018 1:56:54 PM 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  */
public class EmployeeV1 {
	
	
	private String name;
    private int age;
    
    public EmployeeV1(String name, int age) {
        this.name = name;
        this.age = age;        
    }    

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age){
    	this.age = age;
    }
    public void sayHello() {        
    	System.out.println("Hello , this is class Employee ");    	
    }
    public static void main(String[] args){
    	EmployeeV1 p = new EmployeeV1("Andy",29);
    	p.sayHello();    
    	
    }
}