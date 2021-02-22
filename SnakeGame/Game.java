public class Game{
  public static final int NO_DIRECTION = 0, RIGHT_DIRECTION = 1, LEFT_DIRECTION = -1, UP_DIRECTION = 2, DOWN_DIRECTION = -2;

  private Snake snake;
  private Board board;
  private int direction;
  private boolean GameOver;

  public Game(Snake snake, Board board){

    this.snake = snake;
    this.board = board;
  }
  public Snake getSnake(){
    return snake;
  }
  public void setSnake(Snake snake){
    this.snake=snake;
  }
  public Board getBoard(){
    return board;

  }
  public void setBoard(Board board){
    this.board = board;
  }
  public boolean ItsGameOver(){
    return GameOver;

  }
  public void setGameOver(boolean GameOver){
    this.GameOver = GameOver;

  }
  public int getDirection(){
    return direction;

  }
  public void setDirection(int direction){
    this.direction = direction;
  }
  public void update(){
    System.out.println("Updating game");
    if(!GameOver){
      if(direction!=NO_DIRECTION){
        Cell nextCell = getNextCell(snake.getHead());
        if(snake.CheckCrash(nextCell)){
          setDirection(NO_DIRECTION);
          GameOver = true;
        }else{
          snake.Move(nextCell);
          if(nextCell.getCellType() == CellType.FOOD){
            snake.grow();
            board.FoodGenerator();
          }
        }
      }
    }
  }
private Cell getNextCell(Cell currPosition){
  System.out.println("Finding next cell");
  int row = currPosition.getRow();
  int col = currPosition.getCol();

  if(direction == RIGHT_DIRECTION){
    col++;
  }else if(direction == LEFT_DIRECTION){
    col--;
  }else if(direction == UP_DIRECTION){
      row++;
    }else if(direction == DOWN_DIRECTION){
      row--;
    }
    Cell nextCell = board.getCells()[row][col];
    return nextCell;
  }
  public static void main(String[] args){
    System.out.println("Game Starting...");
    Cell initPos = new Cell(0,0);
    Snake initSnake = new Snake(initPos);
    Board board = new Board(10,10);
    Game newGame = new Game(initSnake, board);
    newGame.GameOver = false;
    newGame.direction = RIGHT_DIRECTION;

    for(int i=0;i<5;i++){
      if(i ==2){
      newGame.board.FoodGenerator();
      newGame.update();
    }if(i==3){
        newGame.direction = RIGHT_DIRECTION;
      }if(newGame.GameOver == true){
        break;
}
}
  }
}
