package tera.gameserver.model.listeners;

import tera.gameserver.model.TObject;

/**
 * Слушатель удаляемых объектов из мира.
 * 
 * @author Ronn Mod Evestu
 */
public interface DeleteListener
{
	/**
	 * @param object удаляемый из мира объект.
	 */
	public void onDelete(TObject object);
}
