package de.ngloader.ncpsystem.wrapper;

public enum EntityFlag {

	ENTITY_IS_ON_FIRE(0, 0x01),
	ENTITY_IS_CROUCHING(0, 0x02),
	ENTITY_IS_SPRINTING(0, 0x08),
	ENTITY_IS_SWIMMING(0, 0x10),
	ENTITY_IS_INVISIBLE(0, 0x20),
	ENTITY_IS_HAS_GLOWING_EFFECT(0, 0x40),
	ENTITY_IS_FLYING_WITH_A_ELYTRA(0, 0x80),

	ARROW_IS_CRITICAL(7, 0x01),
	ARROW_IS_NOCLIP(7, 0x02),

	LIVING_ENTITY_IS_HAND_ACTIVE(7, 0x01),
	LIVING_ENTITY_ACTIVE_HAND(7, 0x02),
	LIVING_ENTITY_IS_IN_RIPTIDE_SPIN_ATTACK(7, 0x04),

	PLAYER_CAPE(16, 0x01),
	PLAYER_JACKET(16, 0x02),
	PLAYER_LEFT_SLEEVE(16, 0x04),
	PLAYER_RIGHT_SLEEVE(16, 0x08),
	PLAYER_LEFT_PANTS_LEG(16, 0x10),
	PLAYER_RIGHT_PANTS_LEG(16, 0x20),
	PLAYER_HAT(16, 0x40),

	ARMORSTAND_IS_SMALL(14, 0x01),
	ARMORSTAND_HAS_ARMS(14, 0x04),
	ARMORSTAND_HAS_NO_BASEPLATE(14, 0x08),
	ARMORSTAND_IS_MARKER(14, 0x10),

	MOB_NO_AI(14, 0x01),
	MOB_IS_LEFT_HANDED(14, 0x02),
	MOB_IS_AGRESSIVE(14, 0x04),

	BAT_IS_HANGING(15, 0x01),

	HORSE_IS_TAME(16, 0x02),
	HORSE_IS_SADDLED(16, 0x04),
	HORSE_HAS_BRED(16, 0x08),
	HORSE_IS_EATING(16, 0x10),
	HORSE_IS_REARING(16, 0x20),
	HORSE_IS_MOUTH_OPEN(16, 0x40),

	BEE_IS_ANGRY(16, 0x02),
	BEE_HAS_STUNG(16, 0x04),
	BEE_HAS_NECTAR(16, 0x08),

	FOX_IS_SITTING(17, 0x01),
	FOX_IS_CROUCHING(17, 0x04),
	FOX_IS_INTERESTED(17, 0x08),
	FOX_IS_POUNCING(17, 0x10),
	FOX_IS_SLEEPING(17, 0x20),
	FOX_IS_FACEPLANTED(17, 0x40),
	FOX_IS_DEFENDING(17, 0x80),

	PANDA_IS_SNEEZING(21, 0x02),
	PANDA_IS_ROLLING(21, 0x04),
	PANDA_IS_SITTING(21, 0x08),
	PANDA_IS_ON_BACK(21, 0x10),

	SHEEP_COLOR_ID(16, 0x0F),
	SHEEP_IS_SHEARED(16, 0x10),

	TAMEABLE_IS_SITTING(16, 0x01),
	TAMEABLE_IS_TAMED(16, 0x04),

	IRON_GOLEM_IS_PLAYER_CREATED(15, 0x01),

	SNOW_GOLEM_HAS_NO_PUMPKIN_HAT(15, 0x00),
	SNOW_GOLEM_HAS_PUMPKIN_HAT(15, 0x10),

	BLAZE_IS_ON_FIRE(15, 0x01),

	VEX_IS_ATTACKING(15, 0x01),

	SPIDER_IS_CLIMBING(15, 0x01);

	private final int index;
	private final byte flag;

	private EntityFlag(int index, int flag) {
		this.index = index;
		this.flag = (byte) flag;
	}

	public int getIndex() {
		return this.index;
	}

	public byte getFlag() {
		return this.flag;
	}
}