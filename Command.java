package bot.discord;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Timer;
import java.util.TimerTask;


public class Command extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent e) {
        if(e.getMessage().getContent().startsWith("!")) {
            String[] args = e.getMessage().getContent().replaceFirst( "!", "").split( " ");



            switch(args[0]) {
                case "hello": hello(e.getMessage()); System.out.println("says hello"); break;
                case "delete" : delete(e.getMessage()); System.out.println("deleting memes"); break;
            }
        }
    }


    private void hello(Message msg) {
        String user = msg.getAuthor().getName().toString();
        msg.getChannel().sendMessage( "Hello "+ user).queue(m-> {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    //msg.delete().queue();
                }
            }, 5000);
        });

    }

    private void delete(Message msg) {
        String user = msg.getAuthor().getName().toString();
        msg.getChannel().sendMessage("Deleting " + user + "'s data from their hard drive\nbeep\nboop").queue(m-> {
            ;

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    msg.delete().queue();
                }
            }, 5000);
        });
    }


}
