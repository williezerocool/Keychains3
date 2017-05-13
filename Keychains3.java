/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keychains3;

import java.util.Scanner;

/**
 *
 * @author kendrabooker
 */
public class Keychains3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner ky = new Scanner(System.in);
        int userInput,numOfKeychains, a;
        a = 1;
        numOfKeychains = 0;
        double shipping, tax, perChainShipping, chainPrice;
        chainPrice = 10.00;
        shipping = 5.00;
        tax = .0825;
        perChainShipping = 1.00;
        
        System.out.print("Ye Olde Keychain Shoppe\n" + "1. Add Keychains to Order\n" + "2. Remove Keychains from Order\n" + "3. View Current Order\n" + "4. Checkout\n" + "Please enter your choice: ");
        userInput = ky.nextInt();
        if(userInput > 4 || userInput < 1){
        
            System.out.println("Error\n");
            System.out.print("Ye Olde Keychain Shoppe\n" + "1. Add Keychains to Order\n" + "2. Remove Keychains from Order\n" + "3. View Current Order\n" + "4. Checkout\n" + "Please enter your choice: ");
            userInput = ky.nextInt();
        }
        System.out.println();
        
        while(a > 0){
        
            if(userInput == 1){
            
                numOfKeychains = add_keychains(numOfKeychains);
                System.out.print("1. Add Keychains to Order\n" + "2. Remove Keychains from Order\n" + "3. View Current Order\n" + "4. Checkout\n" + "Please enter your choice: ");
                userInput = ky.nextInt();
                System.out.println();
            
            }else if(userInput == 2){
            
                numOfKeychains = remove_keychains(numOfKeychains);
                System.out.println("you now have " + numOfKeychains + " keychains" + "\n" );
               
                System.out.print("1. Add Keychains to Order\n" + "2. Remove Keychains from Order\n" + "3. View Current Order\n" + "4. Checkout\n" + "Please enter your choice: ");
                userInput = ky.nextInt();
                System.out.println();
            }else if(userInput == 3){
            
                view_order(numOfKeychains, chainPrice, shipping, tax, perChainShipping);
                System.out.print("1. Add Keychains to Order\n" + "2. Remove Keychains from Order\n" + "3. View Current Order\n" + "4. Checkout\n" + "Please enter your choice: ");
                userInput = ky.nextInt();
                System.out.println();
            }else if(userInput == 4){
            
                checkout(numOfKeychains, chainPrice, shipping, tax, perChainShipping);
                a = 0;
                
            }
            
        }
    
    
    }
    
    /**
     *
     * @param numOf
     * @return 
     */
    public static int add_keychains(int numOf){
    
        Scanner ky = new Scanner(System.in);
        int count;
        
        System.out.print("you have " + numOf + " keychains. How many to add? ");
        count = ky.nextInt();
        if(count < 0){
                
                    System.out.println("Error you can't have a negitive amount of chains in your order!");
                    System.out.println();
                    count = 0;
                }else{
                    System.out.print("you now have " + (count + numOf) + " keychains" + "\n");
        }
        return count;
         
    }
    
    public static int remove_keychains(int numOf){
        Scanner ky = new Scanner(System.in);
        int count;
        
        System.out.print("you have " +  numOf +" keychains. How many keychains do you want to remove? ");
        count = ky.nextInt();
        if(count > numOf){
                
                    System.out.println("Error you can't have a negitive amount of chains in your order!");
                    System.out.println();
                    count = 0;
                }
        
        return numOf - count;
    }
    
    /**
     *
     * @param numOf
     * @param price
     */
    public static void view_order(int numOf, double price, double shipping, double tax, double perChainShipping){
    
        
        String order = "You have " + numOf + " keychains\n" + "keychains cost $10.00 each\n" + "shipping charges are $" + ( (numOf * perChainShipping) + shipping) + "0\n" + "subtotal: " + ((numOf * price) + ( (numOf * perChainShipping) + shipping) ) + "0\n" + "tax is 8.25%\n" +"your total is $" + Math.ceil((numOf * price) + ( ( ( (numOf * perChainShipping) + shipping) * tax) + (numOf * perChainShipping) + shipping) );
        System.out.println(order);
    }
    
    public static void checkout(int numOf, double price, double shipping, double tax, double perChainShipping){
        
        Scanner ky = new Scanner(System.in);
        String userInput;
        
        System.out.print("CHECKOUT \n"+ "What is your name? ");
        userInput = ky.next();
        
         String order = "You have " + numOf + " keychains\n" + "keychains cost $10.00 each\n" + "shipping charges are $" + ( (numOf * perChainShipping) + shipping) + "0\n" + "subtotal: " + ((numOf * price) + ( (numOf * perChainShipping) + shipping) ) + "0\n" + "tax is 8.25%\n" +"your total is $" + Math.ceil((numOf * price) + ( ( ( (numOf * perChainShipping) + shipping) * tax) + (numOf * perChainShipping) + shipping) ) + "\n" +"Thanks for your order " + userInput;
        System.out.println(order);
    }
    


}
