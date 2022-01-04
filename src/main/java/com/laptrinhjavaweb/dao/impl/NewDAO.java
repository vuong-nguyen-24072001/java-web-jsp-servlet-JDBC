package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.NewModel;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {
	
	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Long save(NewModel newModel) {
		String sql = "INSERT INTO news (title, content, categoryid, thumbnail, shortdescription, createddate, createdby) VALUES (?, ?, ?, ?, ?, ?, ?)";
		return insert(sql, newModel.getTitle(), newModel.getContent(), newModel.getCategoryId(), newModel.getThumbnail(), newModel.getShortDescription(),
					newModel.getCreatedDated(), newModel.getCreatedBy());
	}

	@Override
	public NewModel findOne(long id) {
		String sql = "SELECT * FROM news WHERE id = ?";
		List<NewModel> news = query(sql, new NewMapper(), id); 
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void update(NewModel updateNew) {
		String sql = "UPDATE news SET title = ?, content= ?, thumbnail = ?, shortdescription = ?, categoryid= ?, createddate = ?, modifieddate = ?, createdby = ?, modifiedby = ? WHERE id = ?";
		update(sql, updateNew.getTitle(), updateNew.getContent(), updateNew.getThumbnail(), updateNew.getShortDescription(), updateNew.getCategoryId(),
				updateNew.getCreatedDated(), updateNew.getModifiedDated(), updateNew.getCreatedBy(), updateNew.getModifiedBy(), updateNew.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM news WHERE id = ?";
		update(sql, id);
	}

	@Override
	public List<NewModel> findAll(Integer offset, Integer limit) {
		String sql= "SELECT * FROM news LIMIT ?, ?";
		return query(sql, new NewMapper(), offset, limit);
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM news";
		return count(sql);
	}

}
