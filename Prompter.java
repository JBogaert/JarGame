import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.File;

import java.lang.Integer;




public class Prompter {
  private BufferedReader mReader;
  private Jar mJar;
  private String mFilling;
  private int mMaxQuantity;
  private int mMagicNumber;
  private int mGuess;
  
  public Prompter()  {
   
    NewGame();

  }

  private void guess(){
    int tryCount = 1;
    mGuess = 0;
    boolean guessIsRight = false;
    while (!guessIsRight) {
          mGuess = readIntLine();
      if (mGuess == mMagicNumber) {
          if(tryCount == 1) {
              System.out.printf("GRATZ! That only took %d try! %n", tryCount);
              guessIsRight = true;
              
              promptNewGame();
          }else {
               System.out.printf("GRATZ! That only took %d tries! %n", tryCount);
               guessIsRight = true;
               promptNewGame();
            }
         } else {
                  if(overCapacity()) {
                   System.out.printf("That wouldn't even fit in the Jar! Try again! %n"); 
                  } else if(guessTooLow()) {
                    System.out.printf("There must be more than that! Try again! %n");
                    tryCount++;
                  } else {
                    System.out.printf("That's too many! Try again! %n");
                    tryCount++;
                  }
                }
       }
  
  }
  
  public boolean wantsNewGame(String answer) {
  boolean wantsNewGame = false;
    if(answer.toLowerCase().equals("y")) {
     wantsNewGame = true;
   } return wantsNewGame;
  }
  
  public void promptNewGame() {
    String answer;

    System.out.println("Would you like to start a new game? Y/N");
      try{
          answer = mReader.readLine();
          if(wantsNewGame(answer)) {
          NewGame(); 
            } else {
                System.out.println("Thanks for playing!"); 
            }
          }catch (IOException ioe) {
            System.out.println("There was an error"); 
          }

    
  }
  
  public void NewGame() {
        try {
              mGuess = 0;
              mReader = new BufferedReader(new InputStreamReader(System.in)); 
   
              System.out.printf("Administrative Options %n"  +
                                "======================= %n" +
                                "What is in your Jar? %n"); 
   
      
              mFilling = mReader.readLine();
              System.out.printf("How many %s can fit in your jar? %n", mFilling); 
   
              mMaxQuantity = readIntLine();
              mJar = new Jar(mFilling, mMaxQuantity);  
              mMagicNumber = mJar.getMagicNumber();
            }catch (IOException ioe) {
                      System.out.println("This is an error on line 21");
            }
  
  
            System.out.printf( "Player - Begin Game %n" +
                              "==================== %n" +
                              "Let's Play! This Jar can potentially hold %d %s. %n" +
                              " How many %s are in the jar? %n", mMaxQuantity, mFilling, mFilling);
    
            guess();
    }
    
  private boolean guessTooLow() {
   if(mGuess < mMagicNumber) {
        return true;
   } else {
        return false;
   }
    
  }
  
  private boolean overCapacity() {
   if(mGuess > mJar.getMaxQuantity()) {
        return true;
   } else {
        return false;
   }
    
  }
  
  private int readIntLine() {
      int maxQuantity = 0;
      boolean done = false;
      while (!done) {
        try {
            maxQuantity = Integer.parseInt(mReader.readLine());
            done = true;
            } catch (NumberFormatException nfe) {
                     System.out.println("Sorry, you must enter a number! Please try again.");
            } catch (IOException ioe) {
                    System. out.println("Sorry, there has been an IO Error");
            }
   
      } return maxQuantity;
  }
  

  
}