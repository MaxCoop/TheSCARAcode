import java.io.*;
import ecs100.*;

public class circle{
    
    private int angle = 0;
    private int increment = 5;
    
    private double xOffset = 340;
    private double yOffset = 180;
    
    private double xRadius = 50; //radius of circle (same and its symmetrical)
    private double yRadius = 50;
    //vairiables 
    private double x;
    private double y;
    private double x2;
    private double y2;
    
    private PrintStream output;

    public circle(){
        
        UI.initialise();
        UI.setDivider(0.5);
        
        UI.addButton("Create Cirlce (and save it)", this::calculateCircle);
        try{
            output = new PrintStream(new File("FinalDrawCircle.txt"));
        }catch(FileNotFoundException e){}
    }

    public void calculateCircle(){
        //Generates the circle
        
        x = (Math.sin(Math.toRadians(angle)))*xRadius;
        y = (Math.cos(Math.toRadians(angle)))*yRadius;
        
        while(angle <= 360){
            

            x2 = (Math.sin(Math.toRadians(angle)))*xRadius;
            y2 = (Math.cos(Math.toRadians(angle)))*yRadius;

            UI.drawLine(x+100, y+100, x2+100, y2+100);

            x = x2;
            y = y2;

            double xOut = ((Math.round(x*10))/10.0)+xOffset;
            double yOut = ((Math.round(y*10))/10.0)+yOffset;


            output.println(xOut+" "+yOut+" 1");

            angle = angle+increment;
        }
    }
}
