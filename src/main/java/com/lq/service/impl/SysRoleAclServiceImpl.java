package com.lq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

import com.lq.entity.SysRoleAcl;
import com.lq.repository.SysRoleAclRepository;
import com.lq.model.SysRoleAclModel;
import com.lq.service.SysRoleAclService;
import com.wlw.pylon.core.beans.mapping.BeanMapper;

import java.util.List;

@Service
public class SysRoleAclServiceImpl implements SysRoleAclService {

	@Autowired
	private BeanMapper beanMapper;

	@Autowired
	private SysRoleAclRepository sysRoleAclRepo;

	@Transactional
	@Override
	public int create(SysRoleAclModel sysRoleAclModel) {
		return sysRoleAclRepo.insert(beanMapper.map(sysRoleAclModel, SysRoleAcl.class));
	}

	@Transactional
	@Override
	public int createSelective(SysRoleAclModel sysRoleAclModel) {
		return sysRoleAclRepo.insertSelective(beanMapper.map(sysRoleAclModel, SysRoleAcl.class));
	}

	@Transactional
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sysRoleAclRepo.deleteByPrimaryKey(id);
	}

	@Transactional(readOnly = true)
	@Override
	public SysRoleAclModel findByPrimaryKey(Integer id) {
		SysRoleAcl sysRoleAcl = sysRoleAclRepo.selectByPrimaryKey(id);
		return beanMapper.map(sysRoleAcl, SysRoleAclModel.class);
	}

	@Transactional(readOnly = true)
	@Override
	public long selectCount(SysRoleAclModel sysRoleAclModel) {
		return sysRoleAclRepo.selectCount(beanMapper.map(sysRoleAclModel, SysRoleAcl.class));
	}

	@Transactional(readOnly = true)
	@Override
	public List<SysRoleAclModel> selectPage(SysRoleAclModel sysRoleAclModel,Pageable pageable) {
		SysRoleAcl sysRoleAcl = beanMapper.map(sysRoleAclModel, SysRoleAcl.class);
		return beanMapper.mapAsList(sysRoleAclRepo.selectPage(sysRoleAcl,pageable),SysRoleAclModel.class);
	}

	@Transactional
	@Override
	public int updateByPrimaryKey(SysRoleAclModel sysRoleAclModel) {
		return sysRoleAclRepo.updateByPrimaryKey(beanMapper.map(sysRoleAclModel, SysRoleAcl.class));
	}
	
	@Transactional
	@Override
	public int updateByPrimaryKeySelective(SysRoleAclModel sysRoleAclModel) {
		return sysRoleAclRepo.updateByPrimaryKeySelective(beanMapper.map(sysRoleAclModel, SysRoleAcl.class));
	}

}
