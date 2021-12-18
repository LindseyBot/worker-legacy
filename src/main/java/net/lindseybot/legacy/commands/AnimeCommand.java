package net.lindseybot.legacy.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.lindseybot.legacy.models.SlashConverter;
import net.lindseybot.worker.legacy.FakeOptionMapping;
import net.lindseybot.worker.legacy.FakeSlashData;
import org.springframework.stereotype.Component;

@Component
public class AnimeCommand extends SlashConverter {

    @Override
    public String[] getNames() {
        return new String[]{"anime"};
    }

    @Override
    public FakeSlashData convert(GuildMessageReceivedEvent event, String name, String[] args) {
        if (args.length == 0) {
            // TODO: HELP
            return null;
        }
        FakeSlashData data = this.createData(event, "anime");
        FakeOptionMapping optName = new FakeOptionMapping();
        optName.setName("name");
        optName.setType(OptionType.STRING);
        optName.setValue(argsToString(args, 0));
        data.getOptions().put(optName.getName(), optName);
        return data;
    }

}
