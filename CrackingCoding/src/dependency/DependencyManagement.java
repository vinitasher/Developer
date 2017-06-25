/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dependency;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author vasher
 */
public class DependencyManagement {
    private static final String DEPEND = "DEPEND";
    private static final String INSTALL = "INSTALL";
    private static final String REMOVE = "REMOVE";
    private static final String LIST = "LIST";
    
    public void callDepend(String input, List<String> dependencies){
        
    }
    
    public void callInstall(String input){
        
    }
    
    public void callList(){
        
    }
    
    public void callRemove(String input){
        
    }
    
    public void callInvalidInput(){
        System.out.println("Invalid input");
    }
    
    public void parseInput(String input){
        if(input == null || input.isEmpty()){
            callInvalidInput();
            return;
        }
        String delims = "[ ]+";
        String[] tokens = input.split(delims);
        if(tokens.length < 1){
            callInvalidInput();
            return;
        }
        switch(tokens[0]){
            case DEPEND:
                if(tokens.length < 3){
                    callInvalidInput();
                    return;
                }
                callDepend(tokens[1], Arrays.asList(Arrays.copyOfRange(tokens, 2, tokens.length)));
                break;
            case INSTALL: 
                if(tokens.length != 2){
                    callInvalidInput();
                    return;
                }
                callInstall(input);
                break;
            case LIST: 
                if(tokens.length != 1){
                    callInvalidInput();
                    return;
                }
                callList();
                break;
            case REMOVE: 
                if(tokens.length != 2){
                    callInvalidInput();
                    return;
                }
                callRemove(input);
                break;
            default:
                callInvalidInput();
        }
    }
    
    public static void main(String[] args){
        DependencyManagement dm = new DependencyManagement();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String input = sc.nextLine();
            dm.parseInput(input);
        }
        
    }
    
}
