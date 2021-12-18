package net.lindseybot.legacy.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.lindseybot.legacy.models.SlashConverter;
import net.lindseybot.worker.legacy.FakeSlashData;
import org.springframework.stereotype.Component;

@Component
public class FlipCommand extends SlashConverter {

    @Override
    public String[] getNames() {
        return new String[]{"flip"};
    }

    @Override
    public FakeSlashData convert(GuildMessageReceivedEvent event, String name, String[] args) {
        return this.createData(event, "flip");
    }

}
