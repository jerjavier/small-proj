//Board display

public class Board{
  final int COUNT_ROW;
  final int COUNT_COL;
  private Cell[][] cells;

  public Board(int CountRow, int CountCol){
    COUNT_ROW = CountRow;
    COUNT_COL = CountCol;
    cells = new Cell[COUNT_ROW][COUNT_COL];
    for(int row=0;row<COUNT_ROW;row++){
      for(int col=0;col<COUNT_COL;col++){
        cells[row][col] = new Cell(row,col);
      }
    }
  }
public Cell[][] getCells(){
  return cells;
}
public void setCells(Cell[][] cells){
  this.cells = cells;

}
  public void FoodGenerator(){
    System.out.println("Generating snake food");
    while(true){
      int row = (int)(Math.random()*COUNT_ROW);
      int col = (int)(Math.random()*COUNT_COL);
      if(cells[row][col].getCellType()!=CellType.SNAKE_NODE){
        break;
      }
      cells[row][col].setCellType(CellType.FOOD);
      System.out.println("generating food at " +row+" "+col);
    }
  }
}
