
package lemonpepper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;



public class MC extends JavaPlugin implements Listener{    

    
   
            
    @Override
    public void onEnable(){
        getServer().getPluginManager().registerEvents(this, this);
    }
 
    @Override
    public void onDisable() {
        // TODO Insert logic to be performed when the plugin is disabled
    }
    
  
    @EventHandler (priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void PlayerChat(PlayerCommandPreprocessEvent event){
        
           try {
                Player player = event.getPlayer();
                String name = player.getDisplayName();
                String msg = event.getMessage();
                event.setMessage(msg);
                DateFormat dateFormat = new SimpleDateFormat("MM/dd HH:mm");
                Date date = new Date();
                String newLine = System.getProperty("line.separator");
                         
		File file = new File("C://Bukkit/whisperlog.txt");
 
		if (!file.exists()) {
				file.createNewFile();
		}
 
		FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		BufferedWriter bw = new BufferedWriter(fw);
                bw.append(dateFormat.format(date) + "- " + name + ": " + msg + newLine);
		bw.flush();
		bw.close();
                        
	
                } 
                catch (IOException e) {
			e.printStackTrace();
                }
            }      
      

 
    @EventHandler (priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
      
       
            try {
                Player player = event.getPlayer();
                String name = player.getDisplayName();
                String msg = event.getMessage();
                event.setMessage(msg);
                DateFormat dateFormat = new SimpleDateFormat("MM/dd HH:mm");
                Date date = new Date();
                String newLine = System.getProperty("line.separator");
                         
		File file = new File("C://Bukkit/chatlog.txt");
 
		if (!file.exists()) {
				file.createNewFile();
		}
 
		FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		BufferedWriter bw = new BufferedWriter(fw);
                bw.append(dateFormat.format(date) + "- " + name + ": " + msg + newLine);
		bw.flush();
		bw.close();
                        
	
                } 
                catch (IOException e) {
			e.printStackTrace();
                }
            }
     
    }

        
    

    
