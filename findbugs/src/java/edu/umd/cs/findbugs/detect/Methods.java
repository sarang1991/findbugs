/*
 * FindBugs - Find bugs in Java programs
 * Copyright (C) 2003-2005 University of Maryland
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package edu.umd.cs.findbugs.detect;

import edu.umd.cs.findbugs.*;
import edu.umd.cs.findbugs.ba.*;
import edu.umd.cs.findbugs.visitclass.PreorderVisitor;
import java.util.*;

import org.apache.bcel.classfile.Field;
import org.apache.bcel.classfile.Method;

public class Methods extends PreorderVisitor implements Detector,
		NonReportingDetector {
	
	private XFactory xFactory = AnalysisContext.currentXFactory();

	public Methods(BugReporter bugReporter) {
	}

	public void visitClassContext(ClassContext classContext) {
		classContext.getJavaClass().accept(this);
	}

	@Override
	public void visit(Method obj) {
		xFactory.createXMethod(this);
	}

	@Override
	public void visit(Field obj) {
		xFactory.createXField(this);
	}

	public void report() {

	}

}
