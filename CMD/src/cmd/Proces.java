/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd;

import java.io.File;

/**
 *
 * @author vojta
 */
class Proces {
    private File actualDir;
    private String message;

    public Proces(File actualDir, String message) {
        this.actualDir = actualDir;
        this.message = message;
    }
    

    File getActualDir() {
        return actualDir;
    }

    String getMessage() {
        return message;
    }
    
}
