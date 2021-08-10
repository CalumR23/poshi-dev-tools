/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.poshi.runner;

import com.liferay.poshi.core.util.PropsUtil;

import java.io.FileInputStream;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Kenji Heigel
 */
public class PoshiRunnerTest extends PoshiRunnerTestCase {

	@Before
	public void setUp() throws Exception {

		// Generate test-portal-web-ext.properties by running from portal (as
		// a note, set test.class with the test you plan to run):
		// ant -f build-test.xml prepare-selenium -Dtest.class=PortalSmoke

		Properties properties = new Properties();

		properties.load(
			new FileInputStream(
				_TEST_BASE_DIR_NAME + "/test/test-portal-web-ext.properties"));

		PropsUtil.clear();

		PropsUtil.setProperties(properties);

		setUpPoshiRunner(_TEST_BASE_DIR_NAME);
	}

	@Test
	public void testPoshiTest() throws Exception {
		PoshiRunner poshiRunner = new PoshiRunner("PortalSmoke#Smoke");

		poshiRunner.setUp();

		poshiRunner.test();
	}

	@Test
	public void testValidation() throws Exception {
	}

	private static final String _PORTAL_DIR_NAME =
		"/opt/dev/projects/github/liferay-portal";

	private static final String _TEST_BASE_DIR_NAME =
		"/opt/dev/projects/github/liferay-portal/portal-web";

}