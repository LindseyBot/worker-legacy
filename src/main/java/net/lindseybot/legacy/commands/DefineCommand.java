package net.lindseybot.legacy.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.lindseybot.legacy.models.SlashConverter;
import net.lindseybot.shared.worker.legacy.FakeOptionMapping;
import net.lindseybot.shared.worker.legacy.FakeSlashData;
import org.springframework.stereotype.Component;

@Component
public class DefineCommand extends SlashConverter {

    @Override
    public String[] getNames() {
        return new String[]{"define"};
    }

    @Override
    public FakeSlashData convert(GuildMessageReceivedEvent event, String name, String[] args) {
        if (args.length == 0) {
            return null;
        }
        FakeSlashData data = this.createData(event, "define");
        FakeOptionMapping option = new FakeOptionMapping();
        option.setName("word");
        option.setType(OptionType.STRING);
        option.setValue(argsToString(args, 0));
        data.getOptions().put(option.getName(), option);
        return data;
    }

}
