/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possystem;

/**
 *
 * @author jrheingans1
 */
public class ConsoleOutput implements OutputStrategy {

    @Override
    public void getOutput(String output) {
        System.out.println(output);
    }
}
