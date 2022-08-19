package com.infernostats;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.NPC;

@Getter(AccessLevel.PACKAGE)
public class Nylocas
{
	private final NPC npc;
	private final int npcIndex;
	@Setter(AccessLevel.PACKAGE)
	private int hp;
	@Setter(AccessLevel.PACKAGE)
	private int queuedDamage;
	@Setter(AccessLevel.PACKAGE)
	private int hidden;

	public Nylocas(NPC npc, int npcIndex, int hp)
	{
		this.npc = npc;
		this.npcIndex = npcIndex;
		this.hp = hp;
		this.queuedDamage = 0;
		this.hidden = 0;
	}
}
