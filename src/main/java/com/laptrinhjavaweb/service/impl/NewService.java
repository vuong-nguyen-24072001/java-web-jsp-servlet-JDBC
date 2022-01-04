package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.service.INewService;

public class NewService implements INewService {

	@Inject
	private INewDAO newDao;
	
	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		return newDao.findByCategoryId(categoryId);
	}

	@Override
	public NewModel save(NewModel newModel) {
		newModel.setCreatedDated(new Timestamp(System.currentTimeMillis()));
		newModel.setCreatedBy("");
		Long newId = newDao.save(newModel);
		return newDao.findOne(newId);
	}

	@Override
	public NewModel update(NewModel updateNew) {
		NewModel oldNew = newDao.findOne(updateNew.getId());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setCreatedDated(oldNew.getCreatedDated());
		updateNew.setModifiedDated(new Timestamp(System.currentTimeMillis()));
		updateNew.setModifiedBy("");
		newDao.update(updateNew);
		return newDao.findOne(updateNew.getId());
	}

	@Override
	public void delete(long[] ids) {
		// xóa các hàng ở các bảng nào có quan hệ 1 - n vói bài viết trước khi xóa bài viết
		// ...
		for (long id: ids) {
			newDao.delete(id);
		}
	}

	@Override
	public List<NewModel> findAll(Integer offset, Integer limit) {
		return newDao.findAll(offset, limit);
	}

	@Override
	public int getTotalItem() {
		return newDao.getTotalItem();
	}

}
