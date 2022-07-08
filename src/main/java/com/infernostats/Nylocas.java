package com.infernostats;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PACKAGE)
public class Nylocas
{
	private int npcIndex;
	@Setter(AccessLevel.PACKAGE)
	private int hp;
	@Setter(AccessLevel.PACKAGE)
	private int queuedDamage;
	@Setter(AccessLevel.PACKAGE)
	private int hidden;

	public Nylocas(int npcIndex, int hp)
	{
		this.npcIndex = npcIndex;
		this.hp = hp;
		this.queuedDamage = 0;
		this.hidden = 0;
	}
}
