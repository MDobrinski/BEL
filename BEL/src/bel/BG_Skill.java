/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bel;

/**
 *
 * @author mdobrinski
 */
public class BG_Skill {
  private int rifle;
  private int pistol;
  private String lang;
  private int langLevel;
  private int drive;
  private int swim;
  private int hand;
  private int lead;
  private int demo;
  private int orient;
  private int bgSerialNumber;
  

    public BG_Skill(String bgType, int solderSN) {
        setRifle(bgType);
        setPistol(bgType);
        setLang(bgType);
        setLangLevel(lang);
        setDrive(bgType);
        setSwim(bgType);
        setHand(bgType);
        setLead(bgType);
        setDemo(bgType);
        setOrient(bgType);
        
    }

  
  
    public int getRifle() {
        return rifle;
    }

    public int getPistol() {
        return pistol;
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

    public int getHand() {
        return hand;
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
    
    public int getSerialNumber(){
        return bgSerialNumber;
    }

    private void setRifle(String bgType) {
      int roll;
      switch(bgType){
          case "City":
              if((D6()+D6())==12){
                 roll = D6()+D6();
                 this.rifle = (roll<=8)? 1: roll-7;
                 break;
              } else {
                  this.rifle = 0;  
                  break;
              }// End City case
          case "Rural":
              if((D6()+D6())>=7){
                 roll = D6()+D6()+1;
                 this.rifle = (roll<=8)? 1: roll-7;
                 break;
              } else {
                  this.rifle = 0;  
                  break;
              }// End Rural case
          default:
              this.rifle = 0;
      }// ******** End of Switch ***********
    }// End setRifle

    private void setPistol(String bgType) {
      int roll;
      switch(bgType){
          case "City":
              if((D6()+D6())>=11){
                 roll = D6()+D6();
                 this.pistol = (roll<=8)? 1: roll-7;
                 break;
              } else {
                  this.pistol = 0;  
                  break;
              }// End City case
          case "Rural":
              if((D6()+D6())>=6){
                 roll = D6()+D6()+1;
                 this.pistol = (roll<=8)? 1: roll-7;
                 break;
              } else {
                  this.pistol = 0;  
                  break;
              }// End Rural case
          default:
              this.pistol = 0;
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
        this.swim = swim;
    }

    private void setHand(String bgType){
        this.hand = hand;
    }

    private void setLead(String bgType) {
        this.lead = lead;
    }

    private void setDemo(String bgType) {
        this.demo = demo;
    }

    private void setOrient(String bgType){
        this.orient = orient;
    }
    
    private void setBGserialNumber(int solderSN){
        this.bgSerialNumber = solderSN;
    }

    
    public static int D6(){
        int roll;
        roll = ((6) * (int)(Math.random()*1000)) / 1000 + 1;
        return roll;
        }

    
    
    
}// ************************* END of BG_Skill Class ****************************
