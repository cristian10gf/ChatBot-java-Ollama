package com.crisplant.chat.ui;

import com.formdev.flatlaf.FlatIntelliJLaf;

public class chatTheme
	extends FlatIntelliJLaf
{
	public static final String NAME = "chatTheme";

	public static boolean setup() {
		return setup( new chatTheme() );
	}

	public static void installLafInfo() {
		installLafInfo( NAME, chatTheme.class );
	}

	@Override
	public String getName() {
		return NAME;
	}
}
