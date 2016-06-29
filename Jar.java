import java.util.Random;

public class Jar {
  private int mMagicNumber;
  private String mFilling;
  private int mMaxQuantity;
  
 public Jar(String filling, int maxQuantity) {
  
  mMaxQuantity = maxQuantity;
   
  setMagicNumber(fill(mMaxQuantity)); 
   
  setFilling(filling); 
   
 }
  
  
  public int fill(int maxQuantity) {
    Random random = new Random();
    int magicNumber = random.nextInt(maxQuantity) + 1;
    
    return magicNumber;
  }
  
  public int getMaxQuantity() {
   return mMaxQuantity; 
  }
  
  public void setMagicNumber(int magicNumber) {
   mMagicNumber = magicNumber; 
  }

  
  public void setFilling(String filling) {
    mFilling = filling;
  }
  
  public String getFilling() {
    return mFilling;
  }
  
public int getMagicNumber() {
  return mMagicNumber;
}
  
}