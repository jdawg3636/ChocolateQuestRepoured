package com.teamcqr.chocolatequestrepoured.objects.entity.ai.spells;

import com.teamcqr.chocolatequestrepoured.objects.entity.bases.AbstractEntityCQR;

import net.minecraft.init.SoundEvents;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class EntityAIBlindTargetSpell extends AbstractEntityAIUseSpell {

	// 15 is blindness
	protected PotionEffect POTION_EFFECT = new PotionEffect(Potion.getPotionById(15), 40);

	public EntityAIBlindTargetSpell(AbstractEntityCQR entity) {
		super(entity);
	}

	public EntityAIBlindTargetSpell(AbstractEntityCQR entity, PotionEffect customEffect) {
		this(entity);
		this.POTION_EFFECT = customEffect;
	}

	@Override
	protected void castSpell() {
		if (this.entity.getAttackTarget() != null) {
			Vec3d v = this.entity.getAttackTarget().getLookVec();
			v = v.normalize();
			v = v.add(v).add(v).add(v);

			if (this.entity.getAttackTarget().isPotionApplicable(this.POTION_EFFECT)) {
				this.entity.getAttackTarget().addPotionEffect(this.POTION_EFFECT);
				Vec3d newPos = this.entity.getAttackTarget().getPositionVector().subtract(v);
				if (this.entity.world.getBlockState(new BlockPos(newPos).offset(EnumFacing.DOWN)).getMaterial().isSolid()) {
					this.entity.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 0.7F, 1.1F);
					this.entity.attemptTeleport(newPos.x, newPos.y, newPos.z);
				}
			}
		}
	}

	@Override
	protected int getCastingTime() {
		return 15;
	}

	@Override
	protected int getCastingInterval() {
		return 50;
	}

	@Override
	protected SoundEvent getSpellPrepareSound() {
		return null;
	}

	@Override
	protected ESpellType getSpellType() {
		return ESpellType.BLIND_TARGET;
	}

}
