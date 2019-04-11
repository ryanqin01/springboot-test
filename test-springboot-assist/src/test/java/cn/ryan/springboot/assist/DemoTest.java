package cn.ryan.springboot.assist;

import org.junit.Assert;
import org.junit.Test;

public class DemoTest {

	@Test
	public void testFieldName() {
		Assert.assertTrue("wo".equalsIgnoreCase("WO"));
	}
}
