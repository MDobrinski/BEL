package bindingtest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author michael.sbg
 */
public class NumGenA {
  private static int count;
  private int value;
    // ^^^^^^^^^^^^^^^^^^^^^^^^^ Constructors ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    public NumGenA() {
        count ++;
        this.value = diceRoll();
    }
    // SSSSSSSSSSSSSSSSSSSSSSSSS Setters SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
    
  
  
  
    // GGGGGGGGGGGGGGGGGGGGGGGGG Getters GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG 
    public static int getCount (){
        return count;
    }
    
    public int getValue (){
        return this.value;
    }
    
    
  
  
  // MMMMMMMMMMMMMMMMMMMM Methods MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
    public static int diceRoll(){
        return ((6-1+1) * (int)(Math.random()*1000)) / 1000 + 1;
    }
  
} // *********************** END NumGenA Class ******************************
