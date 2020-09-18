package com.kenson.map.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 思考：定义一个Student类,属性:name 姓名,no班号,score 成绩   现在将若干Student对象放入List,请统计出每个班级的总分和平均分
 * 方案：面向对象  + 分拣存储
 * @author wuchun
 *
 */
public class MapDemo03 {
	public static void main(String[] args) {
		List<Student> exam = exam();
		Map<String, ClassRoom> chengji = count(exam);
		view(chengji);
	}
	
	/**
	 * 查看每个班的总分和平均分 -->遍历map
	 */
	
	public static void view(Map<String, ClassRoom> map){
		Set<String> keySet = map.keySet();
		//获取迭代器对象
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			//再获取班级编号
			String no = it.next();
			//获取班级
			ClassRoom room = map.get(no);
			//计算总分查看平均分
			double total = room.getTotal();
			double avage = total/room.getStuList().size();
			System.out.println("ClassRoom #: " +room.getNo()+ " Classroom.  Total: " + total + "   avage:   " + avage);
		}
	}
	
	/**
	 * 统计类型
	 */
	
	public static Map<String, ClassRoom> count(List<Student> list){
		Map<String, ClassRoom> map = new HashMap<String, ClassRoom>();
		//遍历list
		for (Student student : list) {
			//分拣 查看是否存在该编号的班级
			String no = student.getNo();	//班级编号
			double score = student.getScore();	//学生成绩
			//如果不存在， 创建班级
			ClassRoom room = map.get(no);
			if (null == room) {
				room = new ClassRoom(no);
				map.put(no, room);
			}
			//如果存在，放入学生
			room.getStuList().add(student);	//放入学生
			room.setTotal(room.getTotal() + score);	//计算总分
		}
		return map;
	}
	
	/**
	 * 模拟考试， 也就是把测试数据放入List
	 */
	public static List<Student> exam(){
		List<Student> list = new ArrayList<Student>();
		//存放学生成绩
		list.add(new Student("ken","a",90));
		list.add(new Student("kenson","a",90));
		list.add(new Student("jam","a",90));
		list.add(new Student("james","b",90));
		list.add(new Student("lusan","b",90));
		list.add(new Student("lusan","c",100.01));
		list.add(new Student("lusan","c",90.28));
		return list;
	}
}
