/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahw5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

/**
 *
 * @author Никита
 */
public class JavaHW5 {
    public static void main(String[] args) throws IOException{
       String l = "langL.flex";
       String p = "";
      
       if(args.length == 0){
           p = "";
            System.out.println("Mod people write");
       }else{
           p = args[0];
           System.out.println("Mod console args");
       }
        init(l,p);
    }
    public static void init(String lexer,String path) throws IOException{
        
      try {
            generarLexer(lexer);
            lexemWriter(path);
        } catch (Exception e) {
           System.out.println("Lexer-file not found or invalid file name!");
        }
    }
    public static void generarLexer(String path){
         File file=new File(path);
            jflex.Main.generate(file); 
         
    } 
   public static void lexemWriter(String path) throws FileNotFoundException, IOException{
      Reader reader = null;
       if(path.equals("")){
           System.out.println("Enter your custom path to file test:");
            Scanner in = new Scanner(System.in);
            String your__path = in.nextLine();
            reader = new BufferedReader(new FileReader(your__path));
           
       }else{
           
           reader = new BufferedReader(new FileReader(path));
       }
        
        try{
           
            Lexer lexer = new Lexer (reader);
            while (true){
                String sflex = lexer.yylex();
                if(sflex == null){return;}
                else{System.out.print(sflex);}
            }  
        }catch(Exception e){
            System.out.println("Test file not found or invalid file name!");
        }
       
    } 
}
