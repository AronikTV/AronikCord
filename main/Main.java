/*    */ package main;
/*    */ 
/*    */ import cmds.broadcast_cmd;
/*    */ import cmds.bungeepl_cmd;
/*    */
/*    */ import cmds.teamchat_cmd;
/*    */ import listener.ChatListener;
/*    */ import net.md_5.bungee.BungeeCord;
/*    */ import net.md_5.bungee.api.plugin.Command;
/*    */ import net.md_5.bungee.api.plugin.Listener;
/*    */ import net.md_5.bungee.api.plugin.Plugin;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Main
/*    */   extends Plugin
/*    */ {
/* 25 */   public static String prefix = "§4§lDeinName§f§l.de §7";
/*    */   
/*    */   public static Main plugin;
/*    */   
/*    */   public void onEnable() {
/* 30 */     plugin = this;
/*    */     
/* 32 */     BungeeCord.getInstance().getConsole().sendMessage(prefix + "Plugin wurde erfolgreich §aaktiviert! Plugin by AronikTV");
/*    */
/* 36 */     BungeeCord.getInstance().getPluginManager().registerListener(this, (Listener)new ChatListener());
/* 37 */     BungeeCord.getInstance().getPluginManager().registerCommand(this, (Command)new broadcast_cmd("broadcast"));
/* 38 */     BungeeCord.getInstance().getPluginManager().registerCommand(this, (Command)new broadcast_cmd("alert"));
/* 39 */     BungeeCord.getInstance().getPluginManager().registerCommand(this, (Command)new broadcast_cmd("bc"));
/* 41 */     BungeeCord.getInstance().getPluginManager().registerCommand(this, (Command)new teamchat_cmd("tc"));
/* 42 */     BungeeCord.getInstance().getPluginManager().registerCommand(this, (Command)new bungeepl_cmd("bungeeplugins"));
/* 43 */     BungeeCord.getInstance().getPluginManager().registerCommand(this, (Command)new bungeepl_cmd("bpl"));
/* 44 */     BungeeCord.getInstance().getPluginManager().registerCommand(this, (Command)new bungeepl_cmd("bplugins"));
/* 41 */     BungeeCord.getInstance().getPluginManager().registerCommand(this, (Command)new teamchat_cmd("teamchat"));
/*    */   }
/*    */ 
/*    */   
/*    */   public void onDisable() {
/* 49 */     BungeeCord.getInstance().getConsole().sendMessage(prefix + "§aPlugin wurde erfolgreich §cdeaktiviert! Plugin by AronikTV");
/*    */   }
/*    */ }
