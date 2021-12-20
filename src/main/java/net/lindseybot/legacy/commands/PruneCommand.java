package net.lindseybot.legacy.commands;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.lindseybot.entities.discord.Label;
import net.lindseybot.legacy.models.SlashConverter;
import net.lindseybot.legacy.services.FinderUtil;
import net.lindseybot.worker.legacy.FakeOptionMapping;
import net.lindseybot.worker.legacy.FakeSlashData;
import net.lindseybot.worker.services.Messenger;
import org.springframework.stereotype.Component;

@Component
public class PruneCommand extends SlashConverter {

    private final Messenger msg;

    public PruneCommand(Messenger msg) {
        this.msg = msg;
    }

    @Override
    public String[] getNames() {
        return new String[]{"prune"};
    }

    @Override
    public FakeSlashData convert(GuildMessageReceivedEvent event, String name, String[] args) {
        if (args.length == 0) {
            // TODO: HELP
            return null;
        }
        int count;
        try {
            count = Integer.parseInt(args[0]);
            if (count < 1) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException ex) {
            this.msg.reply(event, Label.raw("That's not a number."));
            return null;
        }
        FakeSlashData data = this.createData(event, "prune");

        FakeOptionMapping optCount = new FakeOptionMapping();
        optCount.setName("count");
        optCount.setType(OptionType.NUMBER);
        optCount.setValue(String.valueOf(count));
        data.getOptions().put(optCount.getName(), optCount);

        if (args.length > 1) {
            Member target = FinderUtil.findMember(args[1], event.getGuild());
            if (target == null) {
                this.msg.reply(event, Label.raw("User not found."));
                return null;
            }
            FakeOptionMapping optTarget = new FakeOptionMapping();
            optTarget.setName("user");
            optTarget.setType(OptionType.USER);
            optTarget.setValue(target.getId());
            data.getOptions().put(optTarget.getName(), optTarget);
        }
        return data;
    }

}