package net.lindseybot.legacy.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.lindseybot.legacy.models.SlashConverter;
import net.lindseybot.shared.worker.legacy.FakeOptionMapping;
import net.lindseybot.shared.worker.legacy.FakeSlashData;
import org.springframework.stereotype.Component;

@Component
public class LeaderboardCommand extends SlashConverter {

    @Override
    public String[] getNames() {
        return new String[]{"leaderboard", "top"};
    }

    @Override
    public FakeSlashData convert(GuildMessageReceivedEvent event, String name, String[] args) {
        FakeSlashData data = this.createData(event, "leaderboard");
        FakeOptionMapping option = new FakeOptionMapping();
        option.setName("leaderboard");
        option.setType(OptionType.STRING);
        option.setValue("cookies");
        data.getOptions().put(option.getName(), option);
        return data;
    }

}
