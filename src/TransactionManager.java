/**
 Shopping class handles input and output
 @author Ben Plotnick, Michael Sherbine
 **/
import java.util.InputMismatchException;
import java.util.Scanner;

public class TransactionManager{

    public void run(){

        Scanner myObj = new Scanner(System.in);
        String input;
        AccountDatabase database = new AccountDatabase(); // create Account Database
        System.out.println("Lets start shopping!");
        while (!((input = myObj.nextLine()).equals("Q"))) {// while user does not input "Q" keep listening for input
            String[] inputString = input.split("\\s+"); //split input string into array
            try {
                handleInput(inputString);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            
            } 
        }
    

    public void handleInput(String[] input)throws Exception{
        if(input[0].equals("OC")){
            try {
                Profile x = new Profile(input[1], input[2]);
            } catch (NumberFormatException e) {
                throw new NumberFormatException(input[1] + " is not a number");
            } catch (InputMismatchException e){
                throw new InputMismatchException("test");
            }

        } else{
            throw new InputMismatchException("test");
        }

    }


    
}