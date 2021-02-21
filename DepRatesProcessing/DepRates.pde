String filename = "depressiondata2.csv";
String[] rawData;
ArrayList <Percent> allPercents = new ArrayList<Percent>();
int overallMin;
int overallMax;
float xSpacer;
float ySpacer;
int currYear = 2012;

void setup(){
  size(800,500);
  processData();
}

void draw(){
  background(0);
  drawGUI();
  for(Percent p : allPercents){
    p.display();
  }
  
}

void mouseReleased(){
  for(Percent p : allPercents){
    if(dist(mouseX, mouseY, p.button.x, p.button.y)<p.buttonSize/2){
      currYear = p.year;
    }
  }
}


void drawGUI(){
  stroke(100);
  fill(200);
 //fix arrays
  int[] demo = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};
  
  //x-axis
  for(int x=0; x<demo.length; x++){
  float xPos = xSpacer + (xSpacer * x);  
  line(xPos, height - ySpacer, xPos, ySpacer);
  textAlign(CENTER);
  text(demo[x], xPos-5, height - (ySpacer-15));
  
  }
  text(overallMin, xSpacer -15, height - ySpacer);
  text(overallMax, xSpacer -15, ySpacer);
  
  textAlign(LEFT);
  text("Select the year to view:", 50, 25);
  
}
void processData(){
    rawData = loadStrings(filename);
    for(int i=1; i<rawData.length; i+=22) {
    Percent p = new Percent();
    String[] firstRow = split(rawData[i], ",");
    p.year = int(firstRow[0]);
    for(int j=0; j<22; j++) {
      String[] thisRow = split(rawData[i+j], ",");
      p.perc[j] = int(thisRow[2]);

    }
    p.setMinMax();
    allPercents.add(p);
  }
  
  xSpacer = width/(22+1);
  ySpacer = 100;
  
  int[] mins = new int[7];
  int[] maxs = new int[7];
  
  for(int i=0; i<allPercents.size();i++){
    Percent p = allPercents.get(i);
    mins[i] = p.min;
    maxs[i] = p.max;
  }
   overallMin = min(mins);
   overallMax = max(maxs);
  
  for(Percent p : allPercents){

    p.setValues();
}
}
