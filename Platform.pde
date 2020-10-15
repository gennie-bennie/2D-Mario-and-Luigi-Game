class Platform{
  float x, y, l, h;
  
  Platform(float x, float y, float l, float h){
    this.x = x;
    this.y = y;
    this.l = l;
    this.h = h;
    rectMode(CORNER);
  }
  
  
  void display(){
  
  pushMatrix();
  fill(color(106,29,29));
  rect(x,y,l,h);
  popMatrix();
    
  }


}
