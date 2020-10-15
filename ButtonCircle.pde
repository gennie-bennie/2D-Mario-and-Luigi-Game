class ButtonCircle extends Button {
 int x, y;
 int r;
 
 ButtonCircle(int _x, int _y, int _r, color _s, color _us) {
   super(_s, _us);
   x = _x;
   y = _y;
   r = _r;
 }
 
 void update(int mx, int my) {
   if (dist(mx, my, x, y) <= r) {
     isMouseOver = true;
   } else {
     isMouseOver = false;
   }
 }
 
 void drawButton() {
   ellipse(x, y, r*2, r*2);
 }
}
