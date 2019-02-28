/*
 * @author: Martins Anerua.
 * Martins Anerua © 2018.
 * All rights reserved.
 */
package anerua.safe.software;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author MARTINS
 */
public class BetaFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        
        if(f.isDirectory()){
            return true;
        }
        String name = f.getName();
        String extension;
        
        int pointIndex = name.lastIndexOf(".");
        if (pointIndex == -1) {
            extension = null;
        }

        else if (pointIndex == name.length() - 1) {
            extension = null;
        }
        
        else {
            extension = name.substring(pointIndex+1, name.length());
        }
        
        if (extension == null){
            return false;
        }
        
        else if (extension.equals("beta")){
            return true;
        }
        
        return false;
    }

    @Override
    public String getDescription() {
        return "Beta ISA files (*.beta)";
    }

}
