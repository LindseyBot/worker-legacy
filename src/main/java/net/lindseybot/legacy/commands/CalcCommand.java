package net.lindseybot.legacy.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.lindseybot.legacy.models.SlashConverter;
import net.lindseybot.shared.worker.legacy.FakeOptionMapping;
import net.lindseybot.shared.worker.legacy.FakeSlashData;
import org.springframework.stereotype.Component;

@Component
public class CalcCommand extends SlashConverter {

    @Override
    public String[] getNames() {
        return new String[]{"calc"};
    }

    @Override
    public FakeSlashData convert(GuildMessageReceivedEvent event, String name, String[] args) {
        if (args.length == 0) {
            // TODO: HELP
            return null;
        }
        FakeSlashData data = this.createData(event, "calc");
        FakeOptionMapping optExpression = new FakeOptionMapping();
        optExpression.setName("expression");
        optExpression.setType(OptionType.STRING);
        optExpression.setValue(argsToString(args, 0));
        data.getOptions().put(optExpression.getName(), optExpression);
        return data;
    }

}
