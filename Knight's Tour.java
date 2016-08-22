package javaapplication2;
import java.util.Scanner;
import java.util.Random;

public class chess
{
    public static void main (String[]args)
    {
        Scanner inkey = new Scanner (System.in);
        System.out.println ("Please enter knights coordinates on the chessboard to evaluate ");
        System.out.print ("all positions it can make: ");
        
        //holds user input on board.
        int currentx = 0;
        int currenty = 0;
        currentx = inkey.nextInt();
        currenty = inkey.nextInt();
        
        //goes to function to generate random numbers to check availability.
        System.out.println (GenerateRandom());
        
        //Declares new variable for data type Position.
        Position mynewposition = new Position();
        
        //loops to find new available position on chessboard.
        for(int i =0;i<1000;i++)
        {
            mynewposition = MakeMove(currentx,currenty,GenerateRandom());
            if ((mynewposition.x>8) || (mynewposition.x<1) || (mynewposition.y>8) || (mynewposition.y<1))
            {
                mynewposition = MakeMove(mynewposition.x,mynewposition.y,GenerateRandom());
            }
            else
            {
                currentx = mynewposition.x;
                currenty = mynewposition.y;
                
                //Displays result of each move it can make from original input.
                DisplayResult(mynewposition.x, mynewposition.y);
                
                System.out.println("************************");
            }
        }
    }
    
    //Function to display board and result using 'X' to mark move on board.
    public static void DisplayResult(int x, int y)
    {
        for(int i = 1; i < 9; i++)
        {
            for (int j = 1; j < 9; j++)
            {
                if (x == i && y == j)
                {
                    System.out.print("[X]");
                }
                else
                {
                    System.out.print("[O]");
                }
            }
            System.out.println("\n");
        }
    }
    //Function that calculates the moves the can be made based on the 8 x 8 chessboard.
    public static Position MakeMove (int x, int y, int move)
    {
        Position MyPos = new Position();
        switch (move)
        {
            case 1:
                x = x-2;
                y = y-2;
                break;
            case 2:
                x = x-1;
                y = y-2;
                break;
            case 3:
                x = x+1;
                y= y-2;
                break;
            case 4:
                x = x-1;
                y = y-2;
                break;
            case 5:
                x = x+2;
                y = y-1;
                break;
            case 6:
                x = x+2;
                y = y+1;
                break;
            case 7:
                x = x+1;
                y = y+2;
                break;
            case 8:
                x = x-1;
                y = y+2;
                break;
            case 9:
                x = x-2;
                y = y+1;
                break;
        }
        MyPos.x = x;
        MyPos.y=y;
        return MyPos;
    }
    //Method. to retrieve the Random numbers
    public static int GenerateRandom()
    {
        Random MyRandom = new Random();
        int n = MyRandom.nextInt(8);
        n++;
        return n;
    }
}
//new Class (Position) defined outside Class(Chess).
class Position
{
    public int x;
    public int y;
}
