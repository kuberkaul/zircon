package org.hexworks.zircon.examples.game;

import org.hexworks.zircon.api.SwingApplications;
import org.hexworks.zircon.api.builder.application.AppConfigBuilder;

import java.awt.*;

public class BorderlessExample {

    public static void main(String[] args) {
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        SwingApplications.startTileGrid(
            new AppConfigBuilder()
//                .borderless()
//                .fullScreen()
                .fullScreen(screenSize.width, screenSize.height)
                .build());
    }
}
