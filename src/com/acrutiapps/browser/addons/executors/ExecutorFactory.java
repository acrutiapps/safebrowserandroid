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

import java.util.HashMap;
import java.util.Map;

import com.acrutiapps.browser.addons.framework.Action;
import com.acrutiapps.browser.addons.framework.AskUserChoiceAction;
import com.acrutiapps.browser.addons.framework.AskUserConfirmationAction;
import com.acrutiapps.browser.addons.framework.AskUserInputAction;
import com.acrutiapps.browser.addons.framework.LoadUrlAction;
import com.acrutiapps.browser.addons.framework.OpenTabAction;
import com.acrutiapps.browser.addons.framework.ShowDialogAction;
import com.acrutiapps.browser.addons.framework.ShowToastAction;
import com.acrutiapps.browser.addons.framework.TabAction;

public class ExecutorFactory {
	
	private static Map<String, BaseActionExecutor> sClassMap;
	
	static {
		sClassMap = new HashMap<String, BaseActionExecutor>();
		sClassMap.put(TabAction.class.getName(), new TabActionExecutor());
		sClassMap.put(ShowDialogAction.class.getName(), new ShowDialogExecutor());
		sClassMap.put(LoadUrlAction.class.getName(), new LoadUrlExecutor());
		sClassMap.put(ShowToastAction.class.getName(), new ShowToastExecutor());
		sClassMap.put(OpenTabAction.class.getName(), new OpenTabExecutor());
		sClassMap.put(AskUserConfirmationAction.class.getName(), new AskUserConfirmationExecutor());
		sClassMap.put(AskUserInputAction.class.getName(), new AskUserInputExecutor());
		sClassMap.put(AskUserChoiceAction.class.getName(), new AskUserChoiceExecutor());
	}
	
	public static BaseActionExecutor getExecutor(Action addonAction) {
		if (addonAction != null) {
			return sClassMap.get(addonAction.getClass().getName());
		} else {
			return null;
		}
	}

}
