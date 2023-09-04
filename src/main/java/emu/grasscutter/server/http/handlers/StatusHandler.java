package emu.grasscutter.server.http.handlers;

import emu.grasscutter.GameConstants;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.server.http.Router;
import io.javalin.Javalin;
import io.javalin.http.Context;

import static emu.grasscutter.config.Configuration.ACCOUNT;

public final class StatusHandler implements Router {
    @Override public void applyRoutes(Javalin javalin) {
        javalin.get("/status/server", StatusHandler::serverStatus);

    }

    private static void serverStatus(Context ctx) {
        int playerCount = Grasscutter.getGameServer().getPlayers().size();
        int maxPlayer = ACCOUNT.maxPlayer;
        String version = GameConstants.VERSION;

        ctx.result(
            "{\"retcode\":0,\"status\":{\"playerCount\":"
                + playerCount
                + ",\"maxPlayer\":"
                + maxPlayer
                + ",\"version\":\""
                + version
                + "\"}}");
    }
}
