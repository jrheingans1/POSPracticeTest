/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possystem;

import javax.swing.JOptionPane;

/**
 *
 * @author jrheingans1
 */
public class GUIOutput implements OutputStrategy {

    @Override
    public void getOutput(String output) {
        JOptionPane.showMessageDialog(null, output);
    }
}
