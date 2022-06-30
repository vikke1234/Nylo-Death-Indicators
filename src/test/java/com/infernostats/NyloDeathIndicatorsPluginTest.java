package com.infernostats;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class NyloDeathIndicatorsPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(NyloDeathIndicatorsPlugin.class);
		RuneLite.main(args);
	}
}