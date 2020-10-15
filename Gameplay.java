import processing.sound.*;
Mario new1;
Luigi luigi;
Coin coin;
PImage background;
SoundFile mario;
Platform p1, p2, p3;

PImage img;
KoopaSprite koopa1;
float drag = 30.0;

boolean circlePressed = false;
ButtonCircle circle;
ButtonCircle pause;
ButtonCircle play;
ButtonCircle quit;



void setup(){
  size(500,500);
  new1 = new Mario(50,375,100);
  background = loadImage("background.jpg");
  background.resize(500,500);
  frameRate(10);
  mario = new SoundFile(this, "mario.mp3");
  mario.play();
  
  coin = new Coin();

 
  p1 = new Platform(100,350,300,10);
  
  img = loadImage("PauseGamePic.PNG");
  img.resize(400,400);
  //circle = new ButtonCircle(600, 100, 50, color(#EA2424), color(#A29494));
  koopa1 = new KoopaSprite("koopa", 2, 3, 450, 380);

  //circle = new ButtonCircle(600, 100, 50, color(#EA2424), color(#A29494));
  //play = new Buttons(950, 100, 20, color(#F02229), color(#832D34));
  //pause = new Buttons(900, 100, 20, color(#F02229), color(#832D34));
  pause = new ButtonCircle(380, 30, 10, color(#EA2424), color(#A29494));
  play = new ButtonCircle(425, 30, 10, color(#EA2424), color(#A29494));
  quit = new ButtonCircle(470, 30, 10, color(#EA2424), color(#A29494));
  noStroke();
  
  

  luigi = new Luigi(300,390,50);
  //ypos = height * 0.25;
  
  
}


void draw(){
  image(background,0,0);
  if(luigi.coins >= 20 || new1.coins >= 20){
    PImage win = loadImage("WonGame.PNG");
    image(win,20,50);
  }
  if(luigi.coins < -20 || new1.coins < -20){
    PImage lose = loadImage("LostGame.PNG");
    image(lose,20,50);
  
  }
  
  p1.display();  
  
  new1.move();
  new1.display();
  
  
  luigi.display();
  abovePlatform(new1, p1);
  abovePlatform(luigi, p1);
  
  coin.display(); 
  
  pause.update(mouseX, mouseY);
  pause.display();
  textSize(12);
  text("Pause", 365, 60); 
  fill(0, 102, 153, 51);
 
  
  play.update(mouseX, mouseY);
  play.display();
  textSize(12);
  text("Play", 415, 60); 
  fill(0, 102, 153, 51);
  
 
  quit.update(mouseX, mouseY);
  quit.display();
  textSize(12);
  text("Restart", 450, 60); 
  fill(0, 102, 153, 51);

  koopa1.move();
  koopa1.display();
  
  
  
}

void abovePlatform(Mario c, Platform a){
  if(c.x >= a.x && c.x <= a.x + a.l && c.y <= a.y){  
    c.ground = a.y - 50;
    //print(x);
    //this.y = a.y;
  }
  else{
    c.ground = 375;
  }
}

void abovePlatform(Luigi c, Platform a){
  if(c.x >= a.x && c.x <= a.x + a.l && c.y <= a.y){  
    c.ground = a.y - 40;
    //print(x);
    //this.y = a.y;
  }
  else{
    c.ground = 375;
  }
}

void mousePressed() {
  if (pause.isPressed()) {
   play.display();
   play.update(mouseX, mouseY);
   quit.display();
   quit.update(mouseX, mouseY);
   circlePressed = !circlePressed; 
   image(img, 100, 100, 200, 200);
   noLoop();
     if (play.isPressed()) {
     circlePressed = !circlePressed; 
     //image(img, 300, 300, 400, 300);
     loop();
     }
  }
  
  if (play.isPressed()) {
   circlePressed = !circlePressed; 
   //image(img, 300, 300, 400, 300);
   loop();
  }
  
   if (quit.isPressed()) {
   circlePressed = !circlePressed; 
   //image(img, 300, 300, 400, 300);
   setup();
  }
  
  
 
 
}

void mouseReleased() {
  pause.isReleased();
  play.isReleased();
  quit.isReleased();
}


void keyPressed(){
  
  final int k = keyCode;
  if(k == 'P'){
   
    image(img, 300, 300, 400, 300);
    noLoop();
    
  }else{
     loop();
    }
}
