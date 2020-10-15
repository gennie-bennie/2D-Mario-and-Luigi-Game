class Coin {
 float x,y;
 int w,h;
 PImage coin = loadImage("coin.png");
  
  Coin() {
   w = 20;
   h = 20;
   coin.resize(w, h);
   x = random(50, 450);
   y = random(300, 350);
  }
  
  void display() {
   if(!touch(x, y)) {
    image(coin,x,y);
   } else {
    image(coin,-20,-20);
    x = random(50, 450);
    y = random(250, 300);
   }
  }
  
  boolean touch(float x, float y) {
  
  if(luigi.x + 15 > x && luigi.y + 20 > y && luigi.x + 15 < x + w && luigi.y + 20 < y + h) {
      return true;
    } 
  
  if(new1.x + 15 > x && new1.y + 20 > y && new1.x + 15 < x + w && new1.y + 20 < y + h) {
    return true;
    } 
    return false;
  }
  
  
  
}
