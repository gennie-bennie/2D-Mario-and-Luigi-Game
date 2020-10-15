class KoopaSprite{
  PImage[] images;
  int imageCount;
  int frame;
  int speed;
  float x, y;
  
  KoopaSprite(String imagePrefix, int count, int speed, float x, float y) {
    imageCount = count;
    images = new PImage[imageCount];
    
    this.speed = speed;
    this.x = x;
    this.y = y;

    for (int i = 0; i < imageCount; i++) {
      // Use nf() to number format 'i' into four digits
      String filename = imagePrefix + nf(i, 4) + ".gif";
      images[i] = loadImage(filename);
      images[i].resize(50,50);
    }
  }
  
    void move(){
    
    if(x >= width || x <= 0){
      speed = speed*-1;

    }
    
  }

  void display() {
    
    x -= speed;
    
    frame = (frame+1) % imageCount;
    image(images[frame], x, y);
    
  }
  
 int getWidth() {
    return images[0].width;
  }

  }
