/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package de.appwerft.badger;

import me.leolin.shortcutbadger.ShortcutBadgeException;
import me.leolin.shortcutbadger.ShortcutBadger;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiApplication;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

@Kroll.module(name = "Badger", id = "de.appwerft.badger")
public class BadgerModule extends KrollModule {

	public BadgerModule() {
		super();
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app) {
	}

	@Kroll.method
	public boolean setBadge(int a) {
		try {
			ShortcutBadger.applyCountOrThrow(TiApplication.getInstance(), 2);
			return true;
		} catch (ShortcutBadgeException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Kroll.method
	public boolean removeBadge() {
		try {
			ShortcutBadger.removeCountOrThrow(TiApplication.getInstance());
			return true;
		} catch (ShortcutBadgeException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Kroll.method
	public String getLauncher() {
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_HOME);
		ResolveInfo resolveInfo = TiApplication.getAppRootOrCurrentActivity()
				.getPackageManager()
				.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
		return resolveInfo.activityInfo.packageName;
	}
}
