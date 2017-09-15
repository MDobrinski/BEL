/*
 *Character generator for Behind Enemy Lines characters
 */
package bel;

import static java.lang.Math.ceil;

/**
 *
 * @author mdobrinski
 */
public class BEL_Char {
  private String bg_type;
  private int strength;
  private int endurance;
  private int wep_handling;
  private int agility;
  private int stamina;
  private int weight;
  private double avgStat;

  public BEL_Char() {
  setBg_type();
  setStrength();
  setEndurance()   ;
  setAgility();
  setWep_handling();
  setStamina();
  setWeight();
  setAvgStat();  
  }

  private void setAvgStat(){
    int sum = this.agility + this.endurance + this.stamina + this.strength +
            this.wep_handling;
    this.avgStat = Math.floor((((double)sum/5)*10.0+0.5))/10.0;
  }
  
  
  private void setBg_type() {
    this.bg_type = (DiceRoll(1, 6)<4) ? "City": "Rural";
  }

  private void setStrength() {
    this.strength = DiceRoll (1, 6)+4;
  }

  private void setEndurance() {
    this.endurance = DiceRoll (1, 6)+4;
  }

  private void setWep_handling() {
    this.wep_handling = DiceRoll (1, 6)+4;
  }

  private void setAgility() {
    this.agility = DiceRoll (1, 6)+4;
  }

  public void setStamina(int stamina) {
    this.stamina = stamina;
  }
  
  private void setStamina() {
    this.stamina = (int)ceil((this.strength + this.endurance)/2);
  }

  public final void setWeight() {
    this.weight = weightCalc(this.strength, this.agility);
  }

  public String getBg_type() {
    return bg_type;
  }

  public int getStrength() {
    return strength;
  }

  public int getEndurance() {
    return endurance;
  }

  public int getWep_handling() {
    return wep_handling;
  }

  public int getAgility() {
    return agility;
  }

  public int getStamina() {
    return stamina;
  }

  public int getWeight() {
    return weight;
  }
  
  public double getAvgStat(){
      return avgStat;
  }

 private static int weightCalc(int strength, int agility) {
    int result = 0;
    int wtroll = DiceRoll(1, 6) + DiceRoll(1, 6);
    if (strength > 7)
      {wtroll = wtroll +(strength -7);
      }
    if (agility > 7)
      {wtroll = wtroll -(agility -7);
      }
    wtroll = (wtroll<2)? 2: wtroll;  // if roll is less than 2 then make roll equal 2
    switch (wtroll){
      case 2: result = DiceRoll(120, 130);
        break;
      case 3: result = DiceRoll(130, 140);
        break;
      case 4: result = DiceRoll(140, 150);
        break;
      case 5: result = DiceRoll(150, 160);
        break;
      case 6: result = DiceRoll(160, 170);
        break;
      case 7: result = DiceRoll(160, 170);
        break;
      case 8: result = DiceRoll(170, 180);
        break;
      case 9: result = DiceRoll(170, 180);
        break;
      case 10: result = DiceRoll(180, 190);
        break;
      case 11: result = DiceRoll(190, 200);
        break;
      case 12: result = DiceRoll(200, 220);
        break;
      default: result = DiceRoll(220, 250);      
        break;
        
    } // End of switch
   return result;
  }

 public static int DiceRoll(int mn_r, int mx_r){
        int roll;
        roll = ((mx_r-mn_r+1) * (int)(Math.random()*1000)) / 1000 + mn_r;
        return roll;
        }
  @Override
  public String toString() {
    return "Background= " + bg_type 
            + ", \nStrength= " + strength 
            + ", \nEndurance= " + endurance 
            + ", \nWeapons Handling= " + wep_handling 
            + ", \nAgility= " + agility 
            + ", \nStamina= " + stamina 
            + ", \nWeight= " + weight
            + ", \nAverage Stat= " + avgStat;
  }
  
  
  
  
}
