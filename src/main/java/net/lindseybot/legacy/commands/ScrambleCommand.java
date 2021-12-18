package net.lindseybot.legacy.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.lindseybot.legacy.models.SlashConverter;
import net.lindseybot.worker.legacy.FakeSlashData;
import org.springframework.stereotype.Component;

@Component
public class ScrambleCommand extends SlashConverter {

    @Override
    public String[] getNames() {
        return new String[]{"scramble"};
    }

    @Override
    public FakeSlashData convert(GuildMessageReceivedEvent event, String name, String[] args) {
        return this.createData(event, "scramble");
    }

}
