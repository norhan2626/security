/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staticclassloader;

/**
 *
 * @author Dan
 */public class AStatic {

    public static int yiyu = -1;

    public static int getYiyu() {
        return yiyu;
    }

    public static void setYiyu(int yiyu) {
        AStatic.yiyu = yiyu;
    }

    public static void printYiyu(String instanceName){
        System.out.println("The static member yiyu's value in " 
                + instanceName + " is " + AStatic.yiyu);
    }

}