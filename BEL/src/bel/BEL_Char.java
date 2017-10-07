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
  private int serialNumber;
  private int carry; 
  private int lift;  
  private int drag;
  private int rifleBG;        // getRifle()
  private int pistolBG;
  private String lang;      // String getLang()
  private int langLevel;    // getLangLevel()
  private int drive;        // getDrive()
  private int swim;         // getSwim()
  private int handBG;         // getHand()
  private int lead;         // getLead()
  private int demo;         // getDemo()
  private int orient;       // getOrient()
  private int aidBG;          // getAidBG()
  private int aid;          // getAid()
  private int bayonet;      // getBayonet()
  private int grenade;      // getGrenade()
  private int rifleGrenade; // getRifleGrenade()
  private int bar;          // getBAR()
  private int bazooka;      // getBazooka()
  private int mg30;         // getMG30()
  private int mg50;         // getMG50()
  private int mortar;       // getMortar()
  private int pistol45;     // getPistol45()
  private int subGun;       // getSubGun()
  
  
  private static int numSolders;

  public BEL_Char(int index) {
  setBg_type();
  setStrength();
  setEndurance();
  setAgility();
  setWep_handling();
  setStamina();
  setWeight();
  setAvgStat();
  setStrengthCLD();
  setRifleBG(bg_type);
  setPistolBG(bg_type);
  setLang(bg_type);
  setLangLevel(lang);
  setDrive(bg_type);
  setSwim(bg_type);
  setHandBG(bg_type);
  setLead();
  setDemo(bg_type);
  setOrient(bg_type);
  setAidBG();
  setAid();
  setBayonet();
  setGrenade();
  setRifleGrenade();
  setBar();
  setBazooka();
  setMg30();
  setMg50();
  setMortar();   
  setPistol45();   
  setSubGun();
  numSolders++;
  System.out.println(numSolders);
  setSerialNumber(index);
  }

  private void setStrengthCLD(){
   switch(this.strength){
       case 5:
           this.carry = DiceRoll(20, 30);
           this.lift = DiceRoll(50, 75);
           this.drag = DiceRoll(100, 125);
           break;
       case 6:
           this.carry = DiceRoll(30, 40);
           this.lift = DiceRoll(75, 100);
           this.drag = DiceRoll(125, 150);
           break;
       case 7:
           this.carry = DiceRoll(40, 50);
           this.lift = DiceRoll(100, 125);
           this.drag = DiceRoll(150, 175);
           break;
       case 8:
           this.carry = DiceRoll(50, 60);
           this.lift = DiceRoll(125, 150);
           this.drag = DiceRoll(175, 200);
           break;
       case 9:
           this.carry = DiceRoll(60, 70);
           this.lift = DiceRoll(150, 175);
           this.drag = DiceRoll(200, 225);
           break;
       case 10:
           this.carry = DiceRoll(70, 80);
           this.lift = DiceRoll(175, 200);
           this.drag = DiceRoll(225, 250);
           break;
       case 11:
           this.carry = DiceRoll(80, 90);
           this.lift = DiceRoll(200, 225);
           this.drag = DiceRoll(250, 275);
           break;    
   }// End of switch
  }// End of setStrengthCLD()
  
  
  
  
  private void setSerialNumber(int index){
      this.serialNumber = index;
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
  
  private void setRifleBG(String bgType) {
      int roll;
      switch(bgType){
          case "City":
              if((D6()+D6())==12){
                 roll = D6()+D6();
                 this.rifleBG = (roll<=8)? 1: roll-7;
                 break;
              } else {
                  this.rifleBG = 0;  
                  break;
              }// End City case
          case "Rural":
              if((D6()+D6())>=7){
                 roll = D6()+D6()+1;
                 this.rifleBG = (roll<=8)? 1: roll-7;
                 break;
              } else {
                  this.rifleBG = 0;  
                  break;
              }// End Rural case
          default:
              this.rifleBG = 0;
      }// ******** End of Switch ***********
    }// End setRifle

    private void setPistolBG(String bgType) {
      int roll;
      switch(bgType){
          case "City":
              if((D6()+D6())>=11){
                 roll = D6()+D6();
                 this.pistolBG = (roll<=8)? 1: roll-7;
                 break;
              } else {
                  this.pistolBG = 0;  
                  break;
              }// End City case
          case "Rural":
              if((D6()+D6())>=6){
                 roll = D6()+D6()+1;
                 this.pistolBG = (roll<=8)? 1: roll-7;
                 break;
              } else {
                  this.pistolBG = 0;  
                  break;
              }// End Rural case
          default:
              this.pistolBG = 0;
      }// ******** End of Switch ***********
    }// End setPistol
    
    private void setLang(String bgType) {
      int roll;  
      switch(bgType){
          case "City":
              if((D6()+D6())>=11){
                 this.lang = (D6()<=3)? "French": "Italian";
                 break;
              } else {
                  this.lang = "English";
                  this.langLevel = 3;
                  break;
              }// End City case
          case "Rural":
              if((D6()+D6())==12){
                 this.lang = (D6()<=3)? "German": "Italian";
                 break;
              } else {
                  this.lang = "English";
                  this.langLevel = 3;
                  break;
              }// End Rural case
          default:
              this.lang = "English";
              this.langLevel = 3;
      }// ******** End of Switch ***********
    }// End setLang
    
    private void setLangLevel(String lang) {
        int roll;
        if("English".equals(this.lang)){
            this.langLevel = 3;
        } else {
            roll = D6();
            if (roll == 1){
                this.langLevel = 1;
            } else if(roll<=3){
                this.langLevel = 2;
            } else {
                this.langLevel = 3;
            }
        }
    }// End of setLangLevel
    
    private void setDrive(String bgType){
        int roll = D6()+D6();
        if("City".equals(bgType) && roll>3){
            this.drive = 1;
        } else if("Rural".equals(bgType) && roll>4){
            this.drive = 1;
        } else {
            this.drive = 0;
        }
    }// End setDrive

    private void setSwim(String bgType) {
        int roll = D6()+D6();
        if("City".equals(bgType) && roll>8){
            roll = D6();
                if(roll == 1){
                    this.swim = 1;
                } else if(roll == 6){
                    this.swim = 3;
                } else {
                    this.swim = 2;
                }
        } else if("Rural".equals(bgType) && roll>6){
            roll = D6();
                if(roll == 1){
                    this.swim = 1;
                } else if(roll == 6){
                    this.swim = 3;
                } else {
                    this.swim = 2;
                }
        } else {
            this.swim = 0;
        }
    }// End setSwim
    
     private void setHandBG(String bgType){
        int roll = D6()+D6();
        if("City".equals(bgType) && roll>8){
            roll = D6();
                if(roll <= 2){
                    this.handBG = 1;
                } else if(roll == 6){
                    this.handBG = 3;
                } else {
                    this.handBG = 2;
                }
        } else if("Rural".equals(bgType) && roll>9){
            roll = D6();
                if(roll <= 2){
                    this.handBG = 1;
                } else if(roll == 6){
                    this.handBG = 3;
                } else {
                    this.handBG = 2;
                }
        } else {
            this.handBG = 0;
        }
    }// End setHand
      private void setLead() {
      this.lead = ((D6()+D6())>8)?1:0;
    }// End setLead

    private void setDemo(String bgType) {
        if("City".equals(bgType)){
            this.demo = 0;
        } else if(D6()+D6() == 12){
            this.demo = 1;
        }
        this.demo = demo;
    }// End setDemo

    private void setOrient(String bgType){
        int roll = D6()+D6();
        if("City".equals(bgType) && roll==12){
            roll = D6();
                if(roll <= 3){
                    this.orient = 1;
                } else if(roll == 6){
                    this.orient = 3;
                } else {
                    this.orient = 2;
                }
        } else if("Rural".equals(bgType) && roll>=9){
            roll = D6();
                if(roll <= 3){
                    this.orient = 1;
                } else if(roll == 6){
                    this.orient= 3;
                } else {
                    this.orient = 2;
                }
        } else {
            this.orient = 0;
        }
        this.orient = 0;
    }// End setOrient 
    
    private void setAidBG(){
      if(D6()+D6()>10){
        int roll = D6();
        if(roll<4){
            this.aidBG = 1;
        } else if(roll ==6){
            this.aidBG = 3;
        } else{
            this.aidBG = 2;
        }
      } else
            this.aidBG = 0;
    }// End setAid
    
    public void setAid() {
        int roll = D6();
        if(roll<4){
            this.aid = this.aidBG + 1;
        } else if(roll ==6){
            this.aid = this.aidBG + 3;
        } else{
            this.aid = this.aidBG + 2;
        }
      
    }// END of setAid()
    
    public void setBayonet() {
        this.bayonet = 1;
    }
    
    public void setGrenade(){
        this.grenade = 1;
    }
    
    public void setRifleGrenade(){
        this.rifleGrenade = 1;
    }
    
    public void setBar() {
        this.bar = 1;
    }

    public void setBazooka() {
        this.bazooka = 1;
    }

    public void setMg30() {
        this.mg30 = 1;
    }

    public void setMg50() {
        this.mg50 = 0;
    }

    public void setMortar() {
        this.mortar = 1;
    }

    public void setPistol45() {
        this.pistol45 = pistolBG;
    }

    public void setSubGun() {
        this.subGun = 1;
    }

    
  // *************** Getters *******************************
  
  public static int getNumSolders(){
      System.out.println(" ---- " + numSolders);
      return numSolders;
  }
  
  public int getSerialNumber(){
      return this.serialNumber;
  }
  
  public String getBg_type() {
    return this.bg_type;
  }

  public int getStrength() {
    return this.strength;
  }

  public int getEndurance() {
    return this.endurance;
  }

  public int getWep_handling() {
    return this.wep_handling;
  }

  public int getAgility() {
    return this.agility;
  }

  public int getStamina() {
    return this.stamina;
  }

  public int getWeight() {
    return this.weight;
  }
  
  public double getAvgStat(){
      return this.avgStat;
  }
  
  public int getCarry(){
      return this.carry;
  }
  
  public int getLift(){
      return this.lift;
  }
  
  public int getDrag(){
      return this.drag;
  }
  
    public int getRifleBG() {
        return rifleBG;
    }

    public int getPistolBG() {
        return pistolBG;
    }
    
    public String getLang() {
        return lang;
    }
    
    public int getLangLevel(){
        return this.langLevel;
    }
    
    public int getDrive() {
        return drive;
    }

    public int getSwim() {
        return swim;
    }
    
    public int getHandBG() {
        return handBG;
    }
    
    public int getLead() {
        return lead;
    }

    public int getDemo() {
        return demo;
    }

    public int getOrient() {
        return orient;
    }
    
    public int getAidBG(){
        return aidBG;
    }
    
    public int getAid() {
        return aid;
    }
    
    public int getBayonet() {
        return bayonet;
    }
    
    public int getGrenade() {
        return grenade;
    }

    public int getRifleGrenade() {
        return rifleGrenade;
    }
    
    public int getBar() {
        return bar;
    }

    public int getBazooka() {
        return bazooka;
    }

    public int getMg30() {
        return mg30;
    }

    public int getMg50() {
        return mg50;
    }

    public int getMortar() {
        return mortar;
    }

    public int getPistol45() {
        return pistol45;
    }

    public int getSubGun() {
        return subGun;
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
 public static int D6(){
        int roll;
        roll = ((6) * (int)(Math.random()*1000)) / 1000 + 1;
        return roll;
        }
  @Override
  public String toString() {
    return "Background= " + bg_type 
            + ", \r\nStrength= " + strength 
            + ", \r\nEndurance= " + endurance 
            + ", \r\nWeapons Handling= " + wep_handling 
            + ", \r\nAgility= " + agility 
            + ", \r\nStamina= " + stamina 
            + ", \r\nWeight= " + weight
            + ", \r\nAverage Stat= " + avgStat
            + ", \r\ncarry= " + carry 
            + ", \r\nlift= " + lift 
            + ", \r\ndrag= " + drag
            + ", \r\nrifle=" + rifleBG
            + ", \r\npistol=" + pistolBG 
            + ", \r\nlang=" + lang 
            + ", \r\nlangLevel=" + langLevel 
            + ", \r\ndrive=" + drive 
            + ", \r\nswim=" + swim 
            + ", \r\nhand=" + handBG 
            + ", \r\nlead=" + lead 
            + ", \r\ndemo=" + demo 
            + ", \r\norient=" + orient 
            + ", \r\naid=" + aidBG
            + ", \r\nbayonet=" + bayonet 
            + ", \r\ngrenade=" + grenade 
            + ", \r\nrifleGrenade=" + rifleGrenade 
            + ", \r\nBAR=" + bar 
            + ", \r\nBazooka=" + bazooka
            + ", \r\n.30 cal MG=" + mg30 
            + ", \r\n60mm Mortar=" + mortar
            + ", \r\n.50 cal MG=" + mg50
            + ", \r\n.45 cal Pistol=" + pistol45
            + ", \r\nSubmachine gun=" + subGun;
  }// End of toString()
  
}// ******************** END OF BEL_Char class *******************************
