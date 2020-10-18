/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg3.geometries_cs141a;

import javax.swing.JOptionPane;

class CrammersRule {

    private double a1;//a
    private double b1;//b
    private double c1;//e
    private double a2;//c
    private double b2;//d
    private double c2;//f
    String message;

    CrammersRule(double a1, double a2, double b1, double b2, double c1, double c2) {
        this.a1 = a1;
        this.a2 = a2;
        this.b1 = b1;
        this.b2 = b2;
        this.c1 = c1;
        this.c2 = c2;
        message = "";
        performCalculations();
    }

    private void performCalculations() {

        double den = (a1 * b2) - (b1 * a2);

        double x = ((c1 * b2) - (b1 * c2)) / den;
        double y = ((a1 * c2) - (c1 * a2)) / den;
        
        double dx = (c1 * b2) - (b1 * c2);
        
        System.out.println("den: "+den+", x: "+x+", y: "+y);

        if (den == 0 && dx == 0) {
            message = "The system is dependent (same-line). It has infinately many solutions.";   
        }else if(den == 0){
            message = "The system is in-consistent. It has no solution.";
        }else {
            message = String.format("The point of intersaction is (%.2f, %.2f)", x, y);
        }
    }

    public String toString() {
        return message;
    }

}
