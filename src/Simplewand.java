package me.specops.simplewand;
//Main Package
import java.util.logging.Logger;
//Java Imports
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
//Bukkit Imports
import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;
//Permissions Imports
public class Simplewand extends JavaPlugin {
	public static Simplewand plugin;
	
	public final Logger logger = Logger.getLogger("Minecraft");
	private final SimplewandPlayerListener playerListener = new SimplewandPlayerListener();
	private final SimplewandEntityListener entityListener = new SimplewandEntityListener();
	public static PermissionHandler permissionHandler;
	private void setupPermissions() {
	    if (permissionHandler != null) {
	        return;
	    }
	    
	    Plugin permissionsPlugin = this.getServer().getPluginManager().getPlugin("Permissions");
	    
	    if (permissionsPlugin == null) {
	        this.logger.info("Permission system not detected, defaulting to OP");
	        return;
	    }
	    
	    permissionHandler = ((Permissions) permissionsPlugin).getHandler();
	    this.logger.info("Found and will use plugin "+((Permissions)permissionsPlugin).getDescription().getFullName());
	}
	
	
	
@Override
public void onDisable() {
	this.logger.info("Simplewand Disabled.");
}

@Override
public void onEnable() {
	PluginManager pm = getServer().getPluginManager();
	pm.registerEvent(Event.Type.PLAYER_INTERACT, this.playerListener, Event.Priority.Normal, this);
	PluginDescriptionFile pdfFile = this.getDescription(); 
	this.logger.info( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
	setupPermissions();
	
	{



}
}
}