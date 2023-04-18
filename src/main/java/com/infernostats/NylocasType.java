package com.infernostats;

import java.util.HashMap;
import org.apache.commons.lang3.ArrayUtils;

public enum NylocasType
{
	MELEE_SMALL(8342, 8348),
	MELEE_BIG(8345, 8351),
	RANGE_SMALL(8343, 8349),
	RANGE_BIG(8346, 8352),
	MAGE_SMALL(8344, 8350),
	MAGE_BIG(8347, 8353),
	SM_MELEE_SMALL(10774, 10780),
	SM_MELEE_BIG(10777, 10783),
	SM_RANGE_SMALL(10775, 10781),
	SM_RANGE_BIG(10778, 10784),
	SM_MAGE_SMALL(10776, 10782),
	SM_MAGE_BIG(10779, 10785),
	HM_MELEE_SMALL(10791, 10797),
	HM_MELEE_BIG(10794, 10800),
	HM_RANGE_SMALL(10792, 10798),
	HM_RANGE_BIG(10795, 10801),
	HM_MAGE_SMALL(10793, 10799),
	HM_MAGE_BIG(10796, 10802);

	private final int normalId;
	private final int aggressiveId;
	public static final HashMap<Integer, NylocasType> lookupMap = new HashMap<>();

	NylocasType(int normalId, int aggressiveId)
	{
		this.normalId = normalId;
		this.aggressiveId = aggressiveId;
	}

	static
	{
		for (NylocasType type : values())
		{
			lookupMap.put(type.normalId, type);
			lookupMap.put(type.aggressiveId, type);
		}
	}

	static boolean isNylocas(int npcId)
	{
		return lookupMap.get(npcId) != null;
	}

	public static boolean isMeleeNylocas(int npcId)
	{
		return ArrayUtils.contains(new Integer[]{
			MELEE_SMALL.normalId,
			MELEE_SMALL.aggressiveId,
			MELEE_BIG.normalId,
			MELEE_BIG.aggressiveId,
			SM_MELEE_SMALL.normalId,
			SM_MELEE_SMALL.aggressiveId,
			SM_MELEE_BIG.normalId,
			SM_MELEE_BIG.aggressiveId,
			HM_MELEE_SMALL.normalId,
			HM_MELEE_SMALL.aggressiveId,
			HM_MELEE_BIG.normalId,
			HM_MELEE_BIG.aggressiveId,
		}, npcId);
	}

	public static boolean isMeleeSmall(int npcId)
	{
		return ArrayUtils.contains(new Integer[]{
			MELEE_SMALL.normalId,
			MELEE_SMALL.aggressiveId,
			SM_MELEE_SMALL.normalId,
			SM_MELEE_SMALL.aggressiveId,
			HM_MELEE_SMALL.normalId,
			HM_MELEE_SMALL.aggressiveId,
		}, npcId);
	}

	public static boolean isRangeNylocas(int npcId)
	{
		return ArrayUtils.contains(new Integer[]{
			RANGE_SMALL.normalId,
			RANGE_SMALL.aggressiveId,
			RANGE_BIG.normalId,
			RANGE_BIG.aggressiveId,
			SM_RANGE_SMALL.normalId,
			SM_RANGE_SMALL.aggressiveId,
			SM_RANGE_BIG.normalId,
			SM_RANGE_BIG.aggressiveId,
			HM_RANGE_SMALL.normalId,
			HM_RANGE_SMALL.aggressiveId,
			HM_RANGE_BIG.normalId,
			HM_RANGE_BIG.aggressiveId,
		}, npcId);
	}

	public static boolean isRangeSmall(int npcId)
	{
		return ArrayUtils.contains(new Integer[]{
			RANGE_SMALL.normalId,
			RANGE_SMALL.aggressiveId,
			SM_RANGE_SMALL.normalId,
			SM_RANGE_SMALL.aggressiveId,
			HM_RANGE_SMALL.normalId,
			HM_RANGE_SMALL.aggressiveId,
		}, npcId);
	}

	public static boolean isMageNylocas(int npcId)
	{
		return ArrayUtils.contains(new Integer[]{
			MAGE_SMALL.normalId,
			MAGE_SMALL.aggressiveId,
			MAGE_BIG.normalId,
			MAGE_BIG.aggressiveId,
			SM_MAGE_SMALL.normalId,
			SM_MAGE_SMALL.aggressiveId,
			SM_MAGE_BIG.normalId,
			SM_MAGE_BIG.aggressiveId,
			HM_MAGE_SMALL.normalId,
			HM_MAGE_SMALL.aggressiveId,
			HM_MAGE_BIG.normalId,
			HM_MAGE_BIG.aggressiveId,
		}, npcId);
	}

	public static boolean isMageSmall(int npcId)
	{
		return ArrayUtils.contains(new Integer[]{
			MAGE_SMALL.normalId,
			MAGE_SMALL.aggressiveId,
			SM_MAGE_SMALL.normalId,
			SM_MAGE_SMALL.aggressiveId,
			HM_MAGE_SMALL.normalId,
			HM_MAGE_SMALL.aggressiveId,
		}, npcId);
	}

	public static boolean isAggressive(int npcId)
	{
		NylocasType type = lookupMap.get(npcId);
		if (type == null)
		{
			return false;
		}
		return npcId == type.aggressiveId;
	}

	@Override
	public String toString()
	{
		return "NylocasType{" +
			"normalId=" + normalId +
			", aggressiveId=" + aggressiveId +
			'}';
	}
}
