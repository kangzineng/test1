package com.gec.connection;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.swing.plaf.synth.SynthSpinnerUI;

import com.gec.connection.bean.Person;

@SuppressWarnings("unused")
public class Demo16 {

	/**
	 * @param args
	 */
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Collection collection=new ArrayList();
		collection.add(1);
		collection.add(1.1);
		collection.add(3);
		collection.add(true);
		Collection collection2=new ArrayList();
		collection2.add(1);
		collection2.add(1.1);
		collection2.add(3);
		
		boolean b=collection.contains(collection2);
		
		Collection collection3=new ArrayList();
		collection3.add('a');
		collection3.add('b');
		collection3.add('c');
		collection3.add('d');
		//System.out.println(b);
		
		//System.out.println(collection);
		
		Iterator iterator=collection.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		Iterator iterator1=collection.iterator();
		while(iterator1.hasNext()){
			System.out.println(iterator1.next());
		}
		Iterator iterator3=collection.iterator();
		
		
		List list2=new ArrayList();
		list2.add("a");
		list2.add("a");
		list2.add("b");
		list2.add("b");
		list2.add("c");
		list2.add("c");
		list2.add("d");
		list2.add("d");
		List list4=new ArrayList();
		
		Iterator iterator2=list2.iterator();
		Iterator iterator4=list4.iterator();
		
		if(list2.contains(list4)){
			
		}
		while(iterator2.hasNext()){
			//if(list.contains("a")){
				//	list.remove("a");
				//}
			
			System.out.print(iterator2.next()+" ");
			collection.add(1);
		collection.add(1.1);
		collection.add(3);
		collection.add(true);
		Collection collection2=new ArrayList();
		collection2.add(1);
		collection2.add(1.1);
		collection2.add(3);
		
		boolean b=collection.contains(collection2);
		
		Collection collection3=new ArrayList();
		collection3.add('a');
		collection3.add('b');
		collection3.add('c');
		collection3.add('d');
		//System.out.println(b);
		
		//System.out.println(collection);
		
		Iterator iterator=collection.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		Iterator iterator1=collection.iterator();
		while(iterator1.hasNext()){
			System.out.println(iterator1.next());
		}
		Iterator iterator3=collection.iterator();
		
		
		List list2=new ArrayList();
		list2.add("a");
		list2.add("a");
		list2.add("b");
		list2.add("b");
		list2.add("c");
		list2.add("c");
		list2.add("d");
		list2.add("d");
		List list4=new ArrayList();
		
		Iterator iterator2=list2.iterator();
		Iterator iterator4=list4.iterator();
		
		if(list2.contains(list4)){
			
		}
		while(iterator2.hasNext()){
			//if(list.contains("a")){
				//	list.remove("a");
				//}
			
			System.out.print(iterator2.next()+" ");
		}*/
		
		
		//method1();
		//method2();
		//method3();
		//method4();
		//method5();
		//method6();
		//method7();
		//method8();
		//method9();
		//method10();
		//method11();
		//method12();
		//method13();
	}

	//��ArrayList�������ظ����ַ���ȥ��
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void method13() {
		List list=new ArrayList();
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("c");
		list.add("c");
		
		List list2=new ArrayList();//����һ���µļ������ڴ洢ȥ�غ��Ԫ�ؼ���
		
		Iterator iterator=list.iterator();
		while (iterator.hasNext()) {
			Object object = (Object) iterator.next();//��ȡ�����ɼ�����ÿһ��Ԫ�ض���
			if(!list2.contains(object)){//�ж��¼�������û�ж�Ӧ�����Ԫ��
				list2.add(object);//���û������ӵ��¼�����
			}
		}
		System.out.println(list2);
	}

	//��ArrayList�������ظ����Զ������Ԫ��ȥ��
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void method12() {
		List list=new ArrayList();
		list.add(new Person("����",18));
		list.add(new Person("����",18));
		list.add(new Person("����",19));
		list.add(new Person("����",19));
		list.add(new Person("����",20));
		list.add(new Person("����",20));
		list.add(new Person("����",20));
		
		list.remove(new Person("����",18));
		list.remove(new Person("����",19));
		list.remove(new Person("����",20));
		list.remove(new Person("����",20));
		System.out.println(list.size());
		System.out.println(list);
	}

	//�����������Զ������
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void method11() {
		Collection collection=new ArrayList();
		collection.add(new Person("����",18));
		collection.add(new Person("����",19));
		collection.add(new Person("����",20));
		collection.add(new Person("����",21));
		
		Iterator iterator=collection.iterator();
		while (iterator.hasNext()) {
			Person p = (Person) iterator.next();
			System.out.println(p.getName()+"..."+p.getAge());
		}
		/*while (iterator.hasNext()) {
			Object obj = (Object) iterator.next();
			System.out.println(obj);//��ӡ���ǵ�ֵַ
		}*/
	}

	
	//������ɾ��Ԫ��
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void method10() {
		Collection collection=new ArrayList();
		collection.add(1);
		collection.add(2);
		collection.add(3);
		collection.add(4);
		collection.add('a');
		collection.add("����");
		
		Iterator iterator=collection.iterator();
		while (iterator.hasNext()) {
			Object obj = (Object) iterator.next();
			if(obj.equals("����")){
				try {
					iterator.remove();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		System.out.println(collection);
	}

	//����������
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void method9() {
		Collection collection=new ArrayList();
		collection.add(1);
		collection.add(2);
		collection.add(3);
		collection.add(4);
		collection.add('a');
		collection.add("����");
		
		Iterator iterator=collection.iterator();
		while (iterator.hasNext()) {
			Object object = (Object) iterator.next();
			System.out.println(object);
		}
	}

	//removeAll()����
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void method8() {
		Collection collection=new ArrayList();
		collection.add(1);
		collection.add(1.1);
		collection.add('a');
		collection.add("����");
		
		Collection collection2=new ArrayList();
		collection2.add(1);
		collection2.add(2);
		collection2.add('a');
		collection2.add("�Ǻ�");
		Object obj=collection.removeAll(collection2);
		System.out.println(obj);
		System.out.println(collection);
	}

	//�жϼ������Ƿ����ĳ��Ԫ��
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void method7() {
		Collection collection=new ArrayList();
		collection.add(1);
		collection.add(1.1);
		collection.add('a');
		collection.add("����");
		
		Collection collection2=new ArrayList();
		collection2.add(1);
		collection2.add(1.1);
		collection2.add('a');
		collection2.add("����");
		boolean b=collection.containsAll(collection2);
		System.out.println(b);
	}

	//addALL()����
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void method6() {
		Collection collection=new ArrayList();
		collection.add(1);
		collection.add(1.1);
		collection.add('a');
		collection.add("����");
		
		Collection collection2=new ArrayList();
		collection2.add(1);
		collection2.add(1.1);
		collection2.add('a');
		collection2.add("����");
		collection.add(collection2);
		//collection.addAll(collection2);
		System.out.println(collection);
	}
	
	//List���ϵı���
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void method5() {
		List list=new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i)+" ");
		}
	}
	
	//set()����
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void method4() {
		List list=new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		Object obj=list.set(0, "����");
		System.out.println(obj);
		System.out.println(list);
	}

	//get()����
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void method3() {
		List list=new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		System.out.println(list.get(0));
		Object obj=list.get(1);
		System.out.println(obj);
	}

	//remove()����
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void method2() {
		List list=new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		Object obj=list.remove(0);
		list.remove("b");
		System.out.println(obj);
		System.out.println(list);
	}

	
	//add()����
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void method1() {
		
		List list=new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		System.out.println(list);
	}

}
