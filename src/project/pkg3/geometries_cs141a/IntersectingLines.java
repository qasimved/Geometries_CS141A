/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg3.geometries_cs141a;

class IntersectingLines {

    double x1;
    double y1;
    double x2;
    double y2;
    double x3;
    double y3;
    double x4;
    double y4;
    
    double x;
    double y;
    String message;

    IntersectingLines(double x1, double y1,
            double x2, double y2,
            double x3, double y3,
            double x4, double y4) {
        
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;
        
        message = "";
        performCalculations();
        
    }

    private void performCalculations() {
        double a1 = y2-y1;
        double b1 = x1-x2;
        double c1 = (a1*x1)+(b1*y1);
        
        double a2 = y4-y3;
        double b2 = x3-x4;
        double c2 = (a2*x3)+(b2*y3);
        
        double delta = (a1*b2)-(a2*b1);
        
        double x = ((b2*c1)-(b1*c2))/delta;
        double y = ((a1*c2)-(a2*c1))/delta;
        
        if(!Double.isInfinite(x) && !Double.isInfinite(y)){
            message = String.format("The point of intersaction is (%.2f, %.2f)", x, y);
        }else{
            message = "The two lines are parallel.";
        }
        
        
    }
    
    public String toString(){
        return message;
    }

}
