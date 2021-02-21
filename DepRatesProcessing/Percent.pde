class Percent{
  
 int year;
 int[] demo = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};
 int [] perc = new int[22];
 int min;
 int max;
 PVector[] pos = new PVector[22];
  PVector button = new PVector();
  int buttonSize = 30;
 
  Percent(){
    
  }
  
void display(){
  stroke(200);
  if(currYear == year){
  fill(255);
  for(int i = 0; i <pos.length; i++){
    ellipse(pos[i].x, pos[i].y, 10, 10);
    if(i<pos.length-1){
      line(pos[i].x,pos[i].y, pos[i+1].x, pos[i+1].y);
    }
  }
  fill(#add8e6);
  stroke(200);
  ellipse(button.x, button.y+2, buttonSize, buttonSize);
  fill(40);
  textAlign(CENTER);
  text(currYear, button.x+2, button.y+4);
  }
  else{
  noFill();
  stroke(0);
  ellipse(button.x, button.y, buttonSize, buttonSize);
  fill(255);
  textAlign(CENTER);
  text(year, button.x+2, button.y+4);
  }
  
}

 //functions
 void setMinMax(){
   min = min(perc);
   max = max(perc);
 
 }
 
 void setValues(){
   float graphHeight = (height - ySpacer) - ySpacer;
   for(int i = 0;i<perc.length;i++){
     float adjVal = map(perc[i], overallMin, overallMax, 0, graphHeight);
     pos[i] = new PVector();
     pos[i].x = xSpacer * (i+1);
     pos[i].y = (height - ySpacer) - adjVal;
   }
 //  button
 button.y = 25;
 button.x = 250 + ((year-2011) * 40);
 }
 

}
