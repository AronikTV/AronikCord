/*    */ package cmds;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import main.Main;
/*    */ import net.md_5.bungee.api.CommandSender;
/*    */ import net.md_5.bungee.api.chat.BaseComponent;
/*    */ import net.md_5.bungee.api.chat.TextComponent;
/*    */ import net.md_5.bungee.api.connection.ProxiedPlayer;
/*    */ import net.md_5.bungee.api.plugin.Command;
/*    */ import net.md_5.bungee.api.plugin.Plugin;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class bungeepl_cmd
/*    */   extends Command
/*    */ {
/*    */   public bungeepl_cmd(String name) {
/* 23 */     super(name);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void execute(CommandSender cs, String[] args) {
/* 29 */     ProxiedPlayer pp = (ProxiedPlayer)cs;
/* 30 */     if (args.length >= 0) {
/* 31 */       if (pp.hasPermission("admin.bypass")) {
/* 32 */         Collection<Plugin> plugins = Main.plugin.getProxy().getPluginManager().getPlugins();
/* 33 */         String pl = "";
/* 34 */         for (Plugin p : plugins)
/* 35 */           pl = String.valueOf(pl) + p.getDescription().getName() + "§8, §3"; 
/* 36 */         pl = pl.substring(0, pl.length() - 4);
/* 37 */         pp.sendMessage((BaseComponent)new TextComponent(Main.prefix + "BungeePlugins §8» §7(§b" + plugins.size() + "§7) §3" + pl));
/*    */       } else {
/*    */         
/* 40 */         pp.sendMessage(Main.prefix + "§cDu hast keine Rechte um diesen Befehl auszuführen!");
/*    */       } 
/*    */     } else {
/* 43 */       pp.sendMessage((BaseComponent)new TextComponent(Main.prefix + "§cBenutzung: §a/bungeeplugins"));
/*    */     } 
/*    */   }
/*    */ }
