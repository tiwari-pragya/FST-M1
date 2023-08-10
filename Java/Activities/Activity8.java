package Activities;


//customexception class
class CustomException extends Exception{

    private String message = null;

    //constructor
    CustomException(String s){
        this.message = s;
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}



public class Activity8 {

    public static void main(String[] args){
        try{
            Activity8.exceptionTest("Will print to console");
            Activity8.exceptionTest(null);
            //Activity8.exceptionTest("Sting");
            Activity8.exceptionTest("Won't execute");
        }
        catch(CustomException cae){
            System.out.println("Inside catch block: " + cae.getMessage());
        }
    }

    //exception test method
    static void exceptionTest(String s) throws CustomException{
        if (s == null) {
            throw new CustomException("String value is null");
        } else {
            System.out.println(s);
        }
    }
}
