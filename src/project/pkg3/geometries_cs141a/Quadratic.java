/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg3.geometries_cs141a;

class Quadratic {

    double[] roots = new double[2];
    double[] eqn = new double[3];
    String vertix = "";
    double y = 0;
    double axisOfSymetry = 0;
    String concavity = "";
    static String rootsString = "";
    static String solution = "";

    Quadratic(double aVal, double bVal, double cVal) {
        eqn[0] = aVal;
        eqn[1] = bVal;
        eqn[2] = cVal;
        solution = "real";
        solveQuadratic(eqn, roots);
        findVertix(eqn);
        findYIntercept(eqn);
        findAxisOfSymetry(eqn);
        findConcavity(eqn);
    }

    public static int solveQuadratic(double[] eqn, double[] roots) {
        double determinant = eqn[1] * eqn[1] - 4 * eqn[0] * eqn[2];
        // condition for real and different roots
        if (determinant > 0) {
            roots[0] = (-eqn[1] + Math.sqrt(determinant)) / (2 * eqn[0]);
            roots[1] = (-eqn[1] - Math.sqrt(determinant)) / (2 * eqn[0]);

            rootsString = String.format("root1 = %.2f\nroot2 = %.2f", roots[0], roots[1]);
        } // Condition for real and equal roots
        else if (determinant == 0) {
            roots[0] = roots[1] = -eqn[1] / (2 * eqn[0]);

            rootsString = String.format("root1 = root2 = %.2f;", roots[0]);
        } // If roots are not real
        else {
            double realPart = -eqn[1] / (2 * eqn[0]);
            double imaginaryPart = Math.sqrt(-determinant) / (2 * eqn[0]);

            rootsString = String.format("root1 = %.2f+%.2fi\nroot2 = %.2f-%.2fi", realPart, imaginaryPart, realPart, imaginaryPart);
            solution = "imaginary";
        }
        return roots.length;

    }

    void findVertix(double[] eqn) {
        vertix = "V(" + (-eqn[1] / (2 * eqn[0])) + ", " + (((4 * eqn[0] * eqn[2]) - (eqn[1] * eqn[1])) / (4 * eqn[0])) + ")";
    }

    void findYIntercept(double[] eqn) {
        //y = eqn[2] - ((eqn[1] * eqn[1]) + 1) * 4 * eqn[0];
        y = eqn[2];
    }

    void findAxisOfSymetry(double[] eqn) {
        axisOfSymetry = -eqn[1] / (2 * eqn[0]);
    }

    void findConcavity(double[] eqn) {
        if (eqn[0] > 0) {
            concavity = "The parabola concave upward.";
        } else if (eqn[0] < 0) {
            concavity = "The parabola concave downward.";
        } else {
            concavity = "Linear equation.";
        }
    }

    public String toString() {
        return concavity + "\n\nThe axis of symetry of the parabola is: \ny = " + axisOfSymetry + "\n\nThe vertix of parabola is \n" + vertix
                + "\n\nThe y-intercept is: y = " + y + "\n\n"+rootsString+"\n\nTwo "+solution+" solutions.";
    }

}
