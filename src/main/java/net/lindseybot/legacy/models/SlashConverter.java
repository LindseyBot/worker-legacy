package net.lindseybot.legacy.models;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.lindseybot.worker.legacy.FakeSlashData;

public abstract class SlashConverter {

    /**
     * Command name.
     *
     * @return Name of the handled command.
     */
    public abstract String[] getNames();

    public abstract FakeSlashData convert(GuildMessageReceivedEvent event, String name, String[] args);

    protected FakeSlashData createData(GuildMessageReceivedEvent event, String path) {
        FakeSlashData data = new FakeSlashData();
        data.setGuildId(event.getGuild().getIdLong());
        data.setChannelId(event.getChannel().getIdLong());
        data.setMessageId(event.getMessageIdLong());
        data.setMemberId(event.getAuthor().getIdLong());
        data.setResponseNumber(event.getResponseNumber());
        return data;
    }

    protected String argsToString(String[] args, int index) {
        StringBuilder myString = new StringBuilder();
        for (int i = index; i < args.length; i++) {
            String arg = args[i] + " ";
            myString.append(arg);
        }
        if (myString.length() > 0) {
            myString = new StringBuilder(myString.substring(0, myString.length() - 1));
        }
        return myString.toString();
    }

}
