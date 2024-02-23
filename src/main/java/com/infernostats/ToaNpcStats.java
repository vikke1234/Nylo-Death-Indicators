package com.infernostats;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.NpcID;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;

@AllArgsConstructor
public enum ToaNpcStats {
    BABOON_MAGE(NpcID.BABOON_MAGE, 4, 40, 40, 12, 40, 40, 20, 0, 900,
            900, 900, 900, -50, true),
    BABOON_BRAWLER(NpcID.BABOON_BRAWLER, 4, 40, 40, 12, 40, 40, 20, 0,
            900, 900, 900, -60, 900, true),
    BABOON_RANGE(NpcID.BABOON_THROWER,4, 40, 40, 12, 40, 40, 20, 0,
            -50, -50, -50, 900, 900, true),
    BABOON_BRAWLER_12(NpcID.BABOON_BRAWLER_11712, 8, 60, 60, 20, 60, 25, 0, 900,
            900, 900, 900, -50, 900, true),
    BABOON_RANGE_13(NpcID.BABOON_THROWER_11713, 8, 60, 60, 20, 60, 60, 25, 0,
            -50, -50, -50, 900, 900, true),

    BABOON_MAGE_14(NpcID.BABOON_MAGE_11714, 8, 60, 60, 20, 60, 60, 25, 0,
            900, 900, 900, 900, -50, true),
    SHAMAN(NpcID.BABOON_SHAMAN, 16, 60, 60, 20, 60, 60, 25,
            0, 900, 900, 900, 900, -50, true),
    CURSED(NpcID.CURSED_BABOON, 10, 60, 60, 20, 60, 60, 25, 0, 900,
            900, 900, -60, -50, false),
    THRALL(NpcID.BABOON_THRALL, 2, 40, 40, 12, 40, 40, 20, 0,
            0, 0,0, 0, 0, false);

    @Getter
    private final int id;
    @Getter
    private final int baseHp;
    private final int att;
    private final int str;
    private final int def;
    private final int mage;
    private final int range;
    private final int offAtt;
    private final int offStr;
    private final int defStab;
    private final int defSlash;
    private final int defCrush;
    private final int defMage;
    private final int defRange;
    private final boolean bxp;


    private static ImmutableMap<Integer, ToaNpcStats> revLookup = Maps.uniqueIndex(Arrays.asList(values()), ToaNpcStats::getId);

    public static ToaNpcStats lookup(int id) {
        return revLookup.getOrDefault(id, null);
    }

    public int getScaledHealth(int raidLevel, int partySize) {
        assert(partySize <= 8 && partySize >= 1);
        assert((raidLevel % 5) == 0);

        double partyScaling = 1d;
        if (partySize > 1) {
            partyScaling += .9 * (partySize - 3);
        }
        if (partySize >= 4){
            partyScaling += .6 * (partySize - 4);
        }

        double modifier = (2 * raidLevel / 500.0) + partyScaling;

        return (int) Math.floor(baseHp * modifier);
    }

    private double getAvgLevel() {
        return Math.floor(((double) att + (double) str + (double) def + (double) Math.min(this.baseHp, 2000)) / 4d);
    }

    private double getAvgDef() {
        return Math.floor(((double) defStab + (double) defSlash + (double) defCrush) / 3);
    }

    /**
     * scales the xp drop according to https://oldschool.runescape.wiki/w/Combat#PvM_bonus_experience
     * @param xpDrop xp drop to scale
     * @return scaled xp drop
     */
    public int scaleXpDrop(int xpDrop) {
        if (!bxp) {
            return xpDrop;
        }

        double avgs = Math.floor((getAvgLevel() * (getAvgDef() + offStr + offAtt)) / 5120d);
        avgs /= 40d;
        double scale = 1 + avgs;

        return (int) (xpDrop / scale);
    }
}
