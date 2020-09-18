package com.kenson.other.guava;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.collect.Constraint;
import com.google.common.collect.Constraints;

/**
 * 加入约束条件：　非空，长度限制
 * Constraint
 * Preconditions
 * Constraints
 * @author wuchun
 *
 */

public class TestConstraint {
	public static void main(String[] args) {
		Set<String> sets = new HashSet<String>();
		//创建约束
		Constraint<String> constraint = new Constraint<String>(){

			@Override
			public String checkElement(String element) {
				//非空验证
				Preconditions.checkNotNull(element);
				Preconditions.checkArgument(element.length()>5&&element.length()<20);
				return element;
			}
			
		};
		Set<String> csSet = Constraints.constrainedSet(sets, constraint);
		//csSet.add(null);	java.lang.NullPointerException
		//csSet.add("good");	 java.lang.IllegalArgumentException
		csSet.add("Kenson");
		for (String temp : csSet) {
			System.out.println(temp);
		}
	}

}
