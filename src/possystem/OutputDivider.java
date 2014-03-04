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
public class OutputDivider {


        public static enum OutputStrategies {

            CONSOLE, GUI;
        }
        private static OutputDivider instance;

        public static OutputDivider getInstance() {
            if (instance == null) {
                instance = new OutputDivider();
            }
            return instance;
        }

        public OutputStrategy getOutput(OutputStrategies outputType) {
            OutputStrategy o = null;
            switch (outputType) {
                case CONSOLE:
                    o = new ConsoleOutput();
                    break;
                case GUI:
                    o = new GUIOutput();
                    break;
            }
            return o;
        }
    }

