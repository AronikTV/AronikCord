/*    */ package listener;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import main.Main;
/*    */ import net.md_5.bungee.api.chat.BaseComponent;
/*    */ import net.md_5.bungee.api.chat.TextComponent;
/*    */ import net.md_5.bungee.api.connection.ProxiedPlayer;
/*    */ import net.md_5.bungee.api.event.ChatEvent;
/*    */ import net.md_5.bungee.api.plugin.Listener;
/*    */ import net.md_5.bungee.event.EventHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChatListener
/*    */   implements Listener
/*    */ {
/* 22 */   HashMap<ProxiedPlayer, Long> spam = new HashMap<>();
/*    */   
/*    */   @EventHandler
/*    */   public void onChat(ChatEvent e) {
/* 26 */     ProxiedPlayer p = (ProxiedPlayer)e.getSender();
/* 27 */     String msg = e.getMessage().replaceAll("%", "%%");
/*    */     
/* 29 */     if (p.hasPermission("admin.bypass")) {
/* 30 */       if (this.spam.containsKey(p)) {
/* 31 */         if (((Long)this.spam.get(p)).longValue() > System.currentTimeMillis()) {
/* 32 */           e.setCancelled(true);
/*    */         } else {
/*    */           
/* 35 */           this.spam.put(p, Long.valueOf(System.currentTimeMillis() + 0L));
/*    */         } 
/*    */       } else {
/* 38 */         this.spam.put(p, Long.valueOf(System.currentTimeMillis() + 0L));
/*    */       }
/*    */     
/*    */     }
/* 42 */     else if (this.spam.containsKey(p)) {
/* 43 */       if (((Long)this.spam.get(p)).longValue() > System.currentTimeMillis()) {
/* 44 */         e.setCancelled(true);
/* 45 */         p.sendMessage((BaseComponent)new TextComponent(Main.prefix + "&bDu darfst auf diesem Netzwerk §fnicht §bSpammen!"));
/*    */       } else {
/* 47 */         this.spam.put(p, Long.valueOf(System.currentTimeMillis() + 3000L));
/*    */       } 
/*    */     } else {
/* 50 */       this.spam.put(p, Long.valueOf(System.currentTimeMillis() + 3000L));
/*    */     } 
/*    */   }
/*    */ }
