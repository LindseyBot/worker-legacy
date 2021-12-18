package net.lindseybot.legacy.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.lindseybot.legacy.models.SlashConverter;
import net.lindseybot.worker.legacy.FakeOptionMapping;
import net.lindseybot.worker.legacy.FakeSlashData;
import org.springframework.stereotype.Component;

@Component
public class ColorCommand extends SlashConverter {

    @Override
    public String[] getNames() {
        return new String[]{"color"};
    }

    @Override
    public FakeSlashData convert(GuildMessageReceivedEvent event, String name, String[] args) {
        if (args.length == 0) {
            // TODO: HELP
            return null;
        }
        FakeSlashData data = this.createData(event, "color");
        FakeOptionMapping optColor = new FakeOptionMapping();
        optColor.setName("hex");
        optColor.setType(OptionType.STRING);
        optColor.setValue(argsToString(args, 0));
        data.getOptions().put(optColor.getName(), optColor);
        return data;
    }

}
