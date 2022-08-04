//the snake

import java.util.LinkedList;

public class Snake{
  private LinkedList<Cell> SnakeList = new LinkedList<>();
  private Cell head;

  public Snake(Cell initPos){
    head = initPos;
    SnakeList.add(head);
    head.setCellType(CellType.SNAKE_NODE);
  }
  public void grow(){
    SnakeList.add(head);

  }
  public void Move(Cell nextCell){
    System.out.println("Snake moving to " + nextCell.getRow() + " " + nextCell.getCol());
    Cell tail = SnakeList.removeLast();
    tail.setCellType(CellType.EMPTY);
    head =nextCell;
    head.setCellType(CellType.SNAKE_NODE);
    SnakeList.addFirst(head);
  }

  public boolean CheckCrash(Cell nextCell){
    System.out.println("Crash Check");
    for(Cell cell : SnakeList){
      if(cell ==nextCell){
        return true;
      } 
    }
        return false;
  }

  public LinkedList<Cell> getSnakeList(){
    return SnakeList;

  }
  public void setSnakeList(LinkedList<Cell> SnakeList){
    this.SnakeList = SnakeList;
  }
  public Cell getHead(){
    return head;

  }
  public void setHead(Cell head){
    this.head = head;
  }
}
