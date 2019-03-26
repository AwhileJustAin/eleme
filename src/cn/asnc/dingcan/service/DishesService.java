package cn.asnc.dingcan.service;

import java.util.List;

import cn.asnc.dingcan.dao.DishesDao;
import cn.asnc.dingcan.dao.Num;
import cn.asnc.dingcan.vo.Dishes;

public class DishesService implements Num{
	
	DishesDao dd=new DishesDao();
	/**
	 * ����Ա��ѯ���в�Ʒ
	 * @return
	 */
	public List<Dishes> queryAll() {
		return dd.selectAllDishes();
		
	}
	/**
	 * �û���ѯ�����в�Ʒ
	 * @return
	 */
	public List<Dishes> querysAll() {
		return dd.selectAllsDishes();
		
	}
	/**
	 * ¼���Ʒ��Ϣ
	 * @param name
	 * @param price
	 * @return
	 */
	public int setDishes(String name,double price) {
		if(checkDishesName(name)==true) {
			return Exist;
		}else{
			dd.insertDishes(name, price);
			return Success;
		}
		
	}
	/**
	 * ����Ʒ�����Ƿ����
	 * @param name
	 * @return
	 */
	public boolean checkDishesName(String name) {
		Dishes d=dd.selectDishesBYName(name);
		if(name.equals(d.getG_name())) {
			return true;
		}
		return false;
	}
	/**
	 * ���Ĳ�Ʒ״̬
	 * @param id
	 * @return
	 */
	public int updateDishes(String id) {
		Dishes d=new Dishes();
		d=dd.checkDishesNoIsExist(id);
		int di=Integer.parseInt(id);
		if(di==d.getG_no()) {
			dd.updateDishes(id);
			return Success;
		}else {
			return NumError;
		}
		
	}
	/**
	 * ɾ����Ʒ
	 * @param id
	 * @return
	 */
	public int deleteDishes(String id) {
		Dishes d=new Dishes();
		d=dd.checkDishesNoIsExist(id);
		int di=Integer.parseInt(id);
		if(di==d.getG_no()) {
			dd.deleteDishes(id);
			return Success;
		}else {
			return NumError;
		}
	}
/**
 * ����
 * @param dishesId
 * @return
 */
	public int niceShoot(String dishesId) {
		Dishes d=dd.checkDishesNoIsExist(dishesId);
		int di=Integer.parseInt(dishesId);
		if(di==d.getG_no()) {
			dd.updateDishesLikeNum(dishesId);
			return Success;
		}else {
			return NumError;
		}
	}
}
