class Mario{
  
  float x, y, jump, step, ground;
  PImage[] spritesR, spritesL; 
  int frame, coins;
  boolean isMoving, hasJumped;
  String direction;
  
  
  Mario(float x, float ground, float jump){
    this.x = x;
    this.y = ground;
    this.ground = ground;
    this.jump = jump;
    this.step = 20;
    this.coins = 0;
    frame = 0;
    isMoving = false;
    direction = "right";
    
    spritesL = new PImage[4];
    spritesR = new PImage[4];
    for(int i = 1; i <= 4; i ++){
      String filenameR = "marioR" + nf(i,1) + ".png";
      String filenameL = "marioL" + nf(i,1) + ".png";
      spritesR[i-1] = loadImage(filenameR);
      spritesR[i-1].resize(70,70);
      spritesL[i-1] = loadImage(filenameL);
      spritesL[i-1].resize(70,70);
    }
      
    }
    
  
  
  
  void display(){
    
   
   if(isMoving == false){
     if(direction == "right"){
       image(spritesR[1],x,y);
     }
     else{
       image(spritesL[1],x,y);
     } 
   }
   getCoin();
   text("Mario: " + coins, 10, 50);
   
   
   
  }
  
void getCoin() {
    if(x + 15 > coin.x && y + 20 > coin.y && x + 15 < coin.x + coin.w && y + 20 < coin.y + coin.h) {
      coins++;
    }
    if(x + 15 > koopa1.x +10 && y + 20 > koopa1.y && x + 15 < koopa1.x + 30 && y + 20 < koopa1.y + 50) {
      coins--;
    }
  }


  
  
  void move(){
  if(keyCode == LEFT){
    isMoving = true;
    direction = "left";
    if(x - step > 0){
      x -= step;
      frame = (frame + 1) % spritesL.length;
      image(spritesL[frame],x,y);
    }
    
  }
  
  if(keyCode == RIGHT){
    isMoving = true;
    direction = "right";
    if(x + step < width){
      x += step;   
      frame = (frame + 1) % spritesR.length;
      image(spritesR[frame], x,y);
      
    }
  }
  
  if(keyCode == UP){
    isMoving = true;
    if(hasJumped == false){
      y -= jump;
      hasJumped = true;
    }
    
    keyCode = DOWN;
    isMoving = false;
    if(keyCode == LEFT){
      direction = "left";
    }
    if(keyCode == RIGHT){
      direction = "right";
    }
    
    if(direction == "right"){
       image(spritesR[1],x,y);
     }
     else{
       image(spritesL[1],x,y);
     }
    
    image(spritesR[frame],x,y);
      
  }
  
  
  if(keyCode == DOWN){
      if(direction == "right"){
       image(spritesR[1],x,y);
     }
     else{
       image(spritesL[1],x,y);
     }
  
  }
 
  if(y < ground){
    if(direction == "right"){
       image(spritesR[1],x,y);
     }
     else{
       image(spritesL[1],x,y);
     }
    y += 8;
    if(y > ground){
      y = ground;
      hasJumped = false;
    }
    isMoving = true;
  }
  if(y == ground){
    isMoving = false;
    hasJumped = false;
    
    if(direction == "right"){
    image(spritesR[1],x,y);
     }
     else{
       image(spritesL[1],x,y);
     }
  }
  }  
  
/*  
void abovePlatform(Platform a){
  if(x >= a.x && x <= a.x + a.l && y <= a.y){  
    ground = a.y - 50;
    //print(x);
    //this.y = a.y;
  }
  else{
    ground = 375;
  }
}
  
*/
  
  
}
  
