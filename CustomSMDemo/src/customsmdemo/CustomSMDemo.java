/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customsmdemo;

import java.io.File;
import java.io.FilePermission;
import java.security.AccessControlContext;
import java.security.AccessController;

/**
 *
 * @author Dan
 */
public class CustomSMDemo extends SecurityManager {

    public static void main(String[] args) {
        AccessControlContext con = AccessController.getContext();
        File file = new File("CustomSMDemo.policy");
        System.setProperty("java.security.policy", "D:\\iti\\security\\CustomSMDemo\\src\\customsmdemo\\CustomSMDemo.policy\"" +file.getAbsolutePath()   );
// create a security manager
CustomSMDemo sm = new CustomSMDemo();
// set the system security manager
        System.setSecurityManager(sm);
// perform the check
        sm.checkPermission(new FilePermission("C:\\Users\\Dan\\Desktop\\Data.txt", "write"), con);
// print a message if we passed the check
        System.out.println("Allowed!");
    }
}
