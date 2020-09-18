package com.kenson.other.guava;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;
import com.google.common.collect.Tables;

/**
 * 双键的Map --->Map --->rowKey + columnKey + value
 * 1. 方法
 * 所有的行数据 cellSet()
 * 所有的学生 rowKeySet()
 * 所有的课程：columnKeySet()
 * 所有的成绩： values()
 * 学生对应的课程 ： rowMap() +　get(学生) -->取具体某一个学生的课程
 * 			或者：　row(学生)
 * 课程对应的学生： columnMap +　get(课程)	--->取具体某一课程
 * 			或者： column(课程)
 * 
 * 
 * 后期应用场景
 * @author wuchun
 *
 */
public class TestTable {

	public static void main(String[] args) {
		//创建Table
		Table<String, String, Integer> tables = HashBasedTable.create();
		//添加测试数据
		tables.put("Kenson", "JavaSE", 90);
		tables.put("Look", "Oracle", 86);
		tables.put("Jane", "Android", 89);
		tables.put("Kenson", "Oracle", 97);
		tables.put("Look", "Android", 45);
		
		//查看所有的行数据
		Set<Cell<String, String, Integer>> cells = tables.cellSet();
		//遍历这个 Set, 使用增强for循环，也可以使用迭代器Iterator
		for (Cell<String, String, Integer> cell : cells) {
			//输出所有行的数据
			System.out.println(cell.getRowKey() + "　------->" + cell.getColumnKey()+ "　------->" +cell.getValue());
		}
		
		System.out.println("==========按学生查看成绩=============");
		System.out.print("学生\t");
		
		//所有的课程
		Set<String> course = tables.columnKeySet();
		//同理： 遍历set
		for (String cours : course) {
			System.out.print(cours + "\t");
		}
		
		System.out.println();
		
		//所有的学生和成绩
		Set<String> stundents = tables.rowKeySet();
		for (String stu : stundents) {
			System.out.print(stu + "\t");
			Map<String, Integer> scores = tables.row(stu);
			for (String c : course) {
				System.out.print(scores.get(c) + "\t");
			}
			System.out.println();
		}
		
		System.out.println("==========按课程查看成绩=============");
		System.out.print("课程\t");
		//所有的学生
		Set<String> stus = tables.rowKeySet();
		
		//同理： 遍历set
		for (String stu : stus) {
			System.out.print(stu + "\t");
		}
		
		System.out.println();
		
		//所有的课程和成绩
		Set<String> courses = tables.columnKeySet();
		for (String curs : courses) {
			System.out.print(curs + "\t");
			Map<String, Integer> scores = tables.column(curs);
			for (String c : stus) {
				System.out.print(scores.get(c) + "\t");
			}
			System.out.println();
		}
		
		System.out.println("===========转换： 将两列的数据对调=======================");
		Table<String, String, Integer> tables2 = Tables.transpose(tables);

		//查看所有的行数据
		Set<Cell<String, String, Integer>> cells2 = tables2.cellSet();
		//遍历这个 Set, 使用增强for循环，也可以使用迭代器Iterator
		for (Cell<String, String, Integer> cell : cells2) {
			//输出所有行的数据
			System.out.println(cell.getRowKey() + "　------->" + cell.getColumnKey()+ "　------->" +cell.getValue());
		}
		
	}

}
