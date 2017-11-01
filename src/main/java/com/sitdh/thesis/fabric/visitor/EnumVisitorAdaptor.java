package com.sitdh.thesis.fabric.visitor;

import java.util.List;

import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.EnumConstantDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class EnumVisitorAdaptor extends VoidVisitorAdapter<List<String>> {

	public void visit(EnumDeclaration ed, List<String> collection) {
		super.visit(ed, collection);
		
		NodeList<EnumConstantDeclaration> ecd = ed.getEntries();
		String elementName = ed.getName().asString();
		System.out.println(elementName);
		ecd.forEach(e -> collection.add(e.getNameAsString()) );
	}
}
