/*
 * Tint Browser for Android
 * 
 * Copyright (C) 2012 - to infinity and beyond J. Devauchelle and contributors.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * version 3 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

package com.acrutiapps.browser.addons.executors;

import com.acrutiapps.browser.addons.framework.Action;
import com.acrutiapps.browser.addons.framework.ShowDialogAction;

import com.acrutiapps.browser.utils.ApplicationUtils;

public class ShowDialogExecutor extends BaseActionExecutor {

	private ShowDialogAction mAddonAction;
	
	@Override
	protected void finishInit(Action addonAction) {
		mAddonAction = (ShowDialogAction) addonAction;
	}

	@Override
	protected void internalExecute() {
		ApplicationUtils.showMessageDialog(mContext, mAddonAction.getTitle(), mAddonAction.getMessage());
	}

}
