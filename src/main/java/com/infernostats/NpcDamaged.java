package com.infernostats;

import lombok.EqualsAndHashCode;
import lombok.Value;
import net.runelite.client.party.messages.PartyMemberMessage;

@Value
@EqualsAndHashCode(callSuper = true)
public class NpcDamaged extends PartyMemberMessage
{
	int npcIndex;
	int damage;
}
