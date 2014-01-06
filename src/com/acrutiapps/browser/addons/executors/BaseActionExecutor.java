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

import com.acrutiapps.browser.addons.Addon;
import com.acrutiapps.browser.ui.components.CustomWebView;
import com.acrutiapps.browser.ui.managers.UIManager;

import android.content.Context;

public abstract class BaseActionExecutor {
	
	protected Context mContext;
	protected UIManager mUIManager;
	protected CustomWebView mWebView;
	protected Addon mAddon;
	
	private void init(Context context, UIManager uiManager, CustomWebView webView, Addon addon, Action addonAction) {
		mContext = context;
		mUIManager = uiManager;
		mWebView = webView;
		mAddon = addon;
		
		finishInit(addonAction);
	}
	
	protected abstract void finishInit(Action addonAction);
	
	protected abstract void internalExecute();
	
	public synchronized void execute(Context context, UIManager uiManager, CustomWebView webView, Addon addon, Action addonAction) {
		init(context, uiManager, webView, addon, addonAction);
		internalExecute();
	}

}
