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
  private int rifle;        // getRifle()
  private int pistol;       // getPistol()
  private String lang;      // String getLang()
  private int langLevel;    // getLangLevel()
  private int drive;        // getDrive()
  private int swim;         // getSwim()
  private int hand;         // getHand()
  private int lead;         // getLead()
  private int demo;         // getDemo()
  private int orient;       // getOrient()
  private int aid;          // getAid()
  private int bgSkillSN;    // getSerialNumber()


  

    public BG_Skill(String bgType, int solderSN) {
        setRifle(bgType);
        setPistol(bgType);
        setLang(bgType);
        setLangLevel(lang);
        setDrive(bgType);
        setSwim(bgType);
        setHand(bgType);
        setLead();
        setDemo(bgType);
        setOrient(bgType);
        setAid();
        setBGskillSN(solderSN);
        
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
        return bgSkillSN;
    }
    
    public int getAid(){
        return aid;
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

    private void setHand(String bgType){
        int roll = D6()+D6();
        if("City".equals(bgType) && roll>8){
            roll = D6();
                if(roll <= 2){
                    this.hand = 1;
                } else if(roll == 6){
                    this.hand = 3;
                } else {
                    this.hand = 2;
                }
        } else if("Rural".equals(bgType) && roll>9){
            roll = D6();
                if(roll <= 2){
                    this.hand = 1;
                } else if(roll == 6){
                    this.hand = 3;
                } else {
                    this.hand = 2;
                }
        } else {
            this.hand = 0;
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
    
    private void setAid(){
      if(D6()+D6()>10){
        int roll = D6();
        if(roll<4){
            this.aid = 1;
        } else if(roll ==6){
            this.aid = 3;
        } else{
            this.aid = 2;
        }
      } else
            this.aid = 0;
    }// End setAid
    
    private void setBGskillSN(int solderSN){
        this.bgSkillSN = solderSN;
    }// End setBGskillSN

        @Override
    public String toString() {
        return "BG_Skill{" 
                + "\r\nrifle=" + rifle 
                + ", \r\npistol=" + pistol 
                + ", \r\nlang=" + lang 
                + ", \r\nlangLevel=" + langLevel 
                + ", \r\ndrive=" + drive 
                + ", \r\nswim=" + swim 
                + ", \r\nhand=" + hand 
                + ", \r\nlead=" + lead 
                + ", \r\ndemo=" + demo 
                + ", \r\norient=" + orient 
                + ", \r\naid=" + aid 
                + ", \r\nbgSkillSN=" + bgSkillSN + '}';
    }// End of toString
    
    
    public static int D6(){
        int roll;
        roll = ((6) * (int)(Math.random()*1000)) / 1000 + 1;
        return roll;
        }

    
    
    
}// ************************* END of BG_Skill Class ****************************
