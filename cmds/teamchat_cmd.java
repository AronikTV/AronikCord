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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class teamchat_cmd
/*    */   extends Command
/*    */ {
/*    */   public teamchat_cmd(String name) {
/* 24 */     super(name);
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(CommandSender cs, String[] args) {
/* 29 */     if (cs instanceof ProxiedPlayer) {
/* 30 */       ProxiedPlayer pp = (ProxiedPlayer)cs;
/* 31 */       if (pp.hasPermission("admin.bypass")) {
/* 32 */         String msg = Main.prefix + "§8§7" + pp.getServer().getInfo().getName() + " §8» §7" + pp.getDisplayName() + " §8» §7";
/* 33 */         for (int i = 0; i < args.length; i++) {
/* 34 */           msg = msg + "§7" + args[i] + " ";
/*    */         }
/* 36 */         for (ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
/* 37 */           if (all.hasPermission("admin.bypass")) {
/* 38 */             msg = ChatColor.translateAlternateColorCodes('&', msg);
/*    */             
/* 40 */             all.sendMessage((BaseComponent)new TextComponent(msg));
/*    */           }
/*    */         
/*    */         } 
/*    */       } else {
/*    */         
/* 46 */         pp.sendMessage(Main.prefix + "§cDu hast Keine Rechte um diesen Befehl auszuführen!");
/*    */       } 
/*    */     } else {
/*    */       
/* 50 */       cs.sendMessage((BaseComponent)new TextComponent("§7Du bist §ckein Spieler!"));
/*    */     } 
/*    */   }
/*    */ }
