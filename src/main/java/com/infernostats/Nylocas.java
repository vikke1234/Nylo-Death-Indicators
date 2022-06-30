package com.infernostats;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
public class Nylocas
{
	private int npcIndex;
	@Setter(AccessLevel.PACKAGE)
	private int hp;
}
