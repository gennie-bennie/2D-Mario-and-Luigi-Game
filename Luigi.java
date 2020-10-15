class Luigi{
  PImage spriteSheet;
  float x, y, jump, ground;
  PImage[][] images;
  boolean inMotion, hasJumped;
  int jumped;
  int currentDirection;
  float currentFrame;
  final int LEFT = 0, RIGHT = 1;
  int coins;
  
  Luigi(float x, float ground, float jump) {
   this.x = x;
   this.y = ground;
   this.ground = ground;
   this.jump = jump;
   
   setupSprites();
   
  }
  
  void setupSprites() {
   images = new PImage[2][4];
   spriteSheet = loadImage("luigi2.png");
   
   images[0][0] = spriteSheet.get(5 + 24, 40, 29, 40);
   images[1][0] = spriteSheet.get(5 + 24, 80, 29, 40);
   
   for(int i = 0; i < 3; i++) {
     images[0][i+1] = spriteSheet.get(5 + 24*i+1, 40, 29, 40);
     images[1][i+1] = spriteSheet.get(5 + 24*i+1, 80, 29, 40);
   }
  }
  
  void display() {
   move();
   fill(0);
   getCoin();
   text("Luigi: " + coins, 10, 100);
    
   if(inMotion) {
    image(images[currentDirection][1 + int(currentFrame)], x, y);
   } else {
    image(images[currentDirection][0], x, y); 
   }
  }
  
  void updatePlayer(int xDelta, int yDelta) {
   currentFrame = (currentFrame + 0.1) % 3;
   
   inMotion = true;
   if(xDelta == 0) {
    inMotion = false; 
   } else if(xDelta == -1) {
    currentDirection = LEFT;
   } else if(xDelta == 1) {
    currentDirection = RIGHT; 
   }
   
   x = x + xDelta * 10;
   y = y + yDelta * 3;
   
   if(y < ground) {
    y += 4;
    if(keyPressed && key == 's' && hasJumped && jumped < 2) {
     y -= jump; 
     hasJumped = false;
     jumped++;
    }
    if(y >= ground) {
      y = ground;
      jumped = 0;
      hasJumped = false;
    }
   }
   
   
   if(isPlayerOffScreen(x)) {
    x = x - xDelta;
   }
   
  }
  
  boolean isPlayerOffScreen(float x) {
   if(x < 0 || x > width-29) {
    return true; 
   } else {
    return false; 
   }
  }
  
   void getCoin() {
    if(x + 15 > coin.x-5 && y + 20 > coin.y-5 && x + 15 < coin.x + coin.w + 5 && y + 20 < coin.y + coin.h + 5) {
      coins++;
    }
    if(x + 15 > koopa1.x + 20 && y + 20 > koopa1.y && x + 15 < koopa1.x + 30 && y + 20 < koopa1.y + 50) {
      coins--; 
    }
  }

  
  void move() {
   int xDelta = 0;
   int yDelta = 0;
   
   if(keyPressed) {
     if(key == 'w') {
      if(!hasJumped && jumped < 2) {
        yDelta -= jump;
        jumped++;
        hasJumped = true;
      }
     }
     if(key == 'a') {
       xDelta--;
     }
     if(key == 'd') {
       xDelta++; 
     }
   }
   
   updatePlayer(xDelta, yDelta);
  }
}
