/*    */ package cmds;
/*    */ 
/*    */ import main.Main;
/*    */ import net.md_5.bungee.api.ChatColor;
/*    */ import net.md_5.bungee.api.CommandSender;
/*    */ import net.md_5.bungee.api.ProxyServer;
/*    */ import net.md_5.bungee.api.chat.BaseComponent;
/*    */ import net.md_5.bungee.api.chat.TextComponent;
/*    */ import net.md_5.bungee.api.connection.ProxiedPlayer;
/*    */ import net.md_5.bungee.api.plugin.Command;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class broadcast_cmd
/*    */   extends Command
/*    */ {
/*    */   public broadcast_cmd(String name) {
/* 21 */     super(name);
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(CommandSender cs, String[] args) {
/* 26 */     if (cs instanceof ProxiedPlayer) {
/* 27 */       ProxiedPlayer pp = (ProxiedPlayer)cs;
/* 28 */       if (pp.hasPermission("admin.bypass")) {
/* 29 */         if (args.length > 0) {
/* 30 */           String msg = Main.prefix + " §7";
/* 31 */           for (int i = 0; i < args.length; i++) {
/* 32 */             msg = msg + "§7" + args[i] + " ";
/*    */           }
/* 34 */           msg = ChatColor.translateAlternateColorCodes('&', msg);
/*    */           
/* 36 */           ProxyServer.getInstance().broadcast(msg);
/*    */         } else {
/*    */           
/* 39 */           pp.sendMessage((BaseComponent)new TextComponent(Main.prefix + "§cBenutzung: §a/broadcast §8[§7Nachricht§8]"));
/*    */         } 
/*    */       } else {
/*    */         
/* 43 */         pp.sendMessage(Main.prefix + "§cDu hast Keine Rechte um diesen Befehl auszuführen!");
/*    */       } 
/*    */     } else {
/* 46 */       cs.sendMessage((BaseComponent)new TextComponent(Main.prefix + "§7Du bist §ckein Spieler!"));
/*    */     } 
/*    */   }
/*    */ }
