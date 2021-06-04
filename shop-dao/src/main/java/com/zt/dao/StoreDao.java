package com.zt.dao;

import com.zt.pojo.store;

public interface StoreDao {

	public boolean addStore(store store);

	boolean update(store store);

	String selectById(int s_id);
}
