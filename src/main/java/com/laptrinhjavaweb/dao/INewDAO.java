package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.NewModel;

public interface INewDAO extends GenericDAO<NewModel> {
	NewModel findOne(long id);
	List<NewModel> findByCategoryId(Long categoryId);
	Long save(NewModel newModel); 
	void update(NewModel updateNew);
	void delete(long id);
	List<NewModel> findAll(Integer offset, Integer limit);
	int getTotalItem();
}
