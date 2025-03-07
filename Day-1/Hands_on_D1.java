
public class Hands_on_D1 {
    int student_id;
    String student_name;

    public void studentDetails() {
        System.out.println("Id:" + student_id);
        System.out.println("Name:" + student_name);
    }
}

class Implemetation {
    public static void main(String[] args){
        Hands_on_D1 obj = new Hands_on_D1();
        obj.student_id = 7001;
        obj.student_name="Vamsi";
        
        // Student details method caanot be caaled without an object as it is not declared as stcic method
        obj.studentDetails();

        //studentDetails(); Will give an compilation error
    }
}