package com.company;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectPackages("com.company")
@IncludeTags("NegativeTest")
public class NegativeTest {
}
