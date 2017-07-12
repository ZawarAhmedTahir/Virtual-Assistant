/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sun.speech.freetts.*;
/**
 *
 * @author Hp
 */
class Jsapi extends LoginForm{
            public static final String VOICENAME= "kevin16";
        public Jsapi() {
            
        }
        
    }
public class Main {
    public static final String VOICENAME= "kevin16";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Voice voice;               //Voice Object
        VoiceManager vm=VoiceManager.getInstance();
        voice=vm.getVoice(VOICENAME);
        voice.allocate();
        LoginForm obj = new LoginForm();
        Thread tobj = new Thread(obj);
        tobj.start();
        LoginForm newForm=new LoginForm();
        newForm.setVisible(true); 
    }
}
