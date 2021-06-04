package com.zt.service.impl;

import com.zt.dao.StoreDao;
import com.zt.pojo.store;
import com.zt.service.StoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class StoreServiceImpl implements StoreService {

	@Resource
	private StoreDao storeDao;

	@Override
	public boolean addStore(store store) {
		try{
			storeDao.addStore(store);
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(store store) {
		try{
			storeDao.update(store);
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
