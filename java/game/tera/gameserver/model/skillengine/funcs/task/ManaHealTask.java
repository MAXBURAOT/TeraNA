package tera.gameserver.model.skillengine.funcs.task;

import rlib.util.VarTable;
import rlib.util.array.Array;

import tera.gameserver.model.Character;

/**
 * Модель мана хил таска.
 *
 * @author Ronn Mod Evestu
 */
public class ManaHealTask extends AbstractTaskFunc
{
	/** интервал хила */
	private int interval;
	/** можность */
	private int power;

	public ManaHealTask(VarTable vars)
	{
		super(vars);

		this.interval = vars.getInteger("interval");
		this.power = vars.getInteger("power");
	}

	@Override
	public void applyFunc()
	{
		// получаем персонажей
		Array<Character> characters = getCharacters();

		characters.readLock();
		try
		{
			Character[] array = characters.array();

			int power = getPower();

			for(int i = 0, length = characters.size(); i < length; i++)
				array[i].effectHealMp(power, array[i]);
		}
		finally
		{
			characters.readUnlock();
		}
	}

	@Override
	public int getInterval()
	{
		return interval;
	}

	@Override
	public int getLimit()
	{
		return -2;
	}

	/**
	 * @return мощность хила.
	 */
	public int getPower()
	{
		return power;
	}
}
