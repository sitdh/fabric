package com.sitdh.thesis.fabric.visitor;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.visitor.VoidVisitor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnumVisitorAdaptorTest {
	
	private CompilationUnit cu;
	
	public void tearDown() {
		cu = null;
	}

	@Test
	public void visitorCanCollectEnum() {
		
		cu = JavaParser.parse(StringUtils.join(
				Arrays.asList(
						"enum Lorem{",
						"HELLO_ONE,",
						"HELLO_TWO;",
						"}"
						), 
				"\n"));
		
		List<String> fields = new ArrayList<String>();
		
		VoidVisitor<List<String>> enumParser = new EnumVisitorAdaptor();
		enumParser.visit(cu, fields);
		
		assertThat(fields.size(), is(2));
		assertTrue(fields.stream().anyMatch(e -> e.equals("HELLO_ONE")));
		assertTrue(fields.stream().anyMatch(e -> e.equals("HELLO_TWO")));
		assertFalse(fields.stream().anyMatch(e -> e.equals("Lorem")));
	}

}
